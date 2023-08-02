package net.thep2wking.oedldoedlgear.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.thep2wking.oedldoedlcore.api.block.ModBlockBase;
import net.thep2wking.oedldoedlcore.util.ModToolTypes;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.content.block.BlockChunkTNT;
import net.thep2wking.oedldoedlgear.content.block.BlockNuke;
import net.thep2wking.oedldoedlgear.content.block.BlockTrollTNT;

public class ModBlocks {
	public static final Block BADROCK = new ModBlockBase(OedldoedlGear.MODID, "badrock", OedldoedlGear.TAB,
			Material.ROCK, SoundType.STONE, MapColor.BLACK, 10, ModToolTypes.PICKAXE, 10000f, 100000f, 0);
	public static final Block MAGICAL_WOOD = new ModBlockBase(OedldoedlGear.MODID, "magical_wood", OedldoedlGear.TAB,
			Material.WOOD, SoundType.WOOD, MapColor.YELLOW, 1, ModToolTypes.AXE, 3f, 3f, 4);
	public static final Block NUKE = new BlockNuke(OedldoedlGear.MODID, "nuke", OedldoedlGear.TAB, SoundType.PLANT,
			MapColor.BLACK, 0);
	public static final Block TROLL_TNT = new BlockTrollTNT(OedldoedlGear.MODID, "troll_tnt", OedldoedlGear.TAB,
			SoundType.PLANT, MapColor.RED, 0);
	public static final Block CHUNK_TNT = new BlockChunkTNT(OedldoedlGear.MODID, "chunk_tnt", OedldoedlGear.TAB,
			SoundType.PLANT, MapColor.RED, 0);
}