package net.thep2wking.oedldoedlgear.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.thep2wking.oedldoedlcore.api.block.ModBlockBase;
import net.thep2wking.oedldoedlcore.util.ModToolTypes;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.content.block.BlockImpactPad;
import net.thep2wking.oedldoedlgear.content.block.BlockJumpPad;

public class ModBlocks {
	public static final Block BADROCK = new ModBlockBase(OedldoedlGear.MODID, "badrock", OedldoedlGear.TAB, Material.ROCK, SoundType.STONE, MapColor.BLACK, 5, ModToolTypes.PICKAXE, 1000f, 10000f, 0);
	public static final Block ENHANCED_DIRT = new ModBlockBase(OedldoedlGear.MODID, "enhanced_dirt", OedldoedlGear.TAB, Material.GOURD, SoundType.GROUND, MapColor.DIRT, 0, ModToolTypes.SHOVEL, 0.5f, 0.5f, 0);
	public static final Block MAGICAL_WOOD = new ModBlockBase(OedldoedlGear.MODID, "magical_wood", OedldoedlGear.TAB, Material.WOOD, SoundType.WOOD, MapColor.YELLOW, 0, ModToolTypes.AXE, 6f, 6f, 6);
	public static final Block MAGICAL_WOOD_PLANKS = new ModBlockBase(OedldoedlGear.MODID, "magical_wood_planks", OedldoedlGear.TAB, Material.WOOD, SoundType.WOOD, MapColor.YELLOW, 0, ModToolTypes.AXE, 6f, 6f, 6);

	public static final Block JUMP_PAD = new BlockJumpPad(OedldoedlGear.MODID, "jump_pad", OedldoedlGear.TAB, (float) GearConfig.CONTENT.JUMPPADS.JUMP_PAD_MOTION, Material.WOOD, SoundType.WOOD, MapColor.GREEN, 0, ModToolTypes.AXE, 1.5f, 1.5f, 0);
	public static final Block JUMP_PAD_PLUS = new BlockJumpPad(OedldoedlGear.MODID, "jump_pad_plus", OedldoedlGear.TAB, (float) GearConfig.CONTENT.JUMPPADS.JUMP_PAD_PLUS_MOTION, Material.WOOD, SoundType.WOOD, MapColor.PURPLE, 0, ModToolTypes.AXE, 1.5f, 1.5f, 0);
	public static final Block JUMP_PAD_PLUS_PLUS = new BlockJumpPad(OedldoedlGear.MODID, "jump_pad_plus_plus", OedldoedlGear.TAB, (float) GearConfig.CONTENT.JUMPPADS.JUMP_PAD_PLUS_PLUS_MOTION, Material.WOOD, SoundType.WOOD, MapColor.RED, 0, ModToolTypes.AXE, 1.5f, 1.5f, 0);
	public static final Block JUMP_PAD_PLUS_PLUS_PLUS = new BlockJumpPad(OedldoedlGear.MODID, "jump_pad_plus_plus_plus", OedldoedlGear.TAB, (float) GearConfig.CONTENT.JUMPPADS.JUMP_PAD_PLUS_PLUS_PLUS_MOTION, Material.WOOD, SoundType.WOOD, MapColor.BLACK, 0, ModToolTypes.AXE, 1.5f, 1.5f, 0);
	public static final Block IMPACT_PAD = new BlockImpactPad(OedldoedlGear.MODID, "impact_pad", OedldoedlGear.TAB, Material.WOOD, SoundType.WOOD, MapColor.QUARTZ, 0, ModToolTypes.AXE, 1.5f, 1.5f, 0);
}