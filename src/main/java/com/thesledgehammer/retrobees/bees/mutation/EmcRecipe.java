/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.bees.mutation;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableTable;
import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.apiculture.genetics.IBeeDefinition;

public class EmcRecipe  {
	
	private HashBasedTable<IAlleleBeeSpecies, IAlleleBeeSpecies, Long> emcMutations = HashBasedTable.create();
	
	public EmcRecipe() {
		setEmcMutations(emcMutations);
	}
	
	public EmcRecipe(HashBasedTable<IAlleleBeeSpecies, IAlleleBeeSpecies, Long> emcMutations) {
		setEmcMutations(emcMutations);
	}
	
	private void setEmcMutations(HashBasedTable<IAlleleBeeSpecies, IAlleleBeeSpecies, Long> emcMutations) {
		this.emcMutations = emcMutations;
	}
	
	public HashBasedTable<IAlleleBeeSpecies, IAlleleBeeSpecies, Long> getRecipes() {
		return emcMutations;
	}
	
	public double getRecipes(IAlleleBeeSpecies parent0, IAlleleBeeSpecies parent1) {
		return emcMutations.get(parent0, parent1);
	}
	
	public void addRecipe(IAlleleBeeSpecies parent0, IAlleleBeeSpecies parent1, long emcValue) {
		emcMutations.put(parent0, parent1, emcValue);
	}
	
	public void addRecipe(IBeeDefinition parent0, IBeeDefinition parent1, long emcValue) {
		emcMutations.put(parent0.getGenome().getPrimary(), parent1.getGenome().getPrimary(), emcValue);
	}
	
	public int size() {
		return emcMutations.size();
	}
	
	public ImmutableTable<IAlleleBeeSpecies, IAlleleBeeSpecies, Long> recipes() {
		ImmutableTable<IAlleleBeeSpecies, IAlleleBeeSpecies, Long> immutableEmc = ImmutableTable.copyOf(emcMutations);
		return immutableEmc;
	}
}
