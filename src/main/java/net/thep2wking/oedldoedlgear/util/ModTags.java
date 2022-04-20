package net.thep2wking.oedldoedlgear.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.Tags.IOptionalNamedTag;
import net.thep2wking.oedldoedlgear.OedldoedlGear;

public class ModTags 
{
	public static class BLocks
	{
		private static Tags.IOptionalNamedTag<Block> createTag(String name)
		{
			return BlockTags.createOptional(new ResourceLocation(OedldoedlGear.MODID, name));
		}
		
		//bedrock breaker
		public static final Tags.IOptionalNamedTag<Block> BEDROCK_BREAKER_BREAKABLE = createTag("bedrock_breaker_breakable");
		
		private static Tags.IOptionalNamedTag<Block> createForgeTag(String name)
		{
			return BlockTags.createOptional(new ResourceLocation("forge", name));
		}
		
		//blocks
		public static final Tags.IOptionalNamedTag<Block> BEDROCK = createForgeTag("bedrock");
		public static final Tags.IOptionalNamedTag<Block> MAGIC_WOOD = createForgeTag("magic_wood");
	}
	
	public static class Items
	{
		private static IOptionalNamedTag<Item> createTag(String name)
		{
			return ItemTags.createOptional(new ResourceLocation(OedldoedlGear.MODID, name));
		}
		
		//bedrock breaker
		public static final Tags.IOptionalNamedTag<Item> COMMAND_BLOCKS = createTag("command_blocks");

		private static IOptionalNamedTag<Item> createForgeTag(String name)
		{
			return ItemTags.createOptional(new ResourceLocation("forge", name));
		}
		
		//blocks
		public static final Tags.IOptionalNamedTag<Item> BEDROCK = createForgeTag("bedrock");
		public static final Tags.IOptionalNamedTag<Item> MAGIC_WOOD = createForgeTag("magic_wood");
		
		//items
		public static final Tags.IOptionalNamedTag<Item> FORGE_TOOLKITS = createForgeTag("toolkits");
		public static final Tags.IOptionalNamedTag<Item> FORGE_FABRIC = createForgeTag("fabric");
		
		public static final Tags.IOptionalNamedTag<Item> TOOLKITS_BASE = createForgeTag("toolkits/base");
		public static final Tags.IOptionalNamedTag<Item> TOOLKITS_OEDLDOEDL = createForgeTag("toolkits/oedldoedl");
		public static final Tags.IOptionalNamedTag<Item> TOOLKITS_GREMORIUM = createForgeTag("toolkits/gremorium");
		public static final Tags.IOptionalNamedTag<Item> TOOLKITS_HIMEJIMARIUM = createForgeTag("toolkits/himejimarium");
		public static final Tags.IOptionalNamedTag<Item> TOOLKITS_TOUJOURIUM = createForgeTag("toolkits/toujourium");
		public static final Tags.IOptionalNamedTag<Item> TOOLKITS_ARGENTORIUM = createForgeTag("toolkits/argentorium");
		
		public static final Tags.IOptionalNamedTag<Item> FABRIC_WHITE = createForgeTag("fabric/white");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_ORANGE = createForgeTag("fabric/orange");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_MAGENTA = createForgeTag("fabric/magenta");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_LIGHT_BLUE = createForgeTag("fabric/light_blue");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_YELLOW = createForgeTag("fabric/yellow");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_LIME = createForgeTag("fabric/lime");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_PINK = createForgeTag("fabric/pink");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_GRAY = createForgeTag("fabric/gray");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_LIGHT_GRAY = createForgeTag("fabric/light_gray");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_CYAN = createForgeTag("fabric/cyan");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_PURPLE = createForgeTag("fabric/purple");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_BLUE = createForgeTag("fabric/blue");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_BROWN = createForgeTag("fabric/brown");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_GREEN = createForgeTag("fabric/green");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_RED = createForgeTag("fabric/red");
		public static final Tags.IOptionalNamedTag<Item> FABRIC_BLACK = createForgeTag("fabric/black");

		public static final Tags.IOptionalNamedTag<Item> HARDENED_LEATHER = createForgeTag("hardent_leather");
		public static final Tags.IOptionalNamedTag<Item> TRAVELLERS_LEATHER = createForgeTag("travellers_leather");
		
		public static final Tags.IOptionalNamedTag<Item> BASE_HELMET = createForgeTag("base_helmet");
		public static final Tags.IOptionalNamedTag<Item> BASE_CHESTPLATE = createForgeTag("base_chestplate");
		public static final Tags.IOptionalNamedTag<Item> BASE_LEGGINGS = createForgeTag("base_leggings");
		public static final Tags.IOptionalNamedTag<Item> BASE_BOOTS = createForgeTag("base_boots");
		public static final Tags.IOptionalNamedTag<Item> BASE_RINGS = createForgeTag("base_rings");
		
		public static final Tags.IOptionalNamedTag<Item> RODS_LEATHER = createForgeTag("rods/leather");
		public static final Tags.IOptionalNamedTag<Item> RODS_OBSIDIAN = createForgeTag("rods/obsidian");
		public static final Tags.IOptionalNamedTag<Item> RODS_NEUTRONIUM = createForgeTag("rods/neutronium");
	}
}