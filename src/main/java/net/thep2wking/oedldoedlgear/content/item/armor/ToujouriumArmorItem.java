package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thep2wking.oedldoedlcore.api.ModArmorItemBase;
import net.thep2wking.oedldoedlcore.util.ModReferences;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;
import net.thep2wking.oedldoedlgear.util.ModArmorMaterial;

@Mod.EventBusSubscriber
public class ToujouriumArmorItem extends ModArmorItemBase
{
	public enum AttributeUUIDTou {HELMET_UUID("72973f80-73c6-434e-bbce-cb28a5c5d6c3"), CHESTPLATE_UUID("edddc8d4-84a4-42fa-8654-d5704ca26225"), 
		LEGGINGS_UUID("0222ad71-5a72-4490-acce-fd8fb8eb70ee"), BOOTS_UUID("1229d236-1cbd-4415-b367-1f0ed5a00ae6");
		
	public String ids;
		
	AttributeUUIDTou(String ids) 
	{
		this.ids = ids;
	}}
	
	public AttributeUUIDTou uuid;
	
	public ToujouriumArmorItem(IArmorMaterial material, EquipmentSlotType slot, AttributeUUIDTou uuid, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, 
	int annotationLines, Properties properties) 
    {
		super(material, slot, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
		this.uuid = uuid;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT) 
	public int getRGBDurabilityForDisplay(ItemStack stack) 
	{
		return stringColorToInt();
	}
	
	public int stringColorToInt()
	{
		int color = Integer.parseInt(GearConfig.toujourium_rgb_color.get(), 16);
		return color;
	}
	
	@Override
	public int getMaxDamage(ItemStack stack) 
	{
		return ModArmorMaterial.TOUJOURIUM.getMaxDurability();
	}
	
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slotType, ItemStack stack) 
	{
		if(GearConfig.toujourium_abilities.get())
		{
			Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
			if (slotType == this.slot)
			{
				atts.putAll(super.getAttributeModifiers(this.slot, new ItemStack(this)));
				atts.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(UUID.fromString(this.uuid.ids), ModReferences.ATTRIBUTE_ATTACK_KNOCKBACK, 2.5, AttributeModifier.Operation.ADDITION));
				return atts;
			}
			return super.getAttributeModifiers(slotType, stack);
		}
		return super.getAttributeModifiers(slotType, stack);
	}
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) 
	{
		ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
		
        if (((!head.isEmpty()) && (head.getItem() == ModItems.TOUJOURIUM_HELMET.get()) && (!chest.isEmpty()) && (chest.getItem() == ModItems.TOUJOURIUM_CHESTPLATE.get()) && 
        		(!legs.isEmpty()) && (legs.getItem() == ModItems.TOUJOURIUM_LEGGINGS.get()) && (!feet.isEmpty()) && (feet.getItem() == ModItems.TOUJOURIUM_BOOTS.get()) && 
        		GearConfig.toujourium_abilities.get()))
        {
            player.stepHeight = 1.1f;
  			player.setAir(300);
  			
    		player.fallDistance = 0;
  			
  			player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 400, 0, false, false));
    		player.addPotionEffect(new EffectInstance(Effects.SPEED, 200, 7, false, false));
        }
        else
        {
			player.stepHeight = 0.6F;
        }
	}

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) 
    {
    	if (event.getEntity() instanceof PlayerEntity) 
        {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
    		ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
    		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
    		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
    		ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);
    		
            if (((!head.isEmpty()) && (head.getItem() == ModItems.TOUJOURIUM_HELMET.get()) && (!chest.isEmpty()) && (chest.getItem() == ModItems.TOUJOURIUM_CHESTPLATE.get()) && 
            		(!legs.isEmpty()) && (legs.getItem() == ModItems.TOUJOURIUM_LEGGINGS.get()) && (!feet.isEmpty()) && (feet.getItem() == ModItems.TOUJOURIUM_BOOTS.get()) &&
            		GearConfig.toujourium_abilities.get()))
            {
	    		event.setDamageMultiplier(0);
	        	player.fallDistance = 0;	
            }
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
        		
                if (((!head.isEmpty()) && (head.getItem() == ModItems.TOUJOURIUM_HELMET.get()) && (!chest.isEmpty()) && (chest.getItem() == ModItems.TOUJOURIUM_CHESTPLATE.get()) && 
                		(!legs.isEmpty()) && (legs.getItem() == ModItems.TOUJOURIUM_LEGGINGS.get()) && (!feet.isEmpty()) && (feet.getItem() == ModItems.TOUJOURIUM_BOOTS.get()) &&
                		GearConfig.toujourium_abilities.get()))
                {
        			event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.LEVITATION, 10, 20, false, false));
                }
            }
        }
    }
    
	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".toujourium_armor";
    
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
		
		if (ModTooltips.showEffectTip() && GearConfig.toujourium_abilities.get())
		{
			ModTooltips.addEffectHeader(tooltip, ModTooltips.EFFECTS_FULL_ARMOR);
			ModTooltips.addPotionEffect(tooltip, Effects.NIGHT_VISION.getName(), false, 1, 400);
			ModTooltips.addPotionEffect(tooltip, Effects.SPEED.getName(), false, 3, 200);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 2);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 3);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 4);
		}
		else if (ModTooltips.showEffectTipKey() && GearConfig.toujourium_abilities.get())
		{
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
    }
}