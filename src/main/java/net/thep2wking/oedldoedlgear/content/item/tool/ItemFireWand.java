package net.thep2wking.oedldoedlgear.content.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;

public class ItemFireWand extends ModItemBase {
	public ItemFireWand(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
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
		return (repair != null && repair.isItemEqual(new ItemStack(Items.GOLD_INGOT)))
				|| super.getIsRepairable(toRepair, repair);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_GHAST_SHOOT,
				SoundCategory.AMBIENT, 1.0f, 1.0f);
		player.getCooldownTracker().setCooldown(this, 20);
		player.swingArm(hand);
		if (!player.isCreative()) {
			stack.damageItem(1, player);
		}

		if (!world.isRemote) {
			double vecX = (double) (-MathHelper.sin(player.rotationYaw / 180.0F * (float) Math.PI)
					* MathHelper.cos(player.rotationPitch / 180.0F * (float) Math.PI));
			double vecY = (double) (-MathHelper.sin(player.rotationPitch / 180.0F * (float) Math.PI));
			double vecZ = (double) (MathHelper.cos(player.rotationYaw / 180.0F * (float) Math.PI)
					* MathHelper.cos(player.rotationPitch / 180.0F * (float) Math.PI));
			double deltaX = (double) (-MathHelper.sin(player.rotationYaw / 180.0F * (float) Math.PI));
			double deltaZ = (double) (MathHelper.cos(player.rotationYaw / 180.0F * (float) Math.PI));
			EntityLargeFireball fireball = new EntityLargeFireball(world, player.posX + deltaX, player.posY + 1,
					player.posZ + deltaZ, vecX, vecY, vecZ);
			world.spawnEntity(fireball);
		}
		return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
	}
}