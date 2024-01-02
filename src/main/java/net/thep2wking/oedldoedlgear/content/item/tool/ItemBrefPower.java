package net.thep2wking.oedldoedlgear.content.item.tool;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModSounds;

public class ItemBrefPower extends ModItemBase {
	public ItemBrefPower(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
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
		return (repair != null && repair.isItemEqual(new ItemStack(Items.WATER_BUCKET)))
				|| super.getIsRepairable(toRepair, repair);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if (GearConfig.CONTENT.BREF_POWER_SOUND) {
			world.playSound(player, player.getPosition(), ModSounds.QUIEK, SoundCategory.AMBIENT,
					world.rand.nextFloat() + 0.5f, player.world.rand.nextFloat() * 0.5f + 0.75f);
		}
		player.getCooldownTracker().setCooldown(this, GearConfig.CONTENT.BREF_POWER_COOLDOWN);
		stack.damageItem(1, player);
		if (world instanceof WorldServer) {
			double d0 = (double) (-MathHelper.sin(player.rotationYaw * 0.017453292F));
			double d1 = (double) MathHelper.cos(player.rotationYaw * 0.017453292F);
			double d2 = (double) (-MathHelper.sin(player.rotationPitch * 0.017453292F));
			double variation = 0.5d;

			((WorldServer) world).spawnParticle(EnumParticleTypes.WATER_DROP,
					player.posX + d0 * 2d, player.posY + (double) player.height * 0.6D + d2 * 2d, player.posZ + d1 * 2d,
					40, variation, variation / 2d, variation, 0,
					new int[] { Block.getStateId(Blocks.WATER.getDefaultState()) });
			((WorldServer) world).spawnParticle(EnumParticleTypes.WATER_DROP,
					player.posX + d0 * 2d, player.posY + (double) player.height * 0.6D + d2 * 2d, player.posZ + d1 * 2d,
					40, variation, variation / 2d, variation, 0,
					new int[] { Block.getStateId(Blocks.WATER.getDefaultState()) });

			AxisAlignedBB aabb = player.getEntityBoundingBox().grow(1);
			aabb = aabb.offset(new BlockPos(player.getLookVec().scale(2)));
			List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(player, aabb);
			for (Entity entity : entities) {
				if (entity instanceof EntityLiving) {
					stack.damageItem(1, player);
					((EntityLiving) entity)
							.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 200, 0, false, false));
					((EntityLiving) entity)
							.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 0, false, false));
					((EntityLiving) entity)
							.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 4, false, false));
					((EntityLiving) entity)
							.addPotionEffect(new PotionEffect(MobEffects.POISON, 100, 1, false, false));
					((EntityLiving) entity)
							.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 1, false, false));
				}
			}
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
			ModTooltips.addPotionEffect(tooltip, MobEffects.BLINDNESS.getName(), true, 1, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.WEAKNESS.getName(), true, 2, 100);
			ModTooltips.addPotionEffect(tooltip, MobEffects.SLOWNESS.getName(), true, 5, 100);
			ModTooltips.addPotionEffect(tooltip, MobEffects.NAUSEA.getName(), true, 1, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.POISON.getName(), true, 2, 100);
		} else if (ModTooltips.showEffectTipKey()) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
	}
}