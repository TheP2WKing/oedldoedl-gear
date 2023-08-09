package net.thep2wking.oedldoedlgear.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRecipeHelper;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.init.ModBlocks;
import net.thep2wking.oedldoedlgear.init.ModItems;

public class ModRecipes {
	public static void registerOreDict() {
		ModLogger.registeredOreDictLogger(OedldoedlGear.MODID);

		ModRecipeHelper.addOreDict("bedrock", ModBlocks.BADROCK, 0);

		ModRecipeHelper.addOreDict("magicWood", ModBlocks.MAGICAL_WOOD, 0);

		ModRecipeHelper.addOreDict("toolNeedle", ModItems.NEEDLE, 0);

		ModRecipeHelper.addOreDict("leatherHardened", ModItems.HARDENED_LEATHER, 0);
		ModRecipeHelper.addOreDict("leatherTravellers", ModItems.TRAVELLERS_LEATHER, 0);

		ModRecipeHelper.addOreDict("coreExplosion", ModItems.EXPLOSION_CORE, 0);
		ModRecipeHelper.addOreDict("essenceCharged", ModItems.CHARGED_ESSENCE, 0);

		ModRecipeHelper.addOreDict("chainmail", ModItems.CHAINMAIL, 0);

		ModRecipeHelper.addOreDict("noteSuffering", ModItems.NOTE_OF_SUFFERING, 0);

		ModRecipeHelper.addOreDict("toolHoe", ModItems.BASE_HOE, 0);
		ModRecipeHelper.addOreDict("toolHoe", ModItems.OEDLDOEDL_HOE, 0);
		ModRecipeHelper.addOreDict("toolHoe", ModItems.FLINT_HOE, 0);
		ModRecipeHelper.addOreDict("toolHoe", ModItems.EMERALD_HOE, 0);

		ModRecipeHelper.addOreDict("toolHoe", ModItems.GREMORIUM_HOE, 0);
		ModRecipeHelper.addOreDict("toolHoe", ModItems.HIMEJIMARIUM_HOE, 0);
		ModRecipeHelper.addOreDict("toolHoe", ModItems.TOUJOURIUM_HOE, 0);
		ModRecipeHelper.addOreDict("toolHoe", ModItems.ARGENTORIUM_HOE, 0);
		ModRecipeHelper.addOreDict("toolHoe", ModItems.QUARTARIUM_HOE, 0);
		ModRecipeHelper.addOreDict("toolHoe", ModItems.NAGATORIUM_HOE, 0);
		ModRecipeHelper.addOreDict("toolHoe", ModItems.SAKURAJIMARIUM_HOE, 0);

		ModRecipeHelper.addOreDict("fabric", ModItems.WHITE_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.ORANGE_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.MAGENTA_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.LIGHT_BLUE_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.YELLOW_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.LIME_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.PINK_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.GRAY_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.LIGHT_GRAY_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.CYAN_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.PURPLE_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.BLUE_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.BROWN_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.GREEN_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.RED_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabric", ModItems.BLACK_FABRIC, 0);

		ModRecipeHelper.addOreDict("fabricWhite", ModItems.WHITE_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricOrange", ModItems.ORANGE_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricMagenta", ModItems.MAGENTA_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricLightBlue", ModItems.LIGHT_BLUE_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricYellow", ModItems.YELLOW_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricLime", ModItems.LIME_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricPink", ModItems.PINK_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricGray", ModItems.GRAY_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricLightGray", ModItems.LIGHT_GRAY_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricCyan", ModItems.CYAN_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricPurple", ModItems.PURPLE_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricBlue", ModItems.BLUE_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricBrown", ModItems.BROWN_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricGreen", ModItems.GREEN_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricRed", ModItems.RED_FABRIC, 0);
		ModRecipeHelper.addOreDict("fabricBlack", ModItems.BLACK_FABRIC, 0);
	}

	public static void registerRecipes() {
		ModLogger.registeredRecipesLogger(OedldoedlGear.MODID);

		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "base", new ItemStack(ModItems.BASE_HELMET, 1, 0),
				new ItemStack(ModItems.BASE_CHESTPLATE, 1, 0), new ItemStack(ModItems.BASE_LEGGINGS, 1, 0),
				new ItemStack(ModItems.BASE_BOOTS, 1, 0), "ingotBase");
		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "oedldoedl",
				new ItemStack(ModItems.OEDLDOEDL_HELMET, 1, 0),
				new ItemStack(ModItems.OEDLDOEDL_CHESTPLATE, 1, 0), new ItemStack(ModItems.OEDLDOEDL_LEGGINGS, 1, 0),
				new ItemStack(ModItems.OEDLDOEDL_BOOTS, 1, 0), "ingotOedldoedl");
		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "wooden", new ItemStack(ModItems.WOODEN_HELMET, 1, 0),
				new ItemStack(ModItems.WOODEN_CHESTPLATE, 1, 0), new ItemStack(ModItems.WOODEN_LEGGINGS, 1, 0),
				new ItemStack(ModItems.WOODEN_BOOTS, 1, 0), "logWood");
		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "flint", new ItemStack(ModItems.FLINT_HELMET, 1, 0),
				new ItemStack(ModItems.FLINT_CHESTPLATE, 1, 0), new ItemStack(ModItems.FLINT_LEGGINGS, 1, 0),
				new ItemStack(ModItems.FLINT_BOOTS, 1, 0), "gemFlint");
		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "emerald", new ItemStack(ModItems.EMERALD_HELMET, 1, 0),
				new ItemStack(ModItems.EMERALD_CHESTPLATE, 1, 0), new ItemStack(ModItems.EMERALD_LEGGINGS, 1, 0),
				new ItemStack(ModItems.EMERALD_BOOTS, 1, 0), "gemEmerald");
		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "chainmail",
				new ItemStack(Items.CHAINMAIL_HELMET, 1, 0),
				new ItemStack(Items.CHAINMAIL_CHESTPLATE, 1, 0),
				new ItemStack(Items.CHAINMAIL_LEGGINGS, 1, 0),
				new ItemStack(Items.CHAINMAIL_BOOTS, 1, 0), "chainmail");

		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "gremorium",
				new ItemStack(ModItems.GREMORIUM_HELMET, 1, 0),
				new ItemStack(ModItems.GREMORIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.GREMORIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.GREMORIUM_BOOTS, 1, 0), "ingotGremorium");
		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "himejimarium",
				new ItemStack(ModItems.HIMEJIMARIUM_HELMET, 1, 0),
				new ItemStack(ModItems.HIMEJIMARIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.HIMEJIMARIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.HIMEJIMARIUM_BOOTS, 1, 0), "ingotHimejimarium");
		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "toujourium",
				new ItemStack(ModItems.TOUJOURIUM_HELMET, 1, 0),
				new ItemStack(ModItems.TOUJOURIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.TOUJOURIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.TOUJOURIUM_BOOTS, 1, 0), "ingotToujourium");
		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "argentorium",
				new ItemStack(ModItems.ARGENTORIUM_HELMET, 1, 0),
				new ItemStack(ModItems.ARGENTORIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.ARGENTORIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.ARGENTORIUM_BOOTS, 1, 0), "ingotArgentorium");
		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "quartarium",
				new ItemStack(ModItems.QUARTARIUM_HELMET, 1, 0),
				new ItemStack(ModItems.QUARTARIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.QUARTARIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.QUARTARIUM_BOOTS, 1, 0), "ingotQuartarium");
		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "nagatorium",
				new ItemStack(ModItems.NAGATORIUM_HELMET, 1, 0),
				new ItemStack(ModItems.NAGATORIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.NAGATORIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.NAGATORIUM_BOOTS, 1, 0), "ingotNagatorium");
		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "sakurajimarium",
				new ItemStack(ModItems.SAKURAJIMARIUM_HELMET, 1, 0),
				new ItemStack(ModItems.SAKURAJIMARIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.SAKURAJIMARIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.SAKURAJIMARIUM_BOOTS, 1, 0), "ingotSakurajimarium");

		ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "base",
				new ItemStack(ModItems.BASE_SWORD, 1, 0),
				new ItemStack(ModItems.BASE_SHOVEL, 1, 0), new ItemStack(ModItems.BASE_PICKAXE, 1, 0),
				new ItemStack(ModItems.BASE_AXE, 1, 0), new ItemStack(ModItems.BASE_HOE, 1, 0),
				new ItemStack(ModItems.BASE_PAXEL, 1, 0), new ItemStack(ModItems.BASE_SMASHBAT, 1, 0),
				new ItemStack(ModItems.BASE_SHEARS, 1, 0), new ItemStack(ModItems.BASE_SHIELD, 1, 0),
				"stickWood", "ingotBase");
		ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "oedldoedl",
				new ItemStack(ModItems.OEDLDOEDL_SWORD, 1, 0),
				new ItemStack(ModItems.OEDLDOEDL_SHOVEL, 1, 0), new ItemStack(ModItems.OEDLDOEDL_PICKAXE, 1, 0),
				new ItemStack(ModItems.OEDLDOEDL_AXE, 1, 0), new ItemStack(ModItems.OEDLDOEDL_HOE, 1, 0),
				new ItemStack(ModItems.OEDLDOEDL_PAXEL, 1, 0), new ItemStack(ModItems.OEDLDOEDL_SMASHBAT, 1, 0),
				new ItemStack(ModItems.OEDLDOEDL_SHEARS, 1, 0), new ItemStack(ModItems.OEDLDOEDL_SHIELD, 1, 0),
				"stickWood", "ingotOedldoedl");
		ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "flint",
				new ItemStack(ModItems.FLINT_SWORD, 1, 0),
				new ItemStack(ModItems.FLINT_SHOVEL, 1, 0), new ItemStack(ModItems.FLINT_PICKAXE, 1, 0),
				new ItemStack(ModItems.FLINT_AXE, 1, 0), new ItemStack(ModItems.FLINT_HOE, 1, 0),
				new ItemStack(ModItems.FLINT_PAXEL, 1, 0), new ItemStack(ModItems.FLINT_SMASHBAT, 1, 0),
				new ItemStack(ModItems.FLINT_SHEARS, 1, 0), new ItemStack(ModItems.FLINT_SHIELD, 1, 0),
				"stickWood", "gemFlint");
		ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "emerald",
				new ItemStack(ModItems.EMERALD_SWORD, 1, 0),
				new ItemStack(ModItems.EMERALD_SHOVEL, 1, 0), new ItemStack(ModItems.EMERALD_PICKAXE, 1, 0),
				new ItemStack(ModItems.EMERALD_AXE, 1, 0), new ItemStack(ModItems.EMERALD_HOE, 1, 0),
				new ItemStack(ModItems.EMERALD_PAXEL, 1, 0), new ItemStack(ModItems.EMERALD_SMASHBAT, 1, 0),
				new ItemStack(ModItems.EMERALD_SHEARS, 1, 0), new ItemStack(ModItems.EMERALD_SHIELD, 1, 0),
				"stickWood", "gemEmerald");

		ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "gremorium",
				new ItemStack(ModItems.GREMORIUM_SWORD, 1, 0),
				new ItemStack(ModItems.GREMORIUM_SHOVEL, 1, 0), new ItemStack(ModItems.GREMORIUM_PICKAXE, 1, 0),
				new ItemStack(ModItems.GREMORIUM_AXE, 1, 0), new ItemStack(ModItems.GREMORIUM_HOE, 1, 0),
				new ItemStack(ModItems.GREMORIUM_PAXEL, 1, 0), new ItemStack(ModItems.GREMORIUM_SMASHBAT, 1, 0),
				new ItemStack(ModItems.GREMORIUM_SHEARS, 1, 0), new ItemStack(ModItems.GREMORIUM_SHIELD, 1, 0),
				"stickWood", "ingotGremorium");

		ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "himejimarium",
				new ItemStack(ModItems.HIMEJIMARIUM_SWORD, 1, 0),
				new ItemStack(ModItems.HIMEJIMARIUM_SHOVEL, 1, 0), new ItemStack(ModItems.HIMEJIMARIUM_PICKAXE, 1, 0),
				new ItemStack(ModItems.HIMEJIMARIUM_AXE, 1, 0), new ItemStack(ModItems.HIMEJIMARIUM_HOE, 1, 0),
				new ItemStack(ModItems.HIMEJIMARIUM_PAXEL, 1, 0), new ItemStack(ModItems.HIMEJIMARIUM_SMASHBAT, 1, 0),
				new ItemStack(ModItems.HIMEJIMARIUM_SHEARS, 1, 0), new ItemStack(ModItems.HIMEJIMARIUM_SHIELD, 1, 0),
				"stickWood", "ingotHimejimarium");

		ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "toujourium",
				new ItemStack(ModItems.TOUJOURIUM_SWORD, 1, 0),
				new ItemStack(ModItems.TOUJOURIUM_SHOVEL, 1, 0), new ItemStack(ModItems.TOUJOURIUM_PICKAXE, 1, 0),
				new ItemStack(ModItems.TOUJOURIUM_AXE, 1, 0), new ItemStack(ModItems.TOUJOURIUM_HOE, 1, 0),
				new ItemStack(ModItems.TOUJOURIUM_PAXEL, 1, 0), new ItemStack(ModItems.TOUJOURIUM_SMASHBAT, 1, 0),
				new ItemStack(ModItems.TOUJOURIUM_SHEARS, 1, 0), new ItemStack(ModItems.TOUJOURIUM_SHIELD, 1, 0),
				"stickWood", "ingotToujourium");

		ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "argentorium",
				new ItemStack(ModItems.ARGENTORIUM_SWORD, 1, 0),
				new ItemStack(ModItems.ARGENTORIUM_SHOVEL, 1, 0), new ItemStack(ModItems.ARGENTORIUM_PICKAXE, 1, 0),
				new ItemStack(ModItems.ARGENTORIUM_AXE, 1, 0), new ItemStack(ModItems.ARGENTORIUM_HOE, 1, 0),
				new ItemStack(ModItems.ARGENTORIUM_PAXEL, 1, 0), new ItemStack(ModItems.ARGENTORIUM_SMASHBAT, 1, 0),
				new ItemStack(ModItems.ARGENTORIUM_SHEARS, 1, 0), new ItemStack(ModItems.ARGENTORIUM_SHIELD, 1, 0),
				"stickWood", "ingotArgentorium");

		ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "quartarium",
				new ItemStack(ModItems.QUARTARIUM_SWORD, 1, 0),
				new ItemStack(ModItems.QUARTARIUM_SHOVEL, 1, 0), new ItemStack(ModItems.QUARTARIUM_PICKAXE, 1, 0),
				new ItemStack(ModItems.QUARTARIUM_AXE, 1, 0), new ItemStack(ModItems.QUARTARIUM_HOE, 1, 0),
				new ItemStack(ModItems.QUARTARIUM_PAXEL, 1, 0), new ItemStack(ModItems.QUARTARIUM_SMASHBAT, 1, 0),
				new ItemStack(ModItems.QUARTARIUM_SHEARS, 1, 0), new ItemStack(ModItems.QUARTARIUM_SHIELD, 1, 0),
				"stickWood", "ingotQuartarium");

		ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "nagatorium",
				new ItemStack(ModItems.NAGATORIUM_SWORD, 1, 0),
				new ItemStack(ModItems.NAGATORIUM_SHOVEL, 1, 0), new ItemStack(ModItems.NAGATORIUM_PICKAXE, 1, 0),
				new ItemStack(ModItems.NAGATORIUM_AXE, 1, 0), new ItemStack(ModItems.NAGATORIUM_HOE, 1, 0),
				new ItemStack(ModItems.NAGATORIUM_PAXEL, 1, 0), new ItemStack(ModItems.NAGATORIUM_SMASHBAT, 1, 0),
				new ItemStack(ModItems.NAGATORIUM_SHEARS, 1, 0), new ItemStack(ModItems.NAGATORIUM_SHIELD, 1, 0),
				"stickWood", "ingotNagatorium");

		ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "sakurajimarium",
				new ItemStack(ModItems.SAKURAJIMARIUM_SWORD, 1, 0),
				new ItemStack(ModItems.SAKURAJIMARIUM_SHOVEL, 1, 0),
				new ItemStack(ModItems.SAKURAJIMARIUM_PICKAXE, 1, 0),
				new ItemStack(ModItems.SAKURAJIMARIUM_AXE, 1, 0), new ItemStack(ModItems.SAKURAJIMARIUM_HOE, 1, 0),
				new ItemStack(ModItems.SAKURAJIMARIUM_PAXEL, 1, 0),
				new ItemStack(ModItems.SAKURAJIMARIUM_SMASHBAT, 1, 0),
				new ItemStack(ModItems.SAKURAJIMARIUM_SHEARS, 1, 0),
				new ItemStack(ModItems.SAKURAJIMARIUM_SHIELD, 1, 0),
				"stickWood", "ingotSakurajimarium");
	}
}