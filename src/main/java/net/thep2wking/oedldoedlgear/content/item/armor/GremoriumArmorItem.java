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
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;
import net.thep2wking.oedldoedlgear.util.ModArmorMaterial;

public class GremoriumArmorItem extends ModArmorItemBase
{
	public GremoriumArmorItem(IArmorMaterial material, EquipmentSlotType slot, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(material, slot, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT) 
	public int getRGBDurabilityForDisplay(ItemStack stack) 
	{
		return stringColorToInt();
	}
	
	public int stringColorToInt()
	{
		int color = Integer.parseInt(GearConfig.gremorium_rgb_color.get(), 16);
		return color;
	}
	
	@Override
	public int getMaxDamage(ItemStack stack) 
	{
		return ModArmorMaterial.GREMORIUM.getMaxDurability();
	}
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) 
	{
		ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
		
        if (((!head.isEmpty()) && (head.getItem() == ModItems.GREMORIUM_HELMET.get()) && (!chest.isEmpty()) && (chest.getItem() == ModItems.GREMORIUM_CHESTPLATE.get()) && 
        		(!legs.isEmpty()) && (legs.getItem() == ModItems.GREMORIUM_LEGGINGS.get()) && (!feet.isEmpty()) && (feet.getItem() == ModItems.GREMORIUM_BOOTS.get())
        		&& GearConfig.gremorium_abilities.get()))
        {
            player.stepHeight = 1.1f;
  			player.setAir(300);
  			
  			player.abilities.setFlySpeed(0.1F);
            player.abilities.allowFlying = true;
  			player.removeActivePotionEffect(Effects.POISON);
  			player.removeActivePotionEffect(Effects.INSTANT_DAMAGE);
  			player.removeActivePotionEffect(Effects.WITHER);
  			
  			player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 400, 0, false, false));
  			player.addPotionEffect(new EffectInstance(Effects.HASTE, 200, 2, false, false));
        }
        else
        {
            if (!player.isCreative() && !player.isSpectator())
            {
	            player.abilities.allowFlying = false;
	            player.abilities.isFlying = false;
            }
  			player.abilities.setFlySpeed(0.05F);
			player.stepHeight = 0.6F;
        }
	}
	
	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".gremorium_armor";
	
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
		
		if (ModTooltips.showEffectTip() && GearConfig.gremorium_abilities.get())
		{
			ModTooltips.addEffectHeader(tooltip, ModTooltips.EFFECTS_FULL_ARMOR);
			ModTooltips.addPotionEffect(tooltip, Effects.NIGHT_VISION.getName(), false, 1, 400);
			ModTooltips.addPotionEffect(tooltip, Effects.HASTE.getName(), false, 3, 200);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 2);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 3);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 4);
		}
		else if (ModTooltips.showEffectTipKey() && GearConfig.gremorium_abilities.get())
		{
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
    }
}