package net.thep2wking.oedldoedlgear.content.item.tool.misc;

import java.util.UUID;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.thep2wking.oedldoedlcore.api.ModShieldItemBase;
import net.thep2wking.oedldoedlcore.util.ModReferences;

public class AttackDamageShieldItem extends ModShieldItemBase
{
	public final double damage; 
	public static final String SHIELD_UUID = "00834b82-88b7-4c66-bd3b-ace379ab5874";
	
	public AttackDamageShieldItem(IItemTier itemTier, double damage, Item repairItem, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(itemTier, repairItem, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
		this.damage = damage;
	}

	@Override
	public boolean isShield(ItemStack stack, LivingEntity entity) 
	{
		return true;
	}
	
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) 
    {
		Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
		if (slot == EquipmentSlotType.MAINHAND)
		{
			atts.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(UUID.fromString(SHIELD_UUID), ModReferences.ATTRIBUTE_ATTACK_DAMAGE, damage, AttributeModifier.Operation.ADDITION));
			return atts;
		}
		return atts;
	}
}