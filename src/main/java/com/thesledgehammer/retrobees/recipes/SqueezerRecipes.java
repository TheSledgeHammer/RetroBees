/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.recipes;

import com.thesledgehammer.retrobees.RetroBees;
import com.thesledgehammer.retrobees.proxy.ModItems;
import com.thesledgehammer.retrobees.items.EnumDropType;
import net.minecraftforge.fluids.FluidStack;

public class SqueezerRecipes {

	public static void registerSqueezerRecipes() {

		if(RetroBees.instance.isModLoaded("techreborn")) {

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
}
