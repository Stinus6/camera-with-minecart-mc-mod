package net.stinus.tutorialmod.networking;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.SimpleChannel;
import net.stinus.tutorialmod.TutorialMod;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TutorialModPacketHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = ChannelBuilder
            .named(TutorialMod.MOD_ID)
            .networkProtocolVersion(1)
            .simpleChannel();

    private static int id = 0;

    public static void init() {
//        INSTANCE.messageBuilder(CustomNamePacket.class, id++, NetworkDirection.PLAY_TO_SERVER)
//                .decoder(CustomNamePacket::decode)
//                .encoder(CustomNamePacket::encode)
//                .consumer(CustomNamePacket::handle)
//                .add();
    }


}
