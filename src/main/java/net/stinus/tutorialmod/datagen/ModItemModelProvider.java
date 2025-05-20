package net.stinus.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.stinus.tutorialmod.TutorialMod;
import net.stinus.tutorialmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
//        basicItem(ModItems.TEST_ITEM.get());
    }


}
