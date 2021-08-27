package com.thep2wking.oedldoedl.gear.util.tabs;

import com.thep2wking.oedldoedl.gear.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabOedldoedlGear extends CreativeTabs
{
	public TabOedldoedlGear(String label)
	{
		super("tab_oedldoedl_gear");
		func_78025_a("oedldoedl_base.png");
	}
	
	public ItemStack func_78016_d()
	{
		return new ItemStack(ItemInit.ITEM_GREMORIUM_AMULET);
	}
}