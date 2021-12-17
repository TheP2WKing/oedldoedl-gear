package com.thep2wking.oedldoedl.gear.items.baubles.rings;

import java.util.List;

import com.thep2wking.oedldoedl.core.OedldoedlCore;
import com.thep2wking.oedldoedl.core.config.CoreConfig;
import com.thep2wking.oedldoedl.core.init.RarityInit;
import com.thep2wking.oedldoedl.core.util.interfaces.IHasModel;
import com.thep2wking.oedldoedl.core.util.tooltips.TooltipControlEffectInfo;
import com.thep2wking.oedldoedl.core.util.tooltips.TooltipShiftInfo;
import com.thep2wking.oedldoedl.gear.OedldoedlGear;
import com.thep2wking.oedldoedl.gear.ReferenceGear;
import com.thep2wking.oedldoedl.gear.config.GearConfig;
import com.thep2wking.oedldoedl.gear.init.ItemInit;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemOedldoedlRing extends Item implements IHasModel, IBauble
{  
	public ItemOedldoedlRing(String name) 
	{
		setUnlocalizedName(ReferenceGear.MODID+":"+name);
		setRegistryName(ReferenceGear.MODID+":"+name);
		setCreativeTab(OedldoedlGear.TAB);
		setMaxStackSize(1);
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	@SideOnly (Side.CLIENT)
	public void registerModels()
	{
		OedldoedlCore.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
	
    @Override
    @SideOnly (Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) 
    {
    	return RarityInit.RED;
    }
    
	@Override
	public BaubleType getBaubleType(ItemStack arg0) 
	{
  		if (GearConfig.BAUBLES.baubleSlotAny) 
  		{
  			return BaubleType.TRINKET;
  		}
		return BaubleType.RING;
	}
	
    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) 
    {
  		if (GearConfig.GENEREL.effects.baublesGiveEffects) 
  		{
      		if (itemstack.getItemDamage()==0)
      		{
      			player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 200, 4, false, false));
      			player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 200, 4, false, false));
      			player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 200, 4, false, false));
        		player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 200, 4, false, false));
        		player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 200, 4, false, false));
        		player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 200, 4, false, false));
        		player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200, 4, false, false));
        		player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 4, false, false));
        		player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 4, false, false));
        		player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 200, 4, false, false));
        		player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 200, 4, false, false));
      		}
        }
    }
    
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) 
	{
		if(!world.isRemote) 
		{ 
			IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
			for(int i = 0; i < baubles.getSlots(); i++) 
				if((baubles.getStackInSlot(i) == null || baubles.getStackInSlot(i).isEmpty()) && baubles.isItemValidForSlot(i, player.getHeldItem(hand), player)) 
				{
					baubles.setStackInSlot(i, player.getHeldItem(hand).copy());
					if(!player.capabilities.isCreativeMode)
					{
						player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
					}
					onEquipped(player.getHeldItem(hand), player);
					break;
				}
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}
    
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) 
	{
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 1.9f);
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) 
	{
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 2f);
  		if (GearConfig.GENEREL.effects.baublesGiveEffects) 
  		{
  			player.removePotionEffect(MobEffects.ABSORPTION);
  			player.removePotionEffect(MobEffects.FIRE_RESISTANCE);
  			player.removePotionEffect(MobEffects.HASTE);
  			player.removePotionEffect(MobEffects.JUMP_BOOST);
  			player.removePotionEffect(MobEffects.LUCK);
  			player.removePotionEffect(MobEffects.NIGHT_VISION);
  			player.removePotionEffect(MobEffects.REGENERATION);
  			player.removePotionEffect(MobEffects.RESISTANCE);
  			player.removePotionEffect(MobEffects.SPEED);
  			player.removePotionEffect(MobEffects.STRENGTH);
  			player.removePotionEffect(MobEffects.WATER_BREATHING);
  		}
	}	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) 
	{
  		if (CoreConfig.GENEREL.tooltips.itemInformation) 
  		{
  			TooltipShiftInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.oedldoedl_ring.tip"),
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.oedldoedl_ring.tip2"),
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.oedldoedl_ring.tip3"),
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.oedldoedl_ring.tip4"),
  			});
  		}
  		
  		if (CoreConfig.GENEREL.tooltips.potionInformation && GearConfig.GENEREL.effects.baublesGiveEffects) 
  		{
  			TooltipControlEffectInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.DARK_GREEN+""+I18n.format("core.oedldoedl.bauble.effects.tip"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.oedldoedl_ring.effects.tip"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.oedldoedl_ring.effects.tip2"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.oedldoedl_ring.effects.tip3"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.oedldoedl_ring.effects.tip4"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.oedldoedl_ring.effects.tip5"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.oedldoedl_ring.effects.tip6"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.oedldoedl_ring.effects.tip7"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.oedldoedl_ring.effects.tip8"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.oedldoedl_ring.effects.tip9"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.oedldoedl_ring.effects.tip10"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.oedldoedl_ring.effects.tip11"),
  			});
  		}
	}
}