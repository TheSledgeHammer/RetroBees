package com.thesledgehammer.retrobees.input;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyBindings {
	public static KeyBinding masterKey;
	
	public static void init() {
		masterKey = new KeyBinding("key.master", Keyboard.KEY_T, "key.categories.retrobees");
		ClientRegistry.registerKeyBinding(masterKey);
	}
}
