package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.thep2wking.oedldoedlcore.api.ModArmorItemBase;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;

public class EmeraldArmorItem extends ModArmorItemBase
{
	public EmeraldArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
    {
		super(materialIn, slot, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) 
	{
		ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
		
        if (((!head.isEmpty()) && (head.getItem() == ModItems.EMERALD_HELMET.get()) && (!chest.isEmpty()) && (chest.getItem() == ModItems.EMERALD_CHESTPLATE.get()) && 
        		(!legs.isEmpty()) && (legs.getItem() == ModItems.EMERALD_LEGGINGS.get()) && (!feet.isEmpty()) && (feet.getItem() == ModItems.EMERALD_BOOTS.get())
        		&& GearConfig.emerald_effects.get()))
        {
    		player.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 200, 0, false, false));
    		player.addPotionEffect(new EffectInstance(Effects.LUCK, 200, 0, false, false));
    	}
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
    {
		if(ModTooltips.showAnnotationTip())
		{
		    for (int i = 1; i <= annotationLines; ++i)
		    {
				ModTooltips.addAnnotation(tooltip, this.getTranslationKey(), i);
		    }
		}
		if (ModTooltips.showInfoTip())
		{   
		    for (int i = 1; i <= tooltipLines; ++i) 
		    {
				ModTooltips.addInformation(tooltip, this.getTranslationKey(), i);
		    }
		}
		else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0))
		{
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}
		
		if (ModTooltips.showEffectTip() && GearConfig.emerald_effects.get())
		{
			ModTooltips.addEffectHeader(tooltip, ModTooltips.EFFECTS_FULL_ARMOR);
			ModTooltips.addPotionEffect(tooltip, Effects.HERO_OF_THE_VILLAGE.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, Effects.LUCK.getName(), false, 1, 200);
		}
		else if (ModTooltips.showEffectTipKey() && GearConfig.emerald_effects.get())
		{
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
    }
}