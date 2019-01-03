/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.misc;

import com.thesledgehammer.retrobees.RetroBees;
import com.thesledgehammer.retrobees.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {
	
	private static final String CATEGORY_EMC = "emc";

	public static boolean canProduceDarkMatter = true;
	public static boolean canProduceRedMatter = true;
	public static boolean isTransmutable = true;

	//EMC Items
	public static int dropChargedValue = 2048;
	public static int dropOmegaValue = 8192;

	//EMC Bee Species
	public static double darkenedBeeValue = 139264;
	public static double reddenedBeeValue = 466944;
	public static double omegaBeeValue = 933888;
	public static double uuMatterBeeValue = 1867776;

	public static double alchemicalBeeValue = 69632;
	public static double mobiusBeeValue = 139264;
	public static double aeternalisBeeValue = 466944;

	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initConfig(cfg);
		} catch (Exception e) {
			RetroBees.logger.log(Level.ERROR, "Problem loading config file!", e);
		} finally {
			if(cfg.hasChanged()) {
				cfg.save();
			}
		}
	}
	
	private static void initConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(CATEGORY_EMC, "ProjectE EMC configuration");
		dropChargedValue = cfg.get(CATEGORY_EMC, "chargedDropEMCValue (Default: 2048)", dropChargedValue, "The EMC value for the Charged HoneyDrop").getInt();
		dropOmegaValue = cfg.get(CATEGORY_EMC, "omegaDropEMCValue (Default: 8192)", dropOmegaValue, "The EMC value for the Omega HoneyDrop").getInt();

		canProduceDarkMatter = cfg.getBoolean(CATEGORY_EMC, "canProduceDarkMatter (Default: true)", canProduceDarkMatter, "If The Darkened and Omega Bee can produce Dark Matter");
		canProduceRedMatter = cfg.getBoolean(CATEGORY_EMC, "canProduceRedMatter (Default: true)", canProduceRedMatter, "If The Reddended and Omega Bee can produce Red Matter");
		isTransmutable = cfg.getBoolean(CATEGORY_EMC, "isTransmutable (Default: true)", isTransmutable, "If The Bee can be Transmuted into that Bee when combined with the Philosophers Bee and EMC");

		darkenedBeeValue = cfg.get(CATEGORY_EMC, "darkenedBeeEMCValue (Default: 139264)", darkenedBeeValue, "The EMC value for the Darkened Bee Species").getDouble();
		reddenedBeeValue = cfg.get(CATEGORY_EMC, "reddenedBeeEMCValue (Default: 466944)", reddenedBeeValue, "The EMC value for the Reddened Bee Species").getDouble();
		omegaBeeValue = cfg.get(CATEGORY_EMC, "omegaBeeEMCValue (Default: 933888)", omegaBeeValue, "The EMC value for the Omega Bee Species").getDouble();
		uuMatterBeeValue = cfg.get(CATEGORY_EMC, "uuMatterBeeValue (Default: 1867776)", uuMatterBeeValue, "The EMC value for the UU-Matter Bee Species").getDouble();

		alchemicalBeeValue = cfg.get(CATEGORY_EMC, "alchemicalBeeValue (Default: 69632)", alchemicalBeeValue, "The EMC value for the Alchemical Coal Bee Species").getDouble();
		mobiusBeeValue = cfg.get(CATEGORY_EMC, "mobiusBeeValue (Default: 139264)", mobiusBeeValue, "The EMC value for the Mobius Bee Species").getDouble();
		aeternalisBeeValue = cfg.get(CATEGORY_EMC, "aeternalisBeeValue (Default: 466944)", aeternalisBeeValue, "The EMC value for the Aeternalis Bee Species").getDouble();
	}
}
