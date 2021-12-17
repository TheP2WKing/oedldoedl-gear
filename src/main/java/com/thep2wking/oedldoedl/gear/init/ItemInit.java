package com.thep2wking.oedldoedl.gear.init;

import java.util.ArrayList;
import java.util.List;

import com.thep2wking.oedldoedl.gear.ReferenceGear;
import com.thep2wking.oedldoedl.gear.config.GearConfig;
import com.thep2wking.oedldoedl.gear.items.armor.ItemGremoriumArmor;
import com.thep2wking.oedldoedl.gear.items.armor.ItemHimejimariumArmor;
import com.thep2wking.oedldoedl.gear.items.armor.boots.ItemBaseBoots;
import com.thep2wking.oedldoedl.gear.items.armor.boots.ItemOedldoedlBoots;
import com.thep2wking.oedldoedl.gear.items.armor.chestplates.ItemBaseChestplate;
import com.thep2wking.oedldoedl.gear.items.armor.chestplates.ItemBlackFlyingShootingHoodie;
import com.thep2wking.oedldoedl.gear.items.armor.chestplates.ItemClassicFlyingShootingHoodie;
import com.thep2wking.oedldoedl.gear.items.armor.chestplates.ItemFlyingShootingCollegeJacket;
import com.thep2wking.oedldoedl.gear.items.armor.chestplates.ItemOedldoedlChestplate;
import com.thep2wking.oedldoedl.gear.items.armor.chestplates.ItemWhiteFlyingShootingHoodie;
import com.thep2wking.oedldoedl.gear.items.armor.helmets.ItemBaseHelmet;
import com.thep2wking.oedldoedl.gear.items.armor.helmets.ItemBlackFlyingShootingBasecap;
import com.thep2wking.oedldoedl.gear.items.armor.helmets.ItemOedldoedlHelmet;
import com.thep2wking.oedldoedl.gear.items.armor.leggings.ItemBaseLeggings;
import com.thep2wking.oedldoedl.gear.items.armor.leggings.ItemOedldoedlLeggings;
import com.thep2wking.oedldoedl.gear.items.baubles.amulets.ItemArgentoriumAmulet;
import com.thep2wking.oedldoedl.gear.items.baubles.amulets.ItemGermoriumAmulet;
import com.thep2wking.oedldoedl.gear.items.baubles.amulets.ItemHimejimariumAmulet;
import com.thep2wking.oedldoedl.gear.items.baubles.amulets.ItemQuartariumAmulet;
import com.thep2wking.oedldoedl.gear.items.baubles.amulets.ItemToujouriumAmulet;
import com.thep2wking.oedldoedl.gear.items.baubles.charms.ItemMinepods;
import com.thep2wking.oedldoedl.gear.items.baubles.charms.ItemMinepodsPro;
import com.thep2wking.oedldoedl.gear.items.baubles.heads.ItemBunnyEars;
import com.thep2wking.oedldoedl.gear.items.baubles.heads.ItemCatEars;
import com.thep2wking.oedldoedl.gear.items.baubles.heads.ItemLeafHeadband;
import com.thep2wking.oedldoedl.gear.items.baubles.rings.ItemBedrockiumRing;
import com.thep2wking.oedldoedl.gear.items.baubles.rings.ItemOedldoedlRing;
import com.thep2wking.oedldoedl.gear.items.tools.axes.ItemBaseAxe;
import com.thep2wking.oedldoedl.gear.items.tools.axes.ItemOedldoedlAxe;
import com.thep2wking.oedldoedl.gear.items.tools.hoes.ItemBaseHoe;
import com.thep2wking.oedldoedl.gear.items.tools.hoes.ItemOedldoedlHoe;
import com.thep2wking.oedldoedl.gear.items.tools.pickaxes.ItemBasePickaxe;
import com.thep2wking.oedldoedl.gear.items.tools.pickaxes.ItemOedldoedlPickaxe;
import com.thep2wking.oedldoedl.gear.items.tools.shovels.ItemBaseShovel;
import com.thep2wking.oedldoedl.gear.items.tools.shovels.ItemOedldoedlShovel;
import com.thep2wking.oedldoedl.gear.items.tools.smashbats.ItemBaseSmashbat;
import com.thep2wking.oedldoedl.gear.items.tools.smashbats.ItemDiamondSmashbat;
import com.thep2wking.oedldoedl.gear.items.tools.smashbats.ItemGoldenRidingSmashbat;
import com.thep2wking.oedldoedl.gear.items.tools.smashbats.ItemGoldenSmashbat;
import com.thep2wking.oedldoedl.gear.items.tools.smashbats.ItemIronSmashbat;
import com.thep2wking.oedldoedl.gear.items.tools.smashbats.ItemOedldoedlSmashbat;
import com.thep2wking.oedldoedl.gear.items.tools.smashbats.ItemRidingSmashbat;
import com.thep2wking.oedldoedl.gear.items.tools.smashbats.ItemStoneSmashbat;
import com.thep2wking.oedldoedl.gear.items.tools.smashbats.ItemWoodenSmashbat;
import com.thep2wking.oedldoedl.gear.items.tools.staffs.ItemExplosionCore;
import com.thep2wking.oedldoedl.gear.items.tools.staffs.ItemStaffOfExplosion;
import com.thep2wking.oedldoedl.gear.items.tools.swords.ItemBaseSword;
import com.thep2wking.oedldoedl.gear.items.tools.swords.ItemOedldoedlSword;

