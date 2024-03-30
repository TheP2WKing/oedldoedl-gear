package net.thep2wking.oedldoedlgear.content.item.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
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
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.content.tile.TileTransparentReplacement;
import net.thep2wking.oedldoedlgear.init.ModBlocks;
import net.thep2wking.oedldoedlgear.init.ModSounds;

public class ItemMosesStaff extends ModItemBase {
	private TimerTask timerTask;
	private boolean firstUse = true;

	public class PosAndState {
		public BlockPos pos;
		public IBlockState state;

		public PosAndState(BlockPos pos, IBlockState state) {
			this.pos = pos;
			this.state = state;
		}
	}

	private static List<PosAndState> STORED = new ArrayList<>();

	public ItemMosesStaff(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
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

	public void startTimer() {
		Timer timer = new Timer();
		timerTask = new TimerTask() {
			@Override
			public void run() {
				STORED.clear();
				firstUse = true;
			}
		};
		timer.schedule(timerTask, 30000);
	}

	public void abortTimer() {
		if (timerTask != null) {
			timerTask.cancel();
			timerTask = null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		int distance = GearConfig.CONTENT.STAFFS.MOSES_STAFF_RANGE;
		Vec3d vector = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw);
		double x = player.posX;
		double z = player.posZ;
		double lastX = 0;
		double lastZ = 0;
		int count = 0;
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos((int) x, (int) player.posY + 2, (int) z);
		BlockPos.MutableBlockPos lastChecker = new BlockPos.MutableBlockPos();
		BlockPos.MutableBlockPos placePos = new BlockPos.MutableBlockPos();
		if (!world.isRemote && !player.isSneaking()) {
			if (firstUse && STORED.isEmpty()) {
				while (count < distance) {
					lastChecker.setPos(lastX, player.posY + 2, lastZ);
					if (!lastChecker.equals(pos)) {
						if (player.posY + 2 >= world.getHeight() || player.posY + 2 <= 0)
							break;
						for (int i = -2; i < 3; i++) {
							for (int j = -(GearConfig.CONTENT.STAFFS.MOSES_STAFF_VERTICAL_EXTENSION); j < GearConfig.CONTENT.STAFFS.MOSES_STAFF_VERTICAL_EXTENSION; j++) {
								for (int k = -2; k < 3; k++) {
									placePos.setPos(pos.getX() + i, pos.getY() + j, pos.getZ() + k);
									if (world.getBlockState(placePos).getBlock()
											.getMaterial(world.getBlockState(placePos)) == Material.WATER
											|| (world.getBlockState(placePos).getBlock()
													.getMaterial(world.getBlockState(placePos)) == Material.LAVA)
													&& GearConfig.CONTENT.STAFFS.MOSES_STAFF_CAN_SPLIT_LAVA) {
										IBlockState originalState = world.getBlockState(placePos);
										world.setBlockState(placePos, ModBlocks.TRANSPARENT_REPLACEMENT.getDefaultState(), 3);
										TileEntity te = world.getTileEntity(placePos);
										if (te instanceof TileTransparentReplacement) {
											((TileTransparentReplacement) te).setOriginalState(originalState);
										}
										BlockPos immutablePos = new BlockPos(placePos.getX(), placePos.getY(),
												placePos.getZ());
										STORED.add(new PosAndState(immutablePos, originalState));
									}
								}
							}
						}
						count++;
					}
					lastX = x;
					lastZ = z;
					x += vector.x;
					z += vector.z;
					pos.setPos(x, player.posY + 2, z);
				}
				startTimer();
				firstUse = false;
			} else {
				abortTimer();
				List<PosAndState> storedCopy = new ArrayList<>(STORED);
				for (PosAndState posAndState : storedCopy) {
					world.setBlockState(posAndState.pos, posAndState.state, 3);
				}
				STORED.clear();
				firstUse = true;
			}
		} else if (!world.isRemote && player.isSneaking() && GearConfig.CONTENT.STAFFS.MOSES_STAFF_CAN_CONVERT_WATER) {
			double reach = player.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue();
			Vec3d startVec = player.getPositionVector().addVector(0, player.getEyeHeight(), 0);
			Vec3d lookVec = player.getLookVec();
			Vec3d endVec = startVec.addVector(lookVec.x * reach, lookVec.y * reach, lookVec.z * reach);
			RayTraceResult result = world.rayTraceBlocks(startVec, endVec, true, false, false);
			if (result != null && result.typeOfHit == RayTraceResult.Type.BLOCK) {
				BlockPos blockPos = result.getBlockPos();
				IBlockState blockState = world.getBlockState(blockPos);
				if (blockState.getBlock().getMaterial(blockState) == Material.WATER) {
					world.setBlockState(blockPos, ModBlocks.MOSES_BLOOD.getDefaultState(), 3);
				}
			}
		}
		world.playSound(null, player.getPosition(), ModSounds.MOSES, SoundCategory.AMBIENT, 4f,
				1f);
		player.getCooldownTracker().setCooldown(this, GearConfig.CONTENT.STAFFS.MOSES_STAFF_COOLDOWN);
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
					+ GearConfig.CONTENT.STAFFS.MOSES_STAFF_RANGE
					+ (GearConfig.CONTENT.STAFFS.MOSES_STAFF_CAN_CONVERT_WATER
							? (" " + TextFormatting.ITALIC + I18n.format(this.getUnlocalizedName() + ".annotation2"))
							: ""));
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