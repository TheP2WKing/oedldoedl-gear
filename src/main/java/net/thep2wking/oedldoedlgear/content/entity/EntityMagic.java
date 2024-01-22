package net.thep2wking.oedldoedlgear.content.entity;

import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityMagic extends EntityLargeFireball {
	public int ticksAlive;
	public int ticksInAir;

	public EntityMagic(World worldIn) {
		super(worldIn);
		setSize(1, 1);
	}

	@SideOnly(Side.CLIENT)
	public EntityMagic(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(worldIn, x, y, z, accelX, accelY, accelZ);
	}

	public EntityMagic(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
		super(worldIn, shooter, accelX, accelY, accelZ);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isInRangeToRenderDist(double distance) {
		double d0 = this.getEntityBoundingBox().getAverageEdgeLength() * 4.0D;
		if (Double.isNaN(d0)) {
			d0 = 4.0D;
		}
		d0 = d0 * 50.0D;
		return distance < d0 * d0;
	}

	@Override
	public void onUpdate() {
		if (this.world.isRemote || (this.shootingEntity == null || !this.shootingEntity.isDead)
				&& this.world.isBlockLoaded(new BlockPos(this))) {
			// super.onUpdate();
			++this.ticksInAir;
			RayTraceResult raytraceresult = ProjectileHelper.forwardsRaycast(this, true, this.ticksInAir >= 25,
					this.shootingEntity);
			if (raytraceresult != null && !ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
				this.onImpact(raytraceresult);
			}
			this.posX += this.motionX;
			this.posY += this.motionY;
			this.posZ += this.motionZ;
			ProjectileHelper.rotateTowardsMovement(this, 0.2F);
			float f = this.getMotionFactor();
			if (this.isInWater()) {
				for (int i = 0; i < 4; ++i) {
					this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * 0.25D,
							this.posY - this.motionY * 0.25D, this.posZ - this.motionZ * 0.25D, this.motionX,
							this.motionY, this.motionZ);
				}
				f = 0.8F;
			}
			this.motionX += this.accelerationX;
			this.motionY += this.accelerationY;
			this.motionZ += this.accelerationZ;
			this.motionX *= (double) f;
			this.motionY *= (double) f;
			this.motionZ *= (double) f;
			// this.world.spawnParticle(EnumParticleTypes.PORTAL,
			// this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width,
			// this.posY + this.rand.nextDouble() * (double) this.height - 0.25D,
			// this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width,
			// (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(),
			// (this.rand.nextDouble() - 0.5D) * 2.0D);

			this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);

			// this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX, this.posY + 0.5, this.posZ, 0.0D, 0.0D, 0.0D);
			// this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX, this.posY - 0.5, this.posZ, 0.0D, 0.0D, 0.0D);

			// this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + 0.5, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
			// this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX - 0.5, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);

			// this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX, this.posY, this.posZ + 0.5, 0.0D, 0.0D, 0.0D);
			// this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX, this.posY, this.posZ - 0.5, 0.0D, 0.0D, 0.0D);

			// this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
			// this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);

			// this.world.spawnParticle(this.getParticleType(), this.posX, this.posY + 0.5D,e
			// this.posZ, 0.0D, 0.0D, 0.0D);
			this.setPosition(this.posX, this.posY, this.posZ);
		} else {
			this.setDead();
		}
	}

	@Override
	public float getMotionFactor() {
		return 1;
	}

	@Override
	public void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			if (result.entityHit != null) {
				result.entityHit.attackEntityFrom(DamageSource.MAGIC, 12.0F);
				this.applyEnchantments(this.shootingEntity, result.entityHit);
			}
			this.setDead();
		}
	}

	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else {
			this.markVelocityChanged();
			if (source.getTrueSource() != null) {
				Vec3d vec3d = source.getTrueSource().getLookVec();
				if (vec3d != null) {
					this.motionX = vec3d.x;
					this.motionY = vec3d.y;
					this.motionZ = vec3d.z;
					this.accelerationX = this.motionX * 0.1D;
					this.accelerationY = this.motionY * 0.1D;
					this.accelerationZ = this.motionZ * 0.1D;
				}
				if (source.getTrueSource() instanceof EntityLivingBase) {
					this.shootingEntity = (EntityLivingBase) source.getTrueSource();
				}
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public float getBrightness() {
		return 1.0F;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getBrightnessForRender() {
		return 15728880;
	}

	@Override
	public void entityInit() {
	}

	@Override
	public boolean isFireballFiery() {
		return false;
	}
}