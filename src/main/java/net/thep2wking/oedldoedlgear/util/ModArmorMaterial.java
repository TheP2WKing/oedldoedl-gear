package net.thep2wking.oedldoedlgear.util;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.thep2wking.oedldoedlcore.api.armor.ModArmorMaterialBase;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlresources.init.ModItems;

public class ModArmorMaterial {
	public static final ArmorMaterial WOOD = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID, "wood", 8,
			new int[] { 1, 3, 2, 1 }, 0f, 6, SoundEvents.BLOCK_WOOD_PLACE, Item.getItemFromBlock(Blocks.LOG), 0);
	public static final ArmorMaterial FLINT = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID, "flint", 10,
			new int[] { 2, 4, 3, 2 }, 0f, 6, SoundEvents.BLOCK_GRAVEL_STEP, Items.FLINT, 0);
	public static final ArmorMaterial EMERALD = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID, "emerald",
			35, new int[] { 4, 7, 9, 4 }, 2.0f, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, Items.EMERALD, 0);
	public static final ArmorMaterial BASE = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID, "base", 20,
			new int[] { 3, 6, 6, 3 }, 0.5f, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, ModItems.BASE_INGOT, 0);
	public static final ArmorMaterial OEDLDOEDL = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"oedldoedl", 140, new int[] { 6, 10, 12, 6 }, 6.0f, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			ModItems.OEDLDOEDL_INGOT, 0);

	public static final ArmorMaterial GREMORIUM = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"gremorium", 9958, new int[] { 10, 16, 20, 10 }, 8.0f, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			ModItems.GREMORIUM_INGOT, 0);
	public static final ArmorMaterial HIMEJIMARIUM = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"himejimarium", 10260, new int[] { 10, 16, 20, 10 }, 8.0f, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			ModItems.HIMEJIMARIUM_INGOT, 0);
	public static final ArmorMaterial TOUJOURIUM = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"toujourium", 6757, new int[] { 10, 16, 20, 10 }, 8.0f, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			ModItems.TOUJOURIUM_INGOT, 0);
	public static final ArmorMaterial ARGENTORIUM = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"argentorium", 8355, new int[] { 10, 16, 20, 10 }, 8.0f, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			ModItems.ARGENTORIUM_INGOT, 0);
	public static final ArmorMaterial QUARTARIUM = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"quartarium", 8758, new int[] { 10, 16, 20, 10 }, 8.0f, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			ModItems.QUARTARIUM_INGOT, 0);
	public static final ArmorMaterial NAGATORIUM = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"nagatorium", 7656, new int[] { 10, 16, 20, 10 }, 8.0f, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			ModItems.NAGATORIUM_INGOT, 0);
	public static final ArmorMaterial SAKURAJIMARIUM = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"sakurajimarium", 8054, new int[] { 10, 16, 20, 10 }, 8.0f, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			ModItems.SAKURAJIMARIUM_INGOT, 0);

	public static final ArmorMaterial WIZARED_HAT_BLACK = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"wizared_hat", 0, new int[] { 5, 0, 0, 0 }, 2.0f, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
			Item.getItemFromBlock(Blocks.WOOL), 15);
	public static final ArmorMaterial LONG_FALL_BOOTS = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"long_fall_boots", 0, new int[] { 4, 0, 0, 0 }, 2.0f, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
			Item.getItemFromBlock(Blocks.OBSIDIAN), 0);
	public static final ArmorMaterial GAMEMODE_CHESTPLATE = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"gamemode_chestplate", 0, new int[] { 0, 0, 20, 0 }, 20.0f, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
			Item.getItemFromBlock(Blocks.COMMAND_BLOCK), 0);

	public static final ArmorMaterial FLYING_SHOOTING_HOODIE_CLASSIC = ModArmorMaterialBase.addArmorMaterial(
			OedldoedlGear.MODID, "classic_flying_shooting_hoodie", 100, new int[] { 0, 0, 8, 0 }, 4.0f, 20,
			SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Items.AIR, 0);
	public static final ArmorMaterial FLYING_SHOOTING_HOODIE_BLACK = ModArmorMaterialBase.addArmorMaterial(
			OedldoedlGear.MODID, "black_flying_shooting_hoodie", 100, new int[] { 0, 0, 8, 0 }, 4.0f, 20,
			SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Items.AIR, 0);
	public static final ArmorMaterial FLYING_SHOOTING_HOODIE_WHITE = ModArmorMaterialBase.addArmorMaterial(
			OedldoedlGear.MODID, "white_flying_shooting_hoodie", 100, new int[] { 0, 0, 8, 0 }, 4.0f, 20,
			SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Items.AIR, 0);
	public static final ArmorMaterial FLYING_SHOOTING_HOODIE_COLLEGE_JACKET = ModArmorMaterialBase.addArmorMaterial(
			OedldoedlGear.MODID, "flying_shooting_college_jacket", 150, new int[] { 0, 0, 10, 0 }, 6.0f, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Items.AIR, 0);
	public static final ArmorMaterial GUEFFY_JACKET = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"gradient_gueffy_tag_quilted_jacket", 100, new int[] { 0, 0, 8, 0 }, 6.0f, 20,
			SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Items.AIR, 0);

	public static final ArmorMaterial TRAVELLERS_BOOTS = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"travellers_boots", 5, new int[] { 2, 0, 0, 0 }, 0f, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, Items.AIR, 0);
	public static final ArmorMaterial TRAVELLERS_IRON_BOOTS = ModArmorMaterialBase.addArmorMaterial(OedldoedlGear.MODID,
			"travellers_iron_boots", 15, new int[] { 3, 0, 0, 0 }, 1f, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
			Items.IRON_INGOT, 0);
	public static final ArmorMaterial TRAVELLERS_GOLDEN_BOOTS = ModArmorMaterialBase.addArmorMaterial(
			OedldoedlGear.MODID, "travellers_golden_boots", 7, new int[] { 3, 0, 0, 0 }, 0f, 25,
			SoundEvents.ITEM_ARMOR_EQUIP_GOLD, Items.GOLD_INGOT, 0);
	public static final ArmorMaterial TRAVELLERS_DIAMOND_BOOTS = ModArmorMaterialBase.addArmorMaterial(
			OedldoedlGear.MODID, "travellers_diamond_boots", 33, new int[] { 4, 0, 0, 0 }, 3f, 10,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, Items.DIAMOND, 0);
	public static final ArmorMaterial TRAVELLERS_EMERALD_BOOTS = ModArmorMaterialBase.addArmorMaterial(
			OedldoedlGear.MODID, "travellers_emerald_boots", 35, new int[] { 5, 0, 0, 0 }, 3f, 12,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, Items.EMERALD, 0);
}