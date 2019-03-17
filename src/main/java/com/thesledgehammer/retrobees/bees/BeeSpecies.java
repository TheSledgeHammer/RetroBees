/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.bees;

import com.thesledgehammer.retrobees.RetroBees;
import com.thesledgehammer.retrobees.flowers.FlowerRegister;
import com.thesledgehammer.retrobees.init.ModItems;
import com.thesledgehammer.retrobees.items.EnumCombType;
import com.thesledgehammer.retrobees.misc.Config;
import forestry.api.apiculture.*;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.AlleleSpeciesRegisterEvent;
import forestry.api.genetics.IAllele;
import forestry.apiculture.ModuleApiculture;
import forestry.apiculture.genetics.Bee;
import forestry.apiculture.genetics.BeeDefinition;
import forestry.apiculture.genetics.BeeVariation;
import forestry.apiculture.genetics.IBeeDefinition;
import forestry.apiculture.genetics.alleles.AlleleEffects;
import forestry.apiculture.items.EnumHoneyComb;
import forestry.core.genetics.IBranchDefinition;
import forestry.core.genetics.alleles.AlleleHelper;
import forestry.core.genetics.alleles.EnumAllele;
import forestry.core.genetics.alleles.EnumAllele.Lifespan;
import forestry.core.genetics.alleles.EnumAllele.Speed;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import org.apache.commons.lang3.text.WordUtils;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Arrays;
import java.util.Locale;

public enum BeeSpecies implements IBeeDefinition {

