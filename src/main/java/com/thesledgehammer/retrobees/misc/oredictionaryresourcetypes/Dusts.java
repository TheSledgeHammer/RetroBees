/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.misc.oredictionaryresourcetypes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class Dusts {
	
	private ArrayList<ItemStack> Dust = new ArrayList<>();

	public Dusts() {
		setDustUID(Dust);
	}

	public Dusts(ArrayList<ItemStack> Dust) {
		setDustUID(Dust);
	}

	public ArrayList<ItemStack> getDustUIDs() {
		return Dust;
	}

	public ItemStack getDustUID(int index) {
		return Dust.get(index);
	}
	
	private void setDustUID(ArrayList<ItemStack> Dust) {
		this.Dust = Dust;
		Dust.addAll(OreDictionary.getOres("dustCopper"));			// 0
		Dust.addAll(OreDictionary.getOres("dustSilver")); 		// 1
		Dust.addAll(OreDictionary.getOres("dustLead")); 			// 2
		Dust.addAll(OreDictionary.getOres("dustTin")); 			// 3
		Dust.addAll(OreDictionary.getOres("dustAluminium")); 		// 4
		Dust.addAll(OreDictionary.getOres("dustGalena")); 		// 5
		Dust.addAll(OreDictionary.getOres("dustRuby")); 			// 6
		Dust.addAll(OreDictionary.getOres("dustSapphire")); 		// 7
		Dust.addAll(OreDictionary.getOres("dustBauxite")); 		// 8
		Dust.addAll(OreDictionary.getOres("dustCinnabar")); 		// 9
		Dust.addAll(OreDictionary.getOres("dustSphalerite")); 	// 10
		Dust.addAll(OreDictionary.getOres("dustTungsten")); 		// 11
		Dust.addAll(OreDictionary.getOres("dustPeridot")); 		// 12
		Dust.addAll(OreDictionary.getOres("dustSodalite")); 		// 13
		Dust.addAll(OreDictionary.getOres("dustIridium")); 		// 14
		Dust.addAll(OreDictionary.getOres("dustPyrite")); 		// 15
		Dust.addAll(OreDictionary.getOres("dustSheldonite")); 	// 16
		Dust.addAll(OreDictionary.getOres("dustIron"));			// 17
		Dust.addAll(OreDictionary.getOres("dustGold"));			// 18
		Dust.addAll(OreDictionary.getOres("dustEmerald"));		// 19
		Dust.addAll(OreDictionary.getOres("dustDiamond"));		// 20
		//Dust.addAll(OreDictionary.getOres("dust"));
	}
}
