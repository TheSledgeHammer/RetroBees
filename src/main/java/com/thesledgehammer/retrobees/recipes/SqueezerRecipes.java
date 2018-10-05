package com.thesledgehammer.retrobees.recipes;

import com.thesledgehammer.retrobees.init.ModItems;
import com.thesledgehammer.retrobees.items.EnumDropType;
import forestry.api.recipes.RecipeManagers;
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

		//Recipes
		RecipeManagers.squeezerManager.addRecipe(10, ModItems.HoneyDrop.getDrop(EnumDropType.CARBON, 1), Carbon);
		RecipeManagers.squeezerManager.addRecipe(10, ModItems.HoneyDrop.getDrop(EnumDropType.DEUTERIUM, 1), Deuterium);
		RecipeManagers.squeezerManager.addRecipe(10, ModItems.HoneyDrop.getDrop(EnumDropType.HELIUM, 1), Helium);
		RecipeManagers.squeezerManager.addRecipe(10, ModItems.HoneyDrop.getDrop(EnumDropType.HELIUM_3, 1), Helium_3);
		RecipeManagers.squeezerManager.addRecipe(10, ModItems.HoneyDrop.getDrop(EnumDropType.HELIUM_PLASMA, 1), HeliumPlasma);
		RecipeManagers.squeezerManager.addRecipe(10, ModItems.HoneyDrop.getDrop(EnumDropType.HYDROGEN, 1), Hydrogen);
		RecipeManagers.squeezerManager.addRecipe(10, ModItems.HoneyDrop.getDrop(EnumDropType.METHANE, 1), Methane);
		RecipeManagers.squeezerManager.addRecipe(10, ModItems.HoneyDrop.getDrop(EnumDropType.TRITIUM, 1), Tritium);
		RecipeManagers.squeezerManager.addRecipe(10, ModItems.HoneyDrop.getDrop(EnumDropType.WOLFRAMIUM, 1), Wolframium);
	}
}
