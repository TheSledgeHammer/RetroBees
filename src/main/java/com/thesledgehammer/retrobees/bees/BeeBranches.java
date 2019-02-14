/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.bees;

import com.thesledgehammer.retrobees.bees.alleles.AlleleEffectRegister;
import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IClassification;
import forestry.apiculture.genetics.alleles.AlleleEffects;
import forestry.core.genetics.IBranchDefinition;
import forestry.core.genetics.alleles.AlleleHelper;
import forestry.core.genetics.alleles.EnumAllele;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Locale;

public enum BeeBranches implements IBranchDefinition {
	
	// ProjectE EMC Branch
	EMC("Energy-Matter-Convertis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_2);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
		}
	},

	TRANSMUTATED("Transmutatinis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.AVERAGE);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.EFFECT, AlleleEffectRegister.effectPhilosophersStone);
		}
	},

	// TechReborn Irradiated Branch (Renamed from Venegful Branch)
	IRRADIATED("Irradiatis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.LARGEST);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.EFFECT, AlleleEffects.effectRadioactive);
		}
	},
	
	LUMINESCE("Luminescis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.AVERAGE);
		}
	},
	
	
	PHOSPHORESCE("Phosphorescis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.AVERAGE);
		}
	},
	
	CORUSCATE("Coruscatis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.AVERAGE);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
		}
	},
	
	SCINTILLATED("Scintillatis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
		}
	},
	
	OSCILLATED("Oscillatis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.AVERAGE);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
		}
	},
	
	FULGURATED("Fulguratis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.AVERAGE);
		}
	},
	
	PLATITUDINOUS("Platitudinousis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.AVERAGE);
		}
	},
	
	OBFUSCATED("Obfuscatis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.AVERAGE);
		}
	},
	
	MONOTONOUS("Monotonis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.LOW);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGER);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.UP_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.LARGE);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.EFFECT, AlleleEffects.effectMisanthrope);
		}
	},
	
	ACHROMATIC("Achromaticis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.BOTH_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.AVERAGE);
		}
	},
	
	CADAVEROUSNESS("Cadaverousnessis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.DOWN_1);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.AVERAGE);
		}
	},
	
	RADIATE("Radiatis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			//TODO: Add Alleles
		}
	},
	
	ANEMIC("Anemicis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.NEVER_SLEEPS, true);
			AlleleHelper.getInstance().set(alleles, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.AVERAGE);
			
		}
	},
	SEPULCHRAL("Sepulcharalis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			//TODO: Add Alleles
		}
	},

	INCANDESCE("Incandescis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			//TODO: Add Alleles
		}
	},

	ADUMBRATE("Adumbratis") {
		@Override
		protected void setBranchProperties(IAllele[] alleles) {
			//TODO: Add Alleles
		}
	};

	private final IClassification branch;

	BeeBranches(String scientific) {
		branch = BeeManager.beeFactory.createBranch(this.name().toLowerCase(Locale.ENGLISH), scientific);
	}

	protected void setBranchProperties(IAllele[] template) {
		
	}

	@Override
	public final IAllele[] getTemplate() {
		IAllele[] template = getDefaultTemplate();
		setBranchProperties(template);
		return template;
	}

	@Override
	public final IClassification getBranch() {
		return branch;
	}
	
	@Nullable
	private static IAllele[] defaultTemplate;

	private static IAllele[] getDefaultTemplate() {
		if (defaultTemplate == null) {

			defaultTemplate = new IAllele[EnumBeeChromosome.values().length];

			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.SHORTER);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.FERTILITY, EnumAllele.Fertility.NORMAL);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.TEMPERATURE_TOLERANCE,EnumAllele.Tolerance.NONE);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.NEVER_SLEEPS, false);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.HUMIDITY_TOLERANCE, EnumAllele.Tolerance.NONE);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.TOLERATES_RAIN, false);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.CAVE_DWELLING, false);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.FLOWER_PROVIDER, EnumAllele.Flowers.VANILLA);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.SLOWEST);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.TERRITORY, EnumAllele.Territory.AVERAGE);
			AlleleHelper.getInstance().set(defaultTemplate, EnumBeeChromosome.EFFECT, AlleleEffects.effectNone);
		}
		return Arrays.copyOf(defaultTemplate, defaultTemplate.length);
	}
}
