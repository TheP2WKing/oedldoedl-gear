package com.thep2wking.oedldoedl.gear.items.tools.axes;

import java.util.List;

import com.thep2wking.oedldoedl.core.OedldoedlCore;
import com.thep2wking.oedldoedl.core.config.constants.CoreConst;
import com.thep2wking.oedldoedl.core.init.RarityInit;
import com.thep2wking.oedldoedl.core.util.interfaces.IHasModel;
import com.thep2wking.oedldoedl.core.util.tooltips.TooltipShiftInfo;
import com.thep2wking.oedldoedl.gear.OedldoedlGear;
import com.thep2wking.oedldoedl.gear.ReferenceGear;
import com.thep2wking.oedldoedl.gear.init.ItemInit;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemOedldoedlAxe extends ItemAxe implements IHasModel
{
	public ItemOedldoedlAxe(String name, ToolMaterial material) 
	{
		super(ItemInit.TOOL_MATERIAL_OEDLDOEDL, 12f, -3.0f);
		func_77655_b(ReferenceGear.MODID+":"+name);
		setRegistryName(ReferenceGear.MODID+":"+name);
		func_77637_a(OedldoedlGear.TAB);
		func_77625_d(1);
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
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
    @SideOnly(Side.CLIENT)
    public EnumRarity func_77613_e(ItemStack stack) 
    {
    	return RarityInit.RED;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void func_77624_a(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) 
	{
		if (CoreConst.ITEM_INFORMATION) 
  		{
			TooltipShiftInfo.addTooltipText(tooltip, new String[] 
			{
				TextFormatting.GREEN+I18n.func_135052_a("item.oedldoedl.oedldoedl_axe.tip"),
			});
  		}
	}
}