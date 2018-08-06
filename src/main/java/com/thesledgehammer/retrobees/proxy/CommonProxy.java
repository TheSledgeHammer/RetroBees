package com.thesledgehammer.retrobees.proxy;

import java.io.File;

import com.thesledgehammer.retrobees.RetroBees;
import com.thesledgehammer.retrobees.init.ObjectBatchLoader;
import com.thesledgehammer.retrobees.misc.Config;
import com.thesledgehammer.retrobees.network.PacketHandler;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public static Configuration config;

	public void preInit(FMLPreInitializationEvent event) {
		File directory = event.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), RetroBees.MOD_ID + ".cfg"));
		Config.readConfig();
		// Initialize our packet handler. Make sure the name is 20 characters or less!
		PacketHandler.registerMessages("retrobees");
		// Initialization of blocks and items typically goes here:
		ObjectBatchLoader.preInit();
		
	}
	
	 public void init(FMLInitializationEvent event) {
		 ObjectBatchLoader.init();
	 }
	 
	 public void postInit(FMLPostInitializationEvent event) {
		 ObjectBatchLoader.postInit();
		 if(config.hasChanged()) {
			 config.save();
		 }
	 }

	public void registerItem(Item item) {
		
	}
}
