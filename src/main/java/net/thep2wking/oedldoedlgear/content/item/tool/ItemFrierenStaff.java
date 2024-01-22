package net.thep2wking.oedldoedlgear.content.item.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.content.entity.EntityMagic;
import net.thep2wking.oedldoedlgear.init.ModBlocks;
import net.thep2wking.oedldoedlgear.util.Vector3;

public class ItemFrierenStaff extends ModItemBase {
	public ItemFrierenStaff(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
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
		return (repair != null && repair.isItemEqual(new ItemStack(Item.getItemFromBlock(ModBlocks.MAGICAL_WOOD))))
				|| super.getIsRepairable(toRepair, repair);
	}

	public final Vec3d getVectorForRotation(float pitch, float yaw)
    {
        float f = MathHelper.cos(-yaw * 0.017453292F - (float)Math.PI);
        float f1 = MathHelper.sin(-yaw * 0.017453292F - (float)Math.PI);
        float f2 = -MathHelper.cos(-pitch * 0.017453292F);
        float f3 = MathHelper.sin(-pitch * 0.017453292F);
        return new Vec3d((double)(f1 * f2), (double)f3, (double)(f * f2));
    }


	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);

		// if (!world.isRemote) {
		// int dis = 4;
		// List<Entity> list = world.loadedEntityList;
		// for (Entity e : list) {
		// if (!(e.getDistance((Entity) player) <= (float) dis) || e == player)
		// continue;
		// if (e instanceof EntityLivingBase) {
		// EntityLivingBase base = (EntityLivingBase) e;
		// base.setHealth(0);
		// Vec3d vec = player.getLookVec();
		// e.addVelocity(vec.x / 30.0, 0.2, vec.z / 30.0);
		// e.attackEntityFrom(DamageSource.ON_FIRE, 0.0f);
		// }
		// }
		// Vec3d vec = player.getLookVec();
		// double dx = player.posX + vec.x * 2.0;
		// double dy = player.posY + (double)player.getEyeHeight();
		// double dz = player.posZ + vec.z * 2.0;
		// world.playSound(player, player.posX, player.posY, player.posZ,
		// SoundEvents.ENTITY_GHAST_SHOOT,
		// SoundCategory.AMBIENT, 5.0f, 1.0f);
		// Random rand = new Random();
		// float yaw = player.rotationYaw;
		// float pitch = player.rotationPitch;
		// // float f = 1.0f;
		// float x = (float) (-Math.sin(Math.toRadians(yaw)));
		// float z = (float) Math.cos(Math.toRadians(yaw));
		// double y = -Math.sin(Math.toRadians(pitch));
		// for (int i = 0; i < 8; ++i) {
		// world.spawnParticle(EnumParticleTypes.FLAME, player.posX, player.posY + 1.0,
		// player.posZ,
		// ((double) (x + rand.nextFloat()) - 0.5) / 2.0, (y + (double) rand.nextFloat()
		// - 0.5) / 8.0,
		// ((double) (z + rand.nextFloat()) - 0.5) / 2.0, new int[] { 0 });
		// }
		// }

		// if (!world.isRemote) {
		// double vecX = (double) (-MathHelper.sin(player.rotationYaw / 180.0F * (float)
		// Math.PI)
		// * MathHelper.cos(player.rotationPitch / 180.0F * (float) Math.PI));
		// double vecY = (double) (-MathHelper.sin(player.rotationPitch / 180.0F *
		// (float) Math.PI));
		// double vecZ = (double) (MathHelper.cos(player.rotationYaw / 180.0F * (float)
		// Math.PI)
		// * MathHelper.cos(player.rotationPitch / 180.0F * (float) Math.PI));
		// double deltaX = (double) (-MathHelper.sin(player.rotationYaw / 180.0F *
		// (float) Math.PI));
		// double deltaZ = (double) (MathHelper.cos(player.rotationYaw / 180.0F *
		// (float) Math.PI));
		// EntityMagic fireball = new EntityMagic(world, player.posX + deltaX,
		// player.posY + 0, player.posZ + deltaZ, vecX, vecY, vecZ);
		// EntityMagic fireball2 = new EntityMagic(world, player.posX + deltaX,
		// player.posY + 1, player.posZ + deltaZ, vecX, vecY, vecZ);
		// EntityMagic fireball3 = new EntityMagic(world, player.posX + deltaX,
		// player.posY + 2, player.posZ + deltaZ, vecX, vecY, vecZ);
		// EntityMagic fireball4 = new EntityMagic(world, player.posX + deltaX + deltaZ,
		// player.posY + 1, player.posZ + deltaZ + deltaX, vecX, vecY, vecZ);
		// EntityMagic fireball5 = new EntityMagic(world, player.posX + deltaX - deltaZ,
		// player.posY + 1, player.posZ + deltaZ - deltaX, vecX, vecY, vecZ);

		// ModLogger.LOGGER.info(deltaX);
		// ModLogger.LOGGER.info(deltaZ);

		// ModLogger.LOGGER.info(deltaX);
		// ModLogger.LOGGER.info(deltaZ);

		// world.spawnEntity(fireball);
		// world.spawnEntity(fireball2);
		// world.spawnEntity(fireball3);
		// world.spawnEntity(fireball4);
		// world.spawnEntity(fireball5);
		// }

		// if (player.isSneaking()) {
		// float f = 2.5f;
		// double motionX = -MathHelper.sin((float) (player.rotationYaw / 180.0f *
		// (float) Math.PI))
		// * MathHelper.cos((float) (player.rotationPitch / 180.0f * (float) Math.PI)) *
		// f;
		// double motionZ = MathHelper.cos((float) (player.rotationYaw / 180.0f *
		// (float) Math.PI))
		// * MathHelper.cos((float) (player.rotationPitch / 180.0f * (float) Math.PI)) *
		// f;
		// double motionY = -MathHelper.sin((float) (player.rotationPitch / 180.0f *
		// (float) Math.PI)) * f;
		// if (world instanceof WorldServer) {
		// player.addVelocity(motionX, motionY, motionZ);
		// } else {
		// player.setVelocity(motionX, motionY, motionZ);
		// }
		// player.swingArm(hand);
		// world.playSound(player, player.posX, player.posY, player.posZ,
		// (SoundEvent) SoundEvent.REGISTRY.getObject(new
		// ResourceLocation("entity.firework.launch")),
		// SoundCategory.AMBIENT, 10.0f, 1.0f);

		// stack.damageItem(1, player);
		// return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
		// }

		Vec3d lookVec = player.getLookVec();
		Vec3d start = new Vec3d(player.posX, player.posY + player.getEyeHeight(), player.posZ);
		int distance = GearConfig.CONTENT.STAFFS.FRIEREN_STAFF_RANGE;
		boolean gothrough = false;

		if (player.isSneaking()) {
			distance = (distance - 2) / 2;
		}
		Vec3d end = start.addVector(lookVec.x * distance, lookVec.y * distance, lookVec.z * distance);
		RayTraceResult position = gothrough ? null : world.rayTraceBlocks(start, end);

		double vecX = (double) (-MathHelper.sin(player.rotationYaw / 180.0F * (float) Math.PI)	* MathHelper.cos(player.rotationPitch / 180.0F * (float) Math.PI));
		double vecY = (double) (-MathHelper.sin(player.rotationPitch / 180.0F * (float) Math.PI));
		double vecZ = (double) (MathHelper.cos(player.rotationYaw / 180.0F * (float) Math.PI)	* MathHelper.cos(player.rotationPitch / 180.0F * (float) Math.PI));
		// double deltaX = (double) (-MathHelper.sin(player.rotationYaw / 180.0F * (float) Math.PI));
		// double deltaZ = (double) (MathHelper.cos(player.rotationYaw / 180.0F * (float) Math.PI));

				Vec3d vector = new Vec3d(vecX, vecY, vecZ); //new Vector3(player.getLookVec()).normalize();

				ModLogger.LOGGER.info(vector);

		if (gothrough) {
			position = null;
		}
		if (position == null) {
			if (gothrough) {
			} else {
				Block place = ModBlocks.BADROCK;

				// Vec3d vector = new Vec3d(null);

				double x = player.posX;
				double y = player.posY + 2;
				double z = player.posZ;
				BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos((int) x, (int) y, (int) z);

				double lastX = 0;
				double lastY = 0;
				double lastZ = 0;
				BlockPos.MutableBlockPos lastChecker = new BlockPos.MutableBlockPos();

				int count = 0;
				BlockPos.MutableBlockPos placePos = new BlockPos.MutableBlockPos();
				while (count < distance) {
					lastChecker.setPos(lastX, lastY, lastZ);

					if (!lastChecker.equals(pos)) {
						if (y >= world.getHeight() || y <= 0
								|| !world.isAirBlock(pos) && world.getBlockState(pos).getBlock() != place)
							break;

							world.playSound(null, player.getPosition(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.AMBIENT, 0.25F, 1.0f);

							for (int i = -1; i < 2; i++)		//- 1 2			
							for (int j = -1; j < 2; j++) {//- 1 2	
								for (int k = -1; k < 2; k++) {//- 1 2	
									placePos.setPos(pos.getX() + i, pos.getY() + k, pos.getZ() + j);

									world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, placePos.getX(),
									placePos.getY(), placePos.getZ(), 0.0D, 0.0D, 0.0D);
									List<EntityLivingBase> entity =
									world.getEntitiesWithinAABB(EntityLivingBase.class, new
									AxisAlignedBB(placePos));
									for(EntityLivingBase ent : entity) {
										if(ent != player) {
											ent.attackEntityFrom(DamageSource.MAGIC, 5);
										}
									}

									// if (world.isAirBlock(placePos)
									// 		|| world.getBlockState(placePos).getBlock() == place) {
									// 	world.setBlockState(placePos, place.getDefaultState(), 2);
									// }
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

				// world.playSound(null, player.getPosition(), ModSounds.MEGUMIN,
				// SoundCategory.AMBIENT, 1f, 1f);
				// player.world.newExplosion(null, end.x, end.y, end.z,
				// GearConfig.CONTENT.STAFFS.EXPLOSION_STAFF_EXPLOSION_STRENGTH,
				// GearConfig.CONTENT.STAFFS.EXPLOSION_STAFF_EXPLOSION_FIRE,
				// GearConfig.CONTENT.STAFFS.EXPLOSION_STAFF_EXPLOSION_DAMAGE);
				// if (GearConfig.CONTENT.STAFFS.EXPLOSION_STAFF_SPAWNS_LIGHTNING) {
				// player.world.addWeatherEffect(new EntityLightningBolt(world, end.x, end.y,
				// end.z, false));
				// }
				// if (!player.capabilities.isCreativeMode &&
				// GearConfig.CONTENT.STAFFS.EXPLOSION_STAFF_DEBUFFS) {
				// player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 60, 0, false,
				// false));
				// player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 9, false,
				// false));
				// player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 200, 1, false,
				// false));
				// }
				// player.getCooldownTracker().setCooldown(this,
				// GearConfig.CONTENT.STAFFS.FRIEREN_STAFF_COOLDOWN);
				stack.damageItem(1, player);
				player.swingArm(hand);
			}
			return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
		} else {
			Block place = ModBlocks.BADROCK;

			// Vec3d vector = new Vec3d(null);

			double x = player.posX;
			double y = player.posY + 2;
			double z = player.posZ;
			BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos((int) x, (int) y, (int) z);

			double lastX = 0;
			double lastY = 0;
			double lastZ = 0;
			BlockPos.MutableBlockPos lastChecker = new BlockPos.MutableBlockPos();

			int count = 0;
			BlockPos.MutableBlockPos placePos = new BlockPos.MutableBlockPos();
			while (count < distance) {
				lastChecker.setPos(lastX, lastY, lastZ);

				if (!lastChecker.equals(pos)) {
					if (y >= world.getHeight() || y <= 0
							|| !world.isAirBlock(pos) && world.getBlockState(pos).getBlock() != place)
						break;

						world.playSound(null, player.getPosition(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.AMBIENT, 0.25F, 1.0f);


						for (int i = -1; i < 2; i++)		//- 1 2			
						for (int j = -1; j < 2; j++) {//- 1 2	
							for (int k = -1; k < 2; k++) {//- 1 2	
								placePos.setPos(pos.getX() + i, pos.getY() + k, pos.getZ() + j);

								world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, placePos.getX(),
								placePos.getY(), placePos.getZ(), 0.0D, 0.0D, 0.0D);
								List<EntityLivingBase> entity =
								world.getEntitiesWithinAABB(EntityLivingBase.class, new
								AxisAlignedBB(placePos));
								for(EntityLivingBase ent : entity) {
									if(ent != player) {
										ent.attackEntityFrom(DamageSource.MAGIC, 5);
									}
								}

								// if (world.isAirBlock(placePos)
								// 		|| world.getBlockState(placePos).getBlock() == place) {
								// 	world.setBlockState(placePos, place.getDefaultState(), 2);
								// }
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
			// world.playSound(null, player.getPosition(), ModSounds.MEGUMIN,
			// SoundCategory.AMBIENT, 4f, 1f);
			// player.world.newExplosion(null, x, y, z,
			// GearConfig.CONTENT.STAFFS.EXPLOSION_STAFF_EXPLOSION_STRENGTH,
			// GearConfig.CONTENT.STAFFS.EXPLOSION_STAFF_EXPLOSION_FIRE,
			// GearConfig.CONTENT.STAFFS.EXPLOSION_STAFF_EXPLOSION_DAMAGE);
			// if (GearConfig.CONTENT.STAFFS.EXPLOSION_STAFF_SPAWNS_LIGHTNING) {
			// player.world.addWeatherEffect(new EntityLightningBolt(world, end.x, end.y,
			// end.z, false));
			// }
			// if (!player.capabilities.isCreativeMode &&
			// GearConfig.CONTENT.STAFFS.EXPLOSION_STAFF_DEBUFFS) {
			// player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 60, 0, false,
			// false));
			// player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 9, false,
			// false));
			// player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 200, 1, false,
			// false));
			// }
			// player.getCooldownTracker().setCooldown(this,
			// GearConfig.CONTENT.STAFFS.FRIEREN_STAFF_COOLDOWN);
			stack.damageItem(1, player);
			player.swingArm(hand);
		}
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