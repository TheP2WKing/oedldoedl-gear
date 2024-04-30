package net.thep2wking.oedldoedlgear.util;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.thep2wking.oedldoedlcore.util.ModRecipeHelper;

public class ModGearRecipeHelper {
	// armor
	public static void addTravellersBootsUpgrade(String modid, String name, @Nonnull ItemStack bootsOut,
			@Nonnull ItemStack bootsIn, String material) {
		ModRecipeHelper.addShapedRecipe(modid, "armor/" + name + "_boots", bootsOut, "ABA", "CAC", 'A',
				material, 'B', bootsIn, 'C', "leatherTravellers");
	}

	public static void addStarHelmetRecipe(String modid, String name, @Nonnull ItemStack helmet, String material) {
		ModRecipeHelper.addShapedRecipe(modid, "armor/" + name + "_helmet", helmet, "ABA", "A A", 'A', material, 'B',
				name + "Star");
	}

	public static void addStarChestplateRecipe(String modid, String name, @Nonnull ItemStack chestplate, String material) {
		ModRecipeHelper.addShapedRecipe(modid, "armor/" + name + "_chestplate", chestplate, "A A", "ABA", "AAA", 'A',
				material, 'B', name + "Star");
	}

	public static void addStarLeggingsRecipe(String modid, String name, @Nonnull ItemStack leggings, String material) {
		ModRecipeHelper.addShapedRecipe(modid, "armor/" + name + "_leggings", leggings, "ABA", "A A", "A A", 'A',
				material, 'B', name + "Star");
	}

	public static void addStarBootsRecipe(String modid, String name, @Nonnull ItemStack boots, String material) {
		ModRecipeHelper.addShapedRecipe(modid, "armor/" + name + "_boots", boots, "A A", "A B", 'A', material, 'B',
				name + "Star");
	}

	// full armor
	public static void addFullStarArmorRecipe(String modid, String name, @Nonnull ItemStack helmet,
			@Nonnull ItemStack chestplate, @Nonnull ItemStack leggings, @Nonnull ItemStack boots, String material) {
		addStarHelmetRecipe(modid, name, helmet, material);
		addStarChestplateRecipe(modid, name, chestplate, material);
		addStarLeggingsRecipe(modid, name, leggings, material);
		addStarBootsRecipe(modid, name, boots, material);
	}

	// misc
	public static void addFabricRecipe(String modid, String name, @Nonnull ItemStack fabric, String color) {
		ModRecipeHelper.addShapelessRecipe(modid, name, fabric, "toolNeedle",
				"wool" + color.substring(0, 1).toUpperCase() + color.substring(1), "string", "string");
	}
}