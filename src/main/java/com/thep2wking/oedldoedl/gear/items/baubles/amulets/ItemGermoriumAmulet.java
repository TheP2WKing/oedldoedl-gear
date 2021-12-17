package com.thep2wking.oedldoedl.gear.items.baubles.amulets;

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
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGermoriumAmulet extends Item implements IHasModel, IBauble, IRenderBauble
{  
	public ItemGermoriumAmulet(String name) 
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
	
    @SideOnly(Side.CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
	
    @Override
    @SideOnly (Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) 
    {
    	return RarityInit.DARK_RED;
    }
    
	@Override
	public BaubleType getBaubleType(ItemStack arg0) 
	{
  		if (GearConfig.BAUBLES.baubleSlotAny) 
  		{
  			return BaubleType.TRINKET;
  		}
		return BaubleType.AMULET;
	}

    private void startFlying(EntityPlayer player) 
    {
        player.capabilities.allowFlying = true;
        if (!player.getEntityWorld().isRemote) 
        {
      		if (GearConfig.GENEREL.effects.baublesGiveEffects && GearConfig.BAUBLES.gremoriumAmulet.abilities) 
      		{
      			player.sendPlayerAbilities();
      		}
        }
    }

    private void stopFlying(EntityPlayer player) 
    {
        player.capabilities.isFlying = false;
        player.capabilities.allowFlying = false;

        if (!player.getEntityWorld().isRemote) 
        {
      		player.sendPlayerAbilities();
        }
    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase entity) 
    {
        if (stack.getItemDamage()==0) 
        {
            if (entity instanceof EntityPlayer) 
            {
                EntityPlayer player = ((EntityPlayer) entity);
                if (!player.capabilities.allowFlying) 
                {
              		if (GearConfig.GENEREL.effects.baublesGiveEffects && GearConfig.BAUBLES.gremoriumAmulet.abilities) 
              		{
              			startFlying(player);
              		}
                }
            }
            
      		if (GearConfig.GENEREL.effects.baublesGiveEffects && GearConfig.BAUBLES.gremoriumAmulet.abilities) 
      		{
      			((EntityPlayer) entity).getFoodStats().addStats(5, 0F);
      		}
            
      		if (GearConfig.GENEREL.effects.baublesGiveEffects && GearConfig.BAUBLES.gremoriumAmulet.effectsEnabled) 
      		{
      			entity.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 200, 0, false, false));
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
  		if (GearConfig.GENEREL.effects.baublesGiveEffects && GearConfig.BAUBLES.gremoriumAmulet.abilities) 
  		{
  			startFlying((EntityPlayer) player);
  		}
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) 
	{
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 2f);
		stopFlying((EntityPlayer) player);
  		if (GearConfig.GENEREL.effects.baublesGiveEffects && GearConfig.BAUBLES.gremoriumAmulet.effectsEnabled) 
  		{
  			player.removePotionEffect(MobEffects.NIGHT_VISION);
  		}
	}	

	public final ResourceLocation texture;
	@SideOnly(Side.CLIENT)
	private static ModelBiped model;
	
	@Override
	public void onPlayerBaubleRender(ItemStack stack, EntityPlayer player, RenderType type, float partialTicks) 
	{
		if (type!=RenderType.BODY)
			return;

		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		Helper.rotateIfSneaking(player);

		float s = 1.14F/16F;
		GlStateManager.scale(s, s, s);
		if (model==null)
			model = new ModelBiped();

 		if (GearConfig.BAUBLES.baubleRender)
  		{
 			model.bipedBody.render(1);
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
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.gremorium_amulet.tip"),
  			});
  		}
  		
  		if (CoreConfig.GENEREL.tooltips.potionInformation && GearConfig.GENEREL.effects.baublesGiveEffects) 
  		{
  			TooltipControlEffectInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.DARK_GREEN+""+I18n.format("core.oedldoedl.bauble.effects.tip"),
  				TextFormatting.YELLOW+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.gremorium_amulet.effects.tip"),
  				TextFormatting.YELLOW+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.gremorium_amulet.effects.tip2"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.gremorium_amulet.effects.tip3")+TextFormatting.RED+""+TextFormatting.ITALIC+" (1) ",
  			});
  		}
	}
}