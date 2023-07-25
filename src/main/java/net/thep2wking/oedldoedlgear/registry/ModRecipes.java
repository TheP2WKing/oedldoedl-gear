package net.thep2wking.oedldoedlgear.registry;

import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlgear.OedldoedlGear;

public class ModRecipes {
	public static void registerOreDict() {
		ModLogger.registeredOreDictLogger(OedldoedlGear.MODID);
	}

	public static void registerRecipes() {
		ModLogger.registeredRecipesLogger(OedldoedlGear.MODID);
	}
}