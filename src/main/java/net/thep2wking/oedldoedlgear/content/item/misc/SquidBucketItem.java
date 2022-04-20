package net.thep2wking.oedldoedlgear.content.item.misc;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.thep2wking.oedldoedlcore.api.ModBucketItemBase;

public class SquidBucketItem extends ModBucketItemBase 
{
    public SquidBucketItem(Supplier<? extends Fluid> supplier, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
    {
		super(supplier, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}
    
	@Override
    public void onLiquidPlaced(World world, ItemStack stack, BlockPos pos) 
	{
        if (world instanceof ServerWorld) 
        {
            SquidEntity entity = spawn(EntityType.SQUID, (ServerWorld) world, pos, SpawnReason.BUCKET);
            if (entity != null) 
            {
                world.addEntity(entity);
            }
        }
    }
    @Override
    protected void playEmptySound(@Nullable PlayerEntity player, IWorld world, BlockPos pos) 
    {
        world.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY_FISH, SoundCategory.NEUTRAL, 1.0F, 1.0F);
    }
    
    public static <T extends Entity> T spawn(EntityType<T> type, ServerWorld world, BlockPos pos, SpawnReason reason) 
    {
        return type.create(world, null, null, null, pos, reason, false, false);
    }
}