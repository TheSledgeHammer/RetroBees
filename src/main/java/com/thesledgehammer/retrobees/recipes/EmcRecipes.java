/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

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
	}
}
