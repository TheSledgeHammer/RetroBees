package com.thesledgehammer.retrobees.input;

import com.thesledgehammer.retrobees.network.PacketHandler;
import com.thesledgehammer.retrobees.network.PacketSendKey;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class InputHandler {
	
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if(KeyBindings.masterKey.isPressed()) {
			PacketHandler.INSTANCE.sendToServer(new PacketSendKey());
		}
	}
}
