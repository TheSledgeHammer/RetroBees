package com.thesledgehammer.retrobees.bees.alleles;

import forestry.api.genetics.AlleleManager;

public class AlleleEffectRegister {

    public static AlleleEffectPhilosophersStone effectPhilosophersStone;

    public static void init() {
        effectPhilosophersStone = new AlleleEffectPhilosophersStone();
        AlleleManager.alleleRegistry.registerAllele(effectPhilosophersStone);
    }
}
