package net.thep2wking.oedldoedlgear.content.entity;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class EntityChunkTNTPrimed extends Entity {
    public static final DataParameter<Integer> FUSE = EntityDataManager.<Integer>createKey(EntityChunkTNTPrimed.class,
            DataSerializers.VARINT);
    @Nullable
    private EntityLivingBase tntPlacedBy;
    private int fuse;

    public EntityChunkTNTPrimed(World worldIn) {
        super(worldIn);
        this.fuse = 80;
        this.preventEntitySpawning = true;
        this.isImmuneToFire = true;
        this.setSize(0.98F, 0.98F);
    }

    public EntityChunkTNTPrimed(World worldIn, double x, double y, double z, EntityLivingBase igniter) {
        this(worldIn);
        this.setPosition(x, y, z);
        float f = (float) (Math.random() * (Math.PI * 2D));
        this.motionX = (double) (-((float) Math.sin((double) f)) * 0.02F);
        this.motionY = 0.20000000298023224D;
        this.motionZ = (double) (-((float) Math.cos((double) f)) * 0.02F);
        this.setFuse(80);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
        this.tntPlacedBy = igniter;
    }

    public void entityInit() {
        this.dataManager.register(FUSE, Integer.valueOf(80));
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
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D,
                    0.0D);
        }
    }

    public void explode() {
        this.world.playSound((EntityPlayer) null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE,
                SoundCategory.BLOCKS, 4.0F,
                (1.0F + (this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.2F) * 0.7F);

        Chunk chunk = this.world.getChunkFromBlockCoords(this.getPosition());
        int chunkX = chunk.x;
        int chunkZ = chunk.z;

        int chunkPosX1 = chunkX * 16;
        int chunkPosX2 = chunkX * 16 + 16;
        int chunkPosY1 = 0;
        int chunkPosY2 = 256;
        int chunkPosZ1 = chunkZ * 16;
        int chunkPosZ2 = chunkZ * 16 + 16;

        fillReactangle(this.world, chunkPosX1, chunkPosY1, chunkPosZ1, chunkPosX2, chunkPosY2, chunkPosZ2, Blocks.TNT);
    }

    public static void fillReactangle(World world, int x1, int y1, int z1, int x2, int y2, int z2, Block block) {
        for (int x = x1; x < x2; ++x) {
            for (int y = y1; y < y2; ++y) {
                for (int z = z1; z < z2; ++z) {
                    world.setBlockState(new BlockPos(x, y, z), block.getDefaultState());
                }
            }
        }
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