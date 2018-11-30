/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.misc.oredictionaryresourcetypes;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

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
