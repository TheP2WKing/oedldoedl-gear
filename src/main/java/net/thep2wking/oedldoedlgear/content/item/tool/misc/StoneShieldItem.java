package net.thep2wking.oedldoedlgear.content.item.tool.misc;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.tags.ItemTags;
import net.thep2wking.oedldoedlcore.api.ModShieldItemBase;

public class StoneShieldItem extends ModShieldItemBase
{
	public StoneShieldItem(IItemTier itemTier, Item repairItem, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(itemTier, repairItem, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}
	
	@Override
	public boolean isRepairable(ItemStack stack) 
	{
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) 
	{
		if (repairItem == null)
		{
			return ItemTags.STONE_TOOL_MATERIALS.contains(repair.getItem()) || super.getIsRepairable(toRepair, repair);
		}
		return repair.getItem() == Items.COBBLESTONE;
		
	}
}
