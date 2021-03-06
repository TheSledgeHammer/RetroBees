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

public class Ores {

	private ArrayList<ItemStack> Ore = new ArrayList<>();

	public Ores() {
		setOreUID(Ore);
	}

	public Ores(ArrayList<ItemStack> Ore) {
		setOreUID(Ore);
	}

	public ArrayList<ItemStack> getOreUID() {
		return Ore;
	}

	public ItemStack getOreUID(int index) {
		return Ore.get(index);
	}

	private void setOreUID(ArrayList<ItemStack> Ore) {
		this.Ore = Ore;
		Ore.addAll(OreDictionary.getOres("oreCopper")); 	// 0
		Ore.addAll(OreDictionary.getOres("oreSilver")); 	// 1
		Ore.addAll(OreDictionary.getOres("oreLead")); 		// 2
		Ore.addAll(OreDictionary.getOres("oreTin")); 		// 3
		Ore.addAll(OreDictionary.getOres("oreAluminium")); 	// 4
		Ore.addAll(OreDictionary.getOres("oreGalena")); 	// 5
		Ore.addAll(OreDictionary.getOres("oreRuby")); 		// 6
		Ore.addAll(OreDictionary.getOres("oreSapphire")); 	// 7
		Ore.addAll(OreDictionary.getOres("oreBauxite")); 	// 8
		Ore.addAll(OreDictionary.getOres("oreCinnabar")); 	// 9
		Ore.addAll(OreDictionary.getOres("oreSphalerite")); // 10
		Ore.addAll(OreDictionary.getOres("oreTungsten")); 	// 11
		Ore.addAll(OreDictionary.getOres("orePeridot")); 	// 12
		Ore.addAll(OreDictionary.getOres("oreSodalite")); 	// 13
		Ore.addAll(OreDictionary.getOres("oreIridium")); 	// 14
		Ore.addAll(OreDictionary.getOres("orePyrite")); 	// 15
		Ore.addAll(OreDictionary.getOres("oreSheldonite")); // 16
	}
}
