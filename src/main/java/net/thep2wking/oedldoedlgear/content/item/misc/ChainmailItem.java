package net.thep2wking.oedldoedlgear.content.item.misc;

import java.util.Random;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlgear.init.ModItems;

public class ChainmailItem extends ModItemBase
{
	public ChainmailItem(Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) 
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		Random random = new Random();
		if(random.nextFloat() > 0.95f)
		{
			worldIn.addEntity(new ItemEntity(worldIn, playerIn.getPosX(), playerIn.getPosY() + 0.5, playerIn.getPosZ(), new ItemStack(ModItems.NOTE_OF_SUFFERING.get())));
		}
		else
		{
			worldIn.addEntity(new ItemEntity(worldIn, playerIn.getPosX(), playerIn.getPosY() + 0.5, playerIn.getPosZ(), new ItemStack(Items.PAPER)));
		}
      	if(!playerIn.abilities.isCreativeMode)
      	{
      		playerIn.getHeldItemMainhand().shrink(1);
      	}
		worldIn.playSound(null, playerIn.getPosition(), SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.PLAYERS, 1f, 1f);
		return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
	}
}