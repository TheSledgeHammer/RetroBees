package com.thesledgehammer.retrobees.proxy;

import com.thesledgehammer.retrobees.init.ObjectBatchLoader;
import com.thesledgehammer.retrobees.input.InputHandler;
import com.thesledgehammer.retrobees.input.KeyBindings;
import com.thesledgehammer.retrobees.misc.ObjectManager;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
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
	public void registerItem(Item item) {
		ObjectManager.registerItemClient(item);
	}
}