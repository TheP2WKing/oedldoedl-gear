package com.thep2wking.oedldoedl.gear.util.tabs;

import com.thep2wking.oedldoedl.core.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabOedldoedlGear extends CreativeTabs
{
	public TabOedldoedlGear(String label)
	{
		super("tab_oedldoedl_gear");
		setBackgroundImageName("oedldoedl_base.png");
	}
	
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ItemInit.ITEM_ICON_GEAR);
	}
}