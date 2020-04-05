/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees;

import com.thesledgehammer.retrobees.proxy.ClientProxy;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RetroBees.MOD_ID)
public class RetroBees {

	public static final String MOD_ID = "retrobees";

	public static RetroBees instance;
	static ModContainer MOD_CONTAINER;

	public static final Logger logger = LogManager.getLogger();

	public RetroBees() {
		instance = this;
		MOD_CONTAINER = ModLoadingContext.get().getActiveContainer();

		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientProxy::ClientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientProxy::CommonSetup);
	}

	public boolean isModLoaded(String modTarget) {
		ModList modList = ModList.get();
		return modList.isLoaded(modTarget);
	}
}
