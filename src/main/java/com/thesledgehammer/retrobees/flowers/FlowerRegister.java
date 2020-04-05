/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.flowers;

import com.thesledgehammer.retrobees.RetroBees;
import com.thesledgehammer.retrobees.misc.oredictionaryresourcetypes.Ores;
import moze_intel.projecte.gameObjs.ObjHandler;
import net.minecraft.block.Block;

public class FlowerRegister {

	public static final String FlowerType = "flowers";

	public static final String FlowerDarkMatter = "DarkMatter";
	public static final String FlowerRedMatter = "RedMatter";
	public static final String FlowerCoal = "Coal";
	public static final String FlowerDiamond = "Diamond";
	public static final String FlowerRedstone = "Redstone";
	public static final String FlowerNetherQuartz = "Nether Quartz";
	public static final String FlowerIron = "Iron";
	public static final String FlowerGold = "Gold";
	public static final String FlowerCopper = "Copper";
	public static final String FlowerSilver = "Silver";
	public static final String FlowerLead = "Lead";
	public static final String FlowerTin = "Tin";
	public static final String FlowerAluminium = "Aluminium";
	public static final String FlowerGalena = "Galena";
	public static final String FlowerRuby = "Ruby";
	public static final String FlowerSapphire = "Sapphire";
	public static final String FlowerBauxite = "Bauxite";
	public static final String FlowerCinnabar = "Cinnabar";
	public static final String FlowerSphalerite = "Sphalerite";
	public static final String FlowerTungsten = "Tungsten";
	public static final String FlowerPeridot = "Peridot";
	public static final String FlowerSodalite = "Sodalite";
	public static final String FlowerIridium = "Iridium";
	public static final String FlowerPyrite = "Pyrite";
	public static final String FlowerSheldonite = "Sheldonite";

	public static IAlleleFlowers DARKMATTER;
	public static IAlleleFlowers REDMATTER;
	public static IAlleleFlowers COAL_ORE;
	public static IAlleleFlowers DIAMOND_ORE;
	public static IAlleleFlowers REDSTONE_ORE;
	public static IAlleleFlowers NETHER_QUARTZ_ORE;
	public static IAlleleFlowers IRON_ORE;
	public static IAlleleFlowers GOLD_ORE;
	public static IAlleleFlowers COPPER_ORE;
	public static IAlleleFlowers SILVER_ORE;
	public static IAlleleFlowers LEAD_ORE;
	public static IAlleleFlowers TIN_ORE;
	public static IAlleleFlowers ALUMINIUM_ORE;
	public static IAlleleFlowers GALENA_ORE;
	public static IAlleleFlowers RUBY_ORE;
	public static IAlleleFlowers SAPPHIRE_ORE;
	public static IAlleleFlowers BAUXITE_ORE;
	public static IAlleleFlowers CINNABAR_ORE;
	public static IAlleleFlowers SPHALERITE_ORE;
	public static IAlleleFlowers TUNGSTEN_ORE;
	public static IAlleleFlowers PERIDOT_ORE;
	public static IAlleleFlowers SODALITE_ORE;
	public static IAlleleFlowers IRIDIUM_ORE;
	public static IAlleleFlowers PYRITE_ORE;
	public static IAlleleFlowers SHELDONITE_ORE;

	public static void initFlowers() {
		FlowerRegistry flowerRegistry = (FlowerRegistry) FlowerManager.flowerRegistry;
		registerVanillaFlowers(flowerRegistry);

		registerProjectEFlowers(flowerRegistry);
		registerTechRebornFlowers(flowerRegistry);
		registerFlowerAlleles();
	}

	private static void registerFlowerAlleles() {
		DARKMATTER = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerDarkMatter, EnumFlowers.DARKMATTER.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		REDMATTER = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerRedMatter, EnumFlowers.REDMATTER.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);

