/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.init;

import com.thesledgehammer.retrobees.bees.BeeManagerRetroBees;
import com.thesledgehammer.retrobees.bees.BeeSpecies;
import com.thesledgehammer.retrobees.bees.mutation.BeeMutationFactoryEMC;
import com.thesledgehammer.retrobees.flowers.FlowerRegister;
import com.thesledgehammer.retrobees.recipes.CentrifugeRecipes;
import com.thesledgehammer.retrobees.recipes.SmeltingRecipes;
import com.thesledgehammer.retrobees.recipes.SqueezerRecipes;
import forestry.api.apiculture.BeeManager;
import forestry.apiculture.genetics.BeeMutationFactory;

/**
 * Initiates the loading in proxy client of all registered RetroBee Items, Blocks, Tiles, Fluids, Recipes, etc.
 */

public class ObjectBatchLoader {

	public static ModItems items = new ModItems();

	public static void preInit() {
		ModItems.init();
		ModBlocks.init();
	}
	
	public static void init() {
		//RetroBees Custom Bee Mutation Factory
		BeeManagerRetroBees.beeMutationFactoryEMC = new BeeMutationFactoryEMC();
		BeeManager.beeMutationFactory = new BeeMutationFactory();
		FlowerRegister.initFlowers();
		BeeSpecies.initBees();
		CentrifugeRecipes.registerCentrifugeRecipes();
		SqueezerRecipes.registerSqueezerRecipes();
		SmeltingRecipes.registerSmeltingRecipes();
		CompatModule.initCompatability();
	}
	
	public static void postInit() {
		
	}
	
	public static void initModels() {
		ModItems.initModels();
	}
}
