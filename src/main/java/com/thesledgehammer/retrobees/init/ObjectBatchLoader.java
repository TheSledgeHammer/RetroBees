package com.thesledgehammer.retrobees.init;

import com.thesledgehammer.retrobees.bees.BeeManagerRetroBees;
import com.thesledgehammer.retrobees.bees.BeeSpecies;
import com.thesledgehammer.retrobees.bees.mutation.BeeMutationFactoryEMC;
import com.thesledgehammer.retrobees.flowers.FlowerRegister;
import com.thesledgehammer.retrobees.recipes.CentrifugeRecipes;
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
	}
	
	public static void init() {
		//RetroBees Custom Bee Mutation Factory
		BeeManagerRetroBees.beeMutationFactoryEMC = new BeeMutationFactoryEMC();
		BeeManager.beeMutationFactory = new BeeMutationFactory();
		FlowerRegister.initFlowers();
		BeeSpecies.initBees();
		CentrifugeRecipes.registerCentrifugeRecipes();
		SqueezerRecipes.registerSqueezerRecipes();
		CompatModule.initCompatability();
	}
	
	public static void postInit() {
		
	}
	
	public static void initModels() {
		ModItems.initModels();
	}
}
