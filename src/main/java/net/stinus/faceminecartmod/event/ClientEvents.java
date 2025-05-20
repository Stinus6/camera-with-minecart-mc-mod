package net.stinus.faceminecartmod.event;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.stinus.faceminecartmod.TutorialMod;
import net.stinus.faceminecartmod.command.custom.MinecartFacingCommand;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents
{
    private static boolean facingwrong = true;
    private static boolean checkwrong = true;

    public static void Setup()
    {
        facingwrong = true;
        checkwrong = true;
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event)
    {
        Minecraft mc = Minecraft.getInstance();

        if (mc.player != null &&
                MinecartFacingCommand.getStartFacing() &&
                Minecraft.getInstance().player.getVehicle() instanceof Minecart minecart &&
                (isMinecartMoving(minecart))
            )
        {
            mc.player.setYRot(getYaw(minecart, mc));
            mc.player.setXRot(0);
        }
    }

    private static float getYaw(Minecart minecart, Minecraft mc)
    {
        Vec3 velocity = minecart.getDeltaMovement();

        float targetYaw = (float) Math.toDegrees(Math.atan2(velocity.z, velocity.x));

        if(targetYaw < 0)
        {
            targetYaw += 360;
        }

        float currentYaw = minecart.getYRot();

        float smoothSpeed = 5.0f;
        float deltaYaw = targetYaw - currentYaw;

        if (deltaYaw > 180) {
            deltaYaw -= 360;
        } else if (deltaYaw < -180) {
            deltaYaw += 360;
        }

//        if (Math.abs(deltaYaw) > smoothSpeed) {
            currentYaw += Math.signum(deltaYaw) * smoothSpeed;
//        } else {
//            currentYaw = targetYaw;
//        }

        if(currentYaw > 0 && checkwrong)
        {
            facingwrong = false;
        }

        if(facingwrong)
        {
            checkwrong = false;
            currentYaw += 180;
        }


        return (currentYaw - 90 + 360) % 360;
    }

    public static boolean isMinecartMoving(Minecart minecart) {
        Vec3 velocity = minecart.getDeltaMovement();
        double threshold = 0.01;
        return Math.abs(velocity.x) > threshold || Math.abs(velocity.z) > threshold;
    }

    @SubscribeEvent
    public static void onPlayerExitMinecart(EntityMountEvent event)
    {
        if (event.getEntity() instanceof Player player &&
                event.getEntityMounting() instanceof Minecart minecart)
        {
            if (MinecartFacingCommand.getStartFacing())
            {
                MinecartFacingCommand.setStartFacing(false);
            }
        }
    }
}
