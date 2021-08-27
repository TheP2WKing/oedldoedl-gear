package com.thep2wking.oedldoedl.gear.util.handler;

import com.thep2wking.oedldoedl.core.config.constants.GearConst;
import com.thep2wking.oedldoedl.core.util.interfaces.IHasModel;
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
  		if (GearConst.OEDLDOEDL_HELMET) 
  		{
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_HELMET);
  		}
  		if (GearConst.OEDLDOEDL_CHESTPLATE) 
  		{
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_CHESTPLATE);
  		}
  		if (GearConst.OEDLDOEDL_LEGGINGS) 
  		{
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_LEGGINGS);
  		}
  		if (GearConst.OEDLDOEDL_BOOTS) 
  		{
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_BOOTS);
  		}
		
  		//gear - tool items
  		if (GearConst.OEDLDOEDL_SWORD) 
  		{
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_SWORD);
  		}
  		if (GearConst.OEDLDOEDL_SHOVEL) 
  		{
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_SHOVEL);
  		}
  		if (GearConst.OEDLDOEDL_PICKAXE) 
  		{
  			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_PICKAXE);
  		}
  		if (GearConst.OEDLDOEDL_AXE) 
  		{
			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_AXE);
  		}
  		if (GearConst.OEDLDOEDL_HOE) 
  		{
			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_HOE);
  		}
		
  		//gear - bauble items
  		if (GearConst.OEDLDOEDL_RING) 
  		{
			event.getRegistry().register(ItemInit.ITEM_OEDLDOEDL_RING);
  		}
  		if (GearConst.GREMORIUM_AMULET) 
  		{
			event.getRegistry().register(ItemInit.ITEM_GREMORIUM_AMULET);
  		}
  		if (GearConst.HIMEJIMARIUM_AMULET) 
  		{
			event.getRegistry().register(ItemInit.ITEM_HIMEJIMARIUM_AMULET);
  		}
  		if (GearConst.TOUJOURIUM_AMULET) 
  		{
			event.getRegistry().register(ItemInit.ITEM_TOUJOURIUM_AMULET);
  		}
  		if (GearConst.ARGENTORIUM_AMULET) 
  		{
			event.getRegistry().register(ItemInit.ITEM_ARGENTORIUM_AMULET);
  		}
  		if (GearConst.QUARTARIUM_AMULET) 
  		{
			event.getRegistry().register(ItemInit.ITEM_QUARTARIUM_AMULET);
  		}
  		if (GearConst.BUNNY_EARS) 
  		{
			event.getRegistry().register(ItemInit.ITEM_BUNNY_EARS);
  		}
  		if (GearConst.CAT_EARS) 
  		{
			event.getRegistry().register(ItemInit.ITEM_CAT_EARS);
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