import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();

	public static final ArmorMaterial ARMOR_MATERIAL_OEDLDOEDL = EnumHelper.addArmorMaterial(ReferenceGear.MODID+":"+"armor_material_oedldoedl", ReferenceGear.MODID+":"+"oedldoedl", 100, 
	new int[] {6, 12, 16, 6}, 50, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F).setRepairItem(new ItemStack(Item.getByNameOrId("oedldoedlresources:oedldoedl_ingot")));
	
	public static final ArmorMaterial ARMOR_MATERIAL_BASE = EnumHelper.addArmorMaterial(ReferenceGear.MODID+":"+"armor_material_base", ReferenceGear.MODID+":"+"base", GearConfig.ARMOR.baseArmor.armorDurability, 
	new int[] {(int) GearConfig.ARMOR.baseArmor.armorAmplifier, (int) GearConfig.ARMOR.baseArmor.armorAmplifier, (int) GearConfig.ARMOR.baseArmor.armorAmplifier, (int) GearConfig.ARMOR.baseArmor.armorAmplifier}, 
	10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, (float) GearConfig.ARMOR.baseArmor.armorToughnessAmplifier).setRepairItem(new ItemStack(Item.getByNameOrId("oedldoedlresources:ingot_base")));
	
	public static final ArmorMaterial ARMOR_MATERIAL_FLYING_SHOOTING_COLLEGE_JACKET = EnumHelper.addArmorMaterial(ReferenceGear.MODID+":"+"armor_material_flying_shooting_college_jacket", ReferenceGear.MODID+":"+"flying_shooting_college_jacket", 100, 
	new int[] {10, 10, 10, 10}, 100, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 8.0F).setRepairItem(new ItemStack(Blocks.WOOL));	
	
	public static final ArmorMaterial ARMOR_MATERIAL_BLACK_FLYING_SHOOTING_BASECAP = EnumHelper.addArmorMaterial(ReferenceGear.MODID+":"+"armor_material_black_flying_shooting_basecap", ReferenceGear.MODID+":"+"black_flying_shooting_basecap", 100, 
	new int[] {6, 6, 6, 6}, 60, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 4.0F).setRepairItem(new ItemStack(Blocks.WOOL));	
	
	public static final ArmorMaterial ARMOR_MATERIAL_BLACK_FLYING_SHOOTING_HOODIE = EnumHelper.addArmorMaterial(ReferenceGear.MODID+":"+"armor_material_black_flying_shooting_hoodie", ReferenceGear.MODID+":"+"black_flying_shooting_hoodie", 100, 
	new int[] {8, 8, 8, 8}, 80, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 6.0F).setRepairItem(new ItemStack(Blocks.WOOL));	
	
	public static final ArmorMaterial ARMOR_MATERIAL_WHITE_FLYING_SHOOTING_HOODIE = EnumHelper.addArmorMaterial(ReferenceGear.MODID+":"+"armor_material_white_flying_shooting_hoodie", ReferenceGear.MODID+":"+"white_flying_shooting_hoodie", 100, 
	new int[] {8, 8, 8, 8}, 80, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 6.0F).setRepairItem(new ItemStack(Blocks.WOOL));	
	
	public static final ArmorMaterial ARMOR_MATERIAL_CLASSIC_FLYING_SHOOTING_HOODIE = EnumHelper.addArmorMaterial(ReferenceGear.MODID+":"+"armor_material_classic_flying_shooting_hoodie", ReferenceGear.MODID+":"+"classic_flying_shooting_hoodie", 100, 
	new int[] {8, 8, 8, 8}, 80, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 6.0F).setRepairItem(new ItemStack(Blocks.WOOL));	
	

	public static final ArmorMaterial ARMOR_MATERIAL_GREMORIUM = EnumHelper.addArmorMaterial(ReferenceGear.MODID+":"+"armor_material_gremorium", ReferenceGear.MODID+":"+"gremorium_"+GearConfig.ARMOR.gremoriumArmor.armorModel, 9958, 
	new int[] {10, 16, 20, 10}, 200, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8.0F).setRepairItem(new ItemStack(Item.getByNameOrId("oedldoedlresources:gremorium_ingot")));
	
	public static final ArmorMaterial ARMOR_MATERIAL_HIMEJIMARIUM = EnumHelper.addArmorMaterial(ReferenceGear.MODID+":"+"armor_material_gremorium", ReferenceGear.MODID+":"+"himejimarium_"+GearConfig.ARMOR.himejimariumArmor.armorModel, 10260, 
	new int[] {10, 16, 20, 10}, 200, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8.0F).setRepairItem(new ItemStack(Item.getByNameOrId("oedldoedlresources:himejimarium_ingot")));
	
	public static final ToolMaterial TOOL_MATERIAL_OEDLDOEDL = EnumHelper.addToolMaterial(ReferenceGear.MODID+":"+"tool_material_oedldoedl", 5, 2000, 10.0f, 6.0f, 30)
	.setRepairItem(new ItemStack(Item.getByNameOrId("oedldoedlresources:oedldoedl_ingot")));
	
	public static final ToolMaterial TOOL_MATERIAL_BASE = EnumHelper.addToolMaterial(ReferenceGear.MODID+":"+"tool_material_base", 2, GearConfig.TOOLS.baseTools.toolDurability, 2.0f, 2.0f, 10)
	.setRepairItem(new ItemStack(Item.getByNameOrId("oedldoedlresources:base_ingot")));
	
	public static final ToolMaterial TOOL_MATERIAL_CARROT = EnumHelper.addToolMaterial(ReferenceGear.MODID+":"+"tool_material_carrot", 1, 10, 1f, 1.0f, 10)
	.setRepairItem(new ItemStack(Item.getByNameOrId("minecraft:carrot")));
	
	public static final ToolMaterial TOOL_MATERIAL_GOLDEN_CARROT = EnumHelper.addToolMaterial(ReferenceGear.MODID+":"+"tool_material_golden_carrot", 1, 20, 1f, 1.0f, 20)
	.setRepairItem(new ItemStack(Item.getByNameOrId("minecraft:golden_carrot")));
	
	public static final ItemOedldoedlHelmet ITEM_OEDLDOEDL_HELMET = new ItemOedldoedlHelmet("oedldoedl_helmet", ARMOR_MATERIAL_OEDLDOEDL, 1, EntityEquipmentSlot.HEAD);
	public static final ItemOedldoedlChestplate ITEM_OEDLDOEDL_CHESTPLATE = new ItemOedldoedlChestplate("oedldoedl_chestplate", ARMOR_MATERIAL_OEDLDOEDL, 1, EntityEquipmentSlot.CHEST);
	public static final ItemOedldoedlLeggings ITEM_OEDLDOEDL_LEGGINGS = new ItemOedldoedlLeggings("oedldoedl_leggings", ARMOR_MATERIAL_OEDLDOEDL, 2, EntityEquipmentSlot.LEGS);
	public static final ItemOedldoedlBoots ITEM_OEDLDOEDL_BOOTS = new ItemOedldoedlBoots("oedldoedl_boots", ARMOR_MATERIAL_OEDLDOEDL, 1, EntityEquipmentSlot.FEET);	
	public static final ItemBaseHelmet ITEM_BASE_HELMET = new ItemBaseHelmet("base_helmet", ARMOR_MATERIAL_BASE, 1, EntityEquipmentSlot.HEAD);
	public static final ItemBaseChestplate ITEM_BASE_CHESTPLATE = new ItemBaseChestplate("base_chestplate", ARMOR_MATERIAL_BASE, 1, EntityEquipmentSlot.CHEST);
	public static final ItemBaseLeggings ITEM_BASE_LEGGINGS = new ItemBaseLeggings("base_leggings", ARMOR_MATERIAL_BASE, 2, EntityEquipmentSlot.LEGS);
	public static final ItemBaseBoots ITEM_BASE_BOOTS = new ItemBaseBoots("base_boots", ARMOR_MATERIAL_BASE, 1, EntityEquipmentSlot.FEET);
	public static final ItemBlackFlyingShootingBasecap ITEM_BLACK_FLYING_SHOOTING_BASECAP = new ItemBlackFlyingShootingBasecap("black_flying_shooting_basecap", ARMOR_MATERIAL_BLACK_FLYING_SHOOTING_BASECAP, 1, EntityEquipmentSlot.HEAD);
	public static final ItemFlyingShootingCollegeJacket ITEM_FLYING_SHOOTING_COLLEGE_JACKET = new ItemFlyingShootingCollegeJacket("flying_shooting_college_jacket", ARMOR_MATERIAL_FLYING_SHOOTING_COLLEGE_JACKET, 1, EntityEquipmentSlot.CHEST);
	public static final ItemBlackFlyingShootingHoodie ITEM_BLACK_FLYING_SHOOTING_HOODIE = new ItemBlackFlyingShootingHoodie("black_flying_shooting_hoodie", ARMOR_MATERIAL_BLACK_FLYING_SHOOTING_HOODIE, 1, EntityEquipmentSlot.CHEST);
	public static final ItemWhiteFlyingShootingHoodie ITEM_WHITE_FLYING_SHOOTING_HOODIE = new ItemWhiteFlyingShootingHoodie("white_flying_shooting_hoodie", ARMOR_MATERIAL_WHITE_FLYING_SHOOTING_HOODIE, 1, EntityEquipmentSlot.CHEST);
	public static final ItemClassicFlyingShootingHoodie ITEM_CLASSIC_FLYING_SHOOTING_HOODIE = new ItemClassicFlyingShootingHoodie("classic_flying_shooting_hoodie", ARMOR_MATERIAL_CLASSIC_FLYING_SHOOTING_HOODIE, 1, EntityEquipmentSlot.CHEST);
	
	public static final ItemGremoriumArmor ITEM_GREMORIUM_HELMET = new ItemGremoriumArmor("gremorium_helmet", ARMOR_MATERIAL_GREMORIUM, 1, EntityEquipmentSlot.HEAD);
	public static final ItemGremoriumArmor ITEM_GREMORIUM_CHESTPLATE = new ItemGremoriumArmor("gremorium_chestplate", ARMOR_MATERIAL_GREMORIUM, 1, EntityEquipmentSlot.CHEST);
	public static final ItemGremoriumArmor ITEM_GREMORIUM_LEGGINGS = new ItemGremoriumArmor("gremorium_leggings", ARMOR_MATERIAL_GREMORIUM, 2, EntityEquipmentSlot.LEGS);
	public static final ItemGremoriumArmor ITEM_GREMORIUM_BOOTS = new ItemGremoriumArmor("gremorium_boots", ARMOR_MATERIAL_GREMORIUM, 1, EntityEquipmentSlot.FEET);	
	
	public static final ItemHimejimariumArmor ITEM_HIMEJIMARIUM_HELMET = new ItemHimejimariumArmor("himejimarium_helmet", ARMOR_MATERIAL_HIMEJIMARIUM, 1, EntityEquipmentSlot.HEAD);
	public static final ItemHimejimariumArmor ITEM_HIMEJIMARIUM_CHESTPLATE = new ItemHimejimariumArmor("himejimarium_chestplate", ARMOR_MATERIAL_HIMEJIMARIUM, 1, EntityEquipmentSlot.CHEST);
	public static final ItemHimejimariumArmor ITEM_HIMEJIMARIUM_LEGGINGS = new ItemHimejimariumArmor("himejimarium_leggings", ARMOR_MATERIAL_HIMEJIMARIUM, 2, EntityEquipmentSlot.LEGS);
	public static final ItemHimejimariumArmor ITEM_HIMEJIMARIUM_BOOTS = new ItemHimejimariumArmor("himejimarium_boots", ARMOR_MATERIAL_HIMEJIMARIUM, 1, EntityEquipmentSlot.FEET);	
	
	public static final ItemOedldoedlSword ITEM_OEDLDOEDL_SWORD = new ItemOedldoedlSword("oedldoedl_sword", TOOL_MATERIAL_OEDLDOEDL);
	public static final ItemOedldoedlShovel ITEM_OEDLDOEDL_SHOVEL = new ItemOedldoedlShovel("oedldoedl_shovel", TOOL_MATERIAL_OEDLDOEDL);
	public static final ItemOedldoedlPickaxe ITEM_OEDLDOEDL_PICKAXE = new ItemOedldoedlPickaxe("oedldoedl_pickaxe", TOOL_MATERIAL_OEDLDOEDL);
	public static final ItemOedldoedlAxe ITEM_OEDLDOEDL_AXE = new ItemOedldoedlAxe("oedldoedl_axe", TOOL_MATERIAL_OEDLDOEDL);
	public static final ItemOedldoedlHoe ITEM_OEDLDOEDL_HOE = new ItemOedldoedlHoe("oedldoedl_hoe", TOOL_MATERIAL_OEDLDOEDL);
	
	public static final ItemBaseSword ITEM_BASE_SWORD = new ItemBaseSword("base_sword", TOOL_MATERIAL_BASE);
	public static final ItemBaseShovel ITEM_BASE_SHOVEL = new ItemBaseShovel("base_shovel", TOOL_MATERIAL_BASE);
	public static final ItemBasePickaxe ITEM_BASE_PICKAXE = new ItemBasePickaxe("base_pickaxe", TOOL_MATERIAL_BASE);
	public static final ItemBaseAxe ITEM_BASE_AXE = new ItemBaseAxe("base_axe", TOOL_MATERIAL_BASE);
	public static final ItemBaseHoe ITEM_BASE_HOE = new ItemBaseHoe("base_hoe", TOOL_MATERIAL_BASE);

	
	public static final ItemWoodenSmashbat ITEM_WOODEN_SMASHBAT = new ItemWoodenSmashbat("wooden_smashbat", 1f, -2f, ToolMaterial.WOOD);
	public static final ItemStoneSmashbat ITEM_STONE_SMASHBAT = new ItemStoneSmashbat("stone_smashbat", 1f, -2f, ToolMaterial.STONE);
	public static final ItemIronSmashbat ITEM_IRON_SMASHBAT = new ItemIronSmashbat("iron_smashbat", 1f, -2f, ToolMaterial.IRON);
	public static final ItemGoldenSmashbat ITEM_GOLDEN_SMASHBAT = new ItemGoldenSmashbat("golden_smashbat", 1f, -2f, ToolMaterial.GOLD);
	public static final ItemDiamondSmashbat ITEM_DIAMOND_SMASHBAT = new ItemDiamondSmashbat("diamond_smashbat", 1f, -2f, ToolMaterial.DIAMOND);
	public static final ItemBaseSmashbat ITEM_BASE_SMASHBAT = new ItemBaseSmashbat("base_smashbat", 1f, -2f, TOOL_MATERIAL_BASE);
	public static final ItemOedldoedlSmashbat ITEM_OEDLDOEDL_SMASHBAT = new ItemOedldoedlSmashbat("oedldoedl_smashbat", 1f, -2f, TOOL_MATERIAL_OEDLDOEDL);
	public static final ItemRidingSmashbat ITEM_RIDING_SMASHBAT = new ItemRidingSmashbat("riding_smashbat", -1f, -2f, TOOL_MATERIAL_CARROT);
	public static final ItemGoldenRidingSmashbat ITEM_GOLDEN_RIDING_SMASHBAT = new ItemGoldenRidingSmashbat("golden_riding_smashbat", -1f, -2f, TOOL_MATERIAL_GOLDEN_CARROT);

	public static final ItemStaffOfExplosion ITEM_STAFF_OF_EXPLOSION = new ItemStaffOfExplosion("staff_of_explosion");
	public static final ItemExplosionCore ITEM_EXPLOSION_CORE = new ItemExplosionCore("explosion_core");
	
	public static final ItemOedldoedlRing ITEM_OEDLDOEDL_RING = new ItemOedldoedlRing("oedldoedl_ring");
	public static final ItemBedrockiumRing ITEM_BEDROCKIUM_RING = new ItemBedrockiumRing("bedrockium_ring");
	
	public static final ItemGermoriumAmulet ITEM_GREMORIUM_AMULET = new ItemGermoriumAmulet("gremorium_amulet");
	public static final ItemHimejimariumAmulet ITEM_HIMEJIMARIUM_AMULET = new ItemHimejimariumAmulet("himejimarium_amulet");
	public static final ItemToujouriumAmulet ITEM_TOUJOURIUM_AMULET = new ItemToujouriumAmulet("toujourium_amulet");
	public static final ItemArgentoriumAmulet ITEM_ARGENTORIUM_AMULET = new ItemArgentoriumAmulet("argentorium_amulet");
	public static final ItemQuartariumAmulet ITEM_QUARTARIUM_AMULET = new ItemQuartariumAmulet("quartarium_amulet");

	public static final ItemBunnyEars ITEM_BUNNY_EARS = new ItemBunnyEars("bunny_ears");
	public static final ItemCatEars ITEM_CAT_EARS = new ItemCatEars("cat_ears");
	public static final ItemLeafHeadband ITEM_LEAF_HEADBAND = new ItemLeafHeadband("leaf_headband");
	
	public static final ItemMinepods ITEM_MINEPODS = new ItemMinepods("minepods");
	public static final ItemMinepodsPro ITEM_MINEPODS_PRO = new ItemMinepodsPro("minepods_pro");
}