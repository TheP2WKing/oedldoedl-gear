package net.thep2wking.oedldoedlgear.init;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.thep2wking.oedldoedlcore.api.armor.ModItemArmorBase;
import net.thep2wking.oedldoedlcore.api.armor.ModItemHorseArmorBase;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.api.item.ModItemBlockBase;
import net.thep2wking.oedldoedlcore.api.tool.ModItemAxeBase;
import net.thep2wking.oedldoedlcore.api.tool.ModItemHoeBase;
import net.thep2wking.oedldoedlcore.api.tool.ModItemPaxelBase;
import net.thep2wking.oedldoedlcore.api.tool.ModItemPickaxeBase;
import net.thep2wking.oedldoedlcore.api.tool.ModItemShearsBase;
import net.thep2wking.oedldoedlcore.api.tool.ModItemShieldBase;
import net.thep2wking.oedldoedlcore.api.tool.ModItemShovelBase;
import net.thep2wking.oedldoedlcore.api.tool.ModItemSmashbatBase;
import net.thep2wking.oedldoedlcore.api.tool.ModItemSwordBase;
import net.thep2wking.oedldoedlcore.util.ModHitSound;
import net.thep2wking.oedldoedlcore.util.ModRarities;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemArgentoriumArmor;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemDirtArmor;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemEmeraldArmor;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemGamemodeChestplate;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemGremoriumArmor;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemHimejimariumArmor;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemKitagawariumArmor;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemLongFallBoots;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemNagatoriumArmor;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemOedldoedlArmor;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemQuartariumArmor;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemSakurajimariumArmor;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemSlimeArmor;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemToujouriumArmor;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemTravellersBoots;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemWizardHat;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemWoodenArmor;
import net.thep2wking.oedldoedlgear.content.item.armor.ItemArgentoriumArmor.AttributeUUIDArg;
import net.thep2wking.oedldoedlgear.content.item.misc.ItemChainmail;
import net.thep2wking.oedldoedlgear.content.item.misc.ItemChargedEssence;
import net.thep2wking.oedldoedlgear.content.item.misc.ItemChargedSnowball;
import net.thep2wking.oedldoedlgear.content.item.misc.ItemExplosionCore;
import net.thep2wking.oedldoedlgear.content.item.misc.ItemExplosiveSnowball;
import net.thep2wking.oedldoedlgear.content.item.misc.ItemRockySnowball;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemAdminStaff;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemBanHammer;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemBedrockBreaker;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemBlastingSmashbat;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemBrefPower;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemExplosionStaff;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemFireWand;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemFlySwatter;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemKickStick;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemLaunchingSmashbat;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemLightningSmashbat;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemLightningStaff;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemNeedle;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemPorkHammer;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemRidingSmashbat;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemSkullWand;
import net.thep2wking.oedldoedlgear.util.ModArmorMaterial;
import net.thep2wking.oedldoedlgear.util.ModHorseArmorMaterial;
import net.thep2wking.oedldoedlgear.util.ModToolMaterial;

public class ModItems {
	// blocks
	public static final Item BADROCK = new ModItemBlockBase(ModBlocks.BADROCK, ModRarities.WHITE, false, 1, 0);
	public static final Item ENHANCED_DIRT = new ModItemBlockBase(ModBlocks.ENHANCED_DIRT, ModRarities.YELLOW, true, 2, 0);
	public static final Item MAGICAL_WOOD = new ModItemBlockBase(ModBlocks.MAGICAL_WOOD, ModRarities.YELLOW, false, 1, 0);
	public static final Item JUMP_PAD = new ModItemBlockBase(ModBlocks.JUMP_PAD, ModRarities.YELLOW, false, 1, 0);
	public static final Item JUMP_PAD_PLUS = new ModItemBlockBase(ModBlocks.JUMP_PAD_PLUS, ModRarities.YELLOW, false, 1, 0);
	public static final Item JUMP_PAD_PLUS_PLUS = new ModItemBlockBase(ModBlocks.JUMP_PAD_PLUS_PLUS, ModRarities.YELLOW, false, 1, 0);
	public static final Item JUMP_PAD_PLUS_PLUS_PLUS = new ModItemBlockBase(ModBlocks.JUMP_PAD_PLUS_PLUS_PLUS, ModRarities.YELLOW, false, 1, 0);
	public static final Item IMPACT_PAD = new ModItemBlockBase(ModBlocks.IMPACT_PAD, ModRarities.YELLOW, false, 1, 0);

	// base armor
	public static final Item BASE_HELMET = new ModItemArmorBase(OedldoedlGear.MODID, "base_helmet", OedldoedlGear.TAB, ModArmorMaterial.BASE, 0, EntityEquipmentSlot.HEAD, ModRarities.WHITE, false, 1, 0);
	public static final Item BASE_CHESTPLATE = new ModItemArmorBase(OedldoedlGear.MODID, "base_chestplate", OedldoedlGear.TAB, ModArmorMaterial.BASE, 0, EntityEquipmentSlot.CHEST, ModRarities.WHITE, false, 1, 0);
	public static final Item BASE_LEGGINGS = new ModItemArmorBase(OedldoedlGear.MODID, "base_leggings", OedldoedlGear.TAB, ModArmorMaterial.BASE, 1, EntityEquipmentSlot.LEGS, ModRarities.WHITE, false, 1, 0);
	public static final Item BASE_BOOTS = new ModItemArmorBase(OedldoedlGear.MODID, "base_boots", OedldoedlGear.TAB, ModArmorMaterial.BASE, 0, EntityEquipmentSlot.FEET, ModRarities.WHITE, false, 1, 0);

	// oedldoedl armor
	public static final Item OEDLDOEDL_HELMET = new ItemOedldoedlArmor(OedldoedlGear.MODID, "oedldoedl_helmet", OedldoedlGear.TAB, ModArmorMaterial.OEDLDOEDL, 0, EntityEquipmentSlot.HEAD, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0xbf40bf);
	public static final Item OEDLDOEDL_CHESTPLATE = new ItemOedldoedlArmor(OedldoedlGear.MODID, "oedldoedl_chestplate", OedldoedlGear.TAB, ModArmorMaterial.OEDLDOEDL, 0, EntityEquipmentSlot.CHEST, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0xbf40bf);
	public static final Item OEDLDOEDL_LEGGINGS = new ItemOedldoedlArmor(OedldoedlGear.MODID, "oedldoedl_leggings", OedldoedlGear.TAB, ModArmorMaterial.OEDLDOEDL, 1, EntityEquipmentSlot.LEGS, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0xbf40bf);
	public static final Item OEDLDOEDL_BOOTS = new ItemOedldoedlArmor(OedldoedlGear.MODID, "oedldoedl_boots", OedldoedlGear.TAB, ModArmorMaterial.OEDLDOEDL, 0, EntityEquipmentSlot.FEET, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0xbf40bf);

	// dirt armor
	public static final Item DIRT_HELMET = new ItemDirtArmor(OedldoedlGear.MODID, "dirt_helmet", OedldoedlGear.TAB, ModArmorMaterial.DIRT, 0, EntityEquipmentSlot.HEAD, ModRarities.YELLOW, true, 1, 0);
	public static final Item DIRT_CHESTPLATE = new ItemDirtArmor(OedldoedlGear.MODID, "dirt_chestplate", OedldoedlGear.TAB, ModArmorMaterial.DIRT, 0, EntityEquipmentSlot.CHEST, ModRarities.YELLOW, true, 1, 0);
	public static final Item DIRT_LEGGINGS = new ItemDirtArmor(OedldoedlGear.MODID, "dirt_leggings", OedldoedlGear.TAB, ModArmorMaterial.DIRT, 1, EntityEquipmentSlot.LEGS, ModRarities.YELLOW, true, 1, 0);
	public static final Item DIRT_BOOTS = new ItemDirtArmor(OedldoedlGear.MODID, "dirt_boots", OedldoedlGear.TAB, ModArmorMaterial.DIRT, 0, EntityEquipmentSlot.FEET, ModRarities.YELLOW, true, 1, 0);

	// wooden armor
	public static final Item WOODEN_HELMET = new ItemWoodenArmor(OedldoedlGear.MODID, "wooden_helmet", OedldoedlGear.TAB, ModArmorMaterial.WOOD, 0, EntityEquipmentSlot.HEAD, ModRarities.WHITE, false, 1, 0);
	public static final Item WOODEN_CHESTPLATE = new ItemWoodenArmor(OedldoedlGear.MODID, "wooden_chestplate", OedldoedlGear.TAB, ModArmorMaterial.WOOD, 0, EntityEquipmentSlot.CHEST, ModRarities.WHITE, false, 1, 0);
	public static final Item WOODEN_LEGGINGS = new ItemWoodenArmor(OedldoedlGear.MODID, "wooden_leggings", OedldoedlGear.TAB, ModArmorMaterial.WOOD, 1, EntityEquipmentSlot.LEGS, ModRarities.WHITE, false, 1, 0);
	public static final Item WOODEN_BOOTS = new ItemWoodenArmor(OedldoedlGear.MODID, "wooden_boots", OedldoedlGear.TAB, ModArmorMaterial.WOOD, 0, EntityEquipmentSlot.FEET, ModRarities.WHITE, false, 1, 0);

