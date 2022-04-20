package net.thep2wking.oedldoedlgear.content.item.armor.travel;

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
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.init.ModItems;

public class TravellersNetheriteBootsItem extends ModArmorItemBase
{
	public TravellersNetheriteBootsItem(IArmorMaterial materialIn, EquipmentSlotType slot, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
    {
		super(materialIn, slot, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}
    
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
    {
    	if (player.inventory.armorInventory.get(0).getItem().equals(ModItems.TRAVELLERS_NETHERITE_BOOTS.get()))
    	{
	    	player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 10, 0, false, false));
	    	player.addPotionEffect(new EffectInstance(Effects.SPEED, 10, 3, false, false));
	    	player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 10, 1, false, false));
	    	player.stepHeight = 1.1F;
    	}
    	else
    	{
    		player.stepHeight = 0.6F;
    	}
    }
    
	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".travellers_armor";
	
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
		
		if (ModTooltips.showEffectTip())
		{
			ModTooltips.addEffectHeader(tooltip, ModTooltips.EFFECTS_BOOTS);
			ModTooltips.addPotionEffect(tooltip, Effects.FIRE_RESISTANCE.getName(), false, 1, 20);
			ModTooltips.addPotionEffect(tooltip, Effects.JUMP_BOOST.getName(), false, 2, 20);
			ModTooltips.addPotionEffect(tooltip, Effects.SPEED.getName(), false, 4, 20);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
		}
		else if (ModTooltips.showEffectTipKey())
		{
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
    }
}