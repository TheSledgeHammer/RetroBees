package com.thesledgehammer.retrobees.init;


import com.thesledgehammer.retrobees.bees.BeeManagerRetroBees;
import com.thesledgehammer.retrobees.bees.BeeSpecies;
import com.thesledgehammer.retrobees.bees.mutation.BeeMutationFactoryEMC;
import com.thesledgehammer.retrobees.bees.mutation.EMCProxy;
import com.thesledgehammer.retrobees.flowers.FlowerRegister;
import com.thesledgehammer.retrobees.misc.Log;
import com.thesledgehammer.retrobees.misc.OreDictionaryRegister;
import com.thesledgehammer.retrobees.recipes.CentrifugeRecipes;
import com.thesledgehammer.retrobees.recipes.EmcRecipes;
import com.thesledgehammer.retrobees.recipes.SqueezerRecipes;

import forestry.api.apiculture.BeeManager;
import forestry.apiculture.genetics.BeeMutationFactory;
import net.minecraftforge.fml.common.Loader;

/**
 * Initiates the loading in proxy client of all registered RetroBee Items, Blocks, Tiles, Fluids, Recipes, etc.
 */

public class ObjectBatchLoader {
	
	public static void preInit() {
		ModCheck();
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
		EmcRecipes.registerEMCRecipes();
		OreDictionaryRegister.init();
		EMCProxy.addEMC();
	}
	
	public static void postInit() {
		
	}
	
	public static void initModels() {
		ModItems.initModels();
	}
	
	private static void ModCheck() {
		if(Loader.isModLoaded("ProjectE")) {
			Log.logInfo("ProjectE was successfully loaded");
		} else {
			Log.error("ProjectE was not loaded successfully");
		}
		if(Loader.isModLoaded("TechReborn")) {
			Log.logInfo("Tech Reborn was successfully loaded");
		} else {
			Log.error("Tech Reborn was not loaded successfully");
		}
	}
}
