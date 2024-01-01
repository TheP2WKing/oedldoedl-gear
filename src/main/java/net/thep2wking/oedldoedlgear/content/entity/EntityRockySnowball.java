package net.thep2wking.oedldoedlgear.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;

public class EntityRockySnowball extends EntityThrowable {
	public EntityRockySnowball(World worldIn) {
		super(worldIn);
	}

	public EntityRockySnowball(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityRockySnowball(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; ++i) {
				this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, 0.0D, 0.0D,
						0.0D, Item.getIdFromItem(ModItems.ROCKY_SNOWBALL));
			}
		}
	}

	@Override
	public void onImpact(RayTraceResult result) {
		if (result.entityHit != null) {
			int i = GearConfig.CONTENT.SNOWBALLS.ROCKY_SNOWBALL_DAMAGE;
			if (result.entityHit instanceof EntityBlaze) {
				i = GearConfig.CONTENT.SNOWBALLS.ROCKY_SNOWBALL_DAMAGE + 3;
			}
			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()),
					(float) i);
		}
		if (!this.world.isRemote) {
			this.world.setEntityState(this, (byte) 3);
			this.setDead();
		}
	}
}