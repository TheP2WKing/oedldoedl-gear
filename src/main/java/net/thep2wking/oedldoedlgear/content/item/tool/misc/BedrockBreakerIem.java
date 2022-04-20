package net.thep2wking.oedldoedlgear.content.item.tool.misc;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.util.ModTags;

public class BedrockBreakerIem extends ModItemBase
{
	public BedrockBreakerIem(Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties.maxDamage(50));
	}
	
	@Override
	public boolean isRepairable(ItemStack stack) 
	{
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) 
	{
		return ModTags.Items.BEDROCK.contains(repair.getItem()) || super.getIsRepairable(toRepair, repair);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) 
	{
		World world = context.getWorld();
		BlockPos pos = context.getPos();
		BlockState state = world.getBlockState(pos);
		Block block = state.getBlock();
		PlayerEntity player = context.getPlayer();
		ItemStack stack = context.getItem();
		Hand hand = player.getActiveHand();
		if (state.getBlock().isIn(ModTags.BLocks.BEDROCK_BREAKER_BREAKABLE))
		{
			if(!world.isRemote)
			{
				world.destroyBlock(context.getPos(), false);
				world.removeBlock(context.getPos(), false);
				world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(block.getBlock().asItem())));
				player.getCooldownTracker().setCooldown(this, GearConfig.bedrock_breaker_cooldown.get());
				stack.damageItem(1, player, e -> e.sendBreakAnimation(hand));
				player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 20, 0, false, false));
			}
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
	}
}