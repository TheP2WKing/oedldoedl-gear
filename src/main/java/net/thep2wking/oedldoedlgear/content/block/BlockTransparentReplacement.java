package net.thep2wking.oedldoedlgear.content.block;

import java.util.Random;

import javax.annotation.Nullable;

import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thep2wking.oedldoedlcore.api.block.ModBlockBase;
import net.thep2wking.oedldoedlcore.integration.top.ITOPInfoProvider;
import net.thep2wking.oedldoedlcore.util.ModToolTypes;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.content.tile.TileTransparentReplacement;

public class BlockTransparentReplacement extends ModBlockBase implements ITileEntityProvider, ITOPInfoProvider {
	public BlockTransparentReplacement(String modid, String name, CreativeTabs tab, Material material, SoundType sound,
			MapColor mapColor, int harvestLevel, ModToolTypes toolType, float hardness, float resistance,
			int lightLevel) {
		super(modid, name, tab, material, sound, mapColor, harvestLevel, toolType, hardness, resistance, lightLevel);
		GameRegistry.registerTileEntity(TileTransparentReplacement.class, this.getRegistryName());
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	@Nullable
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileTransparentReplacement();
	}

	@Override
	public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
			IBlockState blockState, IProbeHitData data) {
		TileTransparentReplacement tile = (TileTransparentReplacement) world.getTileEntity(data.getPos());
		probeInfo.progress(tile.getSeconds(), tile.getMaxSeconds(),
				probeInfo.defaultProgressStyle().suffix(" / " + tile.getMaxSeconds()));
	}

	@Override
	public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world,
			BlockPos pos, EnumFacing side) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public int quantityDropped(Random random) {
		return 0;
	}

	@Override
	public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isCollidable() {
		if (GearConfig.CONTENT.STAFFS.MOSES_STAFF_TRANSPARENT_REPLACEMENT_DEBUG_MODE) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		if (GearConfig.CONTENT.STAFFS.MOSES_STAFF_TRANSPARENT_REPLACEMENT_DEBUG_MODE) {
			return EnumBlockRenderType.MODEL;
		} else {
			return EnumBlockRenderType.INVISIBLE;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
		if (GearConfig.CONTENT.STAFFS.MOSES_STAFF_TRANSPARENT_REPLACEMENT_DEBUG_MODE) {
			return super.getCollisionBoundingBox(state, world, pos);
		} else {
			return NULL_AABB;
		}
	}
}