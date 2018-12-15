/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.proxy;

import com.thesledgehammer.retrobees.init.ObjectBatchLoader;
import com.thesledgehammer.retrobees.input.InputHandler;
import com.thesledgehammer.retrobees.input.KeyBindings;
import com.thesledgehammer.retrobees.misc.ObjectManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		// Typically initialization of models and such goes here:
		ObjectBatchLoader.initModels();
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		MinecraftForge.EVENT_BUS.register(new InputHandler());
		ObjectManager.ColorRegister();
		KeyBindings.init();
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}

	@Override
	public void registerItem(Item item) {
		ObjectManager.registerItemClient(item);
	}

	@Override
	public void registerBlock(Block block) {
		ObjectManager.registerBlockClient(block);
	}
}
