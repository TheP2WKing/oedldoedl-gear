package net.thep2wking.oedldoedlgear.registry;

import javax.annotation.Nonnull;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModNBTUtil;
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

		ModRecipeHelper.addOreDict("leatherTravellers", ModItems.TRAVELLERS_LEATHER, 0);

		ModRecipeHelper.addOreDict("coreExplosion", ModItems.EXPLOSION_CORE, 0);
		ModRecipeHelper.addOreDict("essenceCharged", ModItems.CHARGED_ESSENCE, 0);

		ModRecipeHelper.addOreDict("chainmail", ModItems.CHAINMAIL, 0);

		ModRecipeHelper.addOreDict("noteSuffering", ModItems.NOTE_OF_SUFFERING, 0);

		ModRecipeHelper.addOreDict("toolHoe", ModItems.BASE_HOE, 0);
		ModRecipeHelper.addOreDict("toolHoe", ModItems.OEDLDOEDL_HOE, 0);
		ModRecipeHelper.addOreDict("toolHoe", ModItems.EMERALD_HOE, 0);

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

	public static void addTravellersBootsUpgrade(String modid, String name, @Nonnull ItemStack bootsOut,
			@Nonnull ItemStack bootsIn, String material) {
		ModRecipeHelper.addShapedRecipe(modid, "armor/" + name + "_boots", bootsOut, "ABA", "CAC", 'A',
				material, 'B', bootsIn, 'C', "leatherTravellers");
	}

	public static void addHelmetRecipe(String modid, String name, @Nonnull ItemStack helmet, String material) {
		ModRecipeHelper.addShapedRecipe(modid, "armor/" + name + "_helmet", helmet, "ABA", "A A", 'A', material, 'B',
				name + "Star");
	}

	public static void addChestplateRecipe(String modid, String name, @Nonnull ItemStack chestplate, String material) {
		ModRecipeHelper.addShapedRecipe(modid, "armor/" + name + "_chestplate", chestplate, "A A", "ABA", "AAA", 'A',
				material, 'B', name + "Star");
	}

	public static void addLeggingsRecipe(String modid, String name, @Nonnull ItemStack leggings, String material) {
		ModRecipeHelper.addShapedRecipe(modid, "armor/" + name + "_leggings", leggings, "ABA", "A A", "A A", 'A',
				material, 'B', name + "Star");
	}

	public static void addBootsRecipe(String modid, String name, @Nonnull ItemStack boots, String material) {
		ModRecipeHelper.addShapedRecipe(modid, "armor/" + name + "_boots", boots, "A A", "A B", 'A', material, 'B',
				name + "Star");
	}

	public static void addFullStarArmorRecipe(String modid, String name, @Nonnull ItemStack helmet,
			@Nonnull ItemStack chestplate, @Nonnull ItemStack leggings, @Nonnull ItemStack boots, String material) {
		addHelmetRecipe(modid, name, helmet, material);
		addChestplateRecipe(modid, name, chestplate, material);
		addLeggingsRecipe(modid, name, leggings, material);
		addBootsRecipe(modid, name, boots, material);
	}

	public static void addFabricRecipe(String modid, String name, @Nonnull ItemStack fabric, String color) {
		ModRecipeHelper.addShapedRecipe(modid, name, fabric, "AB ", "BCB", " B ", 'A', "toolNeedle", 'B',
				"string", 'C', "wool" + color.substring(0, 1).toUpperCase() + color.substring(1));
	}

	@SuppressWarnings("null")
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
		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "emerald", new ItemStack(ModItems.EMERALD_HELMET, 1, 0),
				new ItemStack(ModItems.EMERALD_CHESTPLATE, 1, 0), new ItemStack(ModItems.EMERALD_LEGGINGS, 1, 0),
				new ItemStack(ModItems.EMERALD_BOOTS, 1, 0), "gemEmerald");
		ModRecipeHelper.addFullArmorRecipe(OedldoedlGear.MODID, "chainmail",
				new ItemStack(Items.CHAINMAIL_HELMET, 1, 0),
				new ItemStack(Items.CHAINMAIL_CHESTPLATE, 1, 0),
				new ItemStack(Items.CHAINMAIL_LEGGINGS, 1, 0),
				new ItemStack(Items.CHAINMAIL_BOOTS, 1, 0), "chainmail");

		addFullStarArmorRecipe(OedldoedlGear.MODID, "gremorium",
				new ItemStack(ModItems.GREMORIUM_HELMET, 1, 0),
				new ItemStack(ModItems.GREMORIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.GREMORIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.GREMORIUM_BOOTS, 1, 0), "ingotGremorium");
		addFullStarArmorRecipe(OedldoedlGear.MODID, "himejimarium",
				new ItemStack(ModItems.HIMEJIMARIUM_HELMET, 1, 0),
				new ItemStack(ModItems.HIMEJIMARIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.HIMEJIMARIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.HIMEJIMARIUM_BOOTS, 1, 0), "ingotHimejimarium");
		addFullStarArmorRecipe(OedldoedlGear.MODID, "toujourium",
				new ItemStack(ModItems.TOUJOURIUM_HELMET, 1, 0),
				new ItemStack(ModItems.TOUJOURIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.TOUJOURIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.TOUJOURIUM_BOOTS, 1, 0), "ingotToujourium");
		addFullStarArmorRecipe(OedldoedlGear.MODID, "argentorium",
				new ItemStack(ModItems.ARGENTORIUM_HELMET, 1, 0),
				new ItemStack(ModItems.ARGENTORIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.ARGENTORIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.ARGENTORIUM_BOOTS, 1, 0), "ingotArgentorium");
		addFullStarArmorRecipe(OedldoedlGear.MODID, "quartarium",
				new ItemStack(ModItems.QUARTARIUM_HELMET, 1, 0),
				new ItemStack(ModItems.QUARTARIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.QUARTARIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.QUARTARIUM_BOOTS, 1, 0), "ingotQuartarium");
		addFullStarArmorRecipe(OedldoedlGear.MODID, "nagatorium",
				new ItemStack(ModItems.NAGATORIUM_HELMET, 1, 0),
				new ItemStack(ModItems.NAGATORIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.NAGATORIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.NAGATORIUM_BOOTS, 1, 0), "ingotNagatorium");
		addFullStarArmorRecipe(OedldoedlGear.MODID, "sakurajimarium",
				new ItemStack(ModItems.SAKURAJIMARIUM_HELMET, 1, 0),
				new ItemStack(ModItems.SAKURAJIMARIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.SAKURAJIMARIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.SAKURAJIMARIUM_BOOTS, 1, 0), "ingotSakurajimarium");
		addFullStarArmorRecipe(OedldoedlGear.MODID, "kitagawarium",
				new ItemStack(ModItems.KITAGAWARIUM_HELMET, 1, 0),
				new ItemStack(ModItems.KITAGAWARIUM_CHESTPLATE, 1, 0),
				new ItemStack(ModItems.KITAGAWARIUM_LEGGINGS, 1, 0),
				new ItemStack(ModItems.KITAGAWARIUM_BOOTS, 1, 0), "ingotKitagawarium");

		ModRecipeHelper.addChestplateRecipe(OedldoedlGear.MODID, "gamemode",
				new ItemStack(ModItems.GAMEMODE_CHESTPLATE, 1, 0), "commandBlock");

		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/classic_flying_shooting_hoodie",
				new ItemStack(ModItems.CLASSIC_FLYING_SHOOTING_HOODIE, 1, 0), "A A", "ACB", "AAA", 'A', "fabricBlue",
				'B', "fabricLightGray", 'C', "fabricLightBlue");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/black_flying_shooting_hoodie",
				new ItemStack(ModItems.BLACK_FLYING_SHOOTING_HOODIE, 1, 0), "A A", "ACB", "AAA", 'A', "fabricBlack",
				'B', "fabricLightGray", 'C', "fabricLightBlue");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/white_flying_shooting_hoodie",
				new ItemStack(ModItems.WHITE_FLYING_SHOOTING_HOODIE, 1, 0), "A A", "ACB", "AAA", 'A', "fabricWhite",
				'B', "fabricLightGray", 'C', "fabricLightBlue");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/flying_shooting_college_jacket",
				new ItemStack(ModItems.FLYING_SHOOTING_COLLEGE_JACKET, 1, 0), "A A", "BCB", "ADA", 'A', "fabricBlack",
				'B', "fabricWhite", 'C', new ItemStack(ModItems.BLACK_FLYING_SHOOTING_HOODIE, 1, 0), 'D',
				new ItemStack(ModItems.WHITE_FLYING_SHOOTING_HOODIE, 1, 0));
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/gradient_güffy_tag_quilted_jacket",
				new ItemStack(ModItems.GRADIENT_GUEFFY_TAG_QUILTED_JACKET, 1, 0), "A A", "BCB", "DED", 'A',
				"fabricMagenta", 'B', "fabricPurple", 'C', "fabricWhite", 'D', "fabricLightBlue", 'E', "fabricCyan");

		addTravellersBootsUpgrade(OedldoedlGear.MODID, "travellers",
				new ItemStack(ModItems.TRAVELLERS_BOOTS, 1, 0),
				new ItemStack(Items.LEATHER_BOOTS, 1, 0), "string");
		addTravellersBootsUpgrade(OedldoedlGear.MODID, "travellers_golden",
				new ItemStack(ModItems.TRAVELLERS_GOLDEN_BOOTS, 1, 0),
				new ItemStack(ModItems.TRAVELLERS_BOOTS, 1, 0), "ingotGold");
		addTravellersBootsUpgrade(OedldoedlGear.MODID, "travellers_iron",
				new ItemStack(ModItems.TRAVELLERS_IRON_BOOTS, 1, 0),
				new ItemStack(ModItems.TRAVELLERS_GOLDEN_BOOTS, 1, 0), "ingotIron");
		addTravellersBootsUpgrade(OedldoedlGear.MODID, "travellers_diamond",
				new ItemStack(ModItems.TRAVELLERS_DIAMOND_BOOTS, 1, 0),
				new ItemStack(ModItems.TRAVELLERS_IRON_BOOTS, 1, 0), "gemDiamond");
		addTravellersBootsUpgrade(OedldoedlGear.MODID, "travellers_emerald",
				new ItemStack(ModItems.TRAVELLERS_EMERALD_BOOTS, 1, 0),
				new ItemStack(ModItems.TRAVELLERS_DIAMOND_BOOTS, 1, 0), "gemEmerald");

		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "armor/long_fall_boots",
				new ItemStack(ModItems.LONG_FALL_BOOTS, 1, 0), "A A", "B B", 'A', "gemDiamond", 'B', "obsidian");

		ModRecipeHelper.addHorseArmorRecipe(OedldoedlGear.MODID, "base", new ItemStack(ModItems.BASE_HORSE_ARMOR, 1, 0),
				"ingotBase");
		ModRecipeHelper.addHorseArmorRecipe(OedldoedlGear.MODID, "chainmail",
				new ItemStack(ModItems.CHAINMAIL_HORSE_ARMOR, 1, 0), "chainmail");
		ModRecipeHelper.addHorseArmorRecipe(OedldoedlGear.MODID, "emerald",
				new ItemStack(ModItems.EMERALD_HORSE_ARMOR, 1, 0), "gemEmerald");

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
		ModRecipeHelper.addSwordRecipe(OedldoedlGear.MODID, "emerald",
				new ItemStack(ModItems.EMERALD_SWORD, 1, 0), "stickWood", "gemEmerald");
		ModRecipeHelper.addShovelRecipe(OedldoedlGear.MODID, "emerald",
				new ItemStack(ModItems.EMERALD_SHOVEL, 1, 0), "stickWood", "gemEmerald");
		ModRecipeHelper.addPickaxeRecipe(OedldoedlGear.MODID, "emerald",
				new ItemStack(ModItems.EMERALD_PICKAXE, 1, 0), "stickWood", "gemEmerald");
		ModRecipeHelper.addAxeRecipe(OedldoedlGear.MODID, "emerald", new ItemStack(ModItems.EMERALD_AXE, 1, 0),
				"stickWood", "gemEmerald");
		ModRecipeHelper.addHoeRecipe(OedldoedlGear.MODID, "emerald", new ItemStack(ModItems.EMERALD_HOE, 1, 0),
				"stickWood", "gemEmerald");
		ModRecipeHelper.addPaxelRecipe(OedldoedlGear.MODID, "emerald",
				new ItemStack(ModItems.EMERALD_PAXEL, 1, 0), "stickWood", new ItemStack(ModItems.EMERALD_AXE, 1, 0),
				new ItemStack(ModItems.EMERALD_SHOVEL, 1, 0), new ItemStack(ModItems.EMERALD_PICKAXE, 1, 0));
		ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "emerald",
				new ItemStack(ModItems.EMERALD_SMASHBAT, 1, 0), "gemEmerald");
		ModRecipeHelper.addShearsRecipe(OedldoedlGear.MODID, "emerald",
				new ItemStack(ModItems.EMERALD_SHEARS, 1, 0), "gemEmerald");

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
		ModRecipeHelper.addFullToolRecipe(OedldoedlGear.MODID, "kitagawarium",
				new ItemStack(ModItems.KITAGAWARIUM_SWORD, 1, 0),
				new ItemStack(ModItems.KITAGAWARIUM_SHOVEL, 1, 0), new ItemStack(ModItems.KITAGAWARIUM_PICKAXE, 1, 0),
				new ItemStack(ModItems.KITAGAWARIUM_AXE, 1, 0), new ItemStack(ModItems.KITAGAWARIUM_HOE, 1, 0),
				new ItemStack(ModItems.KITAGAWARIUM_PAXEL, 1, 0), new ItemStack(ModItems.KITAGAWARIUM_SMASHBAT, 1, 0),
				new ItemStack(ModItems.KITAGAWARIUM_SHEARS, 1, 0), new ItemStack(ModItems.KITAGAWARIUM_SHIELD, 1, 0),
				"stickWood", "ingotKitagawarium");

		ModRecipeHelper.addPaxelRecipe(OedldoedlGear.MODID, "wooden", new ItemStack(ModItems.WOODEN_PAXEL, 1, 0),
				"stickWood", new ItemStack(Items.WOODEN_AXE, 1, 0), new ItemStack(Items.WOODEN_SHOVEL, 1, 0),
				new ItemStack(Items.WOODEN_PICKAXE, 1, 0));
		ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "wooden", new ItemStack(ModItems.WOODEN_SMASHBAT, 1, 0),
				"plankWood");
		ModRecipeHelper.addShearsRecipe(OedldoedlGear.MODID, "wooden", new ItemStack(ModItems.WOODEN_SHEARS, 1, 0),
				"plankWood");

		ModRecipeHelper.addPaxelRecipe(OedldoedlGear.MODID, "stone", new ItemStack(ModItems.STONE_PAXEL, 1, 0),
				"cobblestone", new ItemStack(Items.STONE_AXE, 1, 0), new ItemStack(Items.STONE_SHOVEL, 1, 0),
				new ItemStack(Items.STONE_PICKAXE, 1, 0));
		ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "stone", new ItemStack(ModItems.STONE_SMASHBAT, 1, 0),
				"cobblestone");
		ModRecipeHelper.addShearsRecipe(OedldoedlGear.MODID, "stone", new ItemStack(ModItems.STONE_SHEARS, 1, 0),
				"cobblestone");

		ModRecipeHelper.addPaxelRecipe(OedldoedlGear.MODID, "golden", new ItemStack(ModItems.GOLDEN_PAXEL, 1, 0),
				"stickWood", new ItemStack(Items.GOLDEN_AXE, 1, 0), new ItemStack(Items.GOLDEN_SHOVEL, 1, 0),
				new ItemStack(Items.GOLDEN_PICKAXE, 1, 0));
		ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "golden", new ItemStack(ModItems.GOLDEN_SMASHBAT, 1, 0),
				"ingotGold");
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
				new ItemStack(ModItems.DIAMOND_SMASHBAT, 1, 0),
				"gemDiamond");
		ModRecipeHelper.addShearsRecipe(OedldoedlGear.MODID, "diamond", new ItemStack(ModItems.DIAMOND_SHEARS, 1, 0),
				"gemDiamond");

		ModRecipeHelper.addSmashbatRecipe(OedldoedlGear.MODID, "rididng", new ItemStack(ModItems.RIDING_SMASHBAT, 1, 0),
				"cropCarrot");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/golden_riding_smashbat",
				new ItemStack(ModItems.GOLDEN_RIDING_SMASHBAT, 1, 0), "A", "A", "B", 'A',
				new ItemStack(Items.GOLDEN_CARROT, 1, 0), 'B', "leather");

		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/ban_hammer",
				new ItemStack(ModItems.BAN_HAMMER, 1, 0), " A ", " BA", "B  ", 'A', "commandBlock", 'B', "stickWood");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/kick_Stick",
				new ItemStack(ModItems.KICK_STICK, 1, 0), "  A", " A ", "B  ", 'A', "commandBlock", 'B', "stickWood");

		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/explosion_staff",
				new ItemStack(ModItems.EXPLOSION_STAFF, 1, 0), " AB", "CDA", "AC ", 'A', "magicWood", 'B', "string",
				'C', "ingotGold", 'D', "coreExplosion");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/lightning_staff",
				new ItemStack(ModItems.LIGHTNING_STAFF, 1, 0), " AB", "CDA", "AC ", 'A', "magicWood", 'B', "dyeWhite",
				'C', "dyeBlack", 'D', "essenceCharged");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/admin_staff",
				ModNBTUtil.addNBTItem(ModItems.ADMIN_STAFF, "Mode", "Day"), " AA", " BA", "B  ", 'A', "commandBlock",
				'B', "stickWood");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/skull_wand",
				new ItemStack(ModItems.SKULL_WAND, 1, 0), " AB", " CD", "C  ", 'A', "tnt", 'B',
				new ItemStack(Items.SKULL, 1, 1), 'C', "stickWood", 'D', "ingotGold");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/fire_wand", new ItemStack(ModItems.FIRE_WAND, 1, 0),
				" AB", " CD", "C  ", 'A', "tnt", 'B', new ItemStack(Items.FIRE_CHARGE, 1, 0), 'C', "stickWood", 'D',
				"ingotGold");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/bedrock_breaker",
				new ItemStack(ModItems.BEDROCK_BREAKER, 1, 0), " AA", " AA", "B  ", 'A', "bedrock", 'B', "stickWood");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/needle", new ItemStack(ModItems.NEEDLE, 1, 0), "  A",
				" B ", "B  ", 'A', "ingotIron", 'B', "nuggetIron");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "tool/bref_power",
				new ItemStack(ModItems.BREF_POWER, 1, 0), "ABC", "ADB", "EBF", 'A', "nuggetIron", 'B', "ingotIron", 'C',
				"dyeWhite", 'D', new ItemStack(Items.WATER_BUCKET, 1, 0), 'E', "dyeRed", 'F', "dyeOrange");

		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "rocky_snowball",
				new ItemStack(ModItems.ROCKY_SNOWBALL, 8, 0), "AAA", "ABA", "AAA", 'A', "snowball", 'B', "stone");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "explosive_snowball",
				new ItemStack(ModItems.EXPLOSIVE_SNOWBALL, 8, 0), "AAA", "ABA", "AAA", 'A', "snowball", 'B', "tnt");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "charged_snowball",
				new ItemStack(ModItems.CHARGED_SNOWBALL, 8, 0), "AAA", "ABA", "AAA", 'A', "snowball", 'B',
				"essenceCharged");

		addFabricRecipe(OedldoedlGear.MODID, "white_fabric", new ItemStack(ModItems.WHITE_FABRIC, 2, 0), "white");
		addFabricRecipe(OedldoedlGear.MODID, "orange_fabric", new ItemStack(ModItems.ORANGE_FABRIC, 2, 0), "orange");
		addFabricRecipe(OedldoedlGear.MODID, "magenta_fabric", new ItemStack(ModItems.MAGENTA_FABRIC, 2, 0), "magenta");
		addFabricRecipe(OedldoedlGear.MODID, "light_blue_fabric", new ItemStack(ModItems.LIGHT_BLUE_FABRIC, 2, 0),
				"lightBlue");
		addFabricRecipe(OedldoedlGear.MODID, "yellow_fabric", new ItemStack(ModItems.YELLOW_FABRIC, 2, 0), "yellow");
		addFabricRecipe(OedldoedlGear.MODID, "lime_fabric", new ItemStack(ModItems.LIME_FABRIC, 2, 0), "lime");
		addFabricRecipe(OedldoedlGear.MODID, "pink_fabric", new ItemStack(ModItems.PINK_FABRIC, 2, 0), "pink");
		addFabricRecipe(OedldoedlGear.MODID, "gray_fabric", new ItemStack(ModItems.GRAY_FABRIC, 2, 0), "gray");
		addFabricRecipe(OedldoedlGear.MODID, "light_gray_fabric", new ItemStack(ModItems.LIGHT_GRAY_FABRIC, 2, 0),
				"lightGray");
		addFabricRecipe(OedldoedlGear.MODID, "cyan_fabric", new ItemStack(ModItems.CYAN_FABRIC, 2, 0), "cyan");
		addFabricRecipe(OedldoedlGear.MODID, "purple_fabric", new ItemStack(ModItems.PURPLE_FABRIC, 2, 0), "purple");
		addFabricRecipe(OedldoedlGear.MODID, "blue_fabric", new ItemStack(ModItems.BLUE_FABRIC, 2, 0), "blue");
		addFabricRecipe(OedldoedlGear.MODID, "brown_fabric", new ItemStack(ModItems.BROWN_FABRIC, 2, 0), "brown");
		addFabricRecipe(OedldoedlGear.MODID, "green_fabric", new ItemStack(ModItems.GREEN_FABRIC, 2, 0), "green");
		addFabricRecipe(OedldoedlGear.MODID, "red_fabric", new ItemStack(ModItems.RED_FABRIC, 2, 0), "red");
		addFabricRecipe(OedldoedlGear.MODID, "black_fabric", new ItemStack(ModItems.BLACK_FABRIC, 2, 0), "black");

		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "travellers_leather",
				new ItemStack(ModItems.TRAVELLERS_LEATHER, 2, 0), "ABA", "BCB", "ABA", 'A', "gemFlint", 'B',
				"ingotGold", 'C', "leather");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "explosion_core",
				new ItemStack(ModItems.EXPLOSION_CORE, 1, 0), "AAA", "ABA", "AAA", 'A', "tnt", 'B', "blockOedldoedl");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "charged_essence",
				new ItemStack(ModItems.CHARGED_ESSENCE, 1, 0), "ABA", "BCB", "ABA", 'A', "dyeWhite", 'B',
				"dyeLightBlue", 'C', "blockOedldoedl");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "chainmail", new ItemStack(ModItems.CHAINMAIL, 4, 0),
				"AAA", "BCB", "ABA", 'A', "nuggetIron", 'B', "ingotIron", 'C', "paper");

		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "badrock", new ItemStack(ModBlocks.BADROCK, 1, 0), "ABA",
				"CDC", "ABA", 'A', "nuggetBedrockium", 'B', "dyeGray", 'C', "dyeLightGray", 'D', "stone");
		ModRecipeHelper.addShapedRecipe(OedldoedlGear.MODID, "magical_wood",
				new ItemStack(ModBlocks.MAGICAL_WOOD, 1, 0), "ABA", "BCB", "ABA", 'A', "nuggetGold", 'B', "ingotGold",
				'C', "bookshelf");
	}
}