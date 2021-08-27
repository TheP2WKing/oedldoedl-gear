package com.thep2wking.oedldoedl.gear.init;

import java.util.ArrayList;
import java.util.List;

import com.thep2wking.oedldoedl.gear.ReferenceGear;
import com.thep2wking.oedldoedl.gear.items.armor.boots.ItemOedldoedlBoots;
import com.thep2wking.oedldoedl.gear.items.armor.chestplates.ItemOedldoedlChestplate;
import com.thep2wking.oedldoedl.gear.items.armor.helmets.ItemOedldoedlHelmet;
import com.thep2wking.oedldoedl.gear.items.armor.leggings.ItemOedldoedlLeggings;
import com.thep2wking.oedldoedl.gear.items.baubles.amulets.ItemArgentoriumAmulet;
import com.thep2wking.oedldoedl.gear.items.baubles.amulets.ItemGermoriumAmulet;
import com.thep2wking.oedldoedl.gear.items.baubles.amulets.ItemHimejimariumAmulet;
import com.thep2wking.oedldoedl.gear.items.baubles.amulets.ItemQuartariumAmulet;
import com.thep2wking.oedldoedl.gear.items.baubles.amulets.ItemToujouriumAmulet;
import com.thep2wking.oedldoedl.gear.items.baubles.heads.ItemBunnyEars;
import com.thep2wking.oedldoedl.gear.items.baubles.heads.ItemCatEars;
import com.thep2wking.oedldoedl.gear.items.baubles.rings.ItemOedldoedlRing;
import com.thep2wking.oedldoedl.gear.items.tools.axes.ItemOedldoedlAxe;
import com.thep2wking.oedldoedl.gear.items.tools.hoes.ItemOedldoedlHoe;
import com.thep2wking.oedldoedl.gear.items.tools.pickaxes.ItemOedldoedlPickaxe;
import com.thep2wking.oedldoedl.gear.items.tools.shovels.ItemOedldoedlShovel;
import com.thep2wking.oedldoedl.gear.items.tools.swords.ItemOedldoedlSword;

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
	new int[] {5, 5, 5, 5}, 30, SoundEvents.field_187716_o, 5.0F).setRepairItem(new ItemStack(com.thep2wking.oedldoedl.resources.init.ItemInit.ITEM_OEDLDOEDL_INGOT));	
	
	public static final ToolMaterial TOOL_MATERIAL_OEDLDOEDL = EnumHelper.addToolMaterial(ReferenceGear.MODID+":"+"tool_material_oedldoedl", 5, 2000, 10.0f, 6.0f, 30)
	.setRepairItem(new ItemStack(com.thep2wking.oedldoedl.resources.init.ItemInit.ITEM_OEDLDOEDL_INGOT));
	
	public static final ItemOedldoedlHelmet ITEM_OEDLDOEDL_HELMET = new ItemOedldoedlHelmet("oedldoedl_helmet", ARMOR_MATERIAL_OEDLDOEDL, 1, EntityEquipmentSlot.HEAD);
	public static final ItemOedldoedlChestplate ITEM_OEDLDOEDL_CHESTPLATE = new ItemOedldoedlChestplate("oedldoedl_chestplate", ARMOR_MATERIAL_OEDLDOEDL, 1, EntityEquipmentSlot.CHEST);
	public static final ItemOedldoedlLeggings ITEM_OEDLDOEDL_LEGGINGS = new ItemOedldoedlLeggings("oedldoedl_leggings", ARMOR_MATERIAL_OEDLDOEDL, 2, EntityEquipmentSlot.LEGS);
	public static final ItemOedldoedlBoots ITEM_OEDLDOEDL_BOOTS = new ItemOedldoedlBoots("oedldoedl_boots", ARMOR_MATERIAL_OEDLDOEDL, 1, EntityEquipmentSlot.FEET);	
	
	public static final ItemOedldoedlSword ITEM_OEDLDOEDL_SWORD = new ItemOedldoedlSword("oedldoedl_sword", TOOL_MATERIAL_OEDLDOEDL);
	public static final ItemOedldoedlShovel ITEM_OEDLDOEDL_SHOVEL = new ItemOedldoedlShovel("oedldoedl_shovel", TOOL_MATERIAL_OEDLDOEDL);
	public static final ItemOedldoedlPickaxe ITEM_OEDLDOEDL_PICKAXE = new ItemOedldoedlPickaxe("oedldoedl_pickaxe", TOOL_MATERIAL_OEDLDOEDL);
	public static final ItemOedldoedlAxe ITEM_OEDLDOEDL_AXE = new ItemOedldoedlAxe("oedldoedl_axe", TOOL_MATERIAL_OEDLDOEDL);
	public static final ItemOedldoedlHoe ITEM_OEDLDOEDL_HOE = new ItemOedldoedlHoe("oedldoedl_hoe", TOOL_MATERIAL_OEDLDOEDL);
	
	public static final ItemOedldoedlRing ITEM_OEDLDOEDL_RING = new ItemOedldoedlRing("oedldoedl_ring");
	
	public static final ItemGermoriumAmulet ITEM_GREMORIUM_AMULET = new ItemGermoriumAmulet("gremorium_amulet");
	public static final ItemHimejimariumAmulet ITEM_HIMEJIMARIUM_AMULET = new ItemHimejimariumAmulet("himejimarium_amulet");
	public static final ItemToujouriumAmulet ITEM_TOUJOURIUM_AMULET = new ItemToujouriumAmulet("toujourium_amulet");
	public static final ItemArgentoriumAmulet ITEM_ARGENTORIUM_AMULET = new ItemArgentoriumAmulet("argentorium_amulet");
	public static final ItemQuartariumAmulet ITEM_QUARTARIUM_AMULET = new ItemQuartariumAmulet("quartarium_amulet");

	public static final ItemBunnyEars ITEM_BUNNY_EARS = new ItemBunnyEars("bunny_ears");
	public static final ItemCatEars ITEM_CAT_EARS = new ItemCatEars("cat_ears");
}