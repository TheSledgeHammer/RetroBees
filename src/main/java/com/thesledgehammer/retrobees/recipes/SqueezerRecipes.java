package com.thesledgehammer.retrobees.recipes;

import com.thesledgehammer.retrobees.items.EnumDropType;

import com.thesledgehammer.retrobees.init.ModItems;
import forestry.api.recipes.RecipeManagers;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import techreborn.init.ModFluids;

public class SqueezerRecipes {
	
	public static void registerSqueezerRecipes() {
		//Liquids
		FluidStack Carbon = new FluidStack(ModFluids.CARBON, 100);
		FluidStack Deuterium = new FluidStack(ModFluids.DEUTERIUM, 100);
		FluidStack Helium = new FluidStack(ModFluids.HELIUM, 100);
		FluidStack Helium_3 = new FluidStack(ModFluids.HELIUM_3, 100);
		FluidStack HeliumPlasma = new FluidStack(ModFluids.HELIUMPLASMA, 100);
		FluidStack Hydrogen = new FluidStack(ModFluids.HYDROGEN, 100);
		FluidStack Methane = new FluidStack(ModFluids.METHANE, 100);
		FluidStack Tritium = new FluidStack(ModFluids.TRITIUM, 100);
		FluidStack Wolframium = new FluidStack(ModFluids.WOLFRAMIUM, 100);
		//FluidStack UUMatter = new FluidStack();
			
		//Recipes
		RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(ModItems.HoneyDrop.getDrop(EnumDropType.CARBON, 1).getItem()), Carbon);
		RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(ModItems.HoneyDrop.getDrop(EnumDropType.DEUTERIUM, 1).getItem()), Deuterium);
		RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(ModItems.HoneyDrop.getDrop(EnumDropType.HELIUM, 1).getItem()), Helium);
		RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(ModItems.HoneyDrop.getDrop(EnumDropType.HELIUM_3, 1).getItem()), Helium_3);
		RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(ModItems.HoneyDrop.getDrop(EnumDropType.HELIUM_PLASMA, 1).getItem()), HeliumPlasma);
		RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(ModItems.HoneyDrop.getDrop(EnumDropType.HYDROGEN, 1).getItem()), Hydrogen);
		RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(ModItems.HoneyDrop.getDrop(EnumDropType.METHANE, 1).getItem()), Methane);
		RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(ModItems.HoneyDrop.getDrop(EnumDropType.TRITIUM, 1).getItem()), Tritium);
		RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(ModItems.HoneyDrop.getDrop(EnumDropType.WOLFRAMIUM, 1).getItem()), Wolframium);
	}
}
