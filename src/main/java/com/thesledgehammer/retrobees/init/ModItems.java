/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.init;

import com.thesledgehammer.retrobees.RetroBees;
import com.thesledgehammer.retrobees.items.ItemCombType;
import com.thesledgehammer.retrobees.items.ItemDropType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {

	public static ItemCombType BeeComb;
	public static ItemDropType HoneyDrop;

	public static void init() {
		HoneyDrop = registerItem(new ItemDropType(), "honeydrop");
		BeeComb = registerItem(new ItemCombType(), "beecomb");
	}

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		HoneyDrop.initModel();
		BeeComb.initModel();
	}

	private static <T extends Item> T registerItem(T item, String name) {
		item.setUnlocalizedName(name);
		item.setRegistryName(name);
		ForgeRegistries.ITEMS.register(item);
		RetroBees.proxy.registerItem(item);
		return item;
	}

	private static <T extends Item> T registerOreItem(T item, String oreDicName) {
		ForgeRegistries.ITEMS.register(item);
		RetroBees.proxy.registerItem(item);
		OreDictionary.registerOre(oreDicName, item);
		return item;
	}

	private static void registerOreDict(String oreDictName, ItemStack itemStack) {
		OreDictionary.registerOre(oreDictName, itemStack);
	}
	
	private static ItemStack createItemForOreName(String oreName, String registryName) {
		ItemStack oreItem = new ItemStack(registerItem(new Item(), registryName));
		OreDictionary.registerOre(oreName, oreItem);
		return oreItem;
	}
}