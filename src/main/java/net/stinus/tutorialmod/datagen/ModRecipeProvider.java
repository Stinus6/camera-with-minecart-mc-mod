package net.stinus.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.stinus.tutorialmod.block.ModBlocks;
import net.stinus.tutorialmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider
{
    public ModRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(packOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput)
    {
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TEST_BLOCK.get())
//                .pattern("###")
//                .pattern("###")
//                .pattern("###")
//                .define('#', ModItems.TEST_ITEM.get())
//                .unlockedBy(getHasName(ModItems.TEST_ITEM.get()), has(ModItems.TEST_ITEM.get()))
//                .save(recipeOutput);

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TEST_ITEM.get(), 9)
//                .requires(ModBlocks.TEST_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.TEST_BLOCK.get()), has(ModBlocks.TEST_BLOCK.get()))
//                .save(recipeOutput);

    }
}
