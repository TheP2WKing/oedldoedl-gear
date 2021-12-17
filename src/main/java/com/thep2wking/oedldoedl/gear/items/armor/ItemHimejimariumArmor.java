package com.thep2wking.oedldoedl.gear.items.armor;

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
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class ItemHimejimariumArmor extends ItemArmor implements IHasModel
{
	public ItemHimejimariumArmor(String name, ArmorMaterial armorMaterial, int renderIndexIn, EntityEquipmentSlot slot)
	{
		super(ItemInit.ARMOR_MATERIAL_HIMEJIMARIUM, renderIndexIn, slot);
		setUnlocalizedName(ReferenceGear.MODID+":"+name);
		setRegistryName(ReferenceGear.MODID+":"+name);
		setCreativeTab(OedldoedlGear.TAB);
		setMaxDamage(10260);
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
    	return RarityInit.DARK_BLUE;
    }
    
    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) 
    {
    	return 0x232033;
    }
    
    @Override
    public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) 
    {
        ItemStack chest = entity.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        ItemStack feet = entity.getItemStackFromSlot(EntityEquipmentSlot.FEET);
        ItemStack head = entity.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        ItemStack legs = entity.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
        if (((!head.isEmpty()) && (head.getItem() == ItemInit.ITEM_HIMEJIMARIUM_HELMET) && (!chest.isEmpty()) && (chest.getItem() == ItemInit.ITEM_HIMEJIMARIUM_CHESTPLATE) && (!legs.isEmpty()) && (legs.getItem() == ItemInit.ITEM_HIMEJIMARIUM_LEGGINGS) && (!feet.isEmpty()) && (feet.getItem() == ItemInit.ITEM_HIMEJIMARIUM_BOOTS))) 
        {
        	//entity.getent.world.addWeatherEffect(new EntityLightningBolt(entity.getLastAttackedEntity().world, entity.getLastAttackedEntity().posX, entity.getLastAttackedEntity().posY, entity.getLastAttackedEntity().posZ, false));
        	//event.getEntityLiving().world.addWeatherEffect(new EntityLightningBolt(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, false))
            if (entity.isBurning() && GearConfig.ARMOR.himejimariumArmor.effectsEnabled && GearConfig.GENEREL.effects.armorGiveEffects) 
            {
            	entity.extinguish();
            }
            
            if (GearConfig.ARMOR.himejimariumArmor.effectsEnabled && GearConfig.GENEREL.effects.armorGiveEffects) 
            {
        		entity.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0, false, false));
                entity.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
                entity.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, GearConfig.ARMOR.himejimariumArmor.resistanceAmplifier - 1, false, false));
            }
            
            if (GearConfig.ARMOR.himejimariumArmor.effectsEnabled && GearConfig.GENEREL.effects.armorGiveEffects) 
            {
            	entity.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0);
            }
        }
    	else
    	{
    		entity.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.0);
        }
    }
    
    @SubscribeEvent
    public static void onLivingHurtByEnemy(LivingHurtEvent event)
    {
        if (!event.getEntity().world.isRemote && event.getEntity() instanceof EntityPlayer && event.getAmount() >= 1 && GearConfig.ARMOR.himejimariumArmor.abilities && GearConfig.GENEREL.effects.armorGiveEffects)
        {
            ItemStack chest = event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.CHEST);
            ItemStack feet = event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.FEET);
            ItemStack head = event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.HEAD);
            ItemStack legs = event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.LEGS);
            if (((!head.isEmpty()) && (head.getItem() == ItemInit.ITEM_HIMEJIMARIUM_HELMET) && (!chest.isEmpty()) && (chest.getItem() == ItemInit.ITEM_HIMEJIMARIUM_CHESTPLATE) && (!legs.isEmpty()) && (legs.getItem() == ItemInit.ITEM_HIMEJIMARIUM_LEGGINGS) && (!feet.isEmpty()) && (feet.getItem() == ItemInit.ITEM_HIMEJIMARIUM_BOOTS))) 
            {
	        	if (event.getSource() == DamageSource.LIGHTNING_BOLT) 
	        	{
	        		event.setCanceled(true);
	        	} 
	        	else if (event.getSource().getTrueSource() instanceof EntityLiving) 
	        	{
	        		EntityLiving attacker = (EntityLiving) event.getSource().getTrueSource();
	        		attacker.world.addWeatherEffect(new EntityLightningBolt(attacker.world, attacker.posX, attacker.posY, attacker.posZ, false));
	            }
        	}
        }
    }
	
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) 
    {
        if (event.getSource() instanceof EntityDamageSource && !((EntityDamageSource) event.getSource()).getIsThornsDamage() && GearConfig.ARMOR.himejimariumArmor.abilities && GearConfig.GENEREL.effects.armorGiveEffects)
        {
            if (event.getSource().getTrueSource() instanceof EntityPlayer) 
            {
                EntityPlayer attacker = (EntityPlayer) event.getSource().getTrueSource();
                ItemStack chest = attacker.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                ItemStack feet = attacker.getItemStackFromSlot(EntityEquipmentSlot.FEET);
                ItemStack head = attacker.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
                ItemStack legs = attacker.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
                if (((!head.isEmpty()) && (head.getItem() == ItemInit.ITEM_HIMEJIMARIUM_HELMET) && (!chest.isEmpty()) && (chest.getItem() == ItemInit.ITEM_HIMEJIMARIUM_CHESTPLATE) && (!legs.isEmpty()) && (legs.getItem() == ItemInit.ITEM_HIMEJIMARIUM_LEGGINGS) && (!feet.isEmpty()) && (feet.getItem() == ItemInit.ITEM_HIMEJIMARIUM_BOOTS))) 
                {
                	event.getEntity().world.addWeatherEffect(new EntityLightningBolt(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, false));
                }
            }
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
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.himejimarium_armor.tip"),
  			});
  		}
  		
  		if (CoreConfig.GENEREL.tooltips.potionInformation && GearConfig.GENEREL.effects.armorGiveEffects) 
  		{
  			TooltipControlEffectInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.DARK_GREEN+""+I18n.format("core.oedldoedl.full.effects.tip"),
  				TextFormatting.YELLOW+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.himejimarium_armor.effects.tip"),
  				TextFormatting.YELLOW+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.himejimarium_armor.effects.tip2"),
  				TextFormatting.YELLOW+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.himejimarium_armor.effects.tip3"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.himejimarium_armor.effects.tip4")+TextFormatting.RED+""+TextFormatting.ITALIC+" (1) ",
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.himejimarium_armor.effects.tip5")+TextFormatting.RED+""+TextFormatting.ITALIC+" (1) ",
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.himejimarium_armor.effects.tip6")+TextFormatting.RED+""+TextFormatting.ITALIC+" ("+GearConfig.ARMOR.himejimariumArmor.resistanceAmplifier+") ",

  			});
  		}
	}
}