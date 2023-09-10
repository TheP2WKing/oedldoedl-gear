package net.thep2wking.oedldoedlgear.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityChargedSnowball extends EntityThrowable {
	public EntityChargedSnowball(World worldIn) {
		super(worldIn);
	}

	public EntityChargedSnowball(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityChargedSnowball(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public static void registerFixesSnowball(DataFixer fixer) {
		EntityThrowable.registerFixesThrowable(fixer, "ChargedSnowball");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; ++i) {
				this.world.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	public void onImpact(RayTraceResult result) {
		if (result.entityHit != null && !this.world.isRemote) {
			int i = 2;
			if (result.entityHit instanceof EntityBlaze) {
				i = 5;
			}
			result.entityHit.world
					.addWeatherEffect(new EntityLightningBolt(world, result.entityHit.getPosition().getX(),
							result.entityHit.getPosition().getY(), result.entityHit.getPosition().getZ(), false));
			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float) i);
		}
		if (!this.world.isRemote) {
			this.world.setEntityState(this, (byte) 3);
			world.addWeatherEffect(new EntityLightningBolt(world, this.getPosition().getX(), this.getPosition().getY(),
					this.getPosition().getZ(), false));
			this.setDead();
		}
	}
}