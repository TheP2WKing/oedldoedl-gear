package net.thep2wking.oedldoedlgear.content.item.tool;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.util.ModTooltips;

public class ItemSkullWand extends ModItemBase {
	public ItemSkullWand(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
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
		world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_WITHER_SHOOT,
				SoundCategory.AMBIENT, 1.0f, 1.0f);
		player.getCooldownTracker().setCooldown(this, 20);
		player.swingArm(hand);
		if (!player.capabilities.isCreativeMode) {
			stack.damageItem(1, player);
		}
		if (!world.isRemote) {
			Vec3d look = player.getLookVec();
			double deltaX = (double) (-MathHelper.sin(player.rotationYaw / 180.0F * (float) Math.PI));
			double deltaZ = (double) (MathHelper.cos(player.rotationYaw / 180.0F * (float) Math.PI));
			EntityWitherSkull skull = new EntityWitherSkull(world, player, 0, 0, 0) {
				@Override
				public void onImpact(RayTraceResult result) {
					if (!this.world.isRemote && result.entityHit != null
							&& result.entityHit instanceof EntityLivingBase) {
						EntityLivingBase entity = (EntityLivingBase) result.entityHit;
						entity.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200, 1));
					}
					this.world.newExplosion(this, this.posX, this.posY, this.posZ, 1.0F, false, true);
					this.setDead();
				}
			};
			skull.setPosition(player.posX + deltaX, player.posY + player.getEyeHeight() - 0.25, player.posZ + deltaZ);
			skull.accelerationX = look.x * 0.2;
			skull.accelerationY = look.y * 0.2;
			skull.accelerationZ = look.z * 0.2;
			world.spawnEntity(skull);
		}
		return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip()) {
			for (int i = 1; i <= annotationLines; ++i) {
				ModTooltips.addAnnotation(tooltip, this.getUnlocalizedName(), i);
			}
		}
		if (ModTooltips.showInfoTip()) {
			for (int i = 1; i <= tooltipLines; ++i) {
				ModTooltips.addInformation(tooltip, this.getUnlocalizedName(), i);
			}
		} else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0)) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}

		if (ModTooltips.showEffectTip()) {
			ModTooltips.addEffectHeader(tooltip, ModTooltips.EFFECT_ENEMY);
			ModTooltips.addPotionEffect(tooltip, MobEffects.WITHER.getName(), true, 2, 200);
		} else if (ModTooltips.showEffectTipKey()) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
	}
}