	// emerald armor
	public static final Item EMERALD_HELMET = new ItemEmeraldArmor(OedldoedlGear.MODID, "emerald_helmet", OedldoedlGear.TAB, ModArmorMaterial.EMERALD, 0, EntityEquipmentSlot.HEAD, ModRarities.WHITE, false, 1, 0);
	public static final Item EMERALD_CHESTPLATE = new ItemEmeraldArmor(OedldoedlGear.MODID, "emerald_chestplate", OedldoedlGear.TAB, ModArmorMaterial.EMERALD, 0, EntityEquipmentSlot.CHEST, ModRarities.WHITE, false, 1, 0);
	public static final Item EMERALD_LEGGINGS = new ItemEmeraldArmor(OedldoedlGear.MODID, "emerald_leggings", OedldoedlGear.TAB, ModArmorMaterial.EMERALD, 1, EntityEquipmentSlot.LEGS, ModRarities.WHITE, false, 1, 0);
	public static final Item EMERALD_BOOTS = new ItemEmeraldArmor(OedldoedlGear.MODID, "emerald_boots", OedldoedlGear.TAB, ModArmorMaterial.EMERALD, 0, EntityEquipmentSlot.FEET, ModRarities.WHITE, false, 1, 0);

	// slime armor
	public static final Item SLIME_HELMET = new ItemSlimeArmor(OedldoedlGear.MODID, "slime_helmet", OedldoedlGear.TAB, ModArmorMaterial.SLIME, 0, EntityEquipmentSlot.HEAD, ModRarities.GREEN, false, 1, 0);
	public static final Item SLIME_CHESTPLATE = new ItemSlimeArmor(OedldoedlGear.MODID, "slime_chestplate", OedldoedlGear.TAB, ModArmorMaterial.SLIME, 0, EntityEquipmentSlot.CHEST, ModRarities.GREEN, false, 1, 0);
	public static final Item SLIME_LEGGINGS = new ItemSlimeArmor(OedldoedlGear.MODID, "slime_leggings", OedldoedlGear.TAB, ModArmorMaterial.SLIME, 1, EntityEquipmentSlot.LEGS, ModRarities.GREEN, false, 1, 0);
	public static final Item SLIME_BOOTS = new ItemSlimeArmor(OedldoedlGear.MODID, "slime_boots", OedldoedlGear.TAB, ModArmorMaterial.SLIME, 0, EntityEquipmentSlot.FEET, ModRarities.GREEN, false, 1, 0);

	// gremorium armor
	public static final Item GREMORIUM_HELMET = new ItemGremoriumArmor(OedldoedlGear.MODID, "gremorium_helmet", OedldoedlGear.TAB, ModArmorMaterial.GREMORIUM, 0, EntityEquipmentSlot.HEAD, ModRarities.DARK_RED, true, 1, 0).setRGBBarColor(0x990000);
	public static final Item GREMORIUM_CHESTPLATE = new ItemGremoriumArmor(OedldoedlGear.MODID, "gremorium_chestplate", OedldoedlGear.TAB, ModArmorMaterial.GREMORIUM, 0, EntityEquipmentSlot.CHEST, ModRarities.DARK_RED, true, 1, 0).setRGBBarColor(0x990000);
	public static final Item GREMORIUM_LEGGINGS = new ItemGremoriumArmor(OedldoedlGear.MODID, "gremorium_leggings", OedldoedlGear.TAB, ModArmorMaterial.GREMORIUM, 1, EntityEquipmentSlot.LEGS, ModRarities.DARK_RED, true, 1, 0).setRGBBarColor(0x990000);
	public static final Item GREMORIUM_BOOTS = new ItemGremoriumArmor(OedldoedlGear.MODID, "gremorium_boots", OedldoedlGear.TAB, ModArmorMaterial.GREMORIUM, 0, EntityEquipmentSlot.FEET, ModRarities.DARK_RED, true, 1, 0).setRGBBarColor(0x990000);

	// himejimarium armor
	public static final Item HIMEJIMARIUM_HELMET = new ItemHimejimariumArmor(OedldoedlGear.MODID, "himejimarium_helmet", OedldoedlGear.TAB, ModArmorMaterial.HIMEJIMARIUM, 0, EntityEquipmentSlot.HEAD, ModRarities.DARK_BLUE, true, 1, 0).setRGBBarColor(0x232033);
	public static final Item HIMEJIMARIUM_CHESTPLATE = new ItemHimejimariumArmor(OedldoedlGear.MODID, "himejimarium_chestplate", OedldoedlGear.TAB, ModArmorMaterial.HIMEJIMARIUM, 0, EntityEquipmentSlot.CHEST, ModRarities.DARK_BLUE, true, 1, 0).setRGBBarColor(0x232033);
	public static final Item HIMEJIMARIUM_LEGGINGS = new ItemHimejimariumArmor(OedldoedlGear.MODID, "himejimarium_leggings", OedldoedlGear.TAB, ModArmorMaterial.HIMEJIMARIUM, 1, EntityEquipmentSlot.LEGS, ModRarities.DARK_BLUE, true, 1, 0).setRGBBarColor(0x232033);
	public static final Item HIMEJIMARIUM_BOOTS = new ItemHimejimariumArmor(OedldoedlGear.MODID, "himejimarium_boots", OedldoedlGear.TAB, ModArmorMaterial.HIMEJIMARIUM, 0, EntityEquipmentSlot.FEET, ModRarities.DARK_BLUE, true, 1, 0).setRGBBarColor(0x232033);

	// toujourium armor
	public static final Item TOUJOURIUM_HELMET = new ItemToujouriumArmor(OedldoedlGear.MODID, "toujourium_helmet", OedldoedlGear.TAB, ModArmorMaterial.TOUJOURIUM, 0, EntityEquipmentSlot.HEAD, net.thep2wking.oedldoedlgear.content.item.armor.ItemToujouriumArmor.AttributeUUIDArg.HELMET_UUID, ModRarities.GRAY, true, 1, 0).setRGBBarColor(0xc0c0c0);
	public static final Item TOUJOURIUM_CHESTPLATE = new ItemToujouriumArmor(OedldoedlGear.MODID, "toujourium_chestplate", OedldoedlGear.TAB, ModArmorMaterial.TOUJOURIUM, 0, EntityEquipmentSlot.CHEST, net.thep2wking.oedldoedlgear.content.item.armor.ItemToujouriumArmor.AttributeUUIDArg.HELMET_UUID,  ModRarities.GRAY, true, 1, 0).setRGBBarColor(0xc0c0c0);
	public static final Item TOUJOURIUM_LEGGINGS = new ItemToujouriumArmor(OedldoedlGear.MODID, "toujourium_leggings", OedldoedlGear.TAB, ModArmorMaterial.TOUJOURIUM, 1, EntityEquipmentSlot.LEGS, net.thep2wking.oedldoedlgear.content.item.armor.ItemToujouriumArmor.AttributeUUIDArg.HELMET_UUID, ModRarities.GRAY, true, 1, 0).setRGBBarColor(0xc0c0c0);
	public static final Item TOUJOURIUM_BOOTS = new ItemToujouriumArmor(OedldoedlGear.MODID, "toujourium_boots", OedldoedlGear.TAB, ModArmorMaterial.TOUJOURIUM, 0, EntityEquipmentSlot.FEET, net.thep2wking.oedldoedlgear.content.item.armor.ItemToujouriumArmor.AttributeUUIDArg.HELMET_UUID, ModRarities.GRAY, true, 1, 0).setRGBBarColor(0xc0c0c0);

	// argentorium armor
	public static final Item ARGENTORIUM_HELMET = new ItemArgentoriumArmor(OedldoedlGear.MODID, "argentorium_helmet", OedldoedlGear.TAB, ModArmorMaterial.ARGENTORIUM, 0, EntityEquipmentSlot.HEAD, AttributeUUIDArg.HELMET_UUID, ModRarities.YELLOW, true, 1, 0).setRGBBarColor(0xfbd985);
	public static final Item ARGENTORIUM_CHESTPLATE = new ItemArgentoriumArmor(OedldoedlGear.MODID, "argentorium_chestplate", OedldoedlGear.TAB, ModArmorMaterial.ARGENTORIUM, 0, EntityEquipmentSlot.CHEST, AttributeUUIDArg.CHESTPLATE_UUID, ModRarities.YELLOW, true, 1, 0).setRGBBarColor(0xfbd985);
	public static final Item ARGENTORIUM_LEGGINGS = new ItemArgentoriumArmor(OedldoedlGear.MODID, "argentorium_leggings", OedldoedlGear.TAB, ModArmorMaterial.ARGENTORIUM, 1, EntityEquipmentSlot.LEGS, AttributeUUIDArg.LEGGINGS_UUID, ModRarities.YELLOW, true, 1, 0).setRGBBarColor(0xfbd985);
	public static final Item ARGENTORIUM_BOOTS = new ItemArgentoriumArmor(OedldoedlGear.MODID, "argentorium_boots", OedldoedlGear.TAB, ModArmorMaterial.ARGENTORIUM, 0, EntityEquipmentSlot.FEET, AttributeUUIDArg.BOOTS_UUID, ModRarities.YELLOW, true, 1, 0).setRGBBarColor(0xfbd985);
	
