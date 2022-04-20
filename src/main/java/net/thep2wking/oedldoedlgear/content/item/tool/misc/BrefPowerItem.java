package net.thep2wking.oedldoedlgear.content.item.tool.misc;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.init.ModSounds;

public class BrefPowerItem extends ModItemBase
{
	public BrefPowerItem(Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties.maxDamage(250));
	}
	
	@Override
	public boolean isRepairable(ItemStack stack) 
	{
		return true;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) 
	{
		return repair.getItem() == Items.WATER_BUCKET;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) 
	{
        ItemStack stack = player.getHeldItem(hand);
		double d0 = (double)(-MathHelper.sin(player.rotationYaw * 0.017453292F));
		double d1 = (double)MathHelper.cos(player.rotationYaw * 0.017453292F);
		double d2 = (double)(-MathHelper.sin(player.rotationPitch * 0.017453292F));
		double variation = 0.5d;
		
		world.playSound(player, player.getPosition(), ModSounds.QUIEK.get(), SoundCategory.AMBIENT, world.rand.nextFloat()+0.5f, player.world.rand.nextFloat()*0.5f+0.75f);
		world.addParticle(ParticleTypes.RAIN, player.getPosX() + d0*2d, player.getPosY() + (double)player.getEyeHeight() * 0.6D + d2 * 2d + 1, player.getPosZ() + d1*2d, variation, variation/2d, variation);
		world.addParticle(ParticleTypes.RAIN, player.getPosX() + d0*2d, player.getPosY() + (double)player.getEyeHeight() * 0.6D + d2 * 2d + 1, player.getPosZ() + d1*2d, variation, variation/2d, variation);
		world.addParticle(ParticleTypes.RAIN, player.getPosX() + d0*2d, player.getPosY() + (double)player.getEyeHeight() * 0.6D + d2 * 2d + 1, player.getPosZ() + d1*2d, variation, variation/2d, variation);
		world.addParticle(ParticleTypes.RAIN, player.getPosX() + d0*2d, player.getPosY() + (double)player.getEyeHeight() * 0.6D + d2 * 2d + 1, player.getPosZ() + d1*2d, variation, variation/2d, variation);
		stack.damageItem(1, player, e -> e.sendBreakAnimation(hand));
		
		AxisAlignedBB aabb = player.getBoundingBox().grow(1);
		aabb = aabb.offset(new BlockPos(player.getLookVec().scale(2)));
		List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(player, aabb);
		for (Entity entity : entities)
		{
			if (entity instanceof LivingEntity)
			{
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 200, 0, false, false));
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, 0, false, false));
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 4, false, false));
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, 100, 1, false, false));
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, 100, 1, false, false));
			}
		}
		return ActionResult.resultSuccess(stack);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
    {
		if(ModTooltips.showAnnotationTip())
		{
		    for (int i = 1; i <= annotationLines; ++i)
		    {
				ModTooltips.addAnnotation(tooltip, this.getTranslationKey(), i);
		    }
		}
		if (ModTooltips.showInfoTip())
		{   
		    for (int i = 1; i <= tooltipLines; ++i) 
		    {
				ModTooltips.addInformation(tooltip, this.getTranslationKey(), i);
		    }
		}
		else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0))
		{
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}
		
		if (ModTooltips.showEffectTip())
		{
			ModTooltips.addEffectHeader(tooltip, ModTooltips.EFFECTS_ENEMY);
			ModTooltips.addPotionEffect(tooltip, Effects.BLINDNESS.getName(), true, 1, 200);
			ModTooltips.addPotionEffect(tooltip, Effects.WEAKNESS.getName(), true, 2, 100);
			ModTooltips.addPotionEffect(tooltip, Effects.SLOWNESS.getName(), true, 5, 100);
			ModTooltips.addPotionEffect(tooltip, Effects.NAUSEA.getName(), true, 1, 200);
			ModTooltips.addPotionEffect(tooltip, Effects.POISON.getName(), true, 2, 100);
		}
		else if (ModTooltips.showEffectTipKey())
		{
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
    }
}