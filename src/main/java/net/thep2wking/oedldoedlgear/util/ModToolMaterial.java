package net.thep2wking.oedldoedlgear.util;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.thep2wking.oedldoedlcore.api.tool.ModToolMaterialBase;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.init.ModBlocks;
import net.thep2wking.oedldoedlresources.init.ModItems;

public class ModToolMaterial {
	public static final ToolMaterial BASE = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "base", 420, 2, 4f,
			2f, 8, ModItems.BASE_INGOT, 0);
	public static final ToolMaterial OEDLDOEDL = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "oedldoedl",
			4096, 5, 16f, 8f, 20, ModItems.OEDLDOEDL_INGOT, 0);

	public static final ToolMaterial DIRT = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "dirt", 26,
			0, 1.5f, -0.5f, 4, ModBlocks.ENHANCED_DIRT, 0);
	public static final ToolMaterial EMERALD = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "emerald", 1789,
			3, 8.5f, 3.5f, 12, Items.EMERALD, 0);
	public static final ToolMaterial SLIME = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "slime", 2048,
			4, 10f, 5f, 18, Items.SLIME_BALL, 0);

	public static final ToolMaterial LAUNCHING = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "launching",
			64, 0, 1f, 1f, 3, Items.GUNPOWDER, 0);
	public static final ToolMaterial BLASTING = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "blasting", 64,
			0, 1f, 1f, 3, Blocks.TNT, 0);
	public static final ToolMaterial LIGHTNING = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "lightning",
			64, 0, 1f, 1f, 3, Items.GLOWSTONE_DUST, 0);
	public static final ToolMaterial RIDING = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID, "riding", 32, 0,
			1f, 1f, 3, Items.CARROT, 0);
	public static final ToolMaterial GOLDEN_RIDING = ModToolMaterialBase.addToolMaterial(OedldoedlGear.MODID,
			"golden_riding", 64, 0, 1f, 1f, 6, Items.GOLDEN_CARROT, 0);

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
}