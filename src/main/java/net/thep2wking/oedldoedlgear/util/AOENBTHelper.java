package net.thep2wking.oedldoedlgear.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;

public class AOENBTHelper 
{
	public static boolean detectNBT(ItemStack stack) 
	{
		return stack.hasTag();
	}

	public static void initNBT(ItemStack stack) 
	{
		if (!detectNBT(stack)) injectNBT(stack, new CompoundNBT());
	}

	public static void injectNBT(ItemStack stack, CompoundNBT nbt) 
	{
		stack.setTag(nbt);
	}

	public static CompoundNBT getNBT(ItemStack stack) 
	{
		initNBT(stack);
		return stack.getTag();
	}

	public static void setBoolean(ItemStack stack, String tag, boolean b) 
	{
		getNBT(stack).putBoolean(tag, b);
	}

	public static void setCompound(ItemStack stack, String tag, CompoundNBT cmp) 
	{
		if (!tag.equalsIgnoreCase("ench")) getNBT(stack).put(tag, cmp);
	}

	public static boolean verifyExistence(ItemStack stack, String tag) 
	{
		return !stack.isEmpty() && detectNBT(stack) && getNBT(stack).contains(tag);
	}

	public static boolean getBoolean(ItemStack stack, String tag, boolean defaultExpected) 
	{
		return verifyExistence(stack, tag) ? getNBT(stack).getBoolean(tag) : defaultExpected;
	}

	public static CompoundNBT getCompound(ItemStack stack, String tag, boolean nullifyOnFail) 
	{
		return verifyExistence(stack, tag) ? getNBT(stack).getCompound(tag) : nullifyOnFail ? null : new CompoundNBT();
	}

	public static String getString(ItemStack stack, String tag, String defaultExpected) 
	{
		return verifyExistence(stack, tag) ? getNBT(stack).getString(tag) : defaultExpected;
	}

	public static ListNBT getList(ItemStack stack, String tag, int objtype, boolean nullifyOnFail) 
	{
		return verifyExistence(stack, tag) ? getNBT(stack).getList(tag, objtype) : nullifyOnFail ? null : new ListNBT();
	}
}