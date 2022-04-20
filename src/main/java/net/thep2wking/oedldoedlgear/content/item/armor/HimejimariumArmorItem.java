package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thep2wking.oedldoedlcore.api.ModArmorItemBase;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;
import net.thep2wking.oedldoedlgear.util.ModArmorMaterial;

@Mod.EventBusSubscriber
public class HimejimariumArmorItem extends ModArmorItemBase
{
	public HimejimariumArmorItem(IArmorMaterial material, EquipmentSlotType slot, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
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
		int color = Integer.parseInt(GearConfig.himejimarium_rgb_color.get(), 16);
		return color;
	}
	
	@Override
	public int getMaxDamage(ItemStack stack) 
	{
		return ModArmorMaterial.HIMEJIMARIUM.getMaxDurability();
	}
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) 
	{
		ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
		
        if (((!head.isEmpty()) && (head.getItem() == ModItems.HIMEJIMARIUM_HELMET.get()) && (!chest.isEmpty()) && (chest.getItem() == ModItems.HIMEJIMARIUM_CHESTPLATE.get()) && 
        		(!legs.isEmpty()) && (legs.getItem() == ModItems.HIMEJIMARIUM_LEGGINGS.get()) && (!feet.isEmpty()) && (feet.getItem() == ModItems.HIMEJIMARIUM_BOOTS.get()) && 
        		GearConfig.himejimarium_abilities.get()))
        {
            player.stepHeight = 1.1f;
  			player.setAir(300);
  			
            player.extinguish();
            
  			player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 400, 0, false, false));
    		player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 200, 2, false, false));
    		player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 200, 0, false, false));
        }
        else
        {
			player.stepHeight = 0.6F;
        }
	}
	
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) 
    {
        if (event.getSource() instanceof EntityDamageSource && !((EntityDamageSource) event.getSource()).getIsThornsDamage())
        {
            if (event.getSource().getTrueSource() instanceof PlayerEntity)
            {
                PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
        		ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
        		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
        		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
        		ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
        		
                if (((!head.isEmpty()) && (head.getItem() == ModItems.HIMEJIMARIUM_HELMET.get()) && (!chest.isEmpty()) && (chest.getItem() == ModItems.HIMEJIMARIUM_CHESTPLATE.get()) && 
                		(!legs.isEmpty()) && (legs.getItem() == ModItems.HIMEJIMARIUM_LEGGINGS.get()) && (!feet.isEmpty()) && (feet.getItem() == ModItems.HIMEJIMARIUM_BOOTS.get()) &&
                		GearConfig.himejimarium_abilities.get()))
                {
                	LightningBoltEntity lightningBolt = EntityType.LIGHTNING_BOLT.create(player.world);
	                if (lightningBolt != null) 
	                {
	                    lightningBolt.moveForced(Vector3d.copy(event.getEntity().getPosition()));
	                    lightningBolt.setCaster(player instanceof ServerPlayerEntity ? (ServerPlayerEntity) player : null);
	                    player.world.addEntity(lightningBolt);
	                }
	                
                	LightningBoltEntity lightningBolt2 = EntityType.LIGHTNING_BOLT.create(player.world);
	                if (lightningBolt2 != null) 
	                {
	                    lightningBolt2.moveForced(Vector3d.copy(event.getEntity().getPosition()));
	                    lightningBolt2.setCaster(player instanceof ServerPlayerEntity ? (ServerPlayerEntity) player : null);
	                    player.world.addEntity(lightningBolt2);
	                }
                }
            }
        }
    }
    
	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".himejimarium_armor";
	
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
		
		if (ModTooltips.showEffectTip() && GearConfig.himejimarium_abilities.get())
		{
			ModTooltips.addEffectHeader(tooltip, ModTooltips.EFFECTS_FULL_ARMOR);
			ModTooltips.addPotionEffect(tooltip, Effects.FIRE_RESISTANCE.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, Effects.NIGHT_VISION.getName(), false, 1, 400);
			ModTooltips.addPotionEffect(tooltip, Effects.RESISTANCE.getName(), false, 3, 200);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 2);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 3);
		}
		else if (ModTooltips.showEffectTipKey() && GearConfig.himejimarium_abilities.get())
		{
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
    }
}