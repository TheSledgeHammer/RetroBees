package com.thesledgehammer.retrobees.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.Loader;
import techreborn.api.TechRebornAPI;

public class SmeltingRecipes {

    public static void registerSmeltingRecipes() {
        if(Loader.isModLoaded("techreborn")) {
            //Diamond Dust
            FurnaceRecipes.instance().addSmeltingRecipe(TechRebornAPI.subItemRetriever.getDustByName("diamond"), new ItemStack(Items.DIAMOND, 1), 1);

            //Emerald Dust
            FurnaceRecipes.instance().addSmeltingRecipe(TechRebornAPI.subItemRetriever.getDustByName("emerald"), new ItemStack(Items.EMERALD, 1), 1);
        }
    }
}
