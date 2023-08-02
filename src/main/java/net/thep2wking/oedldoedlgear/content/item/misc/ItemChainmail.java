package net.thep2wking.oedldoedlgear.content.item.misc;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlgear.init.ModItems;

public class ItemChainmail extends ModItemBase {
	public ItemChainmail(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		Random random = new Random();
		if (!worldIn.isRemote) {
			if (random.nextFloat() > 0.95f) {
				worldIn.spawnEntity(
						new EntityItem(worldIn, playerIn.getPosition().getX(), playerIn.getPosition().getY() + 0.5,
								playerIn.getPosition().getZ(), new ItemStack(ModItems.NOTE_OF_SUFFERING)));
			} else {
				worldIn.spawnEntity(
						new EntityItem(worldIn, playerIn.getPosition().getX(), playerIn.getPosition().getY() + 0.5,
								playerIn.getPosition().getZ(), new ItemStack(Items.PAPER)));
			}
		}

		if (!playerIn.capabilities.isCreativeMode) {
			playerIn.getHeldItemMainhand().shrink(1);
		}
		worldIn.playSound(null, playerIn.getPosition(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.PLAYERS, 1f,
				1f);
		return ActionResult.newResult(EnumActionResult.SUCCESS, itemstack);
	}
}