package net.thep2wking.oedldoedlgear.util;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.thep2wking.oedldoedlcore.api.tool.ModToolMaterialBase;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlresources.init.ModItems;

public class ModToolMaterial {
	public static final ToolMaterial FLINT = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "flint", 125, 1,
			3f, 1f, 6, Items.FLINT, 0);
	public static final ToolMaterial EMERALD = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "emerald", 1789,
			3, 8.5f, 3.5f, 12, Items.EMERALD, 0);
	public static final ToolMaterial BASE = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "base", 420, 2, 4f,
			2f, 8, ModItems.BASE_INGOT, 0);
	public static final ToolMaterial OEDLDOEDL = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "oedldoedl",
			4096, 5, 16f, 8f, 20, ModItems.OEDLDOEDL_INGOT, 0);

	public static final ToolMaterial CARROT = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "carrot", 10, 0,
			1f, 1f, 3, Items.CARROT, 0);
	public static final ToolMaterial GOLDEN_CARROT = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID,
			"golden_carrot", 20, 0, 1f, 1f, 6, Items.GOLDEN_CARROT, 0);

	public static final ToolMaterial GREMORIUM = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "gremorium",
			9958, 6, 25f, 12f, 32, ModItems.GREMORIUM_INGOT, 0);
	public static final ToolMaterial HIMEJIMARIUM = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID,
			"himejimarium", 10260, 6, 25f, 12f, 32, ModItems.HIMEJIMARIUM_INGOT, 0);
	public static final ToolMaterial TOUJOURIUM = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "toujourium",
			6757, 6, 25f, 12f, 32, ModItems.TOUJOURIUM_INGOT, 0);
	public static final ToolMaterial ARGENTORIUM = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID,
			"argentorium", 8355, 6, 25f, 12f, 32, ModItems.ARGENTORIUM_INGOT, 0);
	public static final ToolMaterial QUARTARIUM = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "quartarium",
			8758, 6, 25f, 12f, 32, ModItems.QUARTARIUM_INGOT, 0);
	public static final ToolMaterial NAGATORIUM = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "nagatorium",
			7656, 6, 25f, 12f, 32, ModItems.NAGATORIUM_INGOT, 0);
	public static final ToolMaterial SAKURAJIMARIUM = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID,
			"sakurajimarium", 8054, 6, 25f, 12f, 32, ModItems.SAKURAJIMARIUM_INGOT, 0);
		public static final ToolMaterial KITAGAWARIUM = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID,
			"kitagawarium", 8658, 6, 25f, 12f, 32, ModItems.KITAGAWARIUM_INGOT, 0);

	public static final ToolMaterial SHIELD_WOOD = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID,
			"shield_wood", 59, 0, 0f, 0f, 0, Blocks.PLANKS, 0);
	public static final ToolMaterial SHIELD_STONE = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID,
			"shield_stone", 131, 0, 0f, 0f, 0, Blocks.COBBLESTONE, 0);
	public static final ToolMaterial SHIELD_IRON = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID,
			"shield_iron", 250, 0, 0f, 0f, 0, Items.IRON_INGOT, 0);
	public static final ToolMaterial SHIELD_DIAMOND = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID,
			"shield_diamond", 1561, 0, 0f, 0f, 0, Items.DIAMOND, 0);
	public static final ToolMaterial SHIELD_GOLD = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID,
			"shield_diamond", 32, 0, 0f, 0f, 0, Items.GOLD_INGOT, 0);
}