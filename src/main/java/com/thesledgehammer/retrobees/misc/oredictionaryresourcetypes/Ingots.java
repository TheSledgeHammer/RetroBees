package com.thesledgehammer.retrobees.misc.oredictionaryresourcetypes;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class Ingots {
	
	private ArrayList<ItemStack> Ingot = new ArrayList<ItemStack>(20);

	public Ingots() {
		setIngotUID(Ingot);
	}

	public Ingots(ArrayList<ItemStack> Ingot) {
		setIngotUID(Ingot);
	}

	public ArrayList<ItemStack> getIngotUID() {
		return Ingot;
	}

	public ItemStack getIngotUID(int index) {
		return Ingot.get(index);
	}
	
	private void setIngotUID(ArrayList<ItemStack> Ingot) {
		this.Ingot = Ingot;
	}
}
