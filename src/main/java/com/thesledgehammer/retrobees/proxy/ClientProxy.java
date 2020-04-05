/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ClientProxy {

	public static void ClientSetup(FMLClientSetupEvent event) {
		ObjectBatchLoader.initModels();
	}

	public static void CommonSetup(FMLCommonSetupEvent event) {
		ObjectManager.RegisterColors();
	}

	public static void registerItem(Item item) {
		ObjectManager.registerItemClient(item);
	}

	public static void registerBlock(Block block) {
		ObjectManager.registerBlockClient(block);
	}
}
