package net.thep2wking.oedldoedlgear.content.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.thep2wking.oedldoedlcore.api.fluid.ModBlockFluidBase;
import net.thep2wking.oedldoedlgear.OedldoedlGear;

public class BlockFluidDeath extends ModBlockFluidBase {
	public static final DamageSource DAMAGE_SOURCE = new DamageSource(OedldoedlGear.MODID + ".death")
			.setMagicDamage();

	public BlockFluidDeath(String modid, String name, Fluid fluid, Material material, MapColor mapColor) {
		super(modid, name, fluid, material, mapColor);
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
		if (entityIn instanceof EntityLivingBase) {
			((EntityLivingBase) entityIn).attackEntityFrom(DAMAGE_SOURCE, 14.0f);
		}
	}
}