	// quartarium armor
	public static final Item QUARTARIUM_HELMET = new ItemQuartariumArmor(OedldoedlGear.MODID, "quartarium_helmet", OedldoedlGear.TAB, ModArmorMaterial.QUARTARIUM, 0, EntityEquipmentSlot.HEAD, ModRarities.BLUE, true, 1, 0).setRGBBarColor(0x0e5191);
	public static final Item QUARTARIUM_CHESTPLATE = new ItemQuartariumArmor(OedldoedlGear.MODID, "quartarium_chestplate", OedldoedlGear.TAB, ModArmorMaterial.QUARTARIUM, 0, EntityEquipmentSlot.CHEST, ModRarities.BLUE, true, 1, 0).setRGBBarColor(0x0e5191);
	public static final Item QUARTARIUM_LEGGINGS = new ItemQuartariumArmor(OedldoedlGear.MODID, "quartarium_leggings", OedldoedlGear.TAB, ModArmorMaterial.QUARTARIUM, 1, EntityEquipmentSlot.LEGS, ModRarities.BLUE, true, 1, 0).setRGBBarColor(0x0e5191);
	public static final Item QUARTARIUM_BOOTS = new ItemQuartariumArmor(OedldoedlGear.MODID, "quartarium_boots", OedldoedlGear.TAB, ModArmorMaterial.QUARTARIUM, 0, EntityEquipmentSlot.FEET, ModRarities.BLUE, true, 1, 0).setRGBBarColor(0x0e5191);

	// nagatorium armor
	public static final Item NAGATORIUM_HELMET = new ItemNagatoriumArmor(OedldoedlGear.MODID, "nagatorium_helmet", OedldoedlGear.TAB, ModArmorMaterial.NAGATORIUM, 0, EntityEquipmentSlot.HEAD, ModRarities.DARK_PURPLE, true, 1, 0).setRGBBarColor(0x650fc1);
	public static final Item NAGATORIUM_CHESTPLATE = new ItemNagatoriumArmor(OedldoedlGear.MODID, "nagatorium_chestplate", OedldoedlGear.TAB, ModArmorMaterial.NAGATORIUM, 0, EntityEquipmentSlot.CHEST, ModRarities.DARK_PURPLE, true, 1, 0).setRGBBarColor(0x650fc1);
	public static final Item NAGATORIUM_LEGGINGS = new ItemNagatoriumArmor(OedldoedlGear.MODID, "nagatorium_leggings", OedldoedlGear.TAB, ModArmorMaterial.NAGATORIUM, 1, EntityEquipmentSlot.LEGS, ModRarities.DARK_PURPLE, true, 1, 0).setRGBBarColor(0x650fc1);
	public static final Item NAGATORIUM_BOOTS = new ItemNagatoriumArmor(OedldoedlGear.MODID, "nagatorium_boots", OedldoedlGear.TAB, ModArmorMaterial.NAGATORIUM, 0, EntityEquipmentSlot.FEET, ModRarities.DARK_PURPLE, true, 1, 0).setRGBBarColor(0x650fc1);

	// sakurajimarium armor
	public static final Item SAKURAJIMARIUM_HELMET = new ItemSakurajimariumArmor(OedldoedlGear.MODID, "sakurajimarium_helmet", OedldoedlGear.TAB, ModArmorMaterial.SAKURAJIMARIUM, 0, EntityEquipmentSlot.HEAD, ModRarities.DARK_GRAY, true, 1, 0).setRGBBarColor(0x2a2929);
	public static final Item SAKURAJIMARIUM_CHESTPLATE = new ItemSakurajimariumArmor(OedldoedlGear.MODID, "sakurajimarium_chestplate", OedldoedlGear.TAB, ModArmorMaterial.SAKURAJIMARIUM, 0, EntityEquipmentSlot.CHEST, ModRarities.DARK_GRAY, true, 1, 0).setRGBBarColor(0x2a2929);
	public static final Item SAKURAJIMARIUM_LEGGINGS = new ItemSakurajimariumArmor(OedldoedlGear.MODID, "sakurajimarium_leggings", OedldoedlGear.TAB, ModArmorMaterial.SAKURAJIMARIUM, 1, EntityEquipmentSlot.LEGS, ModRarities.DARK_GRAY, true, 1, 0).setRGBBarColor(0x2a2929);
	public static final Item SAKURAJIMARIUM_BOOTS = new ItemSakurajimariumArmor(OedldoedlGear.MODID, "sakurajimarium_boots", OedldoedlGear.TAB, ModArmorMaterial.SAKURAJIMARIUM, 0, EntityEquipmentSlot.FEET, ModRarities.DARK_GRAY, true, 1, 0).setRGBBarColor(0x2a2929);

	// kitagawarium armor
	public static final Item KITAGAWARIUM_HELMET = new ItemKitagawariumArmor(OedldoedlGear.MODID, "kitagawarium_helmet", OedldoedlGear.TAB, ModArmorMaterial.KITAGAWARIUM, 0, EntityEquipmentSlot.HEAD, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0x97173e);
	public static final Item KITAGAWARIUM_CHESTPLATE = new ItemKitagawariumArmor(OedldoedlGear.MODID, "kitagawarium_chestplate", OedldoedlGear.TAB, ModArmorMaterial.KITAGAWARIUM, 0, EntityEquipmentSlot.CHEST, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0x97173e);
	public static final Item KITAGAWARIUM_LEGGINGS = new ItemKitagawariumArmor(OedldoedlGear.MODID, "kitagawarium_leggings", OedldoedlGear.TAB, ModArmorMaterial.KITAGAWARIUM, 1, EntityEquipmentSlot.LEGS, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0x97173e);
	public static final Item KITAGAWARIUM_BOOTS = new ItemKitagawariumArmor(OedldoedlGear.MODID, "kitagawarium_boots", OedldoedlGear.TAB, ModArmorMaterial.KITAGAWARIUM, 0, EntityEquipmentSlot.FEET, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0x97173e);
		
	// wizard armor
	public static final Item BLACK_WIZARD_HAT = new ItemWizardHat(OedldoedlGear.MODID, "black_wizard_hat", OedldoedlGear.TAB, ModArmorMaterial.WIZARED_HAT_BLACK, 0, EntityEquipmentSlot.HEAD, ModRarities.AQUA, false, 1, 1);
	public static final Item BLUE_WIZARD_HAT = new ItemWizardHat(OedldoedlGear.MODID, "blue_wizard_hat", OedldoedlGear.TAB, ModArmorMaterial.WIZARED_HAT_BLUE, 0, EntityEquipmentSlot.HEAD, ModRarities.AQUA, false, 1, 1);

	// gamemode armor
	public static final Item GAMEMODE_CHESTPLATE = new ItemGamemodeChestplate(OedldoedlGear.MODID, "gamemode_chestplate", OedldoedlGear.TAB, ModArmorMaterial.GAMEMODE_CHESTPLATE, 0, EntityEquipmentSlot.CHEST, ModRarities.RED, true, 2, 1);

	// flying shooting armor
	public static final Item CLASSIC_FLYING_SHOOTING_HOODIE = new ModItemArmorBase(OedldoedlGear.MODID, "classic_flying_shooting_hoodie", OedldoedlGear.TAB, ModArmorMaterial.FLYING_SHOOTING_HOODIE_CLASSIC, 0, EntityEquipmentSlot.CHEST, ModRarities.AQUA, false, 2, 0);
	public static final Item BLACK_FLYING_SHOOTING_HOODIE = new ModItemArmorBase(OedldoedlGear.MODID, "black_flying_shooting_hoodie", OedldoedlGear.TAB, ModArmorMaterial.FLYING_SHOOTING_HOODIE_BLACK, 0, EntityEquipmentSlot.CHEST, ModRarities.AQUA, false, 2, 0);
	public static final Item WHITE_FLYING_SHOOTING_HOODIE = new ModItemArmorBase(OedldoedlGear.MODID, "white_flying_shooting_hoodie", OedldoedlGear.TAB, ModArmorMaterial.FLYING_SHOOTING_HOODIE_WHITE, 0, EntityEquipmentSlot.CHEST, ModRarities.AQUA, false, 2, 0);
	public static final Item FLYING_SHOOTING_COLLEGE_JACKET = new ModItemArmorBase(OedldoedlGear.MODID, "flying_shooting_college_jacket", OedldoedlGear.TAB, ModArmorMaterial.FLYING_SHOOTING_HOODIE_COLLEGE_JACKET, 0, EntityEquipmentSlot.CHEST, ModRarities.LIGHT_PURPLE, false, 2, 0);
	
	// gueffy armor
	public static final Item GRADIENT_GUEFFY_TAG_QUILTED_JACKET = new ModItemArmorBase(OedldoedlGear.MODID, "gradient_gueffy_tag_quilted_jacket", OedldoedlGear.TAB, ModArmorMaterial.GUEFFY_JACKET, 0, EntityEquipmentSlot.CHEST, ModRarities.LIGHT_PURPLE, false, 1, 0);

