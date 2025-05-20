package net.stinus.tutorialmod.block;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stinus.tutorialmod.TutorialMod;
import net.stinus.tutorialmod.item.ModItems;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

//    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f)
//                    .requiresCorrectToolForDrops()
//                    .sound(SoundType.ANVIL)
//            ));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties())
        {
            @Override
            public void appendHoverText(ItemStack pItemStack, TooltipContext pTooltipContext, List<Component> pTooltipComponents, TooltipFlag pFlag) {
                String tooltipName = "tooltip.tutorialmod." + name;
                if(!Component.translatable(tooltipName).getString().equals("") && !Component.translatable(tooltipName).getString().equals(tooltipName))
                    pTooltipComponents.add(Component.translatable(tooltipName));
            }
        });
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
