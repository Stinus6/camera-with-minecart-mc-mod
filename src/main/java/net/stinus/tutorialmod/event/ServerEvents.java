package net.stinus.tutorialmod.event;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.stinus.tutorialmod.TutorialMod;
import net.stinus.tutorialmod.command.custom.MinecartFacingCommand;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerEvents
{
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event)
    {
        MinecartFacingCommand.register(event.getDispatcher());
    }
}
