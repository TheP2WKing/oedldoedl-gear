package com.thep2wking.oedldoedl.gear.items.baubles.amulets;

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

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import baubles.api.render.IRenderBauble;
import baubles.api.render.IRenderBauble.Helper;
import baubles.api.render.IRenderBauble.RenderType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
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

public class ItemHimejimariumAmulet extends Item implements IHasModel, IBauble, IRenderBauble
{  
	public ItemHimejimariumAmulet(String name) 
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
	
    @SideOnly(Side.CLIENT)
    @Override
    public boolean func_77636_d(ItemStack stack)
    {
        return true;
    }
	
    @Override
    @SideOnly (Side.CLIENT)
    public EnumRarity func_77613_e(ItemStack stack) 
    {
    	return RarityInit.DARK_BLUE;
    }
    
	@Override
	public BaubleType getBaubleType(ItemStack arg0) 
	{
  		if (CoreConst.BAUBLE_SLOT_ANY) 
  		{
  			return BaubleType.TRINKET;
  		}
		return BaubleType.AMULET;
	}

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) 
    {
        if (itemstack.func_77952_i()==0) 
        {
      		if (CoreConst.BAUBLE_EFFECTS) 
      		{
      			player.func_70690_d(new PotionEffect(MobEffects.field_76420_g, 200, 4, false, false));
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
		player.func_184185_a(SoundEvents.field_187716_o, .75F, 1.9f);
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) 
	{
		player.func_184185_a(SoundEvents.field_187716_o, .75F, 2f);
  		if (CoreConst.BAUBLE_EFFECTS) 
  		{
  			player.func_184589_d(MobEffects.field_76420_g);
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

		Minecraft.func_71410_x().field_71446_o.func_110577_a(texture);
		Helper.rotateIfSneaking(player);

		float s = 1.14F/16F;
		GlStateManager.func_179152_a(s, s, s);
		if (model==null)
			model = new ModelBiped();

 		if (CoreConst.BAUBLE_RENDER)
  		{
 			model.field_78115_e.func_78785_a(1);
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
  				TextFormatting.GREEN+I18n.func_135052_a("item.oedldoedl.himejimarium_amulet.tip"),
  			});
  		}
  		
  		if (CoreConst.POTION_INFORMATION && CoreConst.BAUBLE_EFFECTS) 
  		{
  			TooltipControlEffectInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.DARK_GREEN+""+I18n.func_135052_a("core.oedldoedl.bauble.effects.tip"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.func_135052_a("item.oedldoedl.himejimarium_amulet.effects.tip"),
  			});
  		}
	}
}