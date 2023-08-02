package net.thep2wking.oedldoedlgear.content.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlgear.content.entity.EntityNukePrimed;
import net.thep2wking.oedldoedlgear.init.ModSounds;

public class BlockNuke extends BlockTNT {
	public final String modid;
	public final String name;
	public final CreativeTabs tab;
	public final SoundType sound;
	public final MapColor mapColor;
	public final int lightLevel;
	public static final PropertyBool EXPLODE = PropertyBool.create("explode");

	public BlockNuke(String modid, String name, CreativeTabs tab, SoundType sound, MapColor mapColor, int lightLevel) {
		super();
		this.modid = modid;
		this.name = name;
		this.tab = tab;
		this.sound = sound;
		this.mapColor = mapColor;
		this.lightLevel = lightLevel;
		setUnlocalizedName(this.modid + "." + this.name);
		setRegistryName(this.modid + ":" + this.name);
		setCreativeTab(this.tab);
		setSoundType(this.sound);
		this.setDefaultState(this.blockState.getBaseState().withProperty(EXPLODE, Boolean.valueOf(false)));
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		if (worldIn.isBlockPowered(pos)) {
			this.onBlockDestroyedByPlayer(worldIn, pos, state.withProperty(EXPLODE, Boolean.valueOf(true)));
			worldIn.setBlockToAir(pos);
		}
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (worldIn.isBlockPowered(pos)) {
			this.onBlockDestroyedByPlayer(worldIn, pos, state.withProperty(EXPLODE, Boolean.valueOf(true)));
			worldIn.setBlockToAir(pos);
		}
	}

	@Override
	public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
		if (!worldIn.isRemote) {
			EntityNukePrimed entitytntprimed = new EntityNukePrimed(worldIn, (double) ((float) pos.getX() + 0.5F),
					(double) pos.getY(), (double) ((float) pos.getZ() + 0.5F), explosionIn.getExplosivePlacedBy());
			entitytntprimed.setFuse(entitytntprimed.getFuse());
			worldIn.spawnEntity(entitytntprimed);
			worldIn.playSound((EntityPlayer) null, entitytntprimed.posX, entitytntprimed.posY, entitytntprimed.posZ,
			ModSounds.NUKE_ALARM, SoundCategory.BLOCKS, 5.0F, 1.0F);
		}
	}

	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		this.explode(worldIn, pos, state, (EntityLivingBase) null);
	}

	@Override
	public void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
		if (!worldIn.isRemote) {
			if (((Boolean) state.getValue(EXPLODE)).booleanValue()) {
				EntityNukePrimed entitytntprimed = new EntityNukePrimed(worldIn, (double) ((float) pos.getX() + 0.5F),
						(double) pos.getY(), (double) ((float) pos.getZ() + 0.5F), igniter);
				worldIn.spawnEntity(entitytntprimed);
				worldIn.playSound((EntityPlayer) null, entitytntprimed.posX, entitytntprimed.posY, entitytntprimed.posZ,
						ModSounds.NUKE_ALARM, SoundCategory.BLOCKS, 5.0F, 1.0F);
			}
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		return false;
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (!worldIn.isRemote && entityIn instanceof EntityArrow) {
			EntityArrow entityarrow = (EntityArrow) entityIn;

			if (entityarrow.isBurning()) {
				this.explode(worldIn, pos, worldIn.getBlockState(pos).withProperty(EXPLODE, Boolean.valueOf(true)),
						entityarrow.shootingEntity instanceof EntityLivingBase
								? (EntityLivingBase) entityarrow.shootingEntity
								: null);
				worldIn.setBlockToAir(pos);
			}
		}
	}

	@Override
	public boolean canDropFromExplosion(Explosion explosionIn) {
		return false;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(EXPLODE, Boolean.valueOf((meta & 1) > 0));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Boolean) state.getValue(EXPLODE)).booleanValue() ? 1 : 0;
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { EXPLODE });
	}
}