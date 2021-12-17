package com.thep2wking.oedldoedl.gear.items.tools.staffs;

import java.util.List;

import com.thep2wking.oedldoedl.core.OedldoedlCore;
import com.thep2wking.oedldoedl.core.config.CoreConfig;
import com.thep2wking.oedldoedl.core.init.RarityInit;
import com.thep2wking.oedldoedl.core.util.interfaces.IHasModel;
import com.thep2wking.oedldoedl.core.util.tooltips.TooltipShiftInfo;
import com.thep2wking.oedldoedl.gear.OedldoedlGear;
import com.thep2wking.oedldoedl.gear.ReferenceGear;
import com.thep2wking.oedldoedl.gear.config.GearConfig;
import com.thep2wking.oedldoedl.gear.init.ItemInit;
import com.thep2wking.oedldoedl.gear.init.SoundInit;
import com.thep2wking.oedldoedl.gear.util.handler.ExplosionEventHandler;
import com.thep2wking.oedldoedl.gear.util.handler.LightEventHandler;
import com.thep2wking.oedldoedl.gear.util.handler.PacketHandler;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStaffOfExplosion extends Item implements IHasModel
{
	public ItemStaffOfExplosion(String name)
	{
		setUnlocalizedName(ReferenceGear.MODID+":"+name);
		setRegistryName(ReferenceGear.MODID+":"+name);
		setCreativeTab(OedldoedlGear.TAB);
		setMaxStackSize(1);
		setMaxDamage(250);
		ItemInit.ITEMS.add(this);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void registerModels()
	{
		OedldoedlCore.proxy.registerItemRenderer(this, 0, "inventory");
	}

    @Override
    @SideOnly (Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack)
    {
    	return RarityInit.GOLD;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) 
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.capabilities.isCreativeMode)
        {
            itemstack.damageItem(1, player);
        }
        player.getCooldownTracker().setCooldown(this, 80); 
        castExplosion(world, player);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

    private void castExplosion(World world, EntityPlayer player) 
    {
        BlockPos blockPos = null;
        int blockBrightness = 0;
        float maxDistance = 50;
        if (world.isRemote) 
        {
            blockPos = getCollisionBlockPos(maxDistance);
            blockBrightness = world.getLightFor(EnumSkyBlock.BLOCK, blockPos);
        }

        final BlockPos pos = blockPos;
        final int brightness = blockBrightness;
        final int explosionStrength = getExplosionStrength(player);
        new Thread(() -> 
        {
            try 
            {
                Thread.sleep(2000);
                if  (world.isRemote) 
                {
                	PacketHandler.wrapper.sendToServer(new LightEventHandler(pos.getX(), pos.getY(), pos.getZ(), brightness));
                    PacketHandler.wrapper.sendToServer(new ExplosionEventHandler(pos.getX(), pos.getY(), pos.getZ(), explosionStrength));
                }
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }).start();
        world.playSound(player, player.getPosition(), SoundInit.SOUND_MEGUMIN, SoundCategory.MASTER, 2f, 1f);
    }

    @SideOnly(Side.CLIENT)
    @MethodsReturnNonnullByDefault
    private BlockPos getCollisionBlockPos(float maxDistance) 
    {
        BlockPos blockPos;
        Entity view = Minecraft.getMinecraft().getRenderViewEntity();
        RayTraceResult res = view.rayTrace(maxDistance, 1f);
        if (res!=null && res.typeOfHit == RayTraceResult.Type.BLOCK) 
        {
            blockPos = res.getBlockPos();
        } 
        else 
        {
            Vec3d vec = view.getLookVec().scale(50);
            blockPos = view.getPosition().add(vec.x, vec.y, vec.z);
        }
        Entity entity = getEntityHit(view, maxDistance);
        if (entity!=null) 
        {
            BlockPos entityPos = entity.getPosition();
            if (view.getPosition().getDistance(blockPos.getX(), blockPos.getY(), blockPos.getZ()) > view.getPosition().getDistance(entityPos.getX(), entityPos.getY(), entityPos.getZ())) 
            {
                blockPos = entityPos;
            }
        }
        return blockPos;
    }

    @SideOnly(Side.CLIENT)
    private Entity getEntityHit(Entity player, float distance) 
    {
        Entity closestEntity = null;
        Vec3d entityLook = player.getLookVec();
        Vec3d eyeVec = player.getPositionEyes(1f);
        AxisAlignedBB theViewBoundingBox = new AxisAlignedBB
        (
                player.posX-0.5D,
                player.posY-0.0D,
                player.posZ-0.5D,
                player.posX+0.5D+entityLook.x*distance,
                player.posY+1.5D+entityLook.y*distance,
                player.posZ+0.5D+entityLook.z*distance
        );

        float dist = distance;
        List<Entity> list = player.world.getEntitiesWithinAABBExcludingEntity(player, theViewBoundingBox);
        list.removeIf(e -> !e.canBeCollidedWith());
        for (Entity e : list) 
        {
            float bordersize = player.getCollisionBorderSize();
            AxisAlignedBB aabb = new AxisAlignedBB(
                    e.posX-e.width/2-bordersize,
                    e.posY-bordersize,
                    e.posZ-e.width/2-bordersize,
                    e.posX+e.width/2+bordersize,
                    e.posY+e.height+bordersize,
                    e.posZ+e.width/2+bordersize);
            RayTraceResult res = aabb.calculateIntercept(eyeVec, eyeVec.add(entityLook.scale(distance)));
            if (res!=null) 
            {
                float d = (float) eyeVec.distanceTo(res.hitVec);
                if (d < dist) 
                {
                    dist = d;
                    closestEntity = e;
                }
            }
        }
        return closestEntity;
    }

    private int getExplosionStrength(EntityPlayer player)
    {
        int count = GearConfig.TOOLS.explosionStaff.explosionStrength;
        return count;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced)
	{
  		if (CoreConfig.GENEREL.tooltips.itemInformation) 
  		{
  			TooltipShiftInfo.addTooltipText(tooltip, new String[]
  			{
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.staff_of_explosion.tip"),
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.staff_of_explosion.tip2"),
  			});
  		}
	}
}