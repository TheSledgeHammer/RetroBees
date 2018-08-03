package com.thesledgehammer.retrobees.misc;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import com.thesledgehammer.retrobees.RetroBees;

import net.minecraft.item.ItemStack;

public class Log {
	public static void log(Level logLevel, String message) {
		LogManager.getLogger(RetroBees.MOD_ID).log(logLevel, message);
	}

	public static void log(Level logLevel, String message, Object e) {
		LogManager.getLogger(RetroBees.MOD_ID).log(logLevel, message, e);
	}
	
	public static void logInfo(String message){
		LogManager.getLogger(RetroBees.MOD_ID).info(message);
	}
	
	public static void logWarn(String message) {
		LogManager.getLogger(RetroBees.MOD_ID).warn(message);
	}
	
	public static void logFatal(String message) {
		LogManager.getLogger(RetroBees.MOD_ID).fatal(message);
	}
	
	public static void logDebug(String message) {
		LogManager.getLogger(RetroBees.MOD_ID).debug(message);
	}

	public static void error(String string) {
		LogManager.getLogger(RetroBees.MOD_ID).error(string);
	}

	public static void error(String string, ItemStack stack) {
		LogManager.getLogger(RetroBees.MOD_ID).error(string, stack);
		
	}
}
