/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.bees.mutation;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.apiculture.IBeeMutationBuilder;
import forestry.api.apiculture.IBeeMutationFactory;
import forestry.api.genetics.IAllele;

public class BeeMutationFactoryEMC implements IBeeMutationFactory  {

	@Override
	public IBeeMutationBuilder createMutation(IAlleleBeeSpecies parentBee0, IAlleleBeeSpecies parentBee1, IAllele[] result, int chance) {
		BeeMutationEMC beeMutationEMC = new BeeMutationEMC(parentBee0, parentBee1, result, chance);
		BeeManager.beeRoot.registerMutation(beeMutationEMC);
		return beeMutationEMC;
	}
}