	// EMC Branch
	DARKENED(BeeBranches.EMC, "Darkened", false, new Color(0xD6BDE4), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1), 0.30F)
					.addSpecialty(ModItems.BeeComb.getComb(EnumCombType.DARKENED, 1), 0.30F);
			if(Config.canProduceDarkMatter) {
				beeSpecies.addSpecialty(ModItems.BeeComb.getComb(EnumCombType.DARKMATTER, 1), 0.01F);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.DARKMATTER);
		}
		
		@Override
		protected void registerMutations() {
			registerEMCMutation(BeeDefinition.MODEST, BeeDefinition.WINTRY, 100);
		}
	},

	REDDENED(BeeBranches.EMC, "Reddened", true, new Color(0xF7C0C0), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1), 0.30F)
					.addSpecialty(ModItems.BeeComb.getComb(EnumCombType.REDDENED, 1), 0.30F);
			if(Config.canProduceRedMatter) {
				beeSpecies.addSpecialty(ModItems.BeeComb.getComb(EnumCombType.REDMATTER, 1), 0.01F);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.REDMATTER);
		}

		@Override
		protected void registerMutations() {
			registerEMCMutation(DARKENED, BeeDefinition.MODEST, 100);
		}
	},

	OMEGA(BeeBranches.EMC, "Omega", false, new Color(0xFDFE8E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.OMEGA, 1), 0.30F)
					.setHasEffect();
			if(Config.canProduceDarkMatter) {
				beeSpecies.addSpecialty(ModItems.BeeComb.getComb(EnumCombType.DARKMATTER, 1), 0.02F);
			}
			if(Config.canProduceRedMatter) {
				beeSpecies.addSpecialty(ModItems.BeeComb.getComb(EnumCombType.REDMATTER, 1), 0.02F);
			}
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.REDMATTER);
		}
		
		@Override
		protected void registerMutations() {
			registerEMCMutation(DARKENED, REDDENED, 100).restrictBiomeType(BiomeDictionary.Type.NETHER).restrictBiomeType(BiomeDictionary.Type.HOT);
		}
	},

	PHILOSOPHERS_STONE(BeeBranches.TRANSMUTATED, "Philosophicalis Stonis", true, new Color(0xFD5732), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1), 0.30F)
					/*.addProduct(ModItems.BeeComb.getComb(EnumCombType.PHILOSOPHERS, 1), 0.30F)*/
					.setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {
			registerEMCMutation(REDSTONE, GLOWSTONE, 100);
			registerEMCMutation(GLOWSTONE, DIAMOND, 100);
			registerEMCMutation(DIAMOND, REDSTONE, 100);
		}
	},

	//Transmutated Branch
	ALCHEMICAL_COAL(BeeBranches.TRANSMUTATED, "Alchemicalis", true, new Color(0xC60310), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1), 0.30F)
					.addSpecialty(ModItems.BeeComb.getComb(EnumCombType.ALCHEMICAL_COAL, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			//TODO: Add Alleles
		}

		@Override
		protected void registerMutations() {
			registerEMCMutation(PHILOSOPHERS_STONE, COAL, 100);
			registerEMCMutation(PHILOSOPHERS_STONE, MOBIUS, 100);
		}
	},

	MOBIUS(BeeBranches.TRANSMUTATED, "Mobiusis", false, new Color(0x870009), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1), 0.30F)
					.addSpecialty(ModItems.BeeComb.getComb(EnumCombType.MOBIUS, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			//TODO: Add Alleles
		}

		@Override
		protected void registerMutations() {
			registerEMCMutation(PHILOSOPHERS_STONE, ALCHEMICAL_COAL, 100);
			registerEMCMutation(PHILOSOPHERS_STONE, AETERNALIS, 100);
		}
	},

	AETERNALIS(BeeBranches.TRANSMUTATED, "Aeternalisness", true, new Color(0x9D9D9D), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1), 0.30F)
					.addSpecialty(ModItems.BeeComb.getComb(EnumCombType.AETERNALIS, 1), 0.30F)
					.setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			//TODO: Add Alleles
		}

		@Override
		protected void registerMutations() {
			registerEMCMutation(PHILOSOPHERS_STONE, MOBIUS, 100);
		}
	},

	//TechReborn Branches
	COAL(BeeBranches.OSCILLATED, "Coalitis", true, new Color(0x070707), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.COAL, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, Lifespan.SHORT);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.FAST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.COAL_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(BeeDefinition.AUSTERE, BeeDefinition.INDUSTRIOUS, 10);

			if(isTransmutable()) {
				registerEMCMutation(PHILOSOPHERS_STONE, ALCHEMICAL_COAL, 100);
			}
		}
	},

	IRON(BeeBranches.OSCILLATED, "Ironitis", false, new Color(0xBCBCBC), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.IRON, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.FAST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.IRON_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(COAL, BeeDefinition.AUSTERE, 10);

			if(isTransmutable()) {
				registerEMCMutation(PHILOSOPHERS_STONE, GOLD, 100);
			}
		}
	},

	COPPER(BeeBranches.OSCILLATED, "Copperitis", false, new Color(0xBB6F4D), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.COPPER, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.FAST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.COPPER_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(IRON, COAL, 10);
		}
	},

	SILVER(BeeBranches.OSCILLATED, "Silveritis", true, new Color(0xC9D7D9), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.SILVER, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.FAST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.SILVER_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(COPPER, IRON, 10);
		}
	},

	GOLD(BeeBranches.OSCILLATED, "Golditis", true, new Color(0xF2DA57), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.GOLD, 1), 0.30F).setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.FAST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.GOLD_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(SILVER, COPPER, 9);

			if(isTransmutable()) {
				registerEMCMutation(PHILOSOPHERS_STONE, IRON, 100);
				registerEMCMutation(PHILOSOPHERS_STONE, DIAMOND, 100);
			}
		}
	},

	TIN(BeeBranches.SCINTILLATED, "Tinitis", true, new Color(0xF1F1F1), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.TIN, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.TIN_ORE);

		}

		@Override
		protected void registerMutations() {
			registerMutation(COPPER, BeeDefinition.AUSTERE, 12);
		}
	},

	ALUMINUM(BeeBranches.SCINTILLATED, "Aluminumitis", true, new Color(0xDADDDD), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.ALUMINUM, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.ALUMINIUM_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(COPPER, TIN, 12);
		}
	},

	LEAD(BeeBranches.SCINTILLATED, "Leaditis", false, new Color(0x615D68), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.LEAD, 1), 0.30F).setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.LEAD_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(TIN, ALUMINUM, 10);
		}
	},

	REDSTONE(BeeBranches.FULGURATED, "Redstonitis", false, new Color(0x490000), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.REDSTONE, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.REDSTONE_ORE);
			//TODO: Add More Alleles
		}

		@Override
		protected void registerMutations() {
			registerMutation(IRON, GOLD, 10);
		}
	},

	GALENA(BeeBranches.CORUSCATE, "Galenaitis", true, new Color(0x625864), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.GALENA, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.FAST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.GALENA_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(SILVER, LEAD, 8);
		}
	},

	GARNIERITE(BeeBranches.CORUSCATE, "Garnieritis", true, new Color(0x95C74E), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.GARNIERITE, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.FAST);
		}

		@Override
		protected void registerMutations() {
			registerMutation(GALENA, LEAD, 8);
		}
	},

	BAUXITE(BeeBranches.CORUSCATE, "Bauxitis", false, new Color(0x7b4028), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.BAUXITE, 1), 0.30F).setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.FAST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.BAUXITE_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(GARNIERITE, GALENA, 6);
		}
	},

	RUBY(BeeBranches.LUMINESCE, "Rubis", false, new Color(0xD32B37), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.RUBY, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.SHORTENED);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.RUBY_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(BeeDefinition.UNWEARY, BeeDefinition.AUSTERE, 7);
		}
	},

	SAPPHIRE(BeeBranches.LUMINESCE, "Sapphiris", true, new Color(0x3979BE), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.SAPPHIRE, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.SAPPHIRE_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(RUBY, BeeDefinition.UNWEARY, 7);

		}
	},

	DIAMOND(BeeBranches.LUMINESCE, "Diamonditis", true, new Color(0x8CF4E2), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.DIAMOND, 1), 0.30F)
					.setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, Speed.SLOWER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.DIAMOND_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(GOLD, RUBY, 7);

			if(isTransmutable()) {
				registerEMCMutation(PHILOSOPHERS_STONE, GOLD, 100);
				registerEMCMutation(PHILOSOPHERS_STONE, EMERALD, 100);
			}
		}
	},

	EMERALD(BeeBranches.LUMINESCE, "Emeralditis", false, new Color(0x50C878), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.EMERALD, 1), 0.30F)
					.setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, Lifespan.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, Speed.SLOW);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
		}

		@Override
		protected void registerMutations() {
			registerMutation(BeeDefinition.MONASTIC, DIAMOND, 7);

			if(isTransmutable()) {
				registerEMCMutation(PHILOSOPHERS_STONE, DIAMOND, 100);
			}
		}
	},

	RED_GARNET(BeeBranches.FULGURATED, "Red Garnetitis", true, new Color(0xA03A3F), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.RED_GARNET, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.SHORTENED);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
		}

		@Override
		protected void registerMutations() {
			registerMutation(RUBY, SAPPHIRE, 9);
		}
	},

	YELLOW_GARNET(BeeBranches.FULGURATED, "Yellow Garnetitis", true, new Color(0xB29A69), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.YELLOW_GARNET, 1), 0.30F).setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
		}

		@Override
		protected void registerMutations() {
			registerMutation(RED_GARNET, SAPPHIRE, 9);
		}
	},


	ALMANDINE(BeeBranches.ACHROMATIC, "Almandinis", true, new Color(0xD96763), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.ALMANDINE, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.SHORTENED);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
		}

		@Override
		protected void registerMutations() {
			registerMutation(RED_GARNET, RUBY, 4);
		}
	},

	UVAROVITE(BeeBranches.ACHROMATIC, "Uvarovitis", false, new Color(0x50FF50), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.UVAROVITE, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.SHORTENED);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
		}

		@Override
		protected void registerMutations() {
			registerMutation(ALMANDINE, RUBY, 4);
		}
	},

	CHROME(BeeBranches.ACHROMATIC, "Chromitis", true, new Color(0xFFEEF3), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.CHROME, 1), 0.30F).setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.SHORTENED);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.FAST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
		}

		@Override
		protected void registerMutations() {
			registerMutation(UVAROVITE, ALMANDINE, 4);
		}
	},

	GLOWSTONE(BeeBranches.CADAVEROUSNESS, "Glowstonitis", true, new Color(0x868600), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.GLOWSTONE, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			//TODO: Add Alleles
		}

		@Override
		protected void registerMutations() {
			registerMutation(REDSTONE, NETHER_QUARTZ, 7);
		}
	},

	NETHER_QUARTZ(BeeBranches.CADAVEROUSNESS, "Nether's Quartz", false, new Color(0xDFD8CF), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.NETHER_QUARTZ, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectAggressive);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.NETHER_QUARTZ_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(BeeDefinition.FIENDISH, SAPPHIRE, 10);
		}
	},

	PYRITE(BeeBranches.CADAVEROUSNESS, "Pyritis", false, new Color(0xEC9B7F), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.PYRITE, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectAggressive);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.PYRITE_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(NETHER_QUARTZ, BeeDefinition.FIENDISH, 10);
		}
	},

	CINNABAR(BeeBranches.CADAVEROUSNESS, "Cinnabaris", false, new Color(0xB18073), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.CINNABAR, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectAggressive);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.CINNABAR_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(PYRITE, NETHER_QUARTZ, 12);
		}
	},

	SPHALERITE(BeeBranches.CADAVEROUSNESS, "Sphaleritis", true, new Color(0x96A164), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.SPHALERITE, 1), 0.30F)
					.setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectAggressive);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.SPHALERITE_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(CINNABAR, PYRITE, 7);
		}
	},

	SULFUR(BeeBranches.PHOSPHORESCE, "Sulfuris", true, new Color(0xBD8742), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.SULFUR, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectAggressive);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.FAST);
		}

		@Override
		protected void registerMutations() {
			registerMutation(GALENA, PYRITE, 10);
		}
	},

	CALCITE(BeeBranches.PHOSPHORESCE, "Calcitis", true, new Color(0xBFB18A), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.CALCITE, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectAggressive);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.FAST);
		}

		@Override
		protected void registerMutations() {
			registerMutation(SULFUR, PYRITE, 10);
		}
	},

	PHOSPHOROUS(BeeBranches.PHOSPHORESCE, "Phosphorousis", false, new Color(0xC2B15A), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.PHOSPHOROUS, 1), 0.30F).setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectAggressive);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWERING, EnumAllele.Flowering.FAST);
		}

		@Override
		protected void registerMutations() {
			registerMutation(CALCITE, SULFUR, 8);
		}
	},


	PYROPE(BeeBranches.PLATITUDINOUS, "Pyropis", true, new Color(0x5D3753), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.PYROPE, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectAggressive);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
		}

		@Override
		protected void registerMutations() {
			registerMutation(CINNABAR, ALMANDINE, 8);
		}
	},

	SPESSARTINE(BeeBranches.PLATITUDINOUS, "Spessartinis", false, new Color(0xA44A45), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.SPESSARTINE, 1), 0.30F).setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.SHORTENED);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectAggressive);
		}

		@Override
		protected void registerMutations() {
			registerMutation(PYROPE, ALMANDINE, 10);
		}
	},

	MAGNESIUM(BeeBranches.OBFUSCATED, "Magnesiumis", false, new Color(0xAF8F8F), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.MAGNESIUM, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectAggressive);
		}

		@Override
		protected void registerMutations() {
			registerMutation(SPESSARTINE, PYROPE, 9);
		}
	},

	MANGANESE(BeeBranches.OBFUSCATED, "Manganesis", true, new Color(0xBCCCC3), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.MANGANESE, 1), 0.30F).setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONG);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.TEMPERATURE_TOLERANCE, EnumAllele.Tolerance.DOWN_2);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectAggressive);
		}

		@Override
		protected void registerMutations() {
			registerMutation(MAGNESIUM, SPESSARTINE, 9);
		}
	},

	ENDER_PEARL(BeeBranches.MONOTONOUS, "Enderman's Pearl", true, new Color(0x063931), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.ENDER_PEARL, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectReanimation);
		}

		@Override
		protected void registerMutations() {
			registerMutation(DIAMOND, BeeDefinition.SPECTRAL, 8);

			if(isTransmutable()) {
				registerEMCMutation(PHILOSOPHERS_STONE, IRON, 100);
			}
		}
	},

	PERIDOT(BeeBranches.MONOTONOUS, "Peridotis", true, new Color(0x98DA49), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.PERIDOT, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectReanimation);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.PERIDOT_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(ENDER_PEARL, BAUXITE, 8);
		}
	},

	SODALITE(BeeBranches.MONOTONOUS, "Sodalitis", false, new Color(0x2B3E52), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.SODALITE, 1), 0.30F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectReanimation);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.SODALITE_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(PERIDOT, ENDER_PEARL, 8);
		}
	},

	TUNGSTEN(BeeBranches.MONOTONOUS, "Tungstenis", true, new Color(0x4F5559), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.TUNGSTEN, 1), 0.30F).setHasEffect();

		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.EFFECT, AlleleEffects.effectReanimation);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.TUNGSTEN_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(SODALITE, PERIDOT, 8);
		}
	},

	PLATINUM(BeeBranches.IRRADIATED, "Platinumis", false, new Color(0xE5E4E2), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.PLATINUM, 1), 0.25F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.NORMAL);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.SHELDONITE_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(TUNGSTEN, SPHALERITE, 8);
		}
	},

	TITANIUM(BeeBranches.IRRADIATED, "Titaniumis", true, new Color(0xD3D3DD), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.TITANIUM, 1), 0.25F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGER);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.NORMAL);
		}

		@Override
		protected void registerMutations() {
			registerMutation(PLATINUM, TUNGSTEN, 8);
		}
	},

	IRIDIUM(BeeBranches.IRRADIATED, "Iridiumis", false, new Color(0x3D3C3A), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.IRIDIUM, 1), 0.25F)
			.setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.LIFESPAN, EnumAllele.Lifespan.LONGEST);
			AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPEED, EnumAllele.Speed.SLOWEST);
			//AlleleHelper.getInstance().set(template, EnumBeeChromosome.FLOWER_PROVIDER, FlowerRegister.IRIDIUM_ORE);
		}

		@Override
		protected void registerMutations() {
			registerMutation(TITANIUM, PLATINUM, 4);
		}
	},

	UU_MATTER(BeeBranches.RADIATE, "UU-Mattis", true, new Color(0xFF1493), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.UUMATTER, 1), 0.25F)
			.setHasEffect();
		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {
			registerEMCMutation(BeeSpecies.OMEGA, BeeSpecies.IRIDIUM, 100);
		}
	},

	METHANE(BeeBranches.SEPULCHRAL, "Methanis", false, new Color(0xfb05de), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.METHANE, 1), 0.25F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {
			registerMutation(GOLD, BeeDefinition.TRICKY, 13);
		}
	},

	CARBON(BeeBranches.SEPULCHRAL, "Carbonis", true, new Color(0x000000), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.CARBON, 1), 0.25F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {
			registerMutation(METHANE, GOLD, 12);
		}
	},

	HYDROGEN(BeeBranches.ANEMIC, "Hydrogenis", true, new Color(0x043aff), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.HYDROGEN, 1), 0.25F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {
			registerMutation(BAUXITE, METHANE, 10);
		}
	},

	DEUTERIUM(BeeBranches.ANEMIC, "Deuteriumis", true, new Color(0xffff00), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.DEUTERIUM, 1), 0.25F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {
			registerMutation(DEUTERIUM, TRITIUM, 10);
		}
	},

	TRITIUM(BeeBranches.ANEMIC, "Tritiumis", false, new Color(0xff0004), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.TRITIUM, 1), 0.25F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {
			registerMutation(DEUTERIUM, TRITIUM, 9);
		}
	},

	HELIUM_3(BeeBranches.RADIATE, "Heliumis Three", false, new Color(0xbcbc1b), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.HELIUM_3, 1), 0.25F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {
			registerMutation(DEUTERIUM, TRITIUM, 8);
		}
	},

	HELIUM_PLASMA(BeeBranches.RADIATE, "Heliumis Plasmas", true, new Color(0xf5f6bd), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.HELIUM_PLASMA, 1), 0.25F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {
			registerMutation(HELIUM_3, DEUTERIUM, 8);
		}
	},

	HELIUM(BeeBranches.RADIATE, "Heliumis", false, new Color(0xf5f51e), new Color(0xffdc16)) {
		@Override
		protected void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies) {
			beeSpecies.addProduct(ModItems.BeeComb.getComb(EnumCombType.HELIUM, 1), 0.25F);
		}

		@Override
		protected void setAlleles(IAllele[] template) {

		}

		@Override
		protected void registerMutations() {
			registerMutation(HELIUM_PLASMA, HELIUM_3, 6);
		}
	};

	private boolean active;

	private void setActive(boolean active) {
		this.active = active;
	}

	public void setInactive() {
		setActive(true);
		AlleleManager.alleleRegistry.blacklistAllele(species.getUID());
	}

	public void setIsActive() {
		setActive(false);
	}

	public boolean getActive() {
		return active;
	}

	public static boolean isTransmutable() {
		if(Loader.isModLoaded("projecte")) {
			return Config.isTransmutable;
		}
		return false;
	}

	private final IBranchDefinition branch;
	private final IAlleleBeeSpecies species;
	
	@Nullable
	private IAllele[] template;
	
	@Nullable
	private IBeeGenome genome;

	BeeSpecies(IBranchDefinition branch, String binomial, boolean dominant, Color primary, Color secondary) {
		String lowercaseName = this.toString().toLowerCase(Locale.ENGLISH);
		String species = "species" + WordUtils.capitalize(lowercaseName);
		
		String modID = RetroBees.MOD_ID;
		String UID = modID + ".species." + species;
		String description = "for.description." + species;
		String name = "for.bees.species." + lowercaseName;
		
		this.branch = branch;

		IAlleleBeeSpeciesBuilder speciesBuilder = BeeManager.beeFactory.createSpecies(modID, UID, dominant, "TheSledgeHammer", name, description, branch.getBranch(), binomial, primary.getRGB(), secondary.getRGB());
		
		if (isSecret()) {
			speciesBuilder.setIsSecret();
		}
		setSpeciesProperties(speciesBuilder);
		this.species = speciesBuilder.build();
	}

	protected abstract void setSpeciesProperties(IAlleleBeeSpeciesBuilder beeSpecies);

	protected abstract void setAlleles(IAllele[] template);

	protected abstract void registerMutations();

	protected boolean isSecret() {
		return false;
	}
	
	public static void initBees() {
		for(BeeSpecies bee : values()) {
			bee.init();
		}
		for(BeeSpecies bee : values()) {
			bee.registerMutations();
		}
	}

	public static void preInit() {
		MinecraftForge.EVENT_BUS.post(new AlleleSpeciesRegisterEvent<>(BeeManager.beeRoot, IAlleleBeeSpecies.class));
	}

	private void init() {
		template = branch.getTemplate();
		AlleleHelper.getInstance().set(template, EnumBeeChromosome.SPECIES, species);
		setAlleles(template);

		genome = BeeManager.beeRoot.templateAsGenome(template);
		
		BeeManager.beeRoot.registerTemplate(template);
	}
	
	@Override
	public final IAllele[] getTemplate() {
		return Arrays.copyOf(template, template.length);
	}

	@Override
	public final IBeeGenome getGenome() {
		return genome;
	}

	@Override
	public final IBee getIndividual() {
		return new Bee(genome);
	}

	@Override
	public final ItemStack getMemberStack(EnumBeeType beeType) {
		IBee bee = getIndividual();
		return BeeManager.beeRoot.getMemberStack(bee, beeType);
	}

	public final IBeeDefinition getRainResist() {
		return new BeeVariation.RainResist(this);
	}
	
	public final IBeeMutationBuilder registerMutation(IBeeDefinition parent1, IBeeDefinition parent2, int chance) {
		return registerMutation(parent1.getGenome().getPrimary(), parent2.getGenome().getPrimary(), getTemplate(), chance);
	}

	public static IBeeMutationBuilder registerMutation(IBeeDefinition parent1, IBeeDefinition parent2, IBeeDefinition mutation, int chance) {
		return registerMutation(parent1.getGenome().getPrimary(), parent2.getGenome().getPrimary(), mutation.getTemplate(), chance);
	}
	
	public static IBeeMutationBuilder registerMutation(IAlleleBeeSpecies parent1, IAlleleBeeSpecies parent2, IAllele[] template, int chance) {
		return BeeManager.beeMutationFactory.createMutation(parent1, parent2, template, chance);
	}
	
	//Register EMC Mutation Variant:
	public final IBeeMutationBuilder registerEMCMutation(IBeeDefinition parent1, IBeeDefinition parent2, int chance) {
		return registerEMCMutation(parent1.getGenome().getPrimary(), parent2.getGenome().getPrimary(), getTemplate(), chance);
	}

	public static IBeeMutationBuilder registerEMCMutation(IBeeDefinition parent1, IBeeDefinition parent2, IBeeDefinition mutation, int chance) {
		return registerEMCMutation(parent1.getGenome().getPrimary(), parent2.getGenome().getPrimary(), mutation.getTemplate(), chance);
	}
	
	public static IBeeMutationBuilder registerEMCMutation(IAlleleBeeSpecies parent1, IAlleleBeeSpecies parent2, IAllele[] template, int chance) {
		return BeeManagerRetroBees.beeMutationFactoryEMC.createMutation(parent1, parent2, template, chance);
	}
}