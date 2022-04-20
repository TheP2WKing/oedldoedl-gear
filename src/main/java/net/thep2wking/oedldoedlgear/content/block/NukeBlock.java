package net.thep2wking.oedldoedlgear.content.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.TNTBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlgear.content.entity.NukeEntity;
import net.thep2wking.oedldoedlgear.init.ModSounds;

public class NukeBlock extends TNTBlock
{
	public static final BooleanProperty UNSTABLE = BlockStateProperties.UNSTABLE;
	
	public NukeBlock(SoundType sound, int harvestLevel, float hardness, float resistance, int lightLevel, Properties properties) 
	{
		super(properties.sound(SoundType.PLANT));
		this.setDefaultState(this.getDefaultState().with(UNSTABLE, Boolean.valueOf(false)));
	}

	public void catchFire(BlockState state, World world, BlockPos pos, @Nullable Direction face, @Nullable LivingEntity igniter) 
	{
		explode(world, pos, igniter);
	}

	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) 
	{
		if (!oldState.matchesBlock(state.getBlock())) 
		{
			if (worldIn.isBlockPowered(pos)) 
			{
	            catchFire(state, worldIn, pos, null, null);
	            worldIn.removeBlock(pos, false);
			}
		}
	}

	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) 
	{
		if (worldIn.isBlockPowered(pos)) 
		{
			catchFire(state, worldIn, pos, null, null);
			worldIn.removeBlock(pos, false);
		}
	}
   
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) 
   	{
		if (!worldIn.isRemote() && !player.isCreative() && state.get(UNSTABLE)) 
		{
			catchFire(state, worldIn, pos, null, null);
		}
		super.onBlockHarvested(worldIn, pos, state, player);
   	}

	public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn)
	{
		if (!worldIn.isRemote)
		{
			NukeEntity tntentity = new NukeEntity(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, explosionIn.getExplosivePlacedBy());
			tntentity.setFuse((short)(worldIn.rand.nextInt(tntentity.getFuse() / 4) + tntentity.getFuse() / 8));
			worldIn.addEntity(tntentity);
		}
	}

	public static void explode(World world, BlockPos worldIn) 
	{
		explode(world, worldIn, (LivingEntity)null);
	}

	private static void explode(World worldIn, BlockPos pos, @Nullable LivingEntity entityIn) 
	{
		if (!worldIn.isRemote) 
		{
			NukeEntity tntentity = new NukeEntity(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, entityIn);
			worldIn.addEntity(tntentity);
			worldIn.playSound((PlayerEntity)null, tntentity.getPosX(), tntentity.getPosY(), tntentity.getPosZ(), ModSounds.NUKE_ALARM.get(), SoundCategory.BLOCKS, 10.0F, 1.0F);
		}
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
	{
		return ActionResultType.FAIL;
	}

	@Override
	public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) 
	{

	}

	public boolean canDropFromExplosion(Explosion explosionIn) 
   	{
		return false;
   	}
   
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) 
	{
		builder.add(UNSTABLE);
   	}
}