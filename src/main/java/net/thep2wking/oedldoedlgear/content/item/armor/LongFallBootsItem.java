package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thep2wking.oedldoedlcore.api.ModArmorItemBase;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;

@Mod.EventBusSubscriber
public class LongFallBootsItem extends ModArmorItemBase
{
	public LongFallBootsItem(IArmorMaterial materialIn, EquipmentSlotType slot, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
    {
		super(materialIn, slot, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) 
    {
    	if (event.getEntity() instanceof PlayerEntity) 
        {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
        	if (player.inventory.armorInventory.get(0).getItem().equals(ModItems.LONG_FALL_BOOTS.get()))
            {
	    		event.setDamageMultiplier(0);
	        	player.fallDistance = 0;	
            }
        }
    }
    
	@Override
	public boolean isDamageable() 
	{
		return false;
	}
	
	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".long_fall_armor";
	
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
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
		}
		else if (ModTooltips.showEffectTipKey() && GearConfig.emerald_effects.get())
		{
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
    }
}