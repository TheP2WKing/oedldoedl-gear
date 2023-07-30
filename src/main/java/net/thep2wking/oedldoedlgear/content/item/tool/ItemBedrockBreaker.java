package net.thep2wking.oedldoedlgear.content.item.tool;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlgear.init.ModBlocks;

public class ItemBedrockBreaker extends ModItemBase {
	public ItemBedrockBreaker(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		setMaxStackSize(1);
		setMaxDamage(50);
	}

	@Override
	public boolean isRepairable() {
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair != null && repair.isItemEqual(new ItemStack(Item.getItemFromBlock(Blocks.BEDROCK))))
				|| repair != null && repair.isItemEqual(new ItemStack(Item.getItemFromBlock(ModBlocks.BADROCK)))
				|| super.getIsRepairable(toRepair, repair);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {
		IBlockState state = world.getBlockState(pos);
		ItemStack stack = player.getHeldItem(hand);
		Block block = state.getBlock();
		if (state.getBlock() == Blocks.BEDROCK || state.getBlock() == ModBlocks.BADROCK){
			if (!world.isRemote) {
				world.destroyBlock(pos, false);
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(),
						new ItemStack(Item.getItemFromBlock(block))));
				player.getCooldownTracker().setCooldown(this, 40);
				stack.damageItem(1, player);
				player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 20, 0, false, false));
			}
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.FAIL;
	}
}