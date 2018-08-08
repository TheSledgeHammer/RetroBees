package com.thesledgehammer.retrobees.misc;

import com.thesledgehammer.retrobees.init.ModItems;
import com.thesledgehammer.retrobees.items.EnumDropType;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryRegister {
	
	public static final String BEE_COMB = "beeComb";
	public static final String DROP_HONEY = "dropHoney";
	
	public static void init() {
		OreDictionary.registerOre(BEE_COMB, ModItems.BeeComb);
		OreDictionary.registerOre(DROP_HONEY, ModItems.HoneyDrop);
		//OreDictionary.registerOre(techreborn.init.ModItems.UU_MATTER.getUnlocalizedName(), ModItems.HoneyDrop.getDrop(EnumDropType.UUMATTER, 1));
	}
}
