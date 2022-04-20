package net.thep2wking.oedldoedlgear.content.item.tool.infinity;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.ModSwordItemBase;
import net.thep2wking.oedldoedlgear.util.ModDamageSources;

public class InfinitySwordItem extends ModSwordItemBase
{
	public InfinitySwordItem(IItemTier itemTier, int attackDamage, float attackSpeed, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
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
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) 
	{
		target.setHealth(0);
		target.onDeath(ModDamageSources.INFINITY);
		target.attackEntityFrom(ModDamageSources.INFINITY, Integer.MAX_VALUE);
		return super.hitEntity(stack, target, attacker);
	}

	@Override
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) 
	{
		if(isInGroup(group))
		{
			ItemStack stack = new ItemStack(this);
			stack.addEnchantment(Enchantments.LOOTING, 10);
			items.add(stack);
		}
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) 
	{
		stack.addEnchantment(Enchantments.LOOTING, 10);
		super.onCreated(stack, worldIn, playerIn);
	}
}