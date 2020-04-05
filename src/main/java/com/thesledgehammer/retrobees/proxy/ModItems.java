/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.proxy;

import com.thesledgehammer.retrobees.items.ItemCombType;
import com.thesledgehammer.retrobees.items.ItemDropType;
import com.thesledgehammer.retrobees.proxy.ClientProxy;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

	public static ItemCombType BeeComb;
	public static ItemDropType HoneyDrop;

	public static void init() {
		HoneyDrop = registerItem(new ItemDropType(), "honeydrop");
		//OreDictionary.registerOre(OreDictUtil.DROP_HONEY, HoneyDrop.getWildcard());

		BeeComb = registerItem(new ItemCombType(), "beecomb");
		//OreDictionary.registerOre(OreDictUtil.BEE_COMB, BeeComb.getWildcard());
	}

	@OnlyIn(Dist.CLIENT)
	public static void initModels() {
		HoneyDrop.initModel();
		BeeComb.initModel();
	}

	private static <T extends Item> T registerItem(T item, String name) {
		item.setRegistryName(name);
		ClientProxy.registerItem(item);
		ForgeRegistries.ITEMS.register(item);
		return item;
	}
}