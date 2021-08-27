package com.thep2wking.oedldoedl.gear.items.baubles.heads;

import java.util.List;

import com.thep2wking.oedldoedl.core.OedldoedlCore;
import com.thep2wking.oedldoedl.core.config.constants.CoreConst;
import com.thep2wking.oedldoedl.core.init.RarityInit;
import com.thep2wking.oedldoedl.core.util.interfaces.IHasModel;
import com.thep2wking.oedldoedl.core.util.tooltips.TooltipControlEffectInfo;
import com.thep2wking.oedldoedl.core.util.tooltips.TooltipShiftInfo;
import com.thep2wking.oedldoedl.gear.OedldoedlGear;
import com.thep2wking.oedldoedl.gear.ReferenceGear;
import com.thep2wking.oedldoedl.gear.init.ItemInit;
import com.thep2wking.oedldoedl.gear.models.ModelCatEars;

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

import baubles.api.render.IRenderBauble.Helper;
import baubles.api.render.IRenderBauble.RenderType;

public class ItemCatEars extends Item implements IHasModel, IBauble, IRenderBauble
{  
	public ItemCatEars(String name) 
	{
		func_77655_b(ReferenceGear.MODID+":"+name);
		setRegistryName(ReferenceGear.MODID+":"+name);
		func_77637_a(OedldoedlGear.TAB);
		func_77625_d(1);
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
    public EnumRarity func_77613_e(ItemStack stack) 
    {
    	return RarityInit.LIGHT_PURPLE;
    }
    
	@Override
	public BaubleType getBaubleType(ItemStack arg0) 
	{
  		if (CoreConst.BAUBLE_SLOT_ANY) 
  		{
  			return BaubleType.TRINKET;
  		}
		return BaubleType.HEAD;
	}
	
    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) 
    {
  		if (CoreConst.BAUBLE_EFFECTS) 
  		{
  			if (itemstack.func_77952_i()==0) 
  			{
  				if (player.func_70644_a(MobEffects.field_76436_u)) 
  				{
  					player.func_184596_c(MobEffects.field_76436_u);
  				}
  				if (player.func_70644_a(MobEffects.field_82731_v)) 
  				{
  					player.func_184596_c(MobEffects.field_82731_v);
  				}
  				if (player.func_70644_a(MobEffects.field_188424_y)) 
  				{
  					player.func_184596_c(MobEffects.field_188424_y);
  				}
  				if (player.func_70644_a(MobEffects.field_76419_f)) 
  				{
  					player.func_184596_c(MobEffects.field_76419_f);
  				}
  				if (player.func_70644_a(MobEffects.field_76437_t)) 
  				{
  					player.func_184596_c(MobEffects.field_76437_t);
  				}
  				if (player.func_70644_a(MobEffects.field_189112_A)) 
  				{
  					player.func_184596_c(MobEffects.field_189112_A);
  				}
  				if (player.func_70644_a(MobEffects.field_76438_s)) 
  				{
  					player.func_184596_c(MobEffects.field_76438_s);
  				}
  			}
  		}
    }
    
	@Override
	public ActionResult<ItemStack> func_77659_a(World world, EntityPlayer player, EnumHand hand) 
	{
		if(!world.field_72995_K) 
		{ 
			IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
			for(int i = 0; i < baubles.getSlots(); i++) 
				if((baubles.getStackInSlot(i) == null || baubles.getStackInSlot(i).func_190926_b()) && baubles.isItemValidForSlot(i, player.func_184586_b(hand), player)) 
				{
					baubles.setStackInSlot(i, player.func_184586_b(hand).func_77946_l());
					if(!player.field_71075_bZ.field_75098_d)
					{
						player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, ItemStack.field_190927_a);
					}
					onEquipped(player.func_184586_b(hand), player);
					break;
				}
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.func_184586_b(hand));
	}
    
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) 
	{
		player.func_184185_a(SoundEvents.field_187728_s, .75F, 1.9f);
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) 
	{
		player.func_184185_a(SoundEvents.field_187728_s, .75F, 2f);
	}	

	public final ResourceLocation texture;
	@SideOnly(Side.CLIENT)
	private static ModelBiped model;
	
	@Override
	public void onPlayerBaubleRender(ItemStack stack, EntityPlayer player, RenderType type, float partialTicks) 
	{
		if (type!=RenderType.HEAD)
			return;

		Minecraft.func_71410_x().field_71446_o.func_110577_a(texture);
		Helper.translateToHeadLevel(player);

		float s = 1.0F/16F;
		GlStateManager.func_179152_a(s, s, s);
		GlStateManager.func_179114_b(-90, 0, 1, 0);
		GlStateManager.func_179109_b(0, 26, 0);
		if (model==null)
			model = new ModelCatEars();

 		if (CoreConst.BAUBLE_RENDER)
  		{
 			model.field_78116_c.func_78785_a(1);
  		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void func_77624_a(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) 
	{
  		if (CoreConst.ITEM_INFORMATION) 
  		{
  			TooltipShiftInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.GREEN+I18n.func_135052_a("item.oedldoedl.cat_ears.tip"),
  			});
  		}
  		
  		if (CoreConst.POTION_INFORMATION && CoreConst.BAUBLE_EFFECTS) 
  		{
  			TooltipControlEffectInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.DARK_GREEN+""+I18n.func_135052_a("core.oedldoedl.bauble.effects.tip"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.func_135052_a("item.oedldoedl.cat_ears.effects.tip"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.func_135052_a("item.oedldoedl.cat_ears.effects.tip2"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.func_135052_a("item.oedldoedl.cat_ears.effects.tip3"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.func_135052_a("item.oedldoedl.cat_ears.effects.tip4"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.func_135052_a("item.oedldoedl.cat_ears.effects.tip5"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.func_135052_a("item.oedldoedl.cat_ears.effects.tip6"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.func_135052_a("item.oedldoedl.cat_ears.effects.tip7"),
  			});
  		}
	}
}