/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees;

import com.thesledgehammer.retrobees.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


@Mod(
		modid = RetroBees.MOD_ID,
		name = "RetroBees",
		version = RetroBees.VERSION,
		acceptedMinecraftVersions = RetroBees.MCVERSION,
		updateJSON = RetroBees.UPDATE_JSON,
		dependencies = "required-after:forestry;",
		certificateFingerprint = "616437EBB587FE5A83EE547EA1D2E1C403B074CF"
)
public class RetroBees {

	public static final String MOD_ID = "retrobees";
	public static final String VERSION = "@VERSION@";
	public static final String MCVERSION = "1.12.2";
	public static final String UPDATE_JSON = "@UPDATE@";

	@SidedProxy(clientSide = "com.thesledgehammer.retrobees.proxy.ClientProxy", serverSide = "com.thesledgehammer.retrobees.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Mod.Instance("retrobees")
	public static  RetroBees instance;

	public static Logger logger;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
