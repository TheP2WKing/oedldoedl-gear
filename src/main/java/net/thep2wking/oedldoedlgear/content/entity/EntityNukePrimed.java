package net.thep2wking.oedldoedlgear.content.entity;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityNukePrimed extends Entity {
    public static final DataParameter<Integer> FUSE = EntityDataManager.<Integer>createKey(EntityNukePrimed.class,
            DataSerializers.VARINT);
    @Nullable
    public EntityLivingBase tntPlacedBy;
    public int fuse;

    public EntityNukePrimed(World worldIn) {
        super(worldIn);
        this.fuse = 600;
        this.preventEntitySpawning = true;
        this.isImmuneToFire = true;
        this.setSize(0.98F, 0.98F);
    }

    public EntityNukePrimed(World worldIn, double x, double y, double z, EntityLivingBase igniter) {
        this(worldIn);
        this.setPosition(x, y, z);
        float f = (float) (Math.random() * (Math.PI * 2D));
        this.motionX = (double) (-((float) Math.sin((double) f)) * 0.02F);
        this.motionY = 0.20000000298023224D;
        this.motionZ = (double) (-((float) Math.cos((double) f)) * 0.02F);
        this.setFuse(600);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
        this.tntPlacedBy = igniter;
    }

    public void entityInit() {
        this.dataManager.register(FUSE, Integer.valueOf(600));
    }

    public boolean canTriggerWalking() {
        return false;
    }

    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (!this.hasNoGravity()) {
            this.motionY -= 0.03999999910593033D;
        }

        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;

        if (this.onGround) {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
        }

        --this.fuse;

        if (this.fuse <= 0) {
            this.setDead();

            if (!this.world.isRemote) {
                this.explode();
            }
        } else {
            this.handleWaterMovement();
            this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D,
                    0.0D);
            this.world.spawnParticle(EnumParticleTypes.LAVA, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    }

    public void explode() {
        this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 50.0F, true, true);
        this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F) - 5, this.posZ, 50.0F,
                true, true);
        this.world.newExplosion(this, this.posX + 10, this.posY + (double) (this.height / 16.0F), this.posZ, 50.0F,
                true, true);
        this.world.newExplosion(this, this.posX - 10, this.posY + (double) (this.height / 16.0F), this.posZ, 50.0F,
                true, true);
        this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ + 10, 50.0F,
                true, true);
        this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ - 10, 50.0F,
                true, true);
    }

    public void writeEntityToNBT(NBTTagCompound compound) {
        compound.setShort("Fuse", (short) this.getFuse());
    }

    public void readEntityFromNBT(NBTTagCompound compound) {
        this.setFuse(compound.getShort("Fuse"));
    }

    @Nullable
    public EntityLivingBase getTntPlacedBy() {
        return this.tntPlacedBy;
    }

    public float getEyeHeight() {
        return 0.0F;
    }

    public void setFuse(int fuseIn) {
        this.dataManager.set(FUSE, Integer.valueOf(fuseIn));
        this.fuse = fuseIn;
    }

    public void notifyDataManagerChange(DataParameter<?> key) {
        if (FUSE.equals(key)) {
            this.fuse = this.getFuseDataManager();
        }
    }

    public int getFuseDataManager() {
        return ((Integer) this.dataManager.get(FUSE)).intValue();
    }

    public int getFuse() {
        return this.fuse;
    }
}