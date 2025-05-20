package net.stinus.tutorialmod.command.custom;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Minecart;

public class MinecartFacingCommand {

    private static boolean startFacing = false;

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("faceMinecart")
                .requires((commandSource) -> commandSource.hasPermission(2))
                    .then(Commands.argument("start", BoolArgumentType.bool())
                        .executes(MinecartFacingCommand::execute)
                )
        );
    }

    private static int execute(CommandContext<CommandSourceStack> command){
        if(command.getSource().getEntity() instanceof Player player){
            if(player.getVehicle() instanceof Minecart minecart)
            {
                startFacing = BoolArgumentType.getBool(command, "start");
            }

            player.sendSystemMessage(Component.literal("Command: faceMinecart"));
        }
        return Command.SINGLE_SUCCESS;
    }

    public static boolean getStartFacing() { return startFacing; }
    public static void setStartFacing(boolean startFacing) { MinecartFacingCommand.startFacing = startFacing; }

}
