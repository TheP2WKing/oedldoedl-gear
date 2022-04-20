package net.thep2wking.oedldoedlgear.content.item.misc;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlgear.config.GearConfig;

public class CombatDynamiteItem extends ModItemBase
{
	public CombatDynamiteItem(Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) 
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), 
		SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		if (!worldIn.isRemote) 
		{
            SnowballEntity entity = new SnowballEntity(worldIn, playerIn)
            {
            	@Override
            	public void onEntityHit(EntityRayTraceResult result)
            	{
            		super.onEntityHit(result);
            		Entity entity = result.getEntity();
            		entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), 0);
            		entity.world.createExplosion(entity, entity.getPosX(), entity.getPosY(), entity.getPosZ(), GearConfig.combat_dynamite_strength.get(), Mode.NONE);
            	}
            	
            	@Override
            	public void onImpact(RayTraceResult result) 
            	{
            		super.onImpact(result);
            	    if (!this.world.isRemote) 
            	    {
            	    	this.world.setEntityState(this, (byte)3);
            	    	this.remove();  
            	    	this.world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ(), GearConfig.combat_dynamite_strength.get(), Mode.NONE);
            		}   	  
            	}
            };
			playerIn.getCooldownTracker().setCooldown(this, 10);
			entity.setItem(itemstack);
			entity.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
		    worldIn.addEntity(entity);
		}

		playerIn.addStat(Stats.ITEM_USED.get(this));
		if (!playerIn.abilities.isCreativeMode) 
		{
			itemstack.shrink(1);
		}
		return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
	}
}