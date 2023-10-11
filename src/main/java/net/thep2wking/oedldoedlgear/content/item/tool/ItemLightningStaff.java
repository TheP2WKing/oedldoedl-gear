package net.thep2wking.oedldoedlgear.content.item.tool;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.init.ModBlocks;

public class ItemLightningStaff extends ModItemBase {
	public ItemLightningStaff(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		setMaxStackSize(1);
		setMaxDamage(128);
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
		if (!world.isRemote) {
			Vec3d lookVec = player.getLookVec();
			Vec3d start = new Vec3d(player.posX, player.posY + player.getEyeHeight(), player.posZ);
			int distance = 60;
			boolean gothrough = false;

			if (player.isSneaking()) {
				distance /= 2;
			}

			Vec3d end = start.addVector(lookVec.x * distance, lookVec.y * distance, lookVec.z * distance);
			RayTraceResult position = gothrough ? null : world.rayTraceBlocks(start, end);
			if (gothrough) {
				position = null;
			}
			if (position == null) {
				if (gothrough) {

				} else {
					player.world.addWeatherEffect(new EntityLightningBolt(world, end.x + 2, end.y, end.z, false));
					player.world.addWeatherEffect(new EntityLightningBolt(world, end.x - 2, end.y, end.z, false));
					player.world.addWeatherEffect(new EntityLightningBolt(world, end.x, end.y, end.z + 2, false));
					player.world.addWeatherEffect(new EntityLightningBolt(world, end.x, end.y, end.z - 2, false));
					player.world.addWeatherEffect(new EntityLightningBolt(world, end.x, end.y, end.z, false));
					player.getCooldownTracker().setCooldown(this, 60);
					stack.damageItem(1, player);
				}
				return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
			} else {
				BlockPos blockPos = position.getBlockPos();
				int x = blockPos.getX();
				int y = blockPos.getY();
				int z = blockPos.getZ();

				player.world.addWeatherEffect(new EntityLightningBolt(world, x + 2, y, z, false));
				player.world.addWeatherEffect(new EntityLightningBolt(world, x - 2, y, z, false));
				player.world.addWeatherEffect(new EntityLightningBolt(world, x, y, z + 2, false));
				player.world.addWeatherEffect(new EntityLightningBolt(world, x, y, z - 2, false));
				player.world.addWeatherEffect(new EntityLightningBolt(world, x, y, z, false));
				player.getCooldownTracker().setCooldown(this, 60);
				stack.damageItem(1, player);
			}
			return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
		}
		return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip()) {
			tooltip.add(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor()
					+ I18n.format(this.getUnlocalizedName() + ".annotation1") + " " + TextFormatting.YELLOW + "60" + " "
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