	// travel armor
	public static final Item TRAVELLERS_BOOTS = new ItemTravellersBoots(OedldoedlGear.MODID, "travellers_boots", OedldoedlGear.TAB, ModArmorMaterial.TRAVELLERS_BOOTS, 0, EntityEquipmentSlot.FEET, 1, 0, ModRarities.YELLOW, false, 1, 0);
	public static final Item TRAVELLERS_GOLDEN_BOOTS = new ItemTravellersBoots(OedldoedlGear.MODID, "travellers_golden_boots", OedldoedlGear.TAB, ModArmorMaterial.TRAVELLERS_GOLDEN_BOOTS, 0, EntityEquipmentSlot.FEET, 2, 0, ModRarities.YELLOW, false, 1, 0);
	public static final Item TRAVELLERS_IRON_BOOTS = new ItemTravellersBoots(OedldoedlGear.MODID, "travellers_iron_boots", OedldoedlGear.TAB, ModArmorMaterial.TRAVELLERS_IRON_BOOTS, 0, EntityEquipmentSlot.FEET, 3, 0, ModRarities.YELLOW, false, 1, 0);
	public static final Item TRAVELLERS_DIAMOND_BOOTS = new ItemTravellersBoots(OedldoedlGear.MODID, "travellers_diamond_boots", OedldoedlGear.TAB, ModArmorMaterial.TRAVELLERS_DIAMOND_BOOTS, 0, EntityEquipmentSlot.FEET, 3, 1, ModRarities.YELLOW, false, 1, 0);
	public static final Item TRAVELLERS_EMERALD_BOOTS = new ItemTravellersBoots(OedldoedlGear.MODID, "travellers_emerald_boots", OedldoedlGear.TAB, ModArmorMaterial.TRAVELLERS_EMERALD_BOOTS, 0, EntityEquipmentSlot.FEET, 4, 2, ModRarities.YELLOW, false, 1, 0);

	// long fall armor
	public static final Item LONG_FALL_BOOTS = new ItemLongFallBoots(OedldoedlGear.MODID, "long_fall_boots", OedldoedlGear.TAB, ModArmorMaterial.LONG_FALL_BOOTS, 0, EntityEquipmentSlot.FEET, ModRarities.AQUA, false, 1, 0);

	// horsearmor
	public static final Item BASE_HORSE_ARMOR = new ModItemHorseArmorBase(OedldoedlGear.MODID, "base_horse_armor",  OedldoedlGear.TAB, ModHorseArmorMaterial.BASE, ModRarities.WHITE, false, 1, 0);
	public static final Item CHAINMAIL_HORSE_ARMOR = new ModItemHorseArmorBase(OedldoedlGear.MODID, "chainmail_horse_armor",  OedldoedlGear.TAB, ModHorseArmorMaterial.CHAIN, ModRarities.WHITE, false, 1, 0);
	public static final Item EMERALD_HORSE_ARMOR = new ModItemHorseArmorBase(OedldoedlGear.MODID, "emerald_horse_armor",  OedldoedlGear.TAB, ModHorseArmorMaterial.EMERALD, ModRarities.WHITE, false, 1, 0);
	
