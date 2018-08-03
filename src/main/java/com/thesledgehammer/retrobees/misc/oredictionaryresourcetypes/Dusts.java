package com.thesledgehammer.retrobees.misc.oredictionaryresourcetypes;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Dusts {
	
	private ArrayList<ItemStack> Dust = new ArrayList<ItemStack>(20);

	public Dusts() {
		setDustUID(Dust);
	}

	public Dusts(ArrayList<ItemStack> Dust) {
		setDustUID(Dust);
	}

	public ArrayList<ItemStack> getDustUID() {
		return Dust;
	}

	public ItemStack getDustUID(int index) {
		return Dust.get(index);
	}
	
	private void setDustUID(ArrayList<ItemStack> Dust) {
		this.Dust = Dust;
		Dust.addAll(OreDictionary.getOres("dustCopper"));		// 0
		Dust.addAll(OreDictionary.getOres("dustSilver")); 		// 1
		Dust.addAll(OreDictionary.getOres("dustLead")); 		// 2
		Dust.addAll(OreDictionary.getOres("dustTin")); 			// 3
		Dust.addAll(OreDictionary.getOres("dustAluminium")); 	// 4
		Dust.addAll(OreDictionary.getOres("dustGalena")); 		// 5
		Dust.addAll(OreDictionary.getOres("dustRuby")); 		// 6
		Dust.addAll(OreDictionary.getOres("dustSapphire")); 	// 7
		Dust.addAll(OreDictionary.getOres("dustBauxite")); 		// 8
		Dust.addAll(OreDictionary.getOres("dustCinnabar")); 	// 9
		Dust.addAll(OreDictionary.getOres("dustSphalerite")); 	// 10
		Dust.addAll(OreDictionary.getOres("dustTungsten")); 	// 11
		Dust.addAll(OreDictionary.getOres("dustPeridot")); 		// 12
		Dust.addAll(OreDictionary.getOres("dustSodalite")); 	// 13
		Dust.addAll(OreDictionary.getOres("dustIridium")); 		// 14
		Dust.addAll(OreDictionary.getOres("dustPyrite")); 		// 15
		Dust.addAll(OreDictionary.getOres("dustSheldonite")); 	// 16
	}
}
