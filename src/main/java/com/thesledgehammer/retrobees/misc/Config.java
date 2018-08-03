package com.thesledgehammer.retrobees.misc;

import org.apache.logging.log4j.Level;

import com.thesledgehammer.retrobees.RetroBees;
import com.thesledgehammer.retrobees.proxy.CommonProxy;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	private static final String CATEGORY_EMC = "emc";
	
	//EMC
	public static int dropChargedValue = 2048;
	public static int dropOmegaValue = 8192;
	public static double darkenedBeeValue = 139264;
	public static double reddenedBeeValue = 466944;
	public static double omegaBeeValue = 933888;
	public static double uuMatterBeeValue = 1867776;
	
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
		dropChargedValue = cfg.get(CATEGORY_EMC, "chargedDropEMCValue (Default: 2048)", dropChargedValue, "The EMC value for the Charged HoneyDrop").getInt();
		dropOmegaValue = cfg.get(CATEGORY_EMC, "omegaDropEMCValue (Default: 8192)", dropOmegaValue, "The EMC value for the Omega HoneyDrop").getInt();
		darkenedBeeValue = cfg.get(CATEGORY_EMC, "darkenedBeeEMCValue (Default: 139264)", darkenedBeeValue, "The EMC value for the Darkened Bee Species").getDouble();
		reddenedBeeValue = cfg.get(CATEGORY_EMC, "reddenedBeeEMCValue (Default: 466944)", reddenedBeeValue, "The EMC value for the Reddened Bee Species").getDouble();
		omegaBeeValue = cfg.get(CATEGORY_EMC, "omegaBeeEMCValue (Default: 933888)", omegaBeeValue, "The EMC value for the Omega Bee Species").getDouble();
		uuMatterBeeValue = cfg.get(CATEGORY_EMC, "uuMatterBeeValue (Default: 1867776)", uuMatterBeeValue, "The EMC value for the UU-Matter Bee Species").getDouble();
	}
}
