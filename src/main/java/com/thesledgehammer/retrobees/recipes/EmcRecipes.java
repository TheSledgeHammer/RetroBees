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

		//Darkened Bee
		emcMutation.addRecipe(BeeDefinition.MODEST, BeeDefinition.WINTRY, Config.darkenedBeeValue);

		//Reddened Bee
		emcMutation.addRecipe(BeeSpecies.DARKENED, BeeDefinition.MODEST, Config.reddenedBeeValue);

		//Omega Bee
		emcMutation.addRecipe(BeeSpecies.REDDENED, BeeSpecies.DARKENED, Config.omegaBeeValue);

		//UU-Matter Bee
		emcMutation.addRecipe(BeeSpecies.OMEGA, BeeSpecies.IRIDIUM, Config.uuMatterBeeValue);

		//Philosophers Stone Bee
		emcMutation.addRecipe(BeeSpecies.DIAMOND, BeeSpecies.REDSTONE, Config.philosophersBeeValue);
		emcMutation.addRecipe(BeeSpecies.REDSTONE, BeeSpecies.GLOWSTONE, Config.philosophersBeeValue);
		emcMutation.addRecipe(BeeSpecies.GLOWSTONE, BeeSpecies.DIAMOND, Config.philosophersBeeValue);

		//Philosophers Stone Transmutable Bee EMC Mutations:
		//Alchemical Coal Bee
		emcMutation.addRecipe(BeeSpecies.PHILOSOPHERS_STONE, BeeSpecies.COAL, Config.alchemicalBeeValue);
		emcMutation.addRecipe(BeeSpecies.PHILOSOPHERS_STONE, BeeSpecies.MOBIUS, Config.alchemicalBeeValue);

		//Mobius Fuel Bee
		emcMutation.addRecipe(BeeSpecies.PHILOSOPHERS_STONE, BeeSpecies.ALCHEMICAL_COAL, Config.mobiusBeeValue);
		emcMutation.addRecipe(BeeSpecies.PHILOSOPHERS_STONE, BeeSpecies.AETERNALIS, Config.mobiusBeeValue);

		//Aeternalis Fuel Bee
		emcMutation.addRecipe(BeeSpecies.PHILOSOPHERS_STONE, BeeSpecies.MOBIUS, Config.aeternalisBeeValue);

		//Coal Bee
		emcMutation.addRecipe(BeeSpecies.PHILOSOPHERS_STONE, BeeSpecies.MOBIUS, Config.coalBeeValue);

		//Iron Bee
		emcMutation.addRecipe(BeeSpecies.PHILOSOPHERS_STONE, BeeSpecies.GOLD, Config.ironBeeValue);

		//Gold Bee
		emcMutation.addRecipe(BeeSpecies.PHILOSOPHERS_STONE, BeeSpecies.IRON, Config.goldBeeValue);
		emcMutation.addRecipe(BeeSpecies.PHILOSOPHERS_STONE, BeeSpecies.DIAMOND, Config.goldBeeValue);

		//Diamond Bee
		emcMutation.addRecipe(BeeSpecies.PHILOSOPHERS_STONE, BeeSpecies.GOLD, Config.diamondBeeValue);
		emcMutation.addRecipe(BeeSpecies.PHILOSOPHERS_STONE, BeeSpecies.EMERALD, Config.diamondBeeValue);

		//Emerald Bee
		emcMutation.addRecipe(BeeSpecies.PHILOSOPHERS_STONE, BeeSpecies.DIAMOND, Config.emeraldBeeValue);

		//Ender Pearl Bee
		emcMutation.addRecipe(BeeSpecies.PHILOSOPHERS_STONE, BeeSpecies.IRON, Config.enderPearlBeeValue);
	}
}