	// base tools 
	public static final Item BASE_SWORD = new ModItemSwordBase(OedldoedlGear.MODID, "base_sword", OedldoedlGear.TAB, ModToolMaterial.BASE, 3f, -2.4f, ModRarities.WHITE, false, 1, 0);
	public static final Item BASE_SHOVEL = new ModItemShovelBase(OedldoedlGear.MODID, "base_shovel", OedldoedlGear.TAB, ModToolMaterial.BASE, 1.5f, -3f, ModRarities.WHITE, false, 1, 0);
	public static final Item BASE_PICKAXE = new ModItemPickaxeBase(OedldoedlGear.MODID, "base_pickaxe", OedldoedlGear.TAB, ModToolMaterial.BASE, 1f, -2.8f, ModRarities.WHITE, false, 1, 0);
	public static final Item BASE_AXE = new ModItemAxeBase(OedldoedlGear.MODID, "base_axe", OedldoedlGear.TAB, ModToolMaterial.BASE, 8f, -3.1f, ModRarities.WHITE, false, 1, 0);
	public static final Item BASE_HOE = new ModItemHoeBase(OedldoedlGear.MODID, "base_hoe", OedldoedlGear.TAB, ModToolMaterial.BASE, -2f, -1f, ModRarities.WHITE, false, 1, 0);
	public static final Item BASE_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "base_paxel", OedldoedlGear.TAB, ModToolMaterial.BASE, 4f, -3f, ModRarities.WHITE, false, 1, 0);
	public static final Item BASE_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "base_smashbat", OedldoedlGear.TAB, ModToolMaterial.BASE, 0f, -2f, 9f, 4.5f, ModHitSound.METAL, ModRarities.WHITE, false, 1, 0);
	public static final Item BASE_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "base_shears", OedldoedlGear.TAB, ModToolMaterial.BASE, ModRarities.WHITE, false, 1, 0);
	public static final Item BASE_SHIELD = new ModItemShieldBase(OedldoedlGear.MODID, "base_shield", OedldoedlGear.TAB, ModToolMaterial.BASE, ModRarities.WHITE, false, 1, 0);

	// oedldoedl tools 
	public static final Item OEDLDOEDL_SWORD = new ModItemSwordBase(OedldoedlGear.MODID, "oedldoedl_sword", OedldoedlGear.TAB, ModToolMaterial.OEDLDOEDL, 3f, -2.4f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0xbf40bf);
	public static final Item OEDLDOEDL_SHOVEL = new ModItemShovelBase(OedldoedlGear.MODID, "oedldoedl_shovel", OedldoedlGear.TAB, ModToolMaterial.OEDLDOEDL, 1.5f, -3f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0xbf40bf);
	public static final Item OEDLDOEDL_PICKAXE = new ModItemPickaxeBase(OedldoedlGear.MODID, "oedldoedl_pickaxe", OedldoedlGear.TAB, ModToolMaterial.OEDLDOEDL, 1f, -2.8f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0xbf40bf);
	public static final Item OEDLDOEDL_AXE = new ModItemAxeBase(OedldoedlGear.MODID, "oedldoedl_axe", OedldoedlGear.TAB, ModToolMaterial.OEDLDOEDL, 13f, -3f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0xbf40bf);
	public static final Item OEDLDOEDL_HOE = new ModItemHoeBase(OedldoedlGear.MODID, "oedldoedl_hoe", OedldoedlGear.TAB, ModToolMaterial.OEDLDOEDL, -5f, 0f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0xbf40bf);
	public static final Item OEDLDOEDL_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "oedldoedl_paxel", OedldoedlGear.TAB, ModToolMaterial.OEDLDOEDL, 4f, -3f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0xbf40bf);
	public static final Item OEDLDOEDL_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "oedldoedl_smashbat", OedldoedlGear.TAB, ModToolMaterial.OEDLDOEDL, 0f, -2f, 16f, 8f, ModHitSound.GEM, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0xbf40bf);
	public static final Item OEDLDOEDL_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "oedldoedl_shears", OedldoedlGear.TAB, ModToolMaterial.OEDLDOEDL, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0xbf40bf);
	public static final Item OEDLDOEDL_SHIELD = new ModItemShieldBase(OedldoedlGear.MODID, "oedldoedl_shield", OedldoedlGear.TAB, ModToolMaterial.OEDLDOEDL, 2.0f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0xbf40bf);

	// dirt tools 
	public static final Item DIRT_SWORD = new ModItemSwordBase(OedldoedlGear.MODID, "dirt_sword", OedldoedlGear.TAB, ModToolMaterial.DIRT, 3f, -2.4f, ModRarities.YELLOW, true, 1, 0);
	public static final Item DIRT_SHOVEL = new ModItemShovelBase(OedldoedlGear.MODID, "dirt_shovel", OedldoedlGear.TAB, ModToolMaterial.DIRT, 1.5f, -3f, ModRarities.YELLOW, true, 1, 0);
	public static final Item DIRT_PICKAXE = new ModItemPickaxeBase(OedldoedlGear.MODID, "dirt_pickaxe", OedldoedlGear.TAB, ModToolMaterial.DIRT, 1f, -2.8f, ModRarities.YELLOW, true, 1, 0);
	public static final Item DIRT_AXE = new ModItemAxeBase(OedldoedlGear.MODID, "dirt_axe", OedldoedlGear.TAB, ModToolMaterial.DIRT, 5.5f, -3.2f, ModRarities.YELLOW, true, 1, 0);
	public static final Item DIRT_HOE = new ModItemHoeBase(OedldoedlGear.MODID, "dirt_hoe", OedldoedlGear.TAB, ModToolMaterial.DIRT, -2f, -1f, ModRarities.YELLOW, true, 1, 0);
	public static final Item DIRT_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "dirt_paxel", OedldoedlGear.TAB, ModToolMaterial.DIRT, 4f, -3f, ModRarities.YELLOW, true, 1, 0);
	public static final Item DIRT_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "dirt_smashbat", OedldoedlGear.TAB, ModToolMaterial.DIRT, 0f, -2f, 3f, 1.5f, ModHitSound.WOOD, ModRarities.YELLOW, true, 1, 0);
	public static final Item DIRT_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "dirt_shears", OedldoedlGear.TAB, ModToolMaterial.DIRT, ModRarities.YELLOW, true, 1, 0);
	public static final Item DIRT_SHIELD = new ModItemShieldBase(OedldoedlGear.MODID, "dirt_shield", OedldoedlGear.TAB, ModToolMaterial.DIRT, ModRarities.YELLOW, true, 1, 0);
		
	// emerald tools 
	public static final Item EMERALD_SWORD = new ModItemSwordBase(OedldoedlGear.MODID, "emerald_sword", OedldoedlGear.TAB, ModToolMaterial.EMERALD, 3f, -2.4f, ModRarities.WHITE, false, 1, 0);
	public static final Item EMERALD_SHOVEL = new ModItemShovelBase(OedldoedlGear.MODID, "emerald_shovel", OedldoedlGear.TAB, ModToolMaterial.EMERALD, 1.5f, -3f, ModRarities.WHITE, false, 1, 0);
	public static final Item EMERALD_PICKAXE = new ModItemPickaxeBase(OedldoedlGear.MODID, "emerald_pickaxe", OedldoedlGear.TAB, ModToolMaterial.EMERALD, 1f, -2.8f, ModRarities.WHITE, false, 1, 0);
	public static final Item EMERALD_AXE = new ModItemAxeBase(OedldoedlGear.MODID, "emerald_axe", OedldoedlGear.TAB, ModToolMaterial.EMERALD, 8.5f, -3f, ModRarities.WHITE, false, 1, 0);
	public static final Item EMERALD_HOE = new ModItemHoeBase(OedldoedlGear.MODID, "emerald_hoe", OedldoedlGear.TAB, ModToolMaterial.EMERALD, -3f, 0f, ModRarities.WHITE, false, 1, 0);
	public static final Item EMERALD_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "emerald_paxel", OedldoedlGear.TAB, ModToolMaterial.EMERALD, 4f, -3f, ModRarities.WHITE, false, 1, 0);
	public static final Item EMERALD_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "emerald_smashbat", OedldoedlGear.TAB, ModToolMaterial.EMERALD, 0f, -2f, 11f, 5.5f, ModHitSound.GEM, ModRarities.WHITE, false, 1, 0);
	public static final Item EMERALD_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "emerald_shears", OedldoedlGear.TAB, ModToolMaterial.EMERALD, ModRarities.WHITE, false, 1, 0);

	// slime tools 
	public static final Item SLIME_SWORD = new ModItemSwordBase(OedldoedlGear.MODID, "slime_sword", OedldoedlGear.TAB, ModToolMaterial.SLIME, 3f, -2.4f, ModRarities.GREEN, false, 1, 0);
	public static final Item SLIME_SHOVEL = new ModItemShovelBase(OedldoedlGear.MODID, "slime_shovel", OedldoedlGear.TAB, ModToolMaterial.SLIME, 1.5f, -3f, ModRarities.GREEN, false, 1, 0);
	public static final Item SLIME_PICKAXE = new ModItemPickaxeBase(OedldoedlGear.MODID, "slime_pickaxe", OedldoedlGear.TAB, ModToolMaterial.SLIME, 1f, -2.8f, ModRarities.GREEN, false, 1, 0);
	public static final Item SLIME_AXE = new ModItemAxeBase(OedldoedlGear.MODID, "slime_axe", OedldoedlGear.TAB, ModToolMaterial.SLIME, 11f, -3f, ModRarities.GREEN, false, 1, 0);
	public static final Item SLIME_HOE = new ModItemHoeBase(OedldoedlGear.MODID, "slime_hoe", OedldoedlGear.TAB, ModToolMaterial.SLIME, -3f, 0f, ModRarities.GREEN, false, 1, 0);
	public static final Item SLIME_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "slime_paxel", OedldoedlGear.TAB, ModToolMaterial.SLIME, 4f, -3f, ModRarities.GREEN, false, 1, 0);
	public static final Item SLIME_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "slime_smashbat", OedldoedlGear.TAB, ModToolMaterial.SLIME, 0f, -2f, 12f, 6f, ModHitSound.GEM, ModRarities.GREEN, false, 1, 0);
	public static final Item SLIME_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "slime_shears", OedldoedlGear.TAB, ModToolMaterial.SLIME, ModRarities.GREEN, false, 1, 0);
	
	// gremorium tools 
	public static final Item GREMORIUM_SWORD = new ModItemSwordBase(OedldoedlGear.MODID, "gremorium_sword", OedldoedlGear.TAB, ModToolMaterial.GREMORIUM, 3f, -2.4f, ModRarities.DARK_RED, true, 1, 0).setRGBBarColor(0x990000);
	public static final Item GREMORIUM_SHOVEL = new ModItemShovelBase(OedldoedlGear.MODID, "gremorium_shovel", OedldoedlGear.TAB, ModToolMaterial.GREMORIUM, 1.5f, -3f, ModRarities.DARK_RED, true, 1, 0).setRGBBarColor(0x990000);
	public static final Item GREMORIUM_PICKAXE = new ModItemPickaxeBase(OedldoedlGear.MODID, "gremorium_pickaxe", OedldoedlGear.TAB, ModToolMaterial.GREMORIUM, 1f, -2.8f, ModRarities.DARK_RED, true, 1, 0).setRGBBarColor(0x990000);
	public static final Item GREMORIUM_AXE = new ModItemAxeBase(OedldoedlGear.MODID, "gremorium_axe", OedldoedlGear.TAB, ModToolMaterial.GREMORIUM, 18f, -3f, ModRarities.DARK_RED, true, 1, 0).setRGBBarColor(0x990000);
	public static final Item GREMORIUM_HOE = new ModItemHoeBase(OedldoedlGear.MODID, "gremorium_hoe", OedldoedlGear.TAB, ModToolMaterial.GREMORIUM, -6f, -0f, ModRarities.DARK_RED, true, 1, 0).setRGBBarColor(0x990000);
	public static final Item GREMORIUM_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "gremorium_paxel", OedldoedlGear.TAB, ModToolMaterial.GREMORIUM, 4f, -3f, ModRarities.DARK_RED, true, 1, 0).setRGBBarColor(0x990000);
	public static final Item GREMORIUM_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "gremorium_smashbat", OedldoedlGear.TAB, ModToolMaterial.GREMORIUM, 0f, -2f, 20f, 10f, ModHitSound.GEM, ModRarities.DARK_RED, true, 1, 0).setRGBBarColor(0x990000);
	public static final Item GREMORIUM_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "gremorium_shears", OedldoedlGear.TAB, ModToolMaterial.GREMORIUM, ModRarities.DARK_RED, true, 1, 0).setRGBBarColor(0x990000);
	public static final Item GREMORIUM_SHIELD = new ModItemShieldBase(OedldoedlGear.MODID, "gremorium_shield", OedldoedlGear.TAB, ModToolMaterial.GREMORIUM, 4.0f, ModRarities.DARK_RED, true, 1, 0).setRGBBarColor(0x990000);

	// himejimarium tools 
	public static final Item HIMEJIMARIUM_SWORD = new ModItemSwordBase(OedldoedlGear.MODID, "himejimarium_sword", OedldoedlGear.TAB, ModToolMaterial.HIMEJIMARIUM, 3f, -2.4f, ModRarities.DARK_BLUE, true, 1, 0).setRGBBarColor(0x232033);
	public static final Item HIMEJIMARIUM_SHOVEL = new ModItemShovelBase(OedldoedlGear.MODID, "himejimarium_shovel", OedldoedlGear.TAB, ModToolMaterial.HIMEJIMARIUM, 1.5f, -3f, ModRarities.DARK_BLUE, true, 1, 0).setRGBBarColor(0x232033);
	public static final Item HIMEJIMARIUM_PICKAXE = new ModItemPickaxeBase(OedldoedlGear.MODID, "himejimarium_pickaxe", OedldoedlGear.TAB, ModToolMaterial.HIMEJIMARIUM, 1f, -2.8f, ModRarities.DARK_BLUE, true, 1, 0).setRGBBarColor(0x232033);
	public static final Item HIMEJIMARIUM_AXE = new ModItemAxeBase(OedldoedlGear.MODID, "himejimarium_axe", OedldoedlGear.TAB, ModToolMaterial.HIMEJIMARIUM, 18f, -3f, ModRarities.DARK_BLUE, true, 1, 0).setRGBBarColor(0x232033);
	public static final Item HIMEJIMARIUM_HOE = new ModItemHoeBase(OedldoedlGear.MODID, "himejimarium_hoe", OedldoedlGear.TAB, ModToolMaterial.HIMEJIMARIUM, -6f, -0f, ModRarities.DARK_BLUE, true, 1, 0).setRGBBarColor(0x232033);
	public static final Item HIMEJIMARIUM_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "himejimarium_paxel", OedldoedlGear.TAB, ModToolMaterial.HIMEJIMARIUM, 4f, -3f, ModRarities.DARK_BLUE, true, 1, 0).setRGBBarColor(0x232033);
	public static final Item HIMEJIMARIUM_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "himejimarium_smashbat", OedldoedlGear.TAB, ModToolMaterial.HIMEJIMARIUM, 0f, -2f, 20f, 10f, ModHitSound.GEM, ModRarities.DARK_BLUE, true, 1, 0).setRGBBarColor(0x232033);
	public static final Item HIMEJIMARIUM_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "himejimarium_shears", OedldoedlGear.TAB, ModToolMaterial.HIMEJIMARIUM, ModRarities.DARK_BLUE, true, 1, 0).setRGBBarColor(0x232033);
	public static final Item HIMEJIMARIUM_SHIELD = new ModItemShieldBase(OedldoedlGear.MODID, "himejimarium_shield", OedldoedlGear.TAB, ModToolMaterial.HIMEJIMARIUM, 4.0f, ModRarities.DARK_BLUE, true, 1, 0).setRGBBarColor(0x232033);

	// toujourium tools 
	public static final Item TOUJOURIUM_SWORD = new ModItemSwordBase(OedldoedlGear.MODID, "toujourium_sword", OedldoedlGear.TAB, ModToolMaterial.TOUJOURIUM, 3f, -2.4f, ModRarities.GRAY, true, 1, 0).setRGBBarColor(0xc0c0c0);
	public static final Item TOUJOURIUM_SHOVEL = new ModItemShovelBase(OedldoedlGear.MODID, "toujourium_shovel", OedldoedlGear.TAB, ModToolMaterial.TOUJOURIUM, 1.5f, -3f, ModRarities.GRAY, true, 1, 0).setRGBBarColor(0xc0c0c0);
	public static final Item TOUJOURIUM_PICKAXE = new ModItemPickaxeBase(OedldoedlGear.MODID, "toujourium_pickaxe", OedldoedlGear.TAB, ModToolMaterial.TOUJOURIUM, 1f, -2.8f, ModRarities.GRAY, true, 1, 0).setRGBBarColor(0xc0c0c0);
	public static final Item TOUJOURIUM_AXE = new ModItemAxeBase(OedldoedlGear.MODID, "toujourium_axe", OedldoedlGear.TAB, ModToolMaterial.TOUJOURIUM, 18f, -3f, ModRarities.GRAY, true, 1, 0).setRGBBarColor(0xc0c0c0);
	public static final Item TOUJOURIUM_HOE = new ModItemHoeBase(OedldoedlGear.MODID, "toujourium_hoe", OedldoedlGear.TAB, ModToolMaterial.TOUJOURIUM, -6f, -0f, ModRarities.GRAY, true, 1, 0).setRGBBarColor(0xc0c0c0);
	public static final Item TOUJOURIUM_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "toujourium_paxel", OedldoedlGear.TAB, ModToolMaterial.TOUJOURIUM, 4f, -3f, ModRarities.GRAY, true, 1, 0).setRGBBarColor(0xc0c0c0);
	public static final Item TOUJOURIUM_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "toujourium_smashbat", OedldoedlGear.TAB, ModToolMaterial.TOUJOURIUM, 0f, -2f, 20f, 10f, ModHitSound.GEM, ModRarities.GRAY, true, 1, 0).setRGBBarColor(0xc0c0c0);
	public static final Item TOUJOURIUM_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "toujourium_shears", OedldoedlGear.TAB, ModToolMaterial.TOUJOURIUM, ModRarities.GRAY, true, 1, 0).setRGBBarColor(0xc0c0c0);
	public static final Item TOUJOURIUM_SHIELD = new ModItemShieldBase(OedldoedlGear.MODID, "toujourium_shield", OedldoedlGear.TAB, ModToolMaterial.TOUJOURIUM, 4.0f, ModRarities.GRAY, true, 1, 0).setRGBBarColor(0xc0c0c0);

	// argentorium tools 
	public static final Item ARGENTORIUM_SWORD = new ModItemSwordBase(OedldoedlGear.MODID, "argentorium_sword", OedldoedlGear.TAB, ModToolMaterial.ARGENTORIUM, 3f, -2.4f, ModRarities.YELLOW, true, 1, 0).setRGBBarColor(0xfbd985);
	public static final Item ARGENTORIUM_SHOVEL = new ModItemShovelBase(OedldoedlGear.MODID, "argentorium_shovel", OedldoedlGear.TAB, ModToolMaterial.ARGENTORIUM, 1.5f, -3f, ModRarities.YELLOW, true, 1, 0).setRGBBarColor(0xfbd985);
	public static final Item ARGENTORIUM_PICKAXE = new ModItemPickaxeBase(OedldoedlGear.MODID, "argentorium_pickaxe", OedldoedlGear.TAB, ModToolMaterial.ARGENTORIUM, 1f, -2.8f, ModRarities.YELLOW, true, 1, 0).setRGBBarColor(0xfbd985);
	public static final Item ARGENTORIUM_AXE = new ModItemAxeBase(OedldoedlGear.MODID, "argentorium_axe", OedldoedlGear.TAB, ModToolMaterial.ARGENTORIUM, 18f, -3f, ModRarities.YELLOW, true, 1, 0).setRGBBarColor(0xfbd985);
	public static final Item ARGENTORIUM_HOE = new ModItemHoeBase(OedldoedlGear.MODID, "argentorium_hoe", OedldoedlGear.TAB, ModToolMaterial.ARGENTORIUM, -6f, -0f, ModRarities.YELLOW, true, 1, 0).setRGBBarColor(0xfbd985);
	public static final Item ARGENTORIUM_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "argentorium_paxel", OedldoedlGear.TAB, ModToolMaterial.ARGENTORIUM, 4f, -3f, ModRarities.YELLOW, true, 1, 0).setRGBBarColor(0xfbd985);
	public static final Item ARGENTORIUM_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "argentorium_smashbat", OedldoedlGear.TAB, ModToolMaterial.ARGENTORIUM, 0f, -2f, 20f, 10f, ModHitSound.GEM, ModRarities.YELLOW, true, 1, 0).setRGBBarColor(0xfbd985);
	public static final Item ARGENTORIUM_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "argentorium_shears", OedldoedlGear.TAB, ModToolMaterial.ARGENTORIUM, ModRarities.YELLOW, true, 1, 0).setRGBBarColor(0xfbd985);
	public static final Item ARGENTORIUM_SHIELD = new ModItemShieldBase(OedldoedlGear.MODID, "argentorium_shield", OedldoedlGear.TAB, ModToolMaterial.ARGENTORIUM, 4.0f, ModRarities.YELLOW, true, 1, 0).setRGBBarColor(0xfbd985);

	// quartarium tools 
	public static final Item QUARTARIUM_SWORD = new ModItemSwordBase(OedldoedlGear.MODID, "quartarium_sword", OedldoedlGear.TAB, ModToolMaterial.QUARTARIUM, 3f, -2.4f, ModRarities.BLUE, true, 1, 0).setRGBBarColor(0x0e5191);
	public static final Item QUARTARIUM_SHOVEL = new ModItemShovelBase(OedldoedlGear.MODID, "quartarium_shovel", OedldoedlGear.TAB, ModToolMaterial.QUARTARIUM, 1.5f, -3f, ModRarities.BLUE, true, 1, 0).setRGBBarColor(0x0e5191);
	public static final Item QUARTARIUM_PICKAXE = new ModItemPickaxeBase(OedldoedlGear.MODID, "quartarium_pickaxe", OedldoedlGear.TAB, ModToolMaterial.QUARTARIUM, 1f, -2.8f, ModRarities.BLUE, true, 1, 0).setRGBBarColor(0x0e5191);
	public static final Item QUARTARIUM_AXE = new ModItemAxeBase(OedldoedlGear.MODID, "quartarium_axe", OedldoedlGear.TAB, ModToolMaterial.QUARTARIUM, 18f, -3f, ModRarities.BLUE, true, 1, 0).setRGBBarColor(0x0e5191);
	public static final Item QUARTARIUM_HOE = new ModItemHoeBase(OedldoedlGear.MODID, "quartarium_hoe", OedldoedlGear.TAB, ModToolMaterial.QUARTARIUM, -6f, -0f, ModRarities.BLUE, true, 1, 0).setRGBBarColor(0x0e5191);
	public static final Item QUARTARIUM_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "quartarium_paxel", OedldoedlGear.TAB, ModToolMaterial.QUARTARIUM, 4f, -3f, ModRarities.BLUE, true, 1, 0).setRGBBarColor(0x0e5191);
	public static final Item QUARTARIUM_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "quartarium_smashbat", OedldoedlGear.TAB, ModToolMaterial.QUARTARIUM, 0f, -2f, 20f, 10f, ModHitSound.GEM, ModRarities.BLUE, true, 1, 0).setRGBBarColor(0x0e5191);
	public static final Item QUARTARIUM_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "quartarium_shears", OedldoedlGear.TAB, ModToolMaterial.QUARTARIUM, ModRarities.BLUE, true, 1, 0).setRGBBarColor(0x0e5191);
	public static final Item QUARTARIUM_SHIELD = new ModItemShieldBase(OedldoedlGear.MODID, "quartarium_shield", OedldoedlGear.TAB, ModToolMaterial.QUARTARIUM, 4.0f, ModRarities.BLUE, true, 1, 0).setRGBBarColor(0x0e5191);

	// nagatorium tools 
	public static final Item NAGATORIUM_SWORD = new ModItemSwordBase(OedldoedlGear.MODID, "nagatorium_sword", OedldoedlGear.TAB, ModToolMaterial.NAGATORIUM, 3f, -2.4f, ModRarities.DARK_PURPLE, true, 1, 0).setRGBBarColor(0x650fc1);
	public static final Item NAGATORIUM_SHOVEL = new ModItemShovelBase(OedldoedlGear.MODID, "nagatorium_shovel", OedldoedlGear.TAB, ModToolMaterial.NAGATORIUM, 1.5f, -3f, ModRarities.DARK_PURPLE, true, 1, 0).setRGBBarColor(0x650fc1);
	public static final Item NAGATORIUM_PICKAXE = new ModItemPickaxeBase(OedldoedlGear.MODID, "nagatorium_pickaxe", OedldoedlGear.TAB, ModToolMaterial.NAGATORIUM, 1f, -2.8f, ModRarities.DARK_PURPLE, true, 1, 0).setRGBBarColor(0x650fc1);
	public static final Item NAGATORIUM_AXE = new ModItemAxeBase(OedldoedlGear.MODID, "nagatorium_axe", OedldoedlGear.TAB, ModToolMaterial.NAGATORIUM, 18f, -3f, ModRarities.DARK_PURPLE, true, 1, 0).setRGBBarColor(0x650fc1);
	public static final Item NAGATORIUM_HOE = new ModItemHoeBase(OedldoedlGear.MODID, "nagatorium_hoe", OedldoedlGear.TAB, ModToolMaterial.NAGATORIUM, -6f, -0f, ModRarities.DARK_PURPLE, true, 1, 0).setRGBBarColor(0x650fc1);
	public static final Item NAGATORIUM_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "nagatorium_paxel", OedldoedlGear.TAB, ModToolMaterial.NAGATORIUM, 4f, -3f, ModRarities.DARK_PURPLE, true, 1, 0).setRGBBarColor(0x650fc1);
	public static final Item NAGATORIUM_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "nagatorium_smashbat", OedldoedlGear.TAB, ModToolMaterial.NAGATORIUM, 0f, -2f, 20f, 10f, ModHitSound.GEM, ModRarities.DARK_PURPLE, true, 1, 0).setRGBBarColor(0x650fc1);
	public static final Item NAGATORIUM_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "nagatorium_shears", OedldoedlGear.TAB, ModToolMaterial.NAGATORIUM, ModRarities.DARK_PURPLE, true, 1, 0).setRGBBarColor(0x650fc1);
	public static final Item NAGATORIUM_SHIELD = new ModItemShieldBase(OedldoedlGear.MODID, "nagatorium_shield", OedldoedlGear.TAB, ModToolMaterial.NAGATORIUM, 4.0f, ModRarities.DARK_PURPLE, true, 1, 0).setRGBBarColor(0x650fc1);

	// sakurajimarium tools 
	public static final Item SAKURAJIMARIUM_SWORD = new ModItemSwordBase(OedldoedlGear.MODID, "sakurajimarium_sword", OedldoedlGear.TAB, ModToolMaterial.SAKURAJIMARIUM, 3f, -2.4f, ModRarities.DARK_GRAY, true, 1, 0).setRGBBarColor(0x2a2929);
	public static final Item SAKURAJIMARIUM_SHOVEL = new ModItemShovelBase(OedldoedlGear.MODID, "sakurajimarium_shovel", OedldoedlGear.TAB, ModToolMaterial.SAKURAJIMARIUM, 1.5f, -3f, ModRarities.DARK_GRAY, true, 1, 0).setRGBBarColor(0x2a2929);
	public static final Item SAKURAJIMARIUM_PICKAXE = new ModItemPickaxeBase(OedldoedlGear.MODID, "sakurajimarium_pickaxe", OedldoedlGear.TAB, ModToolMaterial.SAKURAJIMARIUM, 1f, -2.8f, ModRarities.DARK_GRAY, true, 1, 0).setRGBBarColor(0x2a2929);
	public static final Item SAKURAJIMARIUM_AXE = new ModItemAxeBase(OedldoedlGear.MODID, "sakurajimarium_axe", OedldoedlGear.TAB, ModToolMaterial.SAKURAJIMARIUM, 18f, -3f, ModRarities.DARK_GRAY, true, 1, 0).setRGBBarColor(0x2a2929);
	public static final Item SAKURAJIMARIUM_HOE = new ModItemHoeBase(OedldoedlGear.MODID, "sakurajimarium_hoe", OedldoedlGear.TAB, ModToolMaterial.SAKURAJIMARIUM, -6f, -0f, ModRarities.DARK_GRAY, true, 1, 0).setRGBBarColor(0x2a2929);
	public static final Item SAKURAJIMARIUM_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "sakurajimarium_paxel", OedldoedlGear.TAB, ModToolMaterial.SAKURAJIMARIUM, 4f, -3f, ModRarities.DARK_GRAY, true, 1, 0).setRGBBarColor(0x2a2929);
	public static final Item SAKURAJIMARIUM_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "sakurajimarium_smashbat", OedldoedlGear.TAB, ModToolMaterial.SAKURAJIMARIUM, 0f, -2f, 20f, 10f, ModHitSound.GEM, ModRarities.DARK_GRAY, true, 1, 0).setRGBBarColor(0x2a2929);
	public static final Item SAKURAJIMARIUM_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "sakurajimarium_shears", OedldoedlGear.TAB, ModToolMaterial.SAKURAJIMARIUM, ModRarities.DARK_GRAY, true, 1, 0).setRGBBarColor(0x2a2929);
	public static final Item SAKURAJIMARIUM_SHIELD = new ModItemShieldBase(OedldoedlGear.MODID, "sakurajimarium_shield", OedldoedlGear.TAB, ModToolMaterial.SAKURAJIMARIUM, 4.0f, ModRarities.DARK_GRAY, true, 1, 0).setRGBBarColor(0x2a2929);

	// kitagawarium tools 
	public static final Item KITAGAWARIUM_SWORD = new ModItemSwordBase(OedldoedlGear.MODID, "kitagawarium_sword", OedldoedlGear.TAB, ModToolMaterial.KITAGAWARIUM, 3f, -2.4f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0x97173e);
	public static final Item KITAGAWARIUM_SHOVEL = new ModItemShovelBase(OedldoedlGear.MODID, "kitagawarium_shovel", OedldoedlGear.TAB, ModToolMaterial.KITAGAWARIUM, 1.5f, -3f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0x97173e);
	public static final Item KITAGAWARIUM_PICKAXE = new ModItemPickaxeBase(OedldoedlGear.MODID, "kitagawarium_pickaxe", OedldoedlGear.TAB, ModToolMaterial.KITAGAWARIUM, 1f, -2.8f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0x97173e);
	public static final Item KITAGAWARIUM_AXE = new ModItemAxeBase(OedldoedlGear.MODID, "kitagawarium_axe", OedldoedlGear.TAB, ModToolMaterial.KITAGAWARIUM, 18f, -3f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0x97173e);
	public static final Item KITAGAWARIUM_HOE = new ModItemHoeBase(OedldoedlGear.MODID, "kitagawarium_hoe", OedldoedlGear.TAB, ModToolMaterial.KITAGAWARIUM, -6f, -0f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0x97173e);
	public static final Item KITAGAWARIUM_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "kitagawarium_paxel", OedldoedlGear.TAB, ModToolMaterial.KITAGAWARIUM, 4f, -3f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0x97173e);
	public static final Item KITAGAWARIUM_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "kitagawarium_smashbat", OedldoedlGear.TAB, ModToolMaterial.KITAGAWARIUM, 0f, -2f, 20f, 10f, ModHitSound.GEM, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0x97173e);
	public static final Item KITAGAWARIUM_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "kitagawarium_shears", OedldoedlGear.TAB, ModToolMaterial.KITAGAWARIUM, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0x97173e);
	public static final Item KITAGAWARIUM_SHIELD = new ModItemShieldBase(OedldoedlGear.MODID, "kitagawarium_shield", OedldoedlGear.TAB, ModToolMaterial.KITAGAWARIUM, 4.0f, ModRarities.LIGHT_PURPLE, true, 1, 0).setRGBBarColor(0x97173e);

	// wooden tools
	public static final Item WOODEN_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "wooden_paxel", OedldoedlGear.TAB, ToolMaterial.WOOD, 4f, -3f, ModRarities.WHITE, false, 1, 0);
	public static final Item WOODEN_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "wooden_smashbat", OedldoedlGear.TAB, ToolMaterial.WOOD, 0f, -2f, 4f, 2f, ModHitSound.WOOD, ModRarities.WHITE, false, 1, 0);
	public static final Item WOODEN_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "wooden_shears", OedldoedlGear.TAB, ToolMaterial.WOOD, ModRarities.WHITE, false, 1, 0);

	// stone tools
	public static final Item STONE_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "stone_paxel", OedldoedlGear.TAB, ToolMaterial.STONE, 4f, -3f, ModRarities.WHITE, false, 1, 0);
	public static final Item STONE_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "stone_smashbat", OedldoedlGear.TAB, ToolMaterial.STONE, 0f, -2f, 6f, 3f, ModHitSound.WOOD, ModRarities.WHITE, false, 1, 0);
	public static final Item STONE_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "stone_shears", OedldoedlGear.TAB, ToolMaterial.STONE, ModRarities.WHITE, false, 1, 0);

	// golden tools
	public static final Item GOLDEN_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "golden_paxel", OedldoedlGear.TAB, ToolMaterial.GOLD, 4f, -3f, ModRarities.WHITE, false, 1, 0);
	public static final Item GOLDEN_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "golden_smashbat", OedldoedlGear.TAB, ToolMaterial.GOLD, 0f, -2f, 4f, 10f, ModHitSound.METAL, ModRarities.WHITE, false, 1, 0);
	public static final Item GOLDEN_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "golden_shears", OedldoedlGear.TAB, ToolMaterial.GOLD, ModRarities.WHITE, false, 1, 0);

	// iron tools
	public static final Item IRON_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "iron_paxel", OedldoedlGear.TAB, ToolMaterial.IRON, 4f, -3f, ModRarities.WHITE, false, 1, 0);
	public static final Item IRON_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "iron_smashbat", OedldoedlGear.TAB, ToolMaterial.IRON, 0f, -2f, 8f, 4f, ModHitSound.METAL, ModRarities.WHITE, false, 1, 0);

	// diamond tools
	public static final Item DIAMOND_PAXEL = new ModItemPaxelBase(OedldoedlGear.MODID, "diamond_paxel", OedldoedlGear.TAB, ToolMaterial.DIAMOND, 4f, -3f, ModRarities.WHITE, false, 1, 0);
	public static final Item DIAMOND_SMASHBAT = new ModItemSmashbatBase(OedldoedlGear.MODID, "diamond_smashbat", OedldoedlGear.TAB, ToolMaterial.DIAMOND, 0f, -2f, 12f, 6f, ModHitSound.GEM, ModRarities.WHITE, false, 1, 0);
	public static final Item DIAMOND_SHEARS = new ModItemShearsBase(OedldoedlGear.MODID, "diamond_shears", OedldoedlGear.TAB, ToolMaterial.DIAMOND, ModRarities.WHITE, false, 1, 0);

	// smashbat tools
	public static final Item LAUNCHING_SMASHBAT = new ItemLaunchingSmashbat(OedldoedlGear.MODID, "launching_smashbat", OedldoedlGear.TAB, ModToolMaterial.LAUNCHING, -1f, -2f, 6f, 4f, ModHitSound.METAL, ModRarities.GREEN, false, 1, 0);
	public static final Item BLASTING_SMASHBAT = new ItemBlastingSmashbat(OedldoedlGear.MODID, "blasting_smashbat", OedldoedlGear.TAB, ModToolMaterial.BLASTING, -1f, -2f, 5, 4f, ModHitSound.METAL, ModRarities.RED, false, 1, 0);
	public static final Item LIGHTNING_SMASHBAT = new ItemLightningSmashbat(OedldoedlGear.MODID, "lightning_smashbat", OedldoedlGear.TAB, ModToolMaterial.LIGHTNING, -1f, -2f, 6f, 4f, ModHitSound.METAL, ModRarities.YELLOW, false, 1, 0);
	public static final Item RIDING_SMASHBAT = new ItemRidingSmashbat(OedldoedlGear.MODID, "riding_smashbat", OedldoedlGear.TAB, ModToolMaterial.RIDING, -1f, -2f, 15f, 5f, ModHitSound.WOOD, ModRarities.GOLD, false, 1, 0);
	public static final Item GOLDEN_RIDING_SMASHBAT = new ItemRidingSmashbat(OedldoedlGear.MODID, "golden_riding_smashbat", OedldoedlGear.TAB, ModToolMaterial.GOLDEN_RIDING, -1f, -2f, 20f, 8f, ModHitSound.WOOD, ModRarities.YELLOW, false, 1, 0);

	// misc tools
	public static final Item PORK_HAMMER = new ItemPorkHammer(OedldoedlGear.MODID, "pork_hammer", OedldoedlGear.TAB, ModRarities.LIGHT_PURPLE, false, 2, 0);
	public static final Item BAN_HAMMER = new ItemBanHammer(OedldoedlGear.MODID, "ban_hammer", OedldoedlGear.TAB, ModRarities.RED, true, 1, 0);
	public static final Item KICK_STICK = new ItemKickStick(OedldoedlGear.MODID, "kick_stick", OedldoedlGear.TAB, ModRarities.RED, true, 1, 0);
	public static final Item EXPLOSION_STAFF = new ItemExplosionStaff(OedldoedlGear.MODID, "explosion_staff", OedldoedlGear.TAB, ModRarities.RED, false, 1, 1);
	public static final Item LIGHTNING_STAFF = new ItemLightningStaff(OedldoedlGear.MODID, "lightning_staff", OedldoedlGear.TAB, ModRarities.AQUA, false, 1, 1);
	public static final Item ADMIN_STAFF = new ItemAdminStaff(OedldoedlGear.MODID, "admin_staff", OedldoedlGear.TAB, ModRarities.RED, true, 1, 1);
	public static final Item SKULL_WAND = new ItemSkullWand(OedldoedlGear.MODID, "skull_wand", OedldoedlGear.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item FIRE_WAND = new ItemFireWand(OedldoedlGear.MODID, "fire_wand", OedldoedlGear.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item FLY_SWATTER = new ItemFlySwatter(OedldoedlGear.MODID, "fly_swatter", OedldoedlGear.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item BEDROCK_BREAKER = new ItemBedrockBreaker(OedldoedlGear.MODID, "bedrock_breaker", OedldoedlGear.TAB, ModRarities.AQUA, false, 1, 0);
	public static final Item NEEDLE = new ItemNeedle(OedldoedlGear.MODID, "needle", OedldoedlGear.TAB, ModRarities.YELLOW, false, 1, 1);
	public static final Item BREF_POWER = new ItemBrefPower(OedldoedlGear.MODID, "bref_power", OedldoedlGear.TAB, ModRarities.YELLOW, false, 1, 0);

	// throwables
	public static final Item ROCKY_SNOWBALL = new ItemRockySnowball(OedldoedlGear.MODID, "rocky_snowball", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item EXPLOSIVE_SNOWBALL = new ItemExplosiveSnowball(OedldoedlGear.MODID, "explosive_snowball", OedldoedlGear.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item CHARGED_SNOWBALL = new ItemChargedSnowball(OedldoedlGear.MODID, "charged_snowball", OedldoedlGear.TAB, ModRarities.AQUA, false, 1, 0);

	// ingredients
	public static final Item WHITE_FABRIC = new ModItemBase(OedldoedlGear.MODID, "white_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item ORANGE_FABRIC = new ModItemBase(OedldoedlGear.MODID, "orange_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item MAGENTA_FABRIC = new ModItemBase(OedldoedlGear.MODID, "magenta_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item LIGHT_BLUE_FABRIC = new ModItemBase(OedldoedlGear.MODID, "light_blue_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item YELLOW_FABRIC = new ModItemBase(OedldoedlGear.MODID, "yellow_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item LIME_FABRIC = new ModItemBase(OedldoedlGear.MODID, "lime_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item PINK_FABRIC = new ModItemBase(OedldoedlGear.MODID, "pink_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item GRAY_FABRIC = new ModItemBase(OedldoedlGear.MODID, "gray_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item LIGHT_GRAY_FABRIC = new ModItemBase(OedldoedlGear.MODID, "light_gray_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item CYAN_FABRIC = new ModItemBase(OedldoedlGear.MODID, "cyan_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item PURPLE_FABRIC = new ModItemBase(OedldoedlGear.MODID, "purple_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item BLUE_FABRIC = new ModItemBase(OedldoedlGear.MODID, "blue_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item BROWN_FABRIC = new ModItemBase(OedldoedlGear.MODID, "brown_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item GREEN_FABRIC = new ModItemBase(OedldoedlGear.MODID, "green_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item RED_FABRIC = new ModItemBase(OedldoedlGear.MODID, "red_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item BLACK_FABRIC = new ModItemBase(OedldoedlGear.MODID, "black_fabric", OedldoedlGear.TAB, ModRarities.WHITE, false, 1, 0);

	public static final Item TRAVELLERS_LEATHER = new ModItemBase(OedldoedlGear.MODID, "travellers_leather", OedldoedlGear.TAB, ModRarities.YELLOW, false, 1, 0);

	public static final Item EXPLOSION_CORE = new ItemExplosionCore(OedldoedlGear.MODID, "explosion_core", OedldoedlGear.TAB, ModRarities.RED, false, 1, 0);
	public static final Item CHARGED_ESSENCE = new ItemChargedEssence(OedldoedlGear.MODID, "charged_essence", OedldoedlGear.TAB, ModRarities.AQUA, false, 1, 0);

	public static final Item CHAINMAIL = new ItemChainmail(OedldoedlGear.MODID, "chainmail", OedldoedlGear.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item NOTE_OF_SUFFERING = new ModItemBase(OedldoedlGear.MODID, "note_of_suffering", OedldoedlGear.TAB, ModRarities.LIGHT_PURPLE, false, 5, 1);
}