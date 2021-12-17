package com.thep2wking.oedldoedl.gear.items.baubles.heads;

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
import com.thep2wking.oedldoedl.gear.models.ModelLeafHeadband;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import baubles.api.render.IRenderBauble;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLeafHeadband extends Item implements IHasModel, IBauble, IRenderBauble
{  
	public ItemLeafHeadband(String name) 
	{
		setUnlocalizedName(ReferenceGear.MODID+":"+name);
		setRegistryName(ReferenceGear.MODID+":"+name);
		setCreativeTab(OedldoedlGear.TAB);
		setMaxStackSize(1);
		texture = new ResourceLocation(ReferenceGear.MODID, "textures/models/bauble/"+name+".png");
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
    	return RarityInit.LIGHT_PURPLE;
    }
    
	@Override
	public BaubleType getBaubleType(ItemStack arg0) 
	{
  		if (GearConfig.BAUBLES.baubleSlotAny) 
  		{
  			return BaubleType.TRINKET;
  		}
		return BaubleType.HEAD;
	}
	
    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) 
    {
 		if (GearConfig.GENEREL.effects.baublesGiveEffects)
  		{
  			if (itemstack.getItemDamage()==0) 
  			{
  				if (player.isPotionActive(MobEffects.POISON)) 
  				{
  					player.removeActivePotionEffect(MobEffects.POISON);
  				}
  				if (player.isPotionActive(MobEffects.WITHER)) 
  				{
  					player.removeActivePotionEffect(MobEffects.WITHER);
  				}
  				if (player.isPotionActive(MobEffects.LEVITATION)) 
  				{
  					player.removeActivePotionEffect(MobEffects.LEVITATION);
  				}
  				if (player.isPotionActive(MobEffects.MINING_FATIGUE)) 
  				{
  					player.removeActivePotionEffect(MobEffects.MINING_FATIGUE);
  				}
  				if (player.isPotionActive(MobEffects.WEAKNESS)) 
  				{
  					player.removeActivePotionEffect(MobEffects.WEAKNESS);
  				}
  				if (player.isPotionActive(MobEffects.UNLUCK)) 
  				{
  					player.removeActivePotionEffect(MobEffects.UNLUCK);
  				}
  				if (player.isPotionActive(MobEffects.HUNGER)) 
  				{
  					player.removeActivePotionEffect(MobEffects.HUNGER);
  				}
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
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, .75F, 1.9f);
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) 
	{
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, .75F, 2f);
	}	

	public final ResourceLocation texture;
	@SideOnly(Side.CLIENT)
	private static ModelBiped model;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void onPlayerBaubleRender(ItemStack stack, EntityPlayer player, RenderType type, float partialTicks) 
	{
		if (type!=RenderType.HEAD)
			return;

		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		Helper.translateToHeadLevel(player);

		float s = 1.0F/16F;
		GlStateManager.scale(s, s, s);
		GlStateManager.rotate(-90, 0, 1, 0);
		GlStateManager.translate(0, 26, 0);
		if (model==null)
			model = new ModelLeafHeadband();

  		if (GearConfig.BAUBLES.baubleRender) 
  		{
 			model.bipedHead.render(1);
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
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.leaf_headband.tip"),
  			});
  		}
  		
  		if (CoreConfig.GENEREL.tooltips.potionInformation && GearConfig.GENEREL.effects.baublesGiveEffects) 
  		{
  			TooltipControlEffectInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.DARK_GREEN+""+I18n.format("core.oedldoedl.bauble.effects.tip"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.leaf_headband.effects.tip"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.leaf_headband.effects.tip2"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.leaf_headband.effects.tip3"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.leaf_headband.effects.tip4"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.leaf_headband.effects.tip5"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.leaf_headband.effects.tip6"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.leaf_headband.effects.tip7"),
  			});
  		}
	}
}