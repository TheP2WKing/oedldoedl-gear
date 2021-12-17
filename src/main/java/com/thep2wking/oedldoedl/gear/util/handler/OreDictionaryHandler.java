package com.thep2wking.oedldoedl.gear.util.handler;

import com.thep2wking.oedldoedl.gear.init.ItemInit;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler
{
	public static void registerOreDictionary()
	{
  		OreDictionary.registerOre("helmetBase", ItemInit.ITEM_BASE_HELMET);
  		OreDictionary.registerOre("chestplateBase", ItemInit.ITEM_BASE_CHESTPLATE);
  		OreDictionary.registerOre("leggingsBase", ItemInit.ITEM_BASE_LEGGINGS);
  		OreDictionary.registerOre("bootsBase", ItemInit.ITEM_BASE_BOOTS);
  		
  		OreDictionary.registerOre("toolHoe", ItemInit.ITEM_BASE_HOE);
  		OreDictionary.registerOre("toolHoe", ItemInit.ITEM_OEDLDOEDL_HOE);
  		
  		OreDictionary.registerOre("explosionCore", ItemInit.ITEM_EXPLOSION_CORE);
  	}
}