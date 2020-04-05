/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.misc;

import com.thesledgehammer.retrobees.RetroBees;

import org.apache.logging.log4j.Level;

public class Config {

	private static final String CATEGORY_EMC = "EMC";

	public static boolean canProduceDarkMatter = true;
	public static boolean canProduceRedMatter = true;
	public static boolean isTransmutable = true;

	//EMC Items
	public static long dropChargedValue = 2048;
	public static long dropOmegaValue = 8192;

	//EMC Bee Species
	public static long darkenedBeeValue = 139264;
	public static long reddenedBeeValue = 466944;
	public static long omegaBeeValue = 933888;
	public static long uuMatterBeeValue = 1867776;
	public static long philosophersBeeValue = 678912;

	//EMC Transmutable Bee Species
	public static long alchemicalBeeValue = 713728;
	public static long mobiusBeeValue = 818176;
	public static long aeternalisBeeValue = 1235968;

	public static long coalBeeValue = 687616;
	public static long ironBeeValue = 696320;
	public static long goldBeeValue = 818176;
	public static long diamondBeeValue = 1235968;
	public static long emeraldBeeValue = 1793024;
	public static long enderPearlBeeValue = 748544;

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
		dropChargedValue = cfg.get(CATEGORY_EMC, "chargedDropEMCValue (Default: 2048)", 2048, "The EMC value for the Charged HoneyDrop").getLong();
		dropOmegaValue = cfg.get(CATEGORY_EMC, "omegaDropEMCValue (Default: 8192)", 8192, "The EMC value for the Omega HoneyDrop").getLong();
		darkenedBeeValue = cfg.get(CATEGORY_EMC, "darkenedBeeEMCValue (Default: 139264)", 139264, "The EMC value for the Darkened Bee Species").getLong();
		reddenedBeeValue = cfg.get(CATEGORY_EMC, "reddenedBeeEMCValue (Default: 466944)", 466944, "The EMC value for the Reddened Bee Species").getLong();
		omegaBeeValue = cfg.get(CATEGORY_EMC, "omegaBeeEMCValue (Default: 933888)", 933888, "The EMC value for the Omega Bee Species").getLong();
		uuMatterBeeValue = cfg.get(CATEGORY_EMC, "uuMatterBeeValue (Default: 1867776)", 1867776, "The EMC value for the UU-Matter Bee Species").getLong();

		philosophersBeeValue = cfg.get(CATEGORY_EMC, "philosophersBeeValue (Default: 678912)", 678912, "The EMC value for the Philosophers Stone Bee Species").getLong();
		alchemicalBeeValue = cfg.get(CATEGORY_EMC, "alchemicalBeeValue (Default: 713728)", 713728, "The EMC value for the Alchemical Coal Bee Species").getLong();
		mobiusBeeValue = cfg.get(CATEGORY_EMC, "mobiusBeeValue (Default: 818176)", 818176, "The EMC value for the Mobius Bee Species").getLong();
		aeternalisBeeValue = cfg.get(CATEGORY_EMC, "aeternalisBeeValue (Default: 1235968)", 1235968, "The EMC value for the Aeternalis Bee Species").getLong();

		coalBeeValue = cfg.get(CATEGORY_EMC, "coalBeeValue (Default: 687616)", 687616, "The EMC value for the Coal Bee Species").getLong();
		ironBeeValue = cfg.get(CATEGORY_EMC, "ironBeeValue (Default: 696320)", 696320, "The EMC value for the Iron Bee Species").getLong();
		goldBeeValue = cfg.get(CATEGORY_EMC, "goldBeeValue (Default: 818176)", 818176, "The EMC value for the Gold Bee Species").getLong();
		diamondBeeValue = cfg.get(CATEGORY_EMC, "diamondBeeValue (Default: 1235968)", 1235968, "The EMC value for the Diamond Bee Species").getLong();
		emeraldBeeValue = cfg.get(CATEGORY_EMC, "emeraldBeeValue (Default: 1793024)", 1793024, "The EMC value for the Emerald Bee Species").getLong();
		enderPearlBeeValue = cfg.get(CATEGORY_EMC, "enderPearlBeeValue (Default: 748544)", 748544, "The EMC value for the Ender Pearl Bee Species").getLong();

		canProduceDarkMatter = cfg.getBoolean(CATEGORY_EMC, "canProduceDarkMatter (Default: true)", true, "If The Darkened and Omega Bee can produce Dark Matter");
		canProduceRedMatter = cfg.getBoolean(CATEGORY_EMC, "canProduceRedMatter (Default: true)", true, "If The Reddended and Omega Bee can produce Red Matter");
		isTransmutable = cfg.getBoolean(CATEGORY_EMC, "isTransmutable (Default: true)", true, "If The Bee can be Transmuted into that Bee when combined with the Philosophers Bee and EMC");
	}
}
