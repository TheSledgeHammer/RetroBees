package com.thesledgehammer.retrobees.recipes;

import com.thesledgehammer.retrobees.bees.BeeSpecies;
import com.thesledgehammer.retrobees.bees.mutation.EmcRecipe;
import com.thesledgehammer.retrobees.misc.Config;
import forestry.apiculture.genetics.BeeDefinition;

public class EmcRecipes {
	
	public static EmcRecipe emcMutation;
	
	public static void registerEMCRecipes() {
		emcMutation = new EmcRecipe();
		
		emcMutation.addRecipe(BeeDefinition.MODEST, BeeDefinition.WINTRY, Config.darkenedBeeValue);
		//emcMutation.addRecipe(BeeDefinition.WINTRY, BeeDefinition.MODEST, Config.darkenedBeeValue);
		
		emcMutation.addRecipe(BeeSpecies.DARKENED, BeeDefinition.MODEST, Config.reddenedBeeValue);
		//emcMutation.addRecipe(BeeDefinition.MODEST, BeeSpecies.DARKENED, Config.reddenedBeeValue);
		
		//emcMutation.addRecipe(BeeSpecies.DARKENED, BeeSpecies.REDDENED, Config.omegaBeeValue);
		emcMutation.addRecipe(BeeSpecies.REDDENED, BeeSpecies.DARKENED, Config.omegaBeeValue);
		
		//emcMutation.addRecipe(BeeSpecies.IRIDIUM, BeeSpecies.OMEGA, Config.uuMatterBeeValue);
		emcMutation.addRecipe(BeeSpecies.COAL, BeeSpecies.COAL, Config.alchemicalBeeValue);

		emcMutation.addRecipe(BeeSpecies.COAL, BeeSpecies.ALCHEMICAL_COAL, Config.mobiusBeeValue);

		emcMutation.addRecipe(BeeSpecies.ALCHEMICAL_COAL, BeeSpecies.MOBIUS, Config.aeternalisBeeValue);

		emcMutation.addRecipe(BeeSpecies.DIAMOND, BeeSpecies.AETERNALIS, Config.darkMatterBeeValue);

		emcMutation.addRecipe(BeeSpecies.AETERNALIS, BeeSpecies.DARKMATTER, Config.redMatterBeeValue);
	}
}
