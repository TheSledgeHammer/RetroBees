package com.thesledgehammer.retrobees.misc;

import com.thesledgehammer.retrobees.RetroBees;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.Level;

public class Log {
	public static void log(Level logLevel, String message) {
		RetroBees.logger.log(logLevel, message);
	}

	public static void log(Level logLevel, String message, Object e) {
		RetroBees.logger.log(logLevel, message, e);
	}
	
	public static void logInfo(String message){
		RetroBees.logger.info(message);
	}
	
	public static void logWarn(String message) {
		RetroBees.logger.warn(message);
	}
	
	public static void logFatal(String message) {
		RetroBees.logger.fatal(message);
	}
	
	public static void logDebug(String message) {
		RetroBees.logger.debug(message);
	}

	public static void error(String string) {
		RetroBees.logger.error(string);
	}

	public static void error(String string, ItemStack stack) {
		RetroBees.logger.error(string, stack);
	}
}
