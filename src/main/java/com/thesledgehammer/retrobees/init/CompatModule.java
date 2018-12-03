/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.init;

import com.thesledgehammer.retrobees.bees.BeeSpecies;
import com.thesledgehammer.retrobees.bees.mutation.EMCProxy;
import com.thesledgehammer.retrobees.misc.Log;
import com.thesledgehammer.retrobees.recipes.EmcRecipes;
import net.minecraftforge.fml.common.Loader;

public class CompatModule {

    public static void initCompatability() {
        CompatProjectE();
        CompatTechReborn();
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
            BeeSpecies.ALCHEMICAL_COAL.setInactive();
            BeeSpecies.MOBIUS.setInactive();
            BeeSpecies.AETERNALIS.setInactive();
        }
    }

    private static void CompatTechReborn() {
        if(Loader.isModLoaded("techreborn")) {
            Log.logInfo("Tech Reborn is loaded");
        }
        if(!Loader.isModLoaded("techreborn")) {
            Log.error("Tech Reborn is not loaded");
            BeeSpecies.COAL.setInactive();
            BeeSpecies.IRON.setInactive();
            BeeSpecies.COPPER.setInactive();
            BeeSpecies.SILVER.setInactive();
            BeeSpecies.TIN.setInactive();
            BeeSpecies.GOLD.setInactive();
            BeeSpecies.ALUMINUM.setInactive();
            BeeSpecies.LEAD.setInactive();
            BeeSpecies.GALENA.setInactive();
            BeeSpecies.GARNIERITE.setInactive();
            BeeSpecies.BAUXITE.setInactive();
            BeeSpecies.RUBY.setInactive();
            BeeSpecies.SAPPHIRE.setInactive();
            BeeSpecies.DIAMOND.setInactive();
            BeeSpecies.EMERALD.setInactive();
            BeeSpecies.RED_GARNET.setInactive();
            BeeSpecies.YELLOW_GARNET.setInactive();
            BeeSpecies.ALMANDINE.setInactive();
            BeeSpecies.UVAROVITE.setInactive();
            BeeSpecies.CHROME.setInactive();
            BeeSpecies.REDSTONE.setInactive();
            BeeSpecies.GLOWSTONE.setInactive();
            BeeSpecies.NETHER_QUARTZ.setInactive();
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
            BeeSpecies.ENDER_PEARL.setInactive();
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
