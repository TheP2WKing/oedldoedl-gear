package com.thep2wking.oedldoedl.gear.items.armor.helmets;

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
import com.thep2wking.oedldoedl.gear.models.ModelBunnyEars;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemOedldoedlHelmet extends ItemArmor implements IHasModel
{
	public ItemOedldoedlHelmet(String name, ArmorMaterial armorMaterial, int renderIndexIn, EntityEquipmentSlot slot)
	{
		super(ItemInit.ARMOR_MATERIAL_OEDLDOEDL, renderIndexIn, slot);
		func_77655_b(ReferenceGear.MODID+":"+name);
		setRegistryName(ReferenceGear.MODID+":"+name); 
		func_77637_a(OedldoedlGear.TAB);
		func_77656_e(2000);
		func_77625_d(1);
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
    public boolean func_77636_d(ItemStack stack)
    {
        return true;
    }
    
    @Override
	@SideOnly (Side.CLIENT)
    public EnumRarity func_77613_e(ItemStack stack) 
    {
    	return RarityInit.RED;
    }
    
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
  		if (CoreConst.POTION_EFFECTS) 
  		{
  			player.func_70690_d(new PotionEffect(MobEffects.field_76439_r, 400, 0, false, false));
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
  				TextFormatting.GREEN+I18n.func_135052_a("item.oedldoedl.oedldoedl_helmet.tip"),
  			});
  		}
  		
  		if (CoreConst.POTION_INFORMATION && CoreConst.POTION_EFFECTS) 
  		{
  			TooltipControlEffectInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.DARK_GREEN+""+I18n.func_135052_a("core.oedldoedl.given.effects.tip"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.func_135052_a("item.oedldoedl.oedldoedl_helmet.effects.tip"),
  			});
  		}
	}
}