		COAL_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerCoal, EnumFlowers.COAL.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		IRON_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerIron, EnumFlowers.IRON.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		GOLD_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerGold, EnumFlowers.GOLD.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		DIAMOND_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerDiamond, EnumFlowers.DIAMOND.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		REDSTONE_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerRedstone, EnumFlowers.REDSTONE.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		NETHER_QUARTZ_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerNetherQuartz, EnumFlowers.NETHER_QUARTZ.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		COPPER_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerCopper, EnumFlowers.COPPER.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		SILVER_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerSilver, EnumFlowers.SILVER.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		LEAD_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerLead, EnumFlowers.LEAD.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		TIN_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerTin, EnumFlowers.TIN.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		ALUMINIUM_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerAluminium, EnumFlowers.ALUMINUM.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		GALENA_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerGalena, EnumFlowers.GALENA.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		RUBY_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerRuby, EnumFlowers.RUBY.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		SAPPHIRE_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerSapphire, EnumFlowers.SAPPHIRE.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		BAUXITE_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerBauxite, EnumFlowers.BAUXITE.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		CINNABAR_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerCinnabar, EnumFlowers.CINNABAR.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		SPHALERITE_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerSphalerite, EnumFlowers.SPHALERITE.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		TUNGSTEN_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerTungsten, EnumFlowers.TUNGSTEN.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		PERIDOT_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerPeridot, EnumFlowers.PERIDOT.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		SODALITE_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerSodalite, EnumFlowers.SODALITE.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		IRIDIUM_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerIridium, EnumFlowers.IRIDIUM.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
		PYRITE_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerPyrite, EnumFlowers.PYRITE.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER);
		SHELDONITE_ORE = AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerType, FlowerSheldonite, EnumFlowers.SHELDONITE.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER);
	}

	private static void registerVanillaFlowers(FlowerRegistry flowerRegistry) {
		flowerRegistry.registerAcceptableFlower(Blocks.COAL_ORE, FlowerCoal);
		flowerRegistry.registerAcceptableFlower(Blocks.IRON_ORE, FlowerIron);
		flowerRegistry.registerAcceptableFlower(Blocks.GOLD_ORE, FlowerGold);
		flowerRegistry.registerAcceptableFlower(Blocks.DIAMOND_ORE, FlowerDiamond);
		flowerRegistry.registerAcceptableFlower(Blocks.REDSTONE_ORE, FlowerRedstone);
		flowerRegistry.registerAcceptableFlower(Blocks.QUARTZ_ORE, FlowerNetherQuartz);
	}

	private static void registerProjectEFlowers(FlowerRegistry flowerRegistry) {
		if (RetroBees.instance.isModLoaded("ProjectE")) {
			Block DarkMatterBlock = ObjHandler.dmBlock;
			Block RedMatterBlock = ObjHandler.rmBlock;
			flowerRegistry.registerAcceptableFlower(DarkMatterBlock, FlowerDarkMatter);
			flowerRegistry.registerAcceptableFlower(RedMatterBlock, FlowerDarkMatter);
		}
	}

	private static void registerTechRebornFlowers(FlowerRegistry flowerRegistry) {
		Ores ore = new Ores();
		if (RetroBees.instance.isModLoaded("TechReborn")) {
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(0).getItem()), FlowerCopper);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(1).getItem()), FlowerSilver);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(2).getItem()), FlowerLead);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(3).getItem()), FlowerTin);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(4).getItem()), FlowerAluminium);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(5).getItem()), FlowerGalena);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(6).getItem()), FlowerRuby);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(7).getItem()), FlowerSapphire);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(8).getItem()), FlowerBauxite);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(9).getItem()), FlowerCinnabar);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(10).getItem()), FlowerSphalerite);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(11).getItem()), FlowerTungsten);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(12).getItem()), FlowerPeridot);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(13).getItem()), FlowerSodalite);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(14).getItem()), FlowerIridium);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(15).getItem()), FlowerPyrite);
			flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(16).getItem()), FlowerSheldonite);
		}
	}
}
