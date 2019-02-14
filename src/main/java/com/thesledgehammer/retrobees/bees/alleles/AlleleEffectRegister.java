package com.thesledgehammer.retrobees.bees.alleles;

import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.apiculture.IAlleleBeeEffect;
import forestry.api.genetics.AlleleManager;
import forestry.apiculture.genetics.alleles.AlleleEffects;

public class AlleleEffectRegister extends AlleleEffects {

    public static IAlleleBeeEffect effectPhilosophersStone;


    public static void init() {
        effectPhilosophersStone = new AlleleEffectPhilosophersStone();

        AlleleManager.alleleRegistry.registerAllele(effectPhilosophersStone, EnumBeeChromosome.EFFECT);
    }
}
