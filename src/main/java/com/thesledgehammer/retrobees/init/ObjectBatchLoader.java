package com.thesledgehammer.retrobees.init;

import com.thesledgehammer.retrobees.bees.BeeManagerRetroBees;
import com.thesledgehammer.retrobees.bees.BeeSpecies;
import com.thesledgehammer.retrobees.bees.mutation.BeeMutationFactoryEMC;
import com.thesledgehammer.retrobees.bees.mutation.EMCProxy;
import com.thesledgehammer.retrobees.flowers.FlowerRegister;
import com.thesledgehammer.retrobees.misc.Log;
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
		CompatProjectE();
		CompatTechReborn();
	}
	
	public static void postInit() {
		
	}
	
	public static void initModels() {
		ModItems.initModels();
	}

	private static void CompatProjectE() {
		if(Loader.isModLoaded("projecte")) {
			Log.logInfo("ProjectE is loaded");
			EmcRecipes.registerEMCRecipes();
			EMCProxy.addEMC();
		}
		if(!Loader.isModLoaded("projecte")) {
			Log.error("ProjectE is not loaded");
			BeeSpecies.DARKENED.setInactive();
			BeeSpecies.REDDENED.setInactive();
			BeeSpecies.OMEGA.setInactive();
		}
	}

	private static void CompatTechReborn() {
		if(Loader.isModLoaded("techreborn")) {
			Log.logInfo("Tech Reborn is loaded");
		}
		if(!Loader.isModLoaded("techreborn")) {
			Log.error("Tech Reborn is not loaded");
			BeeSpecies.COPPER.setInactive();
			BeeSpecies.SILVER.setInactive();
			BeeSpecies.TIN.setInactive();
			BeeSpecies.ALUMINUM.setInactive();
			BeeSpecies.LEAD.setInactive();
			BeeSpecies.GALENA.setInactive();
			BeeSpecies.GARNIERITE.setInactive();
			BeeSpecies.BAUXITE.setInactive();
			BeeSpecies.RUBY.setInactive();
			BeeSpecies.SAPPHIRE.setInactive();
			BeeSpecies.RED_GARNET.setInactive();
			BeeSpecies.YELLOW_GARNET.setInactive();
			BeeSpecies.ALMANDINE.setInactive();
			BeeSpecies.UVAROVITE.setInactive();
			BeeSpecies.CHROME.setInactive();
			BeeSpecies.PYRITE.setInactive();
			BeeSpecies.CINNABAR.setInactive();
			BeeSpecies.SPHALERITE.setInactive();
			BeeSpecies.SULFUR.setInactive();
			BeeSpecies.CALCITE.setInactive();
			BeeSpecies.PHOSPHOROUS.setInactive();
			BeeSpecies.PYROPE.setInactive();
			BeeSpecies.SPESSARTINE.setInactive();
			BeeSpecies.MAGNESIUM.setInactive();
			BeeSpecies.MANGANESE.setInactive();
			BeeSpecies.PERIDOT.setInactive();
			BeeSpecies.SODALITE.setInactive();
			BeeSpecies.TUNGSTEN.setInactive();
			BeeSpecies.PLATINUM.setInactive();
			BeeSpecies.TITANIUM.setInactive();
			BeeSpecies.IRIDIUM.setInactive();
			BeeSpecies.METHANE.setInactive();
			BeeSpecies.CARBON.setInactive();
			BeeSpecies.HYDROGEN.setInactive();
			BeeSpecies.DEUTERIUM.setInactive();
			BeeSpecies.TRITIUM.setInactive();
			BeeSpecies.HELIUM_3.setInactive();
			BeeSpecies.HELIUM_PLASMA.setInactive();
			BeeSpecies.HELIUM.setInactive();
		}
		if(!Loader.isModLoaded("ProjectE") || !Loader.isModLoaded("TechReborn")) {
			BeeSpecies.UU_MATTER.setInactive();
		}
	}
}
