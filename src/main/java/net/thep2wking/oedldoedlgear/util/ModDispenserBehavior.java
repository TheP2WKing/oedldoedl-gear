package net.thep2wking.oedldoedlgear.util;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Util;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;

public class ModDispenserBehavior 
{
	public static void registerModDispenseBehavior()
	{
		DispenserBlock.registerDispenseBehavior(ModItems.EXPLOSIVE_SNOWBALL.get(), new ProjectileDispenseBehavior() 
		{
			protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) 
			{
				return Util.make(new SnowballEntity(worldIn, position.getX(), position.getY(), position.getZ())
				{
	            	@Override
	            	public void onEntityHit(EntityRayTraceResult result)
	            	{
	            		super.onEntityHit(result);
	            		Entity entity = result.getEntity();
	            		int i = entity instanceof BlazeEntity ? 3 : 0;
	            		entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), (float)i);
	            		entity.world.createExplosion(entity, entity.getPosX(), entity.getPosY(), entity.getPosZ(), 1, Mode.BREAK);
	            	}
	            	
	            	@Override
	            	public void onImpact(RayTraceResult result) 
	            	{
	            		super.onImpact(result);
	            	    if (!this.world.isRemote) 
	            	    {
	            	    	this.world.setEntityState(this, (byte)3);
	            	    	this.remove();  
	            	    	this.world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ(), 1, Mode.BREAK);
	            		}   	  
	            	}
				},
				(throwable) -> {throwable.setItem(stackIn);});
	        }
	    });
	      
		DispenserBlock.registerDispenseBehavior(ModItems.ROCKY_SNOWBALL.get(), new ProjectileDispenseBehavior() 
		{
			protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) 
			{
				return Util.make(new SnowballEntity(worldIn, position.getX(), position.getY(), position.getZ())
				{
	            	@Override
	            	public void onEntityHit(EntityRayTraceResult result)
	            	{
	            		super.onEntityHit(result);
	            		Entity entity = result.getEntity();
	            		int i = entity instanceof BlazeEntity ? 3 : 0;
	            		entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), (float)i);
	            		entity.attackEntityFrom(DamageSource.GENERIC, 3f);
	            	}
				},
				(throwable) -> {throwable.setItem(stackIn);});
	        }
	    });
		
		DispenserBlock.registerDispenseBehavior(ModItems.DYNAMITE.get(), new ProjectileDispenseBehavior() 
		{
			protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) 
			{
				return Util.make(new SnowballEntity(worldIn, position.getX(), position.getY(), position.getZ())
				{
	            	@Override
	            	public void onEntityHit(EntityRayTraceResult result)
	            	{
	            		super.onEntityHit(result);
	            		Entity entity = result.getEntity();
	            		entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), 0);
	            		entity.world.createExplosion(entity, entity.getPosX(), entity.getPosY(), entity.getPosZ(), GearConfig.dynamite_strength.get(), Mode.BREAK);
	            	}
	            	
	            	@Override
	            	public void onImpact(RayTraceResult result) 
	            	{
	            		super.onImpact(result);
	            	    if (!this.world.isRemote) 
	            	    {
	            	    	this.world.setEntityState(this, (byte)3);
	            	    	this.remove();  
	            	    	this.world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ(), GearConfig.dynamite_strength.get(), Mode.BREAK);
	            		}   	  
	            	}
				},
				(throwable) -> {throwable.setItem(stackIn);});
	        }
	    });
		
		DispenserBlock.registerDispenseBehavior(ModItems.CHARGED_DYNAMITE.get(), new ProjectileDispenseBehavior() 
		{
			protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) 
			{
				return Util.make(new SnowballEntity(worldIn, position.getX(), position.getY(), position.getZ())
				{
	            	@Override
	            	public void onEntityHit(EntityRayTraceResult result)
	            	{
	            		super.onEntityHit(result);
	            		Entity entity = result.getEntity();
	            		entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), 0);
	            		entity.world.createExplosion(entity, entity.getPosX(), entity.getPosY(), entity.getPosZ(), GearConfig.charged_dynamite_strength.get(), Mode.BREAK);
	            	}
	            	
	            	@Override
	            	public void onImpact(RayTraceResult result) 
	            	{
	            		super.onImpact(result);
	            	    if (!this.world.isRemote) 
	            	    {
	            	    	this.world.setEntityState(this, (byte)3);
	            	    	this.remove();  
	            	    	this.world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ(), GearConfig.charged_dynamite_strength.get(), Mode.BREAK);
	            		}   	  
	            	}
				},
				(throwable) -> {throwable.setItem(stackIn);});
	        }
	    });
		
		DispenserBlock.registerDispenseBehavior(ModItems.COMBAT_DYNAMITE.get(), new ProjectileDispenseBehavior() 
		{
			protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) 
			{
				return Util.make(new SnowballEntity(worldIn, position.getX(), position.getY(), position.getZ())
				{
	            	@Override
	            	public void onEntityHit(EntityRayTraceResult result)
	            	{
	            		super.onEntityHit(result);
	            		Entity entity = result.getEntity();
	            		entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), 0);
	            		entity.world.createExplosion(entity, entity.getPosX(), entity.getPosY(), entity.getPosZ(), GearConfig.combat_dynamite_strength.get(), Mode.NONE);
	            	}
	            	
	            	@Override
	            	public void onImpact(RayTraceResult result) 
	            	{
	            		super.onImpact(result);
	            	    if (!this.world.isRemote) 
	            	    {
	            	    	this.world.setEntityState(this, (byte)3);
	            	    	this.remove();  
	            	    	this.world.createExplosion(null, this.getPosX(), this.getPosY(), this.getPosZ(), GearConfig.combat_dynamite_strength.get(), Mode.NONE);
	            		}   	  
	            	}
				},
				(throwable) -> {throwable.setItem(stackIn);});
	        }
	    });
	}
}
