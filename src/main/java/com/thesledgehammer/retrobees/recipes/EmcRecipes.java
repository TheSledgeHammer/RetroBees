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
		
		//emcMutation.addRecipe(BeeSpecies.IRIDIUM, BeeSpecies.OMEGA, Config.omegaBeeValue);
		emcMutation.addRecipe(BeeSpecies.OMEGA, BeeSpecies.IRIDIUM, Config.uuMatterBeeValue);
	}
}
