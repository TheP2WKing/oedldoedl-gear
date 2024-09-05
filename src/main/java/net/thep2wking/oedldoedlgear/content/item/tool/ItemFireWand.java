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
			float yaw = player.rotationYaw;
			float pitch = player.rotationPitch;
			double vecX = -MathHelper.sin(yaw * (float) Math.PI / 180.0F)
					* MathHelper.cos(pitch * (float) Math.PI / 180.0F);
			double vecY = -MathHelper.sin(pitch * (float) Math.PI / 180.0F);
			double vecZ = MathHelper.cos(yaw * (float) Math.PI / 180.0F)
					* MathHelper.cos(pitch * (float) Math.PI / 180.0F);
			double deltaX = -MathHelper.sin(yaw * (float) Math.PI / 180.0F);
			double deltaZ = MathHelper.cos(yaw * (float) Math.PI / 180.0F);
			EntityLargeFireball fireball = new EntityLargeFireball(world, player.posX + deltaX,
					player.posY + player.getEyeHeight() - 0.25, player.posZ + deltaZ, vecX, vecY, vecZ);
			world.spawnEntity(fireball);
		}
		return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
	}
}