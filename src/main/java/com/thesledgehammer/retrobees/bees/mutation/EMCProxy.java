package com.thesledgehammer.retrobees.bees.mutation;

import com.thesledgehammer.retrobees.init.ModItems;
import com.thesledgehammer.retrobees.items.EnumDropType;
import com.thesledgehammer.retrobees.misc.Config;
import moze_intel.projecte.api.ProjectEAPI;

public class EMCProxy  {
	
	public static void addEMC() {
		/*Add Custom EMC Values to Items/Objects here "emcProxy...(ItemStack, EMCValue)" 
		All EMC Values should be referenced in ConfigHandler*/
		ProjectEAPI.getEMCProxy().registerCustomEMC(ModItems.HoneyDrop.getDrop(EnumDropType.CHARGED, 1), Config.dropChargedValue);
		ProjectEAPI.getEMCProxy().registerCustomEMC(ModItems.HoneyDrop.getDrop(EnumDropType.OMEGA, 1), Config.dropOmegaValue);
	}
}