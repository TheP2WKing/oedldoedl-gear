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
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class ItemArgentoriumAmulet extends Item implements IHasModel, IBauble, IRenderBauble
{  
	public ItemArgentoriumAmulet(String name) 
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
    	return RarityInit.YELLOW;
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

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) 
    {
        if (itemstack.getItemDamage()==0) 
        {
      		if (GearConfig.GENEREL.effects.baublesGiveEffects) 
      		{
      			player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 200, 4, false, false));
      		}
        }
    }
    
    @SubscribeEvent
    public static void onLivingHurtByEnemy(LivingHurtEvent event)
    {
        if (!event.getEntity().world.isRemote && event.getEntity() instanceof EntityPlayer && event.getAmount() >= 1)
        {
        	if (BaublesApi.isBaubleEquipped((EntityPlayer) event.getEntity(), ItemInit.ITEM_ARGENTORIUM_AMULET) != -1)
        	{
	        	if (event.getSource().getTrueSource() instanceof EntityLiving) 
	        	{
	        		//EntityLiving attacker = (EntityLiving) event.getSource().getTrueSource();
	        		//attacker.addPotionEffect(new PotionEffect(MobEffects.WITHER, 60, 2, false, false));
	        		//attacker.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, attacker.posX, attacker.posY, attacker.posZ, 1.0D, 1.0D, 1.0D);
	            }
        	}
        }
    }
    
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) 
    {
        if (event.getSource() instanceof EntityDamageSource && !((EntityDamageSource) event.getSource()).getIsThornsDamage())
        {
            if (event.getSource().getTrueSource() instanceof EntityPlayer) 
            {
                EntityPlayer attacker = (EntityPlayer) event.getSource().getTrueSource();
                if (BaublesApi.isBaubleEquipped(attacker, ItemInit.ITEM_ARGENTORIUM_AMULET) != -1) 
                {
                	if (event.getEntityLiving().isEntityUndead())
                	{
                		 //event.getEntityLiving().setHealth(event.getEntityLiving().getHealth() - 9.5f);
                	}
                	else
                	{
             		    //event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 40, 2, false, false));
                	}
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
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 1.9f);
		//player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0);
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) 
	{
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 2f);
		//player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
  		if (GearConfig.GENEREL.effects.baublesGiveEffects) 
  		{
  			player.removePotionEffect(MobEffects.ABSORPTION);
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
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.argentorium_amulet.tip"),
  			});
  		}
  		
  		if (CoreConfig.GENEREL.tooltips.potionInformation && GearConfig.GENEREL.effects.baublesGiveEffects) 
  		{
  			TooltipControlEffectInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.DARK_GREEN+""+I18n.format("core.oedldoedl.bauble.effects.tip"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.argentorium_amulet.effects.tip"),
  			});
  		}
	}
}