package net.thep2wking.oedldoedlgear.util;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.thep2wking.oedldoedlcore.init.ModItems;
import net.thep2wking.oedldoedlcore.util.ModReferences;

public class ModItemGroups 
{
	public static final ItemGroup TAB_GEAR = new ItemGroup("oedldoedlgear.tab") 
	{	
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon()
		{
			return new ItemStack(ModItems.GEAR_ICON.get());
		}
		
		@Override
		@OnlyIn(Dist.CLIENT)
		public ResourceLocation getBackgroundImage() 
		{
			return ModReferences.TAB_DARK_BASE_RL;
		};
	};
}	