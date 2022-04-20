package net.thep2wking.oedldoedlgear.content.item.tool.infinity;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.ModAxeItemBase;

public class InfinityAxeItem extends ModAxeItemBase
{
	public static final Set<Material> EFFECTIVE_MATERIALS = Sets.newHashSet(Material.LEAVES);
	   
	public InfinityAxeItem(IItemTier itemTier, float attackDamage, float attackSpeed, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(itemTier, attackDamage, attackSpeed, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}

	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) 
	{
		return Integer.MAX_VALUE;
	}
	
	@Override
	public boolean isDamageable() 
	{
		return false;
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		return false;
	}

	@Override
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) 
	{
		if(isInGroup(group))
		{
			ItemStack stack = new ItemStack(this);
			stack.addEnchantment(Enchantments.SILK_TOUCH, 10);
			items.add(stack);
		}
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) 
	{
		stack.addEnchantment(Enchantments.SILK_TOUCH, 10);
		super.onCreated(stack, worldIn, playerIn);
	}
	
	public float getDestroySpeed(ItemStack stack, BlockState state) 
	{
		Material material = state.getMaterial();
		return EFFECTIVE_MATERIALS.contains(material) ? this.efficiency : super.getDestroySpeed(stack, state);
	}
}