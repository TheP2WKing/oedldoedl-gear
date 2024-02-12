package net.thep2wking.oedldoedlgear.content.item.tool;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlgear.config.GearConfig;

public class ItemPorkHammer extends ModItemBase {
	public ItemPorkHammer(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		setMaxStackSize(1);
		setMaxDamage(256);
	}

	@Override
	public boolean isRepairable() {
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair != null && repair.isItemEqual(new ItemStack(Items.PORKCHOP)))
				|| super.getIsRepairable(toRepair, repair);
	}

	public static void dropPork(ItemStack stack, World world, BlockPos pos) {
		double d0 = (double) (world.rand.nextFloat() * 0.5F) + 0.25D;
		double d1 = (double) (world.rand.nextFloat() * 0.5F) + 0.25D;
		double d2 = (double) (world.rand.nextFloat() * 0.5F) + 0.25D;
		if (!world.isRemote) {
			EntityItem pork = new EntityItem(world, (double) pos.getX() + d0, (double) pos.getY() + d1,
					(double) pos.getZ() + d2, new ItemStack(Items.PORKCHOP, 1, 0));
			pork.setDefaultPickupDelay();
			world.spawnEntity(pork);
		}
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos,
			EntityLivingBase entityLiving) {
		EntityPlayer player = (EntityPlayer) entityLiving;
		stack.damageItem(1, player);
		if (GearConfig.CONTENT.PORK_HAMMER_SPAWNS_PORKCHOP) {
			dropPork(stack, worldIn, pos);
		}
		return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		World world = entity.getEntityWorld();
		Random random = new Random();
		stack.damageItem(1, player);
		if (random.nextInt(5) == 0 && GearConfig.CONTENT.PORK_HAMMER_SPAWNS_PORKCHOP) {
			dropPork(stack, world, entity.getPosition());
		}
		return super.onLeftClickEntity(stack, player, entity);
	}
}