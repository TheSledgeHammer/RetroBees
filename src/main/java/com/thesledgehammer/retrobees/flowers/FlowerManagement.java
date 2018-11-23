package com.thesledgehammer.retrobees.flowers;

public class FlowerManagement {

    /*
    public static void initFlowers() {
        //FlowerRegistry flowerRegistry = (FlowerRegistry) FlowerManager.flowerRegistry;
        //registerVanillaFlowers(flowerRegistry);
        //registerProjectEFlowers(flowerRegistry);
        //registerTechRebornFlowers(flowerRegistry);
    }

    private static void registerVanillaFlowers(FlowerRegistry flowerRegistry) {
        flowerRegistry.registerAcceptableFlower(Blocks.COAL_ORE, EnumFlowerAlleles.COAL_ORE.getFlowerType());
        flowerRegistry.registerAcceptableFlower(Blocks.IRON_ORE, EnumFlowerAlleles.IRON_ORE.getFlowerType());
        flowerRegistry.registerAcceptableFlower(Blocks.GOLD_ORE, EnumFlowerAlleles.GOLD_ORE.getFlowerType());
        flowerRegistry.registerAcceptableFlower(Blocks.DIAMOND_ORE, EnumFlowerAlleles.DIAMOND_ORE.getFlowerType());
        flowerRegistry.registerAcceptableFlower(Blocks.REDSTONE_ORE, EnumFlowerAlleles.REDSTONE_ORE.getFlowerType());
        flowerRegistry.registerAcceptableFlower(Blocks.QUARTZ_ORE, EnumFlowerAlleles.NETHER_QUARTZ_ORE.getFlowerType());
    }

    private static void registerProjectEFlowers(FlowerRegistry flowerRegistry) {
        if (Loader.isModLoaded("ProjectE")) {
            flowerRegistry.registerAcceptableFlower(ObjHandler.matterBlock.getDefaultState().withProperty(PEStateProps.TIER_PROP, EnumMatterType.DARK_MATTER), EnumFlowerAlleles.DARKMATTER.getFlowerType());
            flowerRegistry.registerAcceptableFlower(ObjHandler.matterBlock.getDefaultState().withProperty(PEStateProps.TIER_PROP, EnumMatterType.RED_MATTER), EnumFlowerAlleles.REDMATTER.getFlowerType());
        }
    }

    private static void registerTechRebornFlowers(FlowerRegistry flowerRegistry) {
        Ores ore = new Ores();
        if (Loader.isModLoaded("TechReborn")) {
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(0).getItem()), EnumFlowerAlleles.COPPER_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(1).getItem()), EnumFlowerAlleles.SILVER_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(2).getItem()), EnumFlowerAlleles.LEAD_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(3).getItem()), EnumFlowerAlleles.TIN_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(4).getItem()), EnumFlowerAlleles.ALUMINIUM_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(5).getItem()), EnumFlowerAlleles.GALENA_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(6).getItem()), EnumFlowerAlleles.RUBY_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(7).getItem()), EnumFlowerAlleles.SAPPHIRE_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(8).getItem()), EnumFlowerAlleles.BAUXITE_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(9).getItem()), EnumFlowerAlleles.CINNABAR_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(10).getItem()), EnumFlowerAlleles.SPHALERITE_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(11).getItem()), EnumFlowerAlleles.TUNGSTEN_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(12).getItem()), EnumFlowerAlleles.PERIDOT_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(13).getItem()), EnumFlowerAlleles.SODALITE_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(14).getItem()), EnumFlowerAlleles.IRIDIUM_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(15).getItem()), EnumFlowerAlleles.PYRITE_ORE.getFlowerType());
            flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(ore.getOreUID(16).getItem()), EnumFlowerAlleles.SHELDONITE_ORE.getFlowerType());
        }
    }

    	public enum EnumFlowerAlleles implements IStringSerializable {

		DARKMATTER(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerDarkMatter, EnumFlowers.DARKMATTER.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),
		REDMATTER(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerRedMatter, EnumFlowers.REDMATTER.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER)),

		COAL_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerCoal, EnumFlowers.COAL.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),
		IRON_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerIron, EnumFlowers.IRON.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),
		GOLD_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerGold, EnumFlowers.GOLD.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER)),
		DIAMOND_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerDiamond, EnumFlowers.DIAMOND.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),
		REDSTONE_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerRedstone, EnumFlowers.REDSTONE.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),
		NETHER_QUARTZ_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerNetherQuartz, EnumFlowers.NETHER_QUARTZ.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),

		COPPER_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerCopper, EnumFlowers.COPPER.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),
		SILVER_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerSilver, EnumFlowers.SILVER.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER)),
		LEAD_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerLead, EnumFlowers.LEAD.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),
		TIN_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerTin, EnumFlowers.TIN.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER)),
		ALUMINIUM_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerAluminium, EnumFlowers.ALUMINUM.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),
		GALENA_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerGalena, EnumFlowers.GALENA.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER)),
		RUBY_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerRuby, EnumFlowers.RUBY.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),
		SAPPHIRE_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerSapphire, EnumFlowers.SAPPHIRE.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER)),
		BAUXITE_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerBauxite, EnumFlowers.BAUXITE.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),
		CINNABAR_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerCinnabar, EnumFlowers.CINNABAR.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER)),
		SPHALERITE_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerSphalerite, EnumFlowers.SPHALERITE.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),
		TUNGSTEN_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerTungsten, EnumFlowers.TUNGSTEN.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER)),
		PERIDOT_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerPeridot, EnumFlowers.PERIDOT.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),
		SODALITE_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerSodalite, EnumFlowers.SODALITE.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER)),
		IRIDIUM_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerIridium, EnumFlowers.IRIDIUM.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER)),
		PYRITE_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerPyrite, EnumFlowers.PYRITE.getValue(), true, EnumBeeChromosome.FLOWER_PROVIDER)),
		SHELDONITE_ORE(AlleleManager.alleleFactory.createFlowers(RetroBees.MOD_ID, FlowerRegister.FlowerType, FlowerRegister.FlowerSheldonite, EnumFlowers.SHELDONITE.getValue(), false, EnumBeeChromosome.FLOWER_PROVIDER));

		public static final EnumFlowerAlleles[] VALUES = values();

		private final String name;
		private final IAlleleFlowers alleleFlowers;

		EnumFlowerAlleles(IAlleleFlowers alleleFlowers) {
			this.name = toString().toLowerCase(Locale.ENGLISH);
			this.alleleFlowers = alleleFlowers;
		}

		@Override
		public String getName() {
			return name;
		}

		public IAlleleFlowers getFlowerAllele() {
			return alleleFlowers;
		}

		public String getFlowerType() {
			return alleleFlowers.getProvider().getFlowerType();
		}

		public static EnumFlowerAlleles get(int meta) {
			if(meta >= VALUES.length) {
				meta = 0;
			}
			return VALUES[meta];
		}
	}*/
}
