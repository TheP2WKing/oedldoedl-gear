package net.thep2wking.oedldoedlgear.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.thep2wking.oedldoedlcore.api.block.ModBlockBase;
import net.thep2wking.oedldoedlcore.util.ModToolTypes;
import net.thep2wking.oedldoedlgear.OedldoedlGear;

public class ModBlocks {
	public static final Block BADROCK = new ModBlockBase(OedldoedlGear.MODID, "badrock", OedldoedlGear.TAB,
			Material.ROCK, SoundType.STONE, MapColor.BLACK, 10, ModToolTypes.PICKAXE, 10000f, 100000f, 0);
	public static final Block MAGICAL_WOOD = new ModBlockBase(OedldoedlGear.MODID, "magical_wood", OedldoedlGear.TAB,
			Material.WOOD, SoundType.WOOD, MapColor.YELLOW, 1, ModToolTypes.AXE, 3f, 3f, 4);
}