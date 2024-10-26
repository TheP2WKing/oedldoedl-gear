package net.thep2wking.oedldoedlgear.content.item.armor;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.Constants.AttributeModifierOperation;
import net.thep2wking.oedldoedlcore.api.armor.ModItemArmorBase;
import net.thep2wking.oedldoedlcore.util.ModArmorHelper;
import net.thep2wking.oedldoedlcore.util.ModReferences;
import net.thep2wking.oedldoedlgear.config.GearConfig;

public class ItemEmeraldArmor extends ModItemArmorBase {
	public ItemEmeraldArmor(String modid, String name, CreativeTabs tab, ArmorMaterial material, int renderIndex,
			EntityEquipmentSlot slot, EnumRarity rarity, boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, material, renderIndex, slot, rarity, hasEffect, tooltipLines, annotationLines);
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		Multimap<String, AttributeModifier> multimap = LinkedHashMultimap.create();
		if (slot == armorType) {
			multimap.putAll(super.getAttributeModifiers(slot, stack));
		}
		if (slot == armorType && GearConfig.PROPERTIES.ARMOR_KNOCKBACK_RESISTANCE) {
			ModArmorHelper.addFullArmorModifier(multimap, stack, slot, SharedMonsterAttributes.LUCK,
					ModReferences.ATTRIBUTE_LUCK, 0.25, AttributeModifierOperation.ADD_MULTIPLE);
		}
		return multimap;
	}
}