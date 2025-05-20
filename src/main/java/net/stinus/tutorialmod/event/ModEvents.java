package net.stinus.tutorialmod.event;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.stinus.tutorialmod.TutorialMod;
import net.stinus.tutorialmod.networking.TutorialModPacketHandler;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event)
    {
        TutorialModPacketHandler.init();
    }
}
