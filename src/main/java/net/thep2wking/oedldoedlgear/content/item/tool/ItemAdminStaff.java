package net.thep2wking.oedldoedlgear.content.item.tool;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.config.GearConfig;

public class ItemAdminStaff extends ModItemBase {
	public ItemAdminStaff(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		setMaxStackSize(1);
	}

	@Override
	public boolean isDamageable() {
		return false;
	}

	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) {
		return Integer.MAX_VALUE;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (isInCreativeTab(tab)) {
			ItemStack stack = new ItemStack(this);
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("Mode", "Day");
			stack.setTagCompound(compound);
			items.add(stack);
		}
	}

	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("Mode", "Day");
		stack.setTagCompound(compound);
		super.onCreated(stack, worldIn, playerIn);
	}

	public enum Mode {
		Day("/time set day"), Night("/time set night"), Clear("/weather clear"), Rain("/weather rain"),
		Thunder("/weather thunder"), Creative("/gamemode creative"), Survival("/gamemode survival"),;

		public static Mode[] VALUES = values();

		public Mode getNext() {
			return VALUES[(this.ordinal() + 1) % VALUES.length];
		}

		public final String name;

		Mode(String name) {
			this.name = name;
		}

		public String getCommand() {
			return name;
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (GearConfig.CONTENT.ADMINTOOLS.ENABLE_ADMIN_STAFF) {
			ItemStack stack = player.getHeldItem(hand);
			if (!world.isRemote && player.isSneaking()) {
				NBTTagCompound tags = stack.getTagCompound();
				Mode mode = getMode(stack);
				mode = mode.getNext();
				setMode(stack, mode);
				stack.setTagCompound(tags);
				player.swingArm(hand);
				player.sendMessage(
						new TextComponentString(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor()
								+ I18n.format(this.getUnlocalizedName() + ".annotation1"))
								.appendSibling(new TextComponentString(
										" " + TextFormatting.YELLOW + getMode(stack).name().toString())));
				return ActionResult.newResult(EnumActionResult.SUCCESS, stack);

			} else if (!world.isRemote) {
				if (getMode(stack) == Mode.Day || getMode(stack) == Mode.Night || getMode(stack) == Mode.Clear
						|| getMode(stack) == Mode.Rain || getMode(stack) == Mode.Thunder) {
					if (getMode(stack) == Mode.Day) {
						world.getWorldInfo().setWorldTime(1000);
					} else if (getMode(stack) == Mode.Night) {
						world.getWorldInfo().setWorldTime(13000);
					} else if (getMode(stack) == Mode.Clear) {
						world.getWorldInfo().setCleanWeatherTime(0);
						world.getWorldInfo().setRaining(false);
						world.getWorldInfo().setThundering(false);
					} else if (getMode(stack) == Mode.Rain) {
						world.getWorldInfo().setRaining(true);
						world.getWorldInfo().setThundering(false);
					} else if (getMode(stack) == Mode.Thunder) {
						world.getWorldInfo().setRaining(true);
						world.getWorldInfo().setThundering(true);
					}
				}

				if (getMode(stack) == Mode.Creative || getMode(stack) == Mode.Survival) {
					if (getMode(stack) == Mode.Creative) {
						player.setGameType(GameType.CREATIVE);
					} else {
						player.setGameType(GameType.SURVIVAL);
					}
				}
			}
			return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
		}
		return super.onItemRightClick(world, player, hand);
	}

	public static void setMode(ItemStack itemStack, Mode toolMode) {
		NBTTagCompound compound = itemStack.getTagCompound();
		if (compound == null)
			compound = new NBTTagCompound();
		compound.setString("Mode", toolMode.name());
		itemStack.setTagCompound(compound);
	}

	public static Mode getMode(ItemStack itemStack) {
		Mode mode = Mode.Day;
		NBTTagCompound compound = itemStack.getTagCompound();
		if (compound == null) {
			setMode(itemStack, mode);
		} else {
			try {
				mode = Mode.valueOf(compound.getString("Mode"));
			} catch (Exception e) {
				setMode(itemStack, mode);
			}
		}
		return mode;
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings("null")
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip()) {
			if (GearConfig.CONTENT.ADMINTOOLS.ENABLE_ADMIN_STAFF) {
				tooltip.add(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor()
						+ I18n.format(this.getUnlocalizedName() + ".annotation1") + " " + TextFormatting.YELLOW
						+ stack.getTagCompound().getString("Mode"));
			}
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