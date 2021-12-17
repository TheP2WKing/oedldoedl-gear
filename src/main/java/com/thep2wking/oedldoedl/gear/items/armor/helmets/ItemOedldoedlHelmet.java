package com.thep2wking.oedldoedl.gear.items.armor.helmets;

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

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
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

public class ItemOedldoedlHelmet extends ItemArmor implements IHasModel
{
	public ItemOedldoedlHelmet(String name, ArmorMaterial armorMaterial, int renderIndexIn, EntityEquipmentSlot slot)
	{
		super(ItemInit.ARMOR_MATERIAL_OEDLDOEDL, renderIndexIn, slot);
		setUnlocalizedName(ReferenceGear.MODID+":"+name);
		setRegistryName(ReferenceGear.MODID+":"+name); 
		setCreativeTab(OedldoedlGear.TAB);
		setMaxDamage(2000);
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
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
  		if (GearConfig.GENEREL.effects.armorGiveEffects && GearConfig.ARMOR.oedldoedlArmor.helmetGivesNightVision)  
  		{
  			player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0, false, false));
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
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.oedldoedl_helmet.tip"),
  			});
  		}
  		
  		if (CoreConfig.GENEREL.tooltips.potionInformation && GearConfig.GENEREL.effects.armorGiveEffects && GearConfig.ARMOR.oedldoedlArmor.helmetGivesNightVision)  
  		{
  			TooltipControlEffectInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.DARK_GREEN+""+I18n.format("core.oedldoedl.helmet.effects.tip"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.oedldoedl_helmet.effects.tip")+TextFormatting.RED+""+TextFormatting.ITALIC+" (1) ",
  			});
  		}
	}
}