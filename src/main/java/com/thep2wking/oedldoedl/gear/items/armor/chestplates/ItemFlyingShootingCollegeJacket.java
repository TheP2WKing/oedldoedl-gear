package com.thep2wking.oedldoedl.gear.items.armor.chestplates;

import java.util.List;

import com.thep2wking.oedldoedl.core.OedldoedlCore;
import com.thep2wking.oedldoedl.core.config.CoreConfig;
import com.thep2wking.oedldoedl.core.init.RarityInit;
import com.thep2wking.oedldoedl.core.util.interfaces.IHasModel;
import com.thep2wking.oedldoedl.core.util.tooltips.TooltipShiftInfo;
import com.thep2wking.oedldoedl.gear.OedldoedlGear;
import com.thep2wking.oedldoedl.gear.ReferenceGear;
import com.thep2wking.oedldoedl.gear.init.ItemInit;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFlyingShootingCollegeJacket extends ItemArmor implements IHasModel
{
	public ItemFlyingShootingCollegeJacket(String name, ArmorMaterial armorMaterial, int renderIndexIn, EntityEquipmentSlot slot)
	{
		super(ItemInit.ARMOR_MATERIAL_FLYING_SHOOTING_COLLEGE_JACKET, renderIndexIn, slot);
		setUnlocalizedName(ReferenceGear.MODID+":"+name);
		setRegistryName(ReferenceGear.MODID+":"+name);
		setCreativeTab(OedldoedlGear.TAB);
		setMaxDamage(9999);
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
	@SideOnly (Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) 
    {
    	return RarityInit.LIGHT_PURPLE;
    }
    
    @Override
    public void setDamage(ItemStack stack, int damage)
    {
        super.setDamage(stack, 0);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) 
	{
  		if (CoreConfig.GENEREL.tooltips.itemInformation)
  		{
  			TooltipShiftInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.flying_shooting_college_jacket.tip"),
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.flying_shooting_college_jacket.tip2"),
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.flying_shooting_college_jacket.tip3"),
  			});
  		}
	}
}