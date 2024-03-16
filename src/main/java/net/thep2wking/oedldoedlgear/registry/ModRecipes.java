package net.thep2wking.oedldoedlgear.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModNBTUtil;
import net.thep2wking.oedldoedlcore.util.ModRecipeHelper;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModBlocks;
import net.thep2wking.oedldoedlgear.init.ModItems;
import net.thep2wking.oedldoedlgear.init.ModPotions;
import net.thep2wking.oedldoedlgear.util.ModGearRecipeHelper;

public class ModRecipes {
	public static void registerOreDict() {
		ModLogger.registeredOreDictLogger(OedldoedlGear.MODID);

		if (GearConfig.RECIPES.DEFAULT_OREDICT) {
			ModRecipeHelper.addOreDict("bedrock", ModBlocks.BADROCK, 0);
			ModRecipeHelper.addOreDict("dirtEnhanced", ModBlocks.ENHANCED_DIRT, 0);

			ModRecipeHelper.addOreDict("magicWood", ModBlocks.MAGICAL_WOOD, 0);
			ModRecipeHelper.addOreDict("blockMagicWood", ModBlocks.MAGICAL_WOOD, 0);
			ModRecipeHelper.addOreDict("logWood", ModBlocks.MAGICAL_WOOD, 0);
			ModRecipeHelper.addOreDict("blockPlankMagicWood", ModBlocks.MAGICAL_WOOD_PLANKS, 0);
			ModRecipeHelper.addOreDict("plankMagicWood", ModBlocks.MAGICAL_WOOD_PLANKS, 0);
			ModRecipeHelper.addOreDict("plankWood", ModBlocks.MAGICAL_WOOD_PLANKS, 0);

			ModRecipeHelper.addOreDict("toolNeedle", ModItems.NEEDLE, 0);

			ModRecipeHelper.addOreDict("leatherTravellers", ModItems.TRAVELLERS_LEATHER, 0);

			ModRecipeHelper.addOreDict("coreExplosion", ModItems.EXPLOSION_CORE, 0);
			ModRecipeHelper.addOreDict("coreCharged", ModItems.CHARGED_CORE, 0);
			ModRecipeHelper.addOreDict("coreMystic", ModItems.MYSTIC_CORE, 0);

			ModRecipeHelper.addOreDict("chainmail", ModItems.CHAINMAIL, 0);

			ModRecipeHelper.addOreDict("paperSuffering", ModItems.NOTE_OF_SUFFERING, 0);
			ModRecipeHelper.addOreDict("paperBill", ModItems.BILL_OF_REVENGE, 0);
			ModRecipeHelper.addOreDict("paperLicense", ModItems.CRAFTING_LICENSE, 0);
			ModRecipeHelper.addOreDict("paperTos", ModItems.OEDLDOEDL_TOS, 0);

			ModRecipeHelper.addOreDict("toolHoe", ModItems.BASE_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", ModItems.OEDLDOEDL_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", ModItems.DIRT_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", ModItems.EMERALD_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", ModItems.SLIME_HOE, 0);

			ModRecipeHelper.addOreDict("toolHoe", ModItems.GREMORIUM_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", ModItems.HIMEJIMARIUM_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", ModItems.TOUJOURIUM_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", ModItems.ARGENTORIUM_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", ModItems.QUARTARIUM_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", ModItems.NAGATORIUM_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", ModItems.SAKURAJIMARIUM_HOE, 0);
			ModRecipeHelper.addOreDict("toolHoe", ModItems.KITAGAWARIUM_HOE, 0);

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
	}

	public static void registerRecipes() {
		ModLogger.registeredRecipesLogger(OedldoedlGear.MODID);

		if (GearConfig.RECIPES.STANDARD_ARMOR_AMD_TOOL_RECIPES) {
			ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "base", new ItemStack(ModItems.BASE_HELMET, 1, 0),
					new ItemStack(ModItems.BASE_CHESTPLATE, 1, 0), new ItemStack(ModItems.BASE_LEGGINGS, 1, 0),
					new ItemStack(ModItems.BASE_BOOTS, 1, 0), "ingotBase");
			ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "oedldoedl",
					new ItemStack(ModItems.OEDLDOEDL_HELMET, 1, 0), new ItemStack(ModItems.OEDLDOEDL_CHESTPLATE, 1, 0),
					new ItemStack(ModItems.OEDLDOEDL_LEGGINGS, 1, 0), new ItemStack(ModItems.OEDLDOEDL_BOOTS, 1, 0),
					"ingotOedldoedl");
			ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "dirt", new ItemStack(ModItems.DIRT_HELMET, 1, 0),
					new ItemStack(ModItems.DIRT_CHESTPLATE, 1, 0), new ItemStack(ModItems.DIRT_LEGGINGS, 1, 0),
					new ItemStack(ModItems.DIRT_BOOTS, 1, 0), "dirtEnhanced");
			ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "wooden",
					new ItemStack(ModItems.WOODEN_HELMET, 1, 0),
					new ItemStack(ModItems.WOODEN_CHESTPLATE, 1, 0), new ItemStack(ModItems.WOODEN_LEGGINGS, 1, 0),
					new ItemStack(ModItems.WOODEN_BOOTS, 1, 0), "logWood");
			ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "emerald",
					new ItemStack(ModItems.EMERALD_HELMET, 1, 0),
					new ItemStack(ModItems.EMERALD_CHESTPLATE, 1, 0), new ItemStack(ModItems.EMERALD_LEGGINGS, 1, 0),
					new ItemStack(ModItems.EMERALD_BOOTS, 1, 0), "gemEmerald");
			ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "slime", new ItemStack(ModItems.SLIME_HELMET, 1, 0),
					new ItemStack(ModItems.SLIME_CHESTPLATE, 1, 0), new ItemStack(ModItems.SLIME_LEGGINGS, 1, 0),
					new ItemStack(ModItems.SLIME_BOOTS, 1, 0), "slimeball");
			ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "chainmail",
					new ItemStack(Items.CHAINMAIL_HELMET, 1, 0), new ItemStack(Items.CHAINMAIL_CHESTPLATE, 1, 0),
					new ItemStack(Items.CHAINMAIL_LEGGINGS, 1, 0), new ItemStack(Items.CHAINMAIL_BOOTS, 1, 0),
					"chainmail");

			ModGearRecipeHelper.addFullStarArmorRecipe(OedldoedlGear.MODID, "gremorium",
					new ItemStack(ModItems.GREMORIUM_HELMET, 1, 0),
					new ItemStack(ModItems.GREMORIUM_CHESTPLATE, 1, 0),
					new ItemStack(ModItems.GREMORIUM_LEGGINGS, 1, 0),
					new ItemStack(ModItems.GREMORIUM_BOOTS, 1, 0), "ingotGremorium");
			ModGearRecipeHelper.addFullStarArmorRecipe(OedldoedlGear.MODID, "himejimarium",
					new ItemStack(ModItems.HIMEJIMARIUM_HELMET, 1, 0),
					new ItemStack(ModItems.HIMEJIMARIUM_CHESTPLATE, 1, 0),
					new ItemStack(ModItems.HIMEJIMARIUM_LEGGINGS, 1, 0),
					new ItemStack(ModItems.HIMEJIMARIUM_BOOTS, 1, 0), "ingotHimejimarium");
			ModGearRecipeHelper.addFullStarArmorRecipe(OedldoedlGear.MODID, "toujourium",
					new ItemStack(ModItems.TOUJOURIUM_HELMET, 1, 0),
					new ItemStack(ModItems.TOUJOURIUM_CHESTPLATE, 1, 0),
					new ItemStack(ModItems.TOUJOURIUM_LEGGINGS, 1, 0),
					new ItemStack(ModItems.TOUJOURIUM_BOOTS, 1, 0), "ingotToujourium");
			ModGearRecipeHelper.addFullStarArmorRecipe(OedldoedlGear.MODID, "argentorium",
					new ItemStack(ModItems.ARGENTORIUM_HELMET, 1, 0),
					new ItemStack(ModItems.ARGENTORIUM_CHESTPLATE, 1, 0),
					new ItemStack(ModItems.ARGENTORIUM_LEGGINGS, 1, 0),
					new ItemStack(ModItems.ARGENTORIUM_BOOTS, 1, 0), "ingotArgentorium");
			ModGearRecipeHelper.addFullStarArmorRecipe(OedldoedlGear.MODID, "quartarium",
					new ItemStack(ModItems.QUARTARIUM_HELMET, 1, 0),
					new ItemStack(ModItems.QUARTARIUM_CHESTPLATE, 1, 0),
					new ItemStack(ModItems.QUARTARIUM_LEGGINGS, 1, 0),
					new ItemStack(ModItems.QUARTARIUM_BOOTS, 1, 0), "ingotQuartarium");
			ModGearRecipeHelper.addFullStarArmorRecipe(OedldoedlGear.MODID, "nagatorium",
					new ItemStack(ModItems.NAGATORIUM_HELMET, 1, 0),
					new ItemStack(ModItems.NAGATORIUM_CHESTPLATE, 1, 0),
					new ItemStack(ModItems.NAGATORIUM_LEGGINGS, 1, 0),
					new ItemStack(ModItems.NAGATORIUM_BOOTS, 1, 0), "ingotNagatorium");
			ModGearRecipeHelper.addFullStarArmorRecipe(OedldoedlGear.MODID, "sakurajimarium",
					new ItemStack(ModItems.SAKURAJIMARIUM_HELMET, 1, 0),
					new ItemStack(ModItems.SAKURAJIMARIUM_CHESTPLATE, 1, 0),
					new ItemStack(ModItems.SAKURAJIMARIUM_LEGGINGS, 1, 0),
					new ItemStack(ModItems.SAKURAJIMARIUM_BOOTS, 1, 0), "ingotSakurajimarium");
			ModGearRecipeHelper.addFullStarArmorRecipe(OedldoedlGear.MODID, "kitagawarium",
					new ItemStack(ModItems.KITAGAWARIUM_HELMET, 1, 0),
					new ItemStack(ModItems.KITAGAWARIUM_CHESTPLATE, 1, 0),
					new ItemStack(ModItems.KITAGAWARIUM_LEGGINGS, 1, 0),
					new ItemStack(ModItems.KITAGAWARIUM_BOOTS, 1, 0), "ingotKitagawarium");

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
			ModRecipeHelper.addSwordRecipe(OedldoedlGear.MODID, "dirt", new ItemStack(ModItems.DIRT_SWORD, 1, 0),
					"stickWood", "dirtEnhanced");
			ModRecipeHelper.addShovelRecipe(OedldoedlGear.MODID, "dirt", new ItemStack(ModItems.DIRT_SHOVEL, 1, 0),
					"stickWood", "dirtEnhanced");
			ModRecipeHelper.addPickaxeRecipe(OedldoedlGear.MODID, "dirt", new ItemStack(ModItems.DIRT_PICKAXE, 1, 0),
					"stickWood", "dirtEnhanced");
			ModRecipeHelper.addAxeRecipe(OedldoedlGear.MODID, "dirt", new ItemStack(ModItems.DIRT_AXE, 1, 0),
					"stickWood", "dirtEnhanced");
			ModRecipeHelper.addHoeRecipe(OedldoedlGear.MODID, "dirt", new ItemStack(ModItems.DIRT_HOE, 1, 0),
					"stickWood", "dirtEnhanced");
			ModRecipeHelper.addPaxelRecipe(OedldoedlGear.MODID, "dirt", new ItemStack(ModItems.DIRT_PAXEL, 1, 0),
					"stickWood", new ItemStack(ModItems.DIRT_AXE, 1, 0), new ItemStack(ModItems.DIRT_SHOVEL, 1, 0),
					new ItemStack(ModItems.DIRT_PICKAXE, 1, 0));
			ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "dirt", new ItemStack(ModItems.DIRT_SMASHBAT, 1, 0),
					"dirtEnhanced");
			ModRecipeHelper.addShearsRecipe(OedldoedlGear.MODID, "dirt", new ItemStack(ModItems.DIRT_SHEARS, 1, 0),
					"dirtEnhanced");

			ModRecipeHelper.addSwordRecipe(OedldoedlGear.MODID, "emerald", new ItemStack(ModItems.EMERALD_SWORD, 1, 0),
					"stickWood", "gemEmerald");
			ModRecipeHelper.addShovelRecipe(OedldoedlGear.MODID, "emerald",
					new ItemStack(ModItems.EMERALD_SHOVEL, 1, 0), "stickWood", "gemEmerald");
			ModRecipeHelper.addPickaxeRecipe(OedldoedlGear.MODID, "emerald",
					new ItemStack(ModItems.EMERALD_PICKAXE, 1, 0), "stickWood", "gemEmerald");
			ModRecipeHelper.addAxeRecipe(OedldoedlGear.MODID, "emerald", new ItemStack(ModItems.EMERALD_AXE, 1, 0),
					"stickWood", "gemEmerald");
			ModRecipeHelper.addHoeRecipe(OedldoedlGear.MODID, "emerald", new ItemStack(ModItems.EMERALD_HOE, 1, 0),
					"stickWood", "gemEmerald");
			ModRecipeHelper.addPaxelRecipe(OedldoedlGear.MODID, "emerald", new ItemStack(ModItems.EMERALD_PAXEL, 1, 0),
					"stickWood", new ItemStack(ModItems.EMERALD_AXE, 1, 0),
					new ItemStack(ModItems.EMERALD_SHOVEL, 1, 0), new ItemStack(ModItems.EMERALD_PICKAXE, 1, 0));
			ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "emerald",
					new ItemStack(ModItems.EMERALD_SMASHBAT, 1, 0), "gemEmerald");
			ModRecipeHelper.addShearsRecipe(OedldoedlGear.MODID, "emerald",
					new ItemStack(ModItems.EMERALD_SHEARS, 1, 0), "gemEmerald");

			ModRecipeHelper.addSwordRecipe(OedldoedlGear.MODID, "slime", new ItemStack(ModItems.SLIME_SWORD, 1, 0),
					"stickWood", "slimeball");
			ModRecipeHelper.addShovelRecipe(OedldoedlGear.MODID, "slime", new ItemStack(ModItems.SLIME_SHOVEL, 1, 0),
					"stickWood", "slimeball");
			ModRecipeHelper.addPickaxeRecipe(OedldoedlGear.MODID, "slime", new ItemStack(ModItems.SLIME_PICKAXE, 1, 0),
					"stickWood", "slimeball");
			ModRecipeHelper.addAxeRecipe(OedldoedlGear.MODID, "slime", new ItemStack(ModItems.SLIME_AXE, 1, 0),
					"stickWood", "slimeball");
			ModRecipeHelper.addHoeRecipe(OedldoedlGear.MODID, "slime", new ItemStack(ModItems.SLIME_HOE, 1, 0),
					"stickWood", "slimeball");
			ModRecipeHelper.addPaxelRecipe(OedldoedlGear.MODID, "slime", new ItemStack(ModItems.SLIME_PAXEL, 1, 0),
					"stickWood", new ItemStack(ModItems.SLIME_AXE, 1, 0), new ItemStack(ModItems.SLIME_SHOVEL, 1, 0),
					new ItemStack(ModItems.SLIME_PICKAXE, 1, 0));
			ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "slime",
					new ItemStack(ModItems.SLIME_SMASHBAT, 1, 0), "slimeball");
			ModRecipeHelper.addShearsRecipe(OedldoedlGear.MODID, "slime", new ItemStack(ModItems.SLIME_SHEARS, 1, 0),
					"slimeball");

			ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "gremorium",
					new ItemStack(ModItems.GREMORIUM_SWORD, 1, 0),
					new ItemStack(ModItems.GREMORIUM_SHOVEL, 1, 0), new ItemStack(ModItems.GREMORIUM_PICKAXE, 1, 0),
					new ItemStack(ModItems.GREMORIUM_AXE, 1, 0), new ItemStack(ModItems.GREMORIUM_HOE, 1, 0),
					new ItemStack(ModItems.GREMORIUM_PAXEL, 1, 0), new ItemStack(ModItems.GREMORIUM_SMASHBAT, 1, 0),
					new ItemStack(ModItems.GREMORIUM_SHEARS, 1, 0), new ItemStack(ModItems.GREMORIUM_SHIELD, 1, 0),
					"stickWood", "ingotGremorium");
			ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "himejimarium",
					new ItemStack(ModItems.HIMEJIMARIUM_SWORD, 1, 0),
					new ItemStack(ModItems.HIMEJIMARIUM_SHOVEL, 1, 0),
					new ItemStack(ModItems.HIMEJIMARIUM_PICKAXE, 1, 0),
					new ItemStack(ModItems.HIMEJIMARIUM_AXE, 1, 0), new ItemStack(ModItems.HIMEJIMARIUM_HOE, 1, 0),
					new ItemStack(ModItems.HIMEJIMARIUM_PAXEL, 1, 0),
					new ItemStack(ModItems.HIMEJIMARIUM_SMASHBAT, 1, 0),
					new ItemStack(ModItems.HIMEJIMARIUM_SHEARS, 1, 0),
					new ItemStack(ModItems.HIMEJIMARIUM_SHIELD, 1, 0),
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
			ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "kitagawarium",
					new ItemStack(ModItems.KITAGAWARIUM_SWORD, 1, 0),
					new ItemStack(ModItems.KITAGAWARIUM_SHOVEL, 1, 0),
					new ItemStack(ModItems.KITAGAWARIUM_PICKAXE, 1, 0),
					new ItemStack(ModItems.KITAGAWARIUM_AXE, 1, 0), new ItemStack(ModItems.KITAGAWARIUM_HOE, 1, 0),
					new ItemStack(ModItems.KITAGAWARIUM_PAXEL, 1, 0),
					new ItemStack(ModItems.KITAGAWARIUM_SMASHBAT, 1, 0),
					new ItemStack(ModItems.KITAGAWARIUM_SHEARS, 1, 0),
					new ItemStack(ModItems.KITAGAWARIUM_SHIELD, 1, 0),
					"stickWood", "ingotKitagawarium");

			ModRecipeHelper.addPaxelRecipe(OedldoedlGear.MODID, "wooden", new ItemStack(ModItems.WOODEN_PAXEL, 1, 0),
					"stickWood", new ItemStack(Items.WOODEN_AXE, 1, 0), new ItemStack(Items.WOODEN_SHOVEL, 1, 0),
					new ItemStack(Items.WOODEN_PICKAXE, 1, 0));
			ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "wooden",
					new ItemStack(ModItems.WOODEN_SMASHBAT, 1, 0), "plankWood");
			ModRecipeHelper.addShearsRecipe(OedldoedlGear.MODID, "wooden", new ItemStack(ModItems.WOODEN_SHEARS, 1, 0),
					"plankWood");

			ModRecipeHelper.addPaxelRecipe(OedldoedlGear.MODID, "stone", new ItemStack(ModItems.STONE_PAXEL, 1, 0),
					"cobblestone", new ItemStack(Items.STONE_AXE, 1, 0), new ItemStack(Items.STONE_SHOVEL, 1, 0),
					new ItemStack(Items.STONE_PICKAXE, 1, 0));
			ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "stone",
					new ItemStack(ModItems.STONE_SMASHBAT, 1, 0), "cobblestone");
			ModRecipeHelper.addShearsRecipe(OedldoedlGear.MODID, "stone", new ItemStack(ModItems.STONE_SHEARS, 1, 0),
					"cobblestone");

			ModRecipeHelper.addPaxelRecipe(OedldoedlGear.MODID, "golden", new ItemStack(ModItems.GOLDEN_PAXEL, 1, 0),
					"stickWood", new ItemStack(Items.GOLDEN_AXE, 1, 0), new ItemStack(Items.GOLDEN_SHOVEL, 1, 0),
					new ItemStack(Items.GOLDEN_PICKAXE, 1, 0));
			ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "golden",
					new ItemStack(ModItems.GOLDEN_SMASHBAT, 1, 0), "ingotGold");
			ModRecipeHelper.addShearsRecipe(OedldoedlGear.MODID, "golden", new ItemStack(ModItems.GOLDEN_SHEARS, 1, 0),
					"ingotGold");

			ModRecipeHelper.addPaxelRecipe(OedldoedlGear.MODID, "iron", new ItemStack(ModItems.IRON_PAXEL, 1, 0),
					"stickWood", new ItemStack(Items.IRON_AXE, 1, 0), new ItemStack(Items.IRON_SHOVEL, 1, 0),
					new ItemStack(Items.IRON_PICKAXE, 1, 0));
			ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "iron", new ItemStack(ModItems.IRON_SMASHBAT, 1, 0),
					"ingotIron");

			ModRecipeHelper.addPaxelRecipe(OedldoedlGear.MODID, "diamond", new ItemStack(ModItems.DIAMOND_PAXEL, 1, 0),
					"stickWood", new ItemStack(Items.DIAMOND_AXE, 1, 0), new ItemStack(Items.DIAMOND_SHOVEL, 1, 0),
					new ItemStack(Items.DIAMOND_PICKAXE, 1, 0));
			ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "diamond",
					new ItemStack(ModItems.DIAMOND_SMASHBAT, 1, 0), "gemDiamond");
			ModRecipeHelper.addShearsRecipe(OedldoedlGear.MODID, "diamond",
					new ItemStack(ModItems.DIAMOND_SHEARS, 1, 0), "gemDiamond");
		}

		if (GearConfig.RECIPES.DEFAULT_RECIPES) {
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/black_wizard_hat",
					new ItemStack(ModItems.BLACK_WIZARD_HAT, 1, 0), " A ", " B ", "BBB", 'A', "ghastTear", 'B',
					"fabricBlack");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/black_wizard_hat_clear",
					new ItemStack(ModItems.BLACK_WIZARD_HAT, 1, 0), "A", 'A',
					new ItemStack(ModItems.BLACK_WIZARD_HAT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/blue_wizard_hat",
					new ItemStack(ModItems.BLUE_WIZARD_HAT, 1, 0), " A ", " B ", "BCB", 'A', "ghastTear", 'B',
					"fabricBlue", 'C', "fabricYellow");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/blue_wizard_hat_clear",
					new ItemStack(ModItems.BLUE_WIZARD_HAT, 1, 0), "A", 'A',
					new ItemStack(ModItems.BLUE_WIZARD_HAT, 1, 0));
			ModRecipeHelper.addChestplateRecipe(OedldoedlGear.MODID, "gamemode",
					new ItemStack(ModItems.GAMEMODE_CHESTPLATE, 1, 0), "commandBlock");

			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/classic_flying_shooting_hoodie",
					new ItemStack(ModItems.CLASSIC_FLYING_SHOOTING_HOODIE, 1, 0), "A A", "ACB", "AAA", 'A',
					"fabricBlue",
					'B', "fabricLightGray", 'C', "fabricLightBlue");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/black_flying_shooting_hoodie",
					new ItemStack(ModItems.BLACK_FLYING_SHOOTING_HOODIE, 1, 0), "A A", "ACB", "AAA", 'A', "fabricBlack",
					'B', "fabricLightGray", 'C', "fabricLightBlue");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/white_flying_shooting_hoodie",
					new ItemStack(ModItems.WHITE_FLYING_SHOOTING_HOODIE, 1, 0), "A A", "ACB", "AAA", 'A', "fabricWhite",
					'B', "fabricLightGray", 'C', "fabricLightBlue");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/flying_shooting_college_jacket",
					new ItemStack(ModItems.FLYING_SHOOTING_COLLEGE_JACKET, 1, 0), "A A", "BCB", "ADA", 'A',
					"fabricBlack",
					'B', "fabricWhite", 'C', new ItemStack(ModItems.BLACK_FLYING_SHOOTING_HOODIE, 1, 0), 'D',
					new ItemStack(ModItems.WHITE_FLYING_SHOOTING_HOODIE, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/gradient_güffy_tag_quilted_jacket",
					new ItemStack(ModItems.GRADIENT_GUEFFY_TAG_QUILTED_JACKET, 1, 0), "A A", "BCB", "DED", 'A',
					"fabricMagenta", 'B', "fabricPurple", 'C', "fabricWhite", 'D', "fabricLightBlue", 'E',
					"fabricCyan");

			ModGearRecipeHelper.addTravellersBootsUpgrade(OedldoedlGear.MODID, "travellers",
					new ItemStack(ModItems.TRAVELLERS_BOOTS, 1, 0),
					new ItemStack(Items.LEATHER_BOOTS, 1, 0), "string");
			ModGearRecipeHelper.addTravellersBootsUpgrade(OedldoedlGear.MODID, "travellers_golden",
					new ItemStack(ModItems.TRAVELLERS_GOLDEN_BOOTS, 1, 0),
					new ItemStack(ModItems.TRAVELLERS_BOOTS, 1, 0), "ingotGold");
			ModGearRecipeHelper.addTravellersBootsUpgrade(OedldoedlGear.MODID, "travellers_iron",
					new ItemStack(ModItems.TRAVELLERS_IRON_BOOTS, 1, 0),
					new ItemStack(ModItems.TRAVELLERS_GOLDEN_BOOTS, 1, 0), "ingotIron");
			ModGearRecipeHelper.addTravellersBootsUpgrade(OedldoedlGear.MODID, "travellers_diamond",
					new ItemStack(ModItems.TRAVELLERS_DIAMOND_BOOTS, 1, 0),
					new ItemStack(ModItems.TRAVELLERS_IRON_BOOTS, 1, 0), "gemDiamond");
			ModGearRecipeHelper.addTravellersBootsUpgrade(OedldoedlGear.MODID, "travellers_emerald",
					new ItemStack(ModItems.TRAVELLERS_EMERALD_BOOTS, 1, 0),
					new ItemStack(ModItems.TRAVELLERS_DIAMOND_BOOTS, 1, 0), "gemEmerald");

			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/long_fall_boots",
					new ItemStack(ModItems.LONG_FALL_BOOTS, 1, 0), "A A", "B B", 'A', "gemDiamond", 'B', "obsidian");

			ModRecipeHelper.addHorseArmorRecipe(OedldoedlGear.MODID, "base",
					new ItemStack(ModItems.BASE_HORSE_ARMOR, 1, 0), "ingotBase");
			ModRecipeHelper.addHorseArmorRecipe(OedldoedlGear.MODID, "chainmail",
					new ItemStack(ModItems.CHAINMAIL_HORSE_ARMOR, 1, 0), "chainmail");
			ModRecipeHelper.addHorseArmorRecipe(OedldoedlGear.MODID, "emerald",
					new ItemStack(ModItems.EMERALD_HORSE_ARMOR, 1, 0), "gemEmerald");

			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/launching_smashbat",
					new ItemStack(ModItems.LAUNCHING_SMASHBAT, 1, 0), "ABA", "ABA", " C ", 'A', "gunpowder", 'B',
					new ItemStack(Items.BLAZE_ROD, 1, 0), 'C', "leather");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/blasting_smashbat",
					new ItemStack(ModItems.BLASTING_SMASHBAT, 1, 0), "ABA", "ABA", " C ", 'A', "gemFlint", 'B', "tnt",
					'C', "leather");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/lightning_smashbat",
					new ItemStack(ModItems.LIGHTNING_SMASHBAT, 1, 0), "ABA", "ABA", " C ", 'A', "dustGlowstone", 'B',
					"ingotIron", 'C', "leather");
			ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "rididng",
					new ItemStack(ModItems.RIDING_SMASHBAT, 1, 0), "cropCarrot");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/golden_riding_smashbat",
					new ItemStack(ModItems.GOLDEN_RIDING_SMASHBAT, 1, 0), "A", "A", "B", 'A',
					new ItemStack(Items.GOLDEN_CARROT, 1, 0), 'B', "leather");

			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/pork_hammer",
					new ItemStack(ModItems.PORK_HAMMER, 1, 0), " A ", " BA", "B  ", 'A',
					new ItemStack(Items.PORKCHOP, 1, 0), 'B', "stickWood");

			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/ban_hammer",
					new ItemStack(ModItems.BAN_HAMMER, 1, 0), " A ", " BA", "B  ", 'A', "commandBlock", 'B',
					"stickWood");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/kick_Stick",
					new ItemStack(ModItems.KICK_STICK, 1, 0), "  A", " A ", "B  ", 'A', "commandBlock", 'B',
					"stickWood");

			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/explosion_staff",
					new ItemStack(ModItems.EXPLOSION_STAFF, 1, 0), " AB", "CDA", "AC ", 'A', "blockMagicWood", 'B',
					"ingotGold", 'C', "fabricWhite", 'D', "coreExplosion");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/lightning_staff",
					new ItemStack(ModItems.LIGHTNING_STAFF, 1, 0), " AB", "CDA", "AC ", 'A', "blockMagicWood", 'B',
					"dyeWhite", 'C', "fabricBlack", 'D', "coreCharged");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/frieren_staff",
					new ItemStack(ModItems.FRIEREN_STAFF, 1, 0), " AB", "CDA", "AC ", 'A', "blockMagicWood", 'B',
					"ingotGold", 'C', "fabricRed", 'D', "coreMystic");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/admin_staff",
					ModNBTUtil.addNBTItem(ModItems.ADMIN_STAFF, "Mode", "Day"), " AA", " BA", "B  ", 'A',
					"commandBlock", 'B', "stickWood");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/skull_wand",
					new ItemStack(ModItems.SKULL_WAND, 1, 0), " AB", " CD", "C  ", 'A', "tnt", 'B',
					new ItemStack(Items.SKULL, 1, 1), 'C', "stickWood", 'D', "ingotGold");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/fire_wand",
					new ItemStack(ModItems.FIRE_WAND, 1, 0),
					" AB", " CD", "C  ", 'A', "tnt", 'B', new ItemStack(Items.FIRE_CHARGE, 1, 0), 'C', "stickWood", 'D',
					"ingotGold");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/fly_swatter",
					new ItemStack(ModItems.FLY_SWATTER, 1, 0), " AA", " AA", "B  ", 'A', "string", 'B', "stickWood");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/bedrock_breaker",
					new ItemStack(ModItems.BEDROCK_BREAKER, 1, 0), " AA", " AA", "B  ", 'A', "bedrock", 'B',
					"stickWood");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/needle", new ItemStack(ModItems.NEEDLE, 1, 0),
					"  A", " B ", "B  ", 'A', "ingotIron", 'B', "nuggetIron");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/bref_power",
					new ItemStack(ModItems.BREF_POWER, 1, 0), "ABC", "ADB", "EBF", 'A', "nuggetIron", 'B', "ingotIron",
					'C', "dyeWhite", 'D', "listAllwater", 'E', "dyeRed", 'F', "dyeOrange");

			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "rocky_snowball",
					new ItemStack(ModItems.ROCKY_SNOWBALL, 8, 0), "AAA", "ABA", "AAA", 'A', "snowball", 'B', "stone");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "explosive_snowball",
					new ItemStack(ModItems.EXPLOSIVE_SNOWBALL, 8, 0), "AAA", "ABA", "AAA", 'A', "snowball", 'B', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "charged_snowball",
					new ItemStack(ModItems.CHARGED_SNOWBALL, 8, 0), "AAA", "ABA", "AAA", 'A', "snowball", 'B',
					"essenceCharged");

			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "white_fabric",
					new ItemStack(ModItems.WHITE_FABRIC, 2, 0), "white");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "orange_fabric",
					new ItemStack(ModItems.ORANGE_FABRIC, 2, 0), "orange");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "magenta_fabric",
					new ItemStack(ModItems.MAGENTA_FABRIC, 2, 0), "magenta");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "light_blue_fabric",
					new ItemStack(ModItems.LIGHT_BLUE_FABRIC, 2, 0), "lightBlue");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "yellow_fabric",
					new ItemStack(ModItems.YELLOW_FABRIC, 2, 0), "yellow");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "lime_fabric",
					new ItemStack(ModItems.LIME_FABRIC, 2, 0), "lime");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "pink_fabric",
					new ItemStack(ModItems.PINK_FABRIC, 2, 0), "pink");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "gray_fabric",
					new ItemStack(ModItems.GRAY_FABRIC, 2, 0), "gray");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "light_gray_fabric",
					new ItemStack(ModItems.LIGHT_GRAY_FABRIC, 2, 0), "lightGray");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "cyan_fabric",
					new ItemStack(ModItems.CYAN_FABRIC, 2, 0), "cyan");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "purple_fabric",
					new ItemStack(ModItems.PURPLE_FABRIC, 2, 0), "purple");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "blue_fabric",
					new ItemStack(ModItems.BLUE_FABRIC, 2, 0), "blue");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "brown_fabric",
					new ItemStack(ModItems.BROWN_FABRIC, 2, 0), "brown");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "green_fabric",
					new ItemStack(ModItems.GREEN_FABRIC, 2, 0), "green");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "red_fabric",
					new ItemStack(ModItems.RED_FABRIC, 2, 0), "red");
			ModGearRecipeHelper.addFabricRecipe(OedldoedlGear.MODID, "black_fabric",
					new ItemStack(ModItems.BLACK_FABRIC, 2, 0), "black");

			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "travellers_leather",
					new ItemStack(ModItems.TRAVELLERS_LEATHER, 2, 0), "ABA", "BCB", "ABA", 'A', "gemFlint", 'B',
					"ingotGold", 'C', "leather");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "explosion_core",
					new ItemStack(ModItems.EXPLOSION_CORE, 1, 0), "AAA", "ABA", "AAA", 'A', "tnt", 'B',
					"blockOedldoedl");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "charged_core",
					new ItemStack(ModItems.CHARGED_CORE, 1, 0), "ABA", "BCB", "ABA", 'A', "dyeWhite", 'B',
					"dyeLightBlue", 'C', "blockOedldoedl");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "mystic_core",
					new ItemStack(ModItems.MYSTIC_CORE, 1, 0), "ABA", "CDC", "ABA", 'A', "ingotGold", 'B',
					"dyeRed", 'C', ModNBTUtil.addSplashPotion("strong_harming"), 'D', "blockOedldoedl");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "chainmail", new ItemStack(ModItems.CHAINMAIL, 4, 0),
					"AAA", "BCB", "ABA", 'A', "nuggetIron", 'B', "ingotIron", 'C', "paper");

			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "badrock", new ItemStack(ModBlocks.BADROCK, 1, 0),
					"ABA", "CDC", "ABA", 'A', "nuggetBedrockium", 'B', "dyeGray", 'C', "dyeLightGray", 'D', "stone");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "enhanced_dirt",
					new ItemStack(ModBlocks.ENHANCED_DIRT, 4, 0), " A ", "ABA", " A ", 'A', "dirt", 'B',
					"bookEnchanted");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "magical_wood",
					new ItemStack(ModBlocks.MAGICAL_WOOD, 1, 0), "ABA", "BCB", "ABA", 'A', "nuggetGold", 'B',
					"ingotGold", 'C', "bookshelf");
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "magical_wood_planks",
					new ItemStack(ModBlocks.MAGICAL_WOOD_PLANKS, 4, 0), "A", 'A', "blockMagicWood");

			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "jump_pad", new ItemStack(ModBlocks.JUMP_PAD, 1, 0),
					"A", "B", 'A', "slimeball", 'B', new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "jump_pad_plus",
					new ItemStack(ModBlocks.JUMP_PAD_PLUS, 1, 0),
					"A", "B", 'A', "slimeball", 'B', new ItemStack(ModBlocks.JUMP_PAD, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "jump_pad_plus_plus",
					new ItemStack(ModBlocks.JUMP_PAD_PLUS_PLUS, 1, 0),
					"A", "B", 'A', "slimeball", 'B', new ItemStack(ModBlocks.JUMP_PAD_PLUS, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "jump_pad_plus_plus_plus",
					new ItemStack(ModBlocks.JUMP_PAD_PLUS_PLUS_PLUS, 1, 0),
					"A", "B", 'A', "slimeball", 'B', new ItemStack(ModBlocks.JUMP_PAD_PLUS_PLUS, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "impact_pad",
					new ItemStack(ModBlocks.IMPACT_PAD, 1, 0),
					"A", "B", 'A', "wool", 'B', new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 1, 0));
		}

		if (GearConfig.RECIPES.BREWING_RECIPES) {
			ModRecipeHelper.addBrewingRecipe(ModPotions.FLIGHT_NORMAL, PotionTypes.AWKWARD,
					new ItemStack(Items.ELYTRA, 1, 0));
			ModRecipeHelper.addBrewingRecipe(ModPotions.FLIGHT_LONG, ModPotions.FLIGHT_NORMAL,
					new ItemStack(Items.REDSTONE, 1, 0));

			ModRecipeHelper.addBrewingRecipe(ModPotions.MILK_NORMAL, PotionTypes.WATER,
					new ItemStack(Items.MILK_BUCKET, 1, 0));
		}
	}
}