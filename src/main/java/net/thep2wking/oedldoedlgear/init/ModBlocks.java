package net.thep2wking.oedldoedlgear.init;

import java.util.function.Supplier;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.thep2wking.oedldoedlcore.api.ModBlockBase;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.content.block.JumpPadBlock;
import net.thep2wking.oedldoedlgear.content.block.NukeBlock;
import net.thep2wking.oedldoedlgear.content.block.TrollTNTBlock;

public class ModBlocks 
{
	//deferred register
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OedldoedlGear.MODID);
	
	//misc
	public static final RegistryObject<Block> BADROCK = registerBlock("badrock", 
			() -> new ModBlockBase(SoundType.STONE, 10, 10000f, 100000f, ToolType.PICKAXE, 0, AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK)));
	public static final RegistryObject<Block> MAGICAL_WOOD = registerBlock("magical_wood", 
			() -> new ModBlockBase(SoundType.WOOD, 1, 3f, 3f, ToolType.AXE, 4, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.YELLOW)));
	public static final RegistryObject<Block> NUKE = registerBlock("nuke", 
			() -> new NukeBlock(SoundType.PLANT, 0, 0f, 0f, 0, AbstractBlock.Properties.create(Material.TNT, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> TROLL_TNT = registerBlock("troll_tnt", 
			() -> new TrollTNTBlock(SoundType.PLANT, 0, 0f, 0f, 0, AbstractBlock.Properties.create(Material.TNT, MaterialColor.WARPED_HYPHAE)));
	
	//jumo pads
	public static final RegistryObject<Block> JUMP_PAD = registerBlock("jump_pad", 
			() -> new JumpPadBlock(1.0, SoundType.STONE, 0, 2f, 4f, ToolType.PICKAXE, 0, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GREEN)));
	public static final RegistryObject<Block> JUMP_PAD_PLUS = registerBlock("jump_pad_plus", 
			() -> new JumpPadBlock(1.5, SoundType.STONE, 0, 2f, 4f, ToolType.PICKAXE, 0, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE)));
	public static final RegistryObject<Block> JUMP_PAD_PLUS_PLUS = registerBlock("jump_pad_plus_plus", 
			() -> new JumpPadBlock(2.0, SoundType.STONE, 0, 2f, 4f, ToolType.PICKAXE, 0, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED)));
	public static final RegistryObject<Block> JUMP_PAD_PLUS_PLUS_PLUS = registerBlock("jump_pad_plus_plus_plus", 
			() -> new JumpPadBlock(2.5, SoundType.STONE, 0, 2f, 4f, ToolType.PICKAXE, 0, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)));
	
	private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block)
	{
		RegistryObject<T> toReturn = BLOCKS.register(name, block);	
		return toReturn;
	}
	
	public static void register(IEventBus enevtBus)
	{
		BLOCKS.register(enevtBus);
	
		OedldoedlGear.LOGGER.info("Registerd Blocks for " + OedldoedlGear.MODID + "!");
	}
}