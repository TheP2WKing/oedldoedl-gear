package net.thep2wking.oedldoedlgear.content.entity;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.thep2wking.oedldoedlgear.init.ModEntities;

public class NukeEntity extends Entity
{
	private static final DataParameter<Integer> FUSE = EntityDataManager.createKey(NukeEntity.class, DataSerializers.VARINT);
	@Nullable
	private LivingEntity igniter;
	private int fuse = 600;

	public NukeEntity(EntityType<? extends Entity> type, World worldIn) 
	{
		super(type, worldIn);
		this.preventEntitySpawning = true;
	}

	public NukeEntity(World worldIn, double x, double y, double z, @Nullable LivingEntity igniter) 
	{
		this(ModEntities.NUKE.get(), worldIn);
		this.setPosition(x, y, z);
		double d0 = worldIn.rand.nextDouble() * (double)((float)Math.PI * 2F);
		this.setMotion(-Math.sin(d0) * 0.02D, (double)0.2F, -Math.cos(d0) * 0.02D);
		this.setFuse(600);
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		this.igniter = igniter;
	}

	protected void registerData() 
	{
		this.dataManager.register(FUSE, 600);
	}

	protected boolean canTriggerWalking() 
	{
		return false;
	}

	@SuppressWarnings("deprecation")
	public boolean canBeCollidedWith() 
	{
		return !this.removed;
	}

	public void tick() 
	{
		if (!this.hasNoGravity()) 
		{
			this.setMotion(this.getMotion().add(0.0D, -0.04D, 0.0D));
		}
		this.move(MoverType.SELF, this.getMotion());
		this.setMotion(this.getMotion().scale(0.98D));
		if (this.onGround) 
		{
			this.setMotion(this.getMotion().mul(0.7D, -0.5D, 0.7D));
		}

		--this.fuse;
		if (this.fuse <= 0) 
		{
			this.remove();
			if (!this.world.isRemote) 
			{
				this.explode();
			}
		}
		else 
		{
			this.func_233566_aG_();
			if (this.world.isRemote) 
			{
				this.world.addParticle(ParticleTypes.FLAME, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), 0.0D, 0.0D, 0.0D);
				this.world.addParticle(ParticleTypes.LAVA, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), 0.0D, 0.0D, 0.0D);
				this.world.addParticle(ParticleTypes.LARGE_SMOKE, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	protected void explode() 
	{
		this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.0625D), this.getPosZ(), 100.0F, true, Explosion.Mode.DESTROY);  
	}

	protected void writeAdditional(CompoundNBT compound) 
	{
		compound.putShort("Fuse", (short)this.getFuse());
	}

	protected void readAdditional(CompoundNBT compound) 
	{
		this.setFuse(compound.getShort("Fuse"));
	}

	@Nullable
	public LivingEntity getIgniter() 
	{
		return this.igniter;
	}

	protected float getEyeHeight(Pose poseIn, EntitySize sizeIn) 
	{
		return 0.15F;
	}

	public void setFuse(int fuseIn) 
	{
		this.dataManager.set(FUSE, fuseIn);
		this.fuse = fuseIn;
	}

	public void notifyDataManagerChange(DataParameter<?> key) 
	{
		if (FUSE.equals(key)) 
		{
			this.fuse = this.getFuseDataManager();
		}
	}

	public int getFuseDataManager() 
	{
		return this.dataManager.get(FUSE);
	}

	public int getFuse() 
	{
		return this.fuse;
	}

	@Override
	public IPacket<?> createSpawnPacket()
	{
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}