package net.thep2wking.oedldoedlgear.content.item.tool.misc;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.thep2wking.oedldoedlcore.api.ModSmashbatItemBase;

public class RidingSmashbatItem extends ModSmashbatItemBase
{
	public RidingSmashbatItem(IItemTier itemTier, float attackDamage, float attackSpeed, double horizontalMotion, double verticalMotion, HitSound hitSound, Set<Block> effectiveBlocks, Rarity rarity, 
	boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties)
	{
		super(itemTier, attackDamage, attackSpeed, horizontalMotion, verticalMotion, hitSound, effectiveBlocks, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) 
	{
		attacker.startRiding(target);
		return super.hitEntity(stack, target, attacker);
	}
}