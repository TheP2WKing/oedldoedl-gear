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

public class InfinityArmorItem extends ModArmorItemBase
{
	public InfinityArmorItem(IArmorMaterial material, EquipmentSlotType slot, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(material, slot, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}
	
	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) 
	{
		return Integer.MAX_VALUE;
	}
	
	@Override
	public boolean isDamageable() 
	{
		return false;
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		return false;
	}
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) 
	{
		ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
		
        if (((!head.isEmpty()) && (head.getItem() == ModItems.INFINITY_HELMET.get()) && (!chest.isEmpty()) && (chest.getItem() == ModItems.INFINITY_CHESTPLATE.get()) && 
        		(!legs.isEmpty()) && (legs.getItem() == ModItems.INFINITY_LEGGINGS.get()) && (!feet.isEmpty()) && (feet.getItem() == ModItems.INFINITY_BOOTS.get())
        		&& GearConfig.infinity_abilities.get()))
        {
            player.stepHeight = 1.1f;
  			player.setAir(300);
  			player.abilities.setFlySpeed(0.15F);
            player.abilities.allowFlying = true;
  			player.removeActivePotionEffect(Effects.BLINDNESS);
  			player.removeActivePotionEffect(Effects.HUNGER);
  			player.removeActivePotionEffect(Effects.INSTANT_DAMAGE);
  			player.removeActivePotionEffect(Effects.LEVITATION);
  			player.removeActivePotionEffect(Effects.MINING_FATIGUE);
  			player.removeActivePotionEffect(Effects.NAUSEA);
  			player.removeActivePotionEffect(Effects.POISON);
  			player.removeActivePotionEffect(Effects.SLOWNESS);
  			player.removeActivePotionEffect(Effects.UNLUCK);
  			player.removeActivePotionEffect(Effects.WEAKNESS);
  			player.removeActivePotionEffect(Effects.WITHER);
  			player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 400, 0, false, false));
  			player.getFoodStats().addStats(20, 20f);
  			if (player.isBurning())
  			{
  				player.extinguish();
  			}
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
        
        if (((!head.isEmpty()) && (head.getItem() == ModItems.INFINITY_HELMET.get()) && (!chest.isEmpty()) && (chest.getItem() == ModItems.INFINITY_CHESTPLATE.get()) && 
        		(!legs.isEmpty()) && (legs.getItem() == ModItems.INFINITY_LEGGINGS.get()) && (!feet.isEmpty()) && (feet.getItem() == ModItems.INFINITY_BOOTS.get())
        		&& GearConfig.infinity_invulnerability.get()))
        {
  			player.setInvulnerable(true);
        }
        else
        {
  			player.setInvulnerable(false);
        }
	}

	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".infinity_armor";
	
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
			if (GearConfig.infinity_abilities.get() || GearConfig.infinity_invulnerability.get())
			{
				ModTooltips.addEffectHeader(tooltip, ModTooltips.EFFECTS_FULL_ARMOR);
			}
			if (GearConfig.infinity_abilities.get())
			{
				ModTooltips.addPotionEffect(tooltip, Effects.NIGHT_VISION.getName(), false, 1, 400);
			}
			if(GearConfig.infinity_invulnerability.get())
			{
				ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
				ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 2);
			}
			if (GearConfig.infinity_abilities.get())
			{
				ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 3);
				ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 4);
				ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 5);
			}
		}
		else if (ModTooltips.showEffectTipKey() && GearConfig.infinity_abilities.get() || GearConfig.infinity_invulnerability.get())
		{
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
    }
}