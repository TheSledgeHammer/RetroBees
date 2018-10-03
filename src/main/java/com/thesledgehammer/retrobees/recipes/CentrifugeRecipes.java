package com.thesledgehammer.retrobees.recipes;

import com.google.common.collect.ImmutableMap;
import com.thesledgehammer.retrobees.init.ModItems;
import com.thesledgehammer.retrobees.init.ObjectBatchLoader;
import com.thesledgehammer.retrobees.items.EnumCombType;
import com.thesledgehammer.retrobees.items.EnumDropType;

import forestry.api.recipes.RecipeManagers;
import forestry.apiculture.ModuleApiculture;
import net.minecraft.item.ItemStack;
import techreborn.api.TechRebornAPI;

public class CentrifugeRecipes {

	public static void registerCentrifugeRecipes() {

        //CENTRIFUGE
		//Darkened comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.DARKENED, 1), ImmutableMap.of(
                ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				ModItems.HoneyDrop.getDrop(EnumDropType.CHARGED, 1), 0.15f
        ));
			
		//Reddened comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.REDDENED, 1), ImmutableMap.of(
                ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				ModItems.HoneyDrop.getDrop(EnumDropType.CHARGED, 2), 0.15f
        ));
			
		//Omega comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.OMEGA, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				ModItems.HoneyDrop.getDrop(EnumDropType.OMEGA, 1), 0.15f
		));
			
		//Iron comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.IRON, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("iron"), 0.5f
		));
			
        //Copper comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.COPPER, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("copper"), 0.5f
		));
			
		//Silver comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.SILVER, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("silver"), 0.5f
		));
			
		//Gold comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.GOLD, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("gold"), 0.5f
		));
			
		//Tin comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.TIN, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("tin"), 0.5f
		));
			
		//Aluminum comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.ALUMINUM, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("aluminum"), 0.5f
		));
			
		//Lead comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.LEAD, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("lead"), 0.5f
        ));
			
		//Ruby comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.RUBY, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("ruby"), 0.5f
		));
			
		//Sapphire comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.SAPPHIRE, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("sapphire"), 0.5f
		));
			
		//Sulfur comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.SULFUR, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("sulfur"), 0.5f
		));
			
		//Calcite comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.CALCITE, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("calcite"), 0.5f
		));
			
		//Phosphorous comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.PHOSPHOROUS, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("phosphorous"), 0.5f
		));
			
		//Galena comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.GALENA, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("galena"), 0.5f
		));
			
		//Garnierite comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.GARNIERITE, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("nickel"), 0.5f
		));
			
		//Bauxite comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.BAUXITE, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("bauxite"), 0.5f
		));
			
		//Red Garnet comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.RED_GARNET, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("red_garnet"), 0.5f
		));
			
		//Yellow Garnet comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.YELLOW_GARNET, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("yellow_garnet"), 0.5f
		));
			
		//Magnesium comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.MAGNESIUM, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("magnesium"), 0.5f
		));
			
		//Maganese comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.MANGANESE, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("manganese"), 0.5f
		));
			
		//Peridot comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.PERIDOT, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("peridot"), 0.5f
		));
			
		//Sodalite comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.SODALITE, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("sodalite"), 0.5f
		));
			
		//Tungsten comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.TUNGSTEN, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("tungsten"), 0.5f
		));
			
		//Pyrite comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.PYRITE, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("pyrite"), 0.5f
		));
			
		//Cinnabar comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.CINNABAR, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("cinnabar"), 0.5f
		));
			
		//Sphalerite comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.SPHALERITE, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("sphalerite"), 0.5f
		));
			
		//Pyrope comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.PYROPE, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("pyrope"), 0.5f
		));
			
		//Spessartine comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.SPESSARTINE, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("spessartine"), 0.5f
		));

		//Almandine comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.ALMANDINE, 1), ImmutableMap.of(
                ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("almandine"), 0.5f
        ));
			
		//Uvarovite comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.UVAROVITE, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("uvarovite"), 0.5f
		));
			
		//Chrome comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.CHROME, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("chrome"), 0.5f
		));
			
		//Platinum comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.PLATINUM, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("platinum"), 0.5f
		));
			
		//Titanium comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.TITANIUM, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getDustByName("titanium"), 0.5f
		));
			
		//Iridium comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.IRIDIUM, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				TechRebornAPI.subItemRetriever.getNuggetByName("iridium"), 0.6f
		));

		//Carbon comb
        RecipeManagers.centrifugeManager.addRecipe(20,ModItems.BeeComb.getComb(EnumCombType.CARBON, 1), ImmutableMap.of(
				ModItems.HoneyDrop.getDrop(EnumDropType.CARBON, 1), 0.15f
		));

		//Hydrogen comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.HYDROGEN, 1), ImmutableMap.of(
				ModItems.HoneyDrop.getDrop(EnumDropType.HYDROGEN, 1), 0.15f
		));

		//Methane comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.METHANE, 1), ImmutableMap.of(
				ModItems.HoneyDrop.getDrop(EnumDropType.METHANE, 1), 0.15f
		));

		//Deuterium comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.DEUTERIUM, 1), ImmutableMap.of(
				ModItems.HoneyDrop.getDrop(EnumDropType.DEUTERIUM, 1), 0.15f
		));

		//Tritium comb
        RecipeManagers.centrifugeManager.addRecipe(20,ModItems.BeeComb.getComb(EnumCombType.TRITIUM, 1), ImmutableMap.of(
				ModItems.HoneyDrop.getDrop(EnumDropType.TRITIUM, 1), 0.15f
		));

		//Helium comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.HELIUM, 1), ImmutableMap.of(
				ModItems.HoneyDrop.getDrop(EnumDropType.HELIUM, 1), 0.15f
		));

		//Helium 2 comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.HELIUM_3, 1), ImmutableMap.of(
				ModItems.HoneyDrop.getDrop(EnumDropType.HELIUM_3, 1), 0.15f
		));

		//Helium Plasma comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.HELIUM_PLASMA, 1), ImmutableMap.of(
				ModItems.HoneyDrop.getDrop(EnumDropType.HELIUM_PLASMA, 1), 0.15f
		));
			
		//UU-Matter comb
        RecipeManagers.centrifugeManager.addRecipe(20, ModItems.BeeComb.getComb(EnumCombType.UUMATTER, 1), ImmutableMap.of(
				ModuleApiculture.getItems().honeyDrop.getItemStack(), 0.2f,
				//ModItems.HoneyDrop.getDrop(EnumDropType.UUMATTER, 1), 0.3f,
				new ItemStack(techreborn.init.ModItems.UU_MATTER, 1), 0.15f
		));
	}
}