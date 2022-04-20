package net.thep2wking.oedldoedlgear.content.item.misc;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.thep2wking.oedldoedlcore.api.ModItemBase;

public class ChargedEssenceItem extends ModItemBase
{
	public ChargedEssenceItem(Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
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
      	
      	LightningBoltEntity lightningBolt = EntityType.LIGHTNING_BOLT.create(playerentity.world);
      	if (lightningBolt != null) 
      	{
      		lightningBolt.moveForced(Vector3d.copy(blockpos));
      		lightningBolt.setCaster(playerentity instanceof ServerPlayerEntity ? (ServerPlayerEntity) playerentity : null);
      		playerentity.world.addEntity(lightningBolt);
      	}
      	
      	LightningBoltEntity lightningBolt2 = EntityType.LIGHTNING_BOLT.create(playerentity.world);
      	if (lightningBolt2 != null) 
      	{
      		lightningBolt2.moveForced(Vector3d.copy(blockpos));
      		lightningBolt2.setCaster(playerentity instanceof ServerPlayerEntity ? (ServerPlayerEntity) playerentity : null);
      		playerentity.world.addEntity(lightningBolt2);
      	}
		return ActionResultType.SUCCESS;
	}
}