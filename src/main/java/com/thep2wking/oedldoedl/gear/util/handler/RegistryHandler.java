package com.thep2wking.oedldoedl.gear.util.handler;

import com.thep2wking.oedldoedl.core.util.interfaces.IHasModel;
import com.thep2wking.oedldoedl.gear.config.GearConfig;
import com.thep2wking.oedldoedl.gear.init.BlockInit;
import com.thep2wking.oedldoedl.gear.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler
{
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		
	}
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		//gear - armor items
		if (GearConfig.ARMOR.baseArmor.enabled)
		{
	  		event.getRegistry().register(ItemInit.ITEM_BASE_HELMET);
	  		event.getRegistry().register(ItemInit.ITEM_BASE_CHESTPLATE);
	  		event.getRegistry().register(ItemInit.ITEM_BASE_LEGGINGS);
	  		event.getRegistry().register(ItemInit.ITEM_BASE_BOOTS);
		}
		
		if (GearConfig.ARMOR.oedldoedlArmor.enabled)
		{
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_HELMET);
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_CHESTPLATE);
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_LEGGINGS);
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_BOOTS);
		}
		
		if (GearConfig.ARMOR.gremoriumArmor.enabled)
		{
  			event.getRegistry().register(ItemInit.ITEM_GREMORIUM_HELMET);
  			event.getRegistry().register(ItemInit.ITEM_GREMORIUM_CHESTPLATE);
  			event.getRegistry().register(ItemInit.ITEM_GREMORIUM_LEGGINGS);
  			event.getRegistry().register(ItemInit.ITEM_GREMORIUM_BOOTS);
		}
		
		if (GearConfig.ARMOR.himejimariumArmor.enabled)
		{
  			event.getRegistry().register(ItemInit.ITEM_HIMEJIMARIUM_HELMET);
  			event.getRegistry().register(ItemInit.ITEM_HIMEJIMARIUM_CHESTPLATE);
  			event.getRegistry().register(ItemInit.ITEM_HIMEJIMARIUM_LEGGINGS);
  			event.getRegistry().register(ItemInit.ITEM_HIMEJIMARIUM_BOOTS);
		}
		
		if (GearConfig.ARMOR.flyingShootingArmor.enabled)
		{
	  		event.getRegistry().register(ItemInit.ITEM_BLACK_FLYING_SHOOTING_BASECAP);
	  		event.getRegistry().register(ItemInit.ITEM_FLYING_SHOOTING_COLLEGE_JACKET);
	  		event.getRegistry().register(ItemInit.ITEM_BLACK_FLYING_SHOOTING_HOODIE);
	  		event.getRegistry().register(ItemInit.ITEM_WHITE_FLYING_SHOOTING_HOODIE);
	  		event.getRegistry().register(ItemInit.ITEM_CLASSIC_FLYING_SHOOTING_HOODIE);
		}

  		//gear - tool items
		if (GearConfig.TOOLS.baseTools.enabled)
		{
  			event.getRegistry().register(ItemInit.ITEM_BASE_SWORD);
  			event.getRegistry().register(ItemInit.ITEM_BASE_SHOVEL);
  			event.getRegistry().register(ItemInit.ITEM_BASE_PICKAXE);
			event.getRegistry().register(ItemInit.ITEM_BASE_AXE);
			event.getRegistry().register(ItemInit.ITEM_BASE_HOE);
		}
		
		if (GearConfig.TOOLS.oedldoedlTools.enabled)
		{
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_SWORD);
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_SHOVEL);
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_PICKAXE);
			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_AXE);
			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_HOE);
		}
		
		if (GearConfig.TOOLS.smshbats)
		{
  			event.getRegistry().register(ItemInit.ITEM_WOODEN_SMASHBAT);
  			event.getRegistry().register(ItemInit.ITEM_STONE_SMASHBAT);
  			event.getRegistry().register(ItemInit.ITEM_IRON_SMASHBAT);
  			event.getRegistry().register(ItemInit.ITEM_GOLDEN_SMASHBAT);
  			event.getRegistry().register(ItemInit.ITEM_DIAMOND_SMASHBAT);
  			event.getRegistry().register(ItemInit.ITEM_BASE_SMASHBAT);
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_SMASHBAT);
  			event.getRegistry().register(ItemInit.ITEM_RIDING_SMASHBAT);
  			event.getRegistry().register(ItemInit.ITEM_GOLDEN_RIDING_SMASHBAT);
		}
		
		if (GearConfig.TOOLS.explosionStaff.enabled)
		{
  			event.getRegistry().register(ItemInit.ITEM_STAFF_OF_EXPLOSION);
  			event.getRegistry().register(ItemInit.ITEM_EXPLOSION_CORE);
		}

  		//gear - bauble items

		if (GearConfig.BAUBLES.oedldoedlRing)
		{
			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_RING);
		}
		
		if (GearConfig.BAUBLES.bedrockiumRing)
		{
			event.getRegistry().register(ItemInit.ITEM_BEDROCKIUM_RING);
		}
		
		if (GearConfig.BAUBLES.gremoriumAmulet.enabled)
		{
			event.getRegistry().register(ItemInit.ITEM_GREMORIUM_AMULET);
		}
		
		if (GearConfig.BAUBLES.himejimariumAmulet.enabled)
		{
			event.getRegistry().register(ItemInit.ITEM_HIMEJIMARIUM_AMULET);
		}
		
		if (GearConfig.BAUBLES.toujouriumAmulet.enabled)
		{
			event.getRegistry().register(ItemInit.ITEM_TOUJOURIUM_AMULET);
		}
		
		if (GearConfig.BAUBLES.argentoriumAmulet)
		{
			event.getRegistry().register(ItemInit.ITEM_ARGENTORIUM_AMULET);
		}
		
		if (GearConfig.BAUBLES.quartariumAmulet)
		{
			event.getRegistry().register(ItemInit.ITEM_QUARTARIUM_AMULET);
		}
		
		if (GearConfig.BAUBLES.baubleAccessoires)
		{
			event.getRegistry().register(ItemInit.ITEM_BUNNY_EARS);
			event.getRegistry().register(ItemInit.ITEM_CAT_EARS);
			event.getRegistry().register(ItemInit.ITEM_LEAF_HEADBAND);
  	
	  		event.getRegistry().register(ItemInit.ITEM_MINEPODS);
	  		event.getRegistry().register(ItemInit.ITEM_MINEPODS_PRO);
		}
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Block block : BlockInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
		
		for(Item item : ItemInit.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
	}

	public static void preInitRegistries(FMLPreInitializationEvent event) 
	{

	}
	
	public static void InitRegistries(FMLInitializationEvent event) 
	{
		
	}
	
	public static void postInitRegistries(FMLPostInitializationEvent event) 
	{

	}
}