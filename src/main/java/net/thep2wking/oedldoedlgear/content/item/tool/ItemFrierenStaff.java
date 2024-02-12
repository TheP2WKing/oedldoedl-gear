package net.thep2wking.oedldoedlgear.content.item.tool;

import java.util.List;
import javax.annotation.Nullable;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModCustomParticleRenderer;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModBlocks;

public class ItemFrierenStaff extends ModItemBase {
	public ItemFrierenStaff(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		setMaxStackSize(1);
		setMaxDamage(512);
	}

	@Override
	public boolean isRepairable() {
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair != null && repair.isItemEqual(new ItemStack(Item.getItemFromBlock(ModBlocks.MAGICAL_WOOD))))
				|| super.getIsRepairable(toRepair, repair);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		int distance = GearConfig.CONTENT.STAFFS.FRIEREN_STAFF_RANGE;

		if (player.isSneaking()) {
			distance = (distance - 2) / 2;
		}

		Vec3d vector = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw);

		double x = player.posX;
		double y = player.posY + 2;
		double z = player.posZ;

		double lastX = 0;
		double lastY = 0;
		double lastZ = 0;

		int count = 0;

		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos((int) x, (int) y, (int) z);
		BlockPos.MutableBlockPos lastChecker = new BlockPos.MutableBlockPos();
		BlockPos.MutableBlockPos placePos = new BlockPos.MutableBlockPos();

		while (count < distance) {
			lastChecker.setPos(lastX, lastY, lastZ);
			if (!lastChecker.equals(pos)) {
				if (y >= world.getHeight() || y <= 0 || !world.isAirBlock(pos))
					break;
				for (int i = -1; i < 2; i++) // - 1 2
					for (int j = -1; j < 2; j++) { // - 1 2
						for (int k = -1; k < 2; k++) { // - 1 2
							placePos.setPos(pos.getX() + i, pos.getY() + k, pos.getZ() + j);

							ModCustomParticleRenderer.addParticleFromHex(world, placePos, "#686080");
							ModCustomParticleRenderer.addParticleFromHex(world, placePos, "#92a29e");
							ModCustomParticleRenderer.addParticleFromHex(world, placePos, "#ffffff");

							List<EntityLivingBase> entity = world.getEntitiesWithinAABB(EntityLivingBase.class,
									new AxisAlignedBB(placePos));
							for (EntityLivingBase ent : entity) {
								if (ent != player) {
									ent.attackEntityFrom(DamageSource.causeIndirectMagicDamage(player, player),
											GearConfig.CONTENT.STAFFS.FRIEREN_STAFF_MAGIC_DAMAGE);
								}
							}
						}
					}
				count++;
			}
			lastX = x;
			lastY = y;
			lastZ = z;
			x += vector.x;
			y += vector.y;
			z += vector.z;
			pos.setPos(x, y, z);
		}
		world.playSound(null, player.getPosition(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.AMBIENT, 4f,
				1f);
		player.getCooldownTracker().setCooldown(this, GearConfig.CONTENT.STAFFS.FRIEREN_STAFF_COOLDOWN);
		stack.damageItem(1, player);
		player.swingArm(hand);
		return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip()) {
			tooltip.add(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor()
					+ I18n.format(this.getUnlocalizedName() + ".annotation1") + " " + TextFormatting.YELLOW
					+ GearConfig.CONTENT.STAFFS.FRIEREN_STAFF_RANGE + " "
					+ TextFormatting.ITALIC + I18n.format(this.getUnlocalizedName() + ".annotation2"));
		}
		if (ModTooltips.showInfoTip()) {
			for (int i = 1; i <= tooltipLines; ++i) {
				ModTooltips.addInformation(tooltip, this.getUnlocalizedName(), i);
			}
		} else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0)) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}
	}
}