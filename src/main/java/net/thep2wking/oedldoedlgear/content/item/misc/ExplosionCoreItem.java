package net.thep2wking.oedldoedlgear.content.item.misc;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion.Mode;
import net.thep2wking.oedldoedlcore.api.ModItemBase;

public class ExplosionCoreItem extends ModItemBase
{
	public ExplosionCoreItem(Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) 
	{
	    PlayerEntity playerentity = context.getPlayer();
	    BlockPos blockpos = context.getPos();
      	if(!playerentity.abilities.isCreativeMode)
      	{
      		playerentity.getHeldItemMainhand().shrink(1);
      	}
      	
      	playerentity.world.createExplosion(playerentity, blockpos.getX(), blockpos.getY(), blockpos.getZ(), 4, false, Mode.BREAK);
      	
		return ActionResultType.SUCCESS;
	}
}