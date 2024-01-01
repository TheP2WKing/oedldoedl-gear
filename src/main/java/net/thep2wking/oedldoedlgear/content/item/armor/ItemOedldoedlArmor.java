package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.armor.ModItemArmorBase;
import net.thep2wking.oedldoedlcore.util.ModArmorHelper;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;

public class ItemOedldoedlArmor extends ModItemArmorBase {
	public ItemOedldoedlArmor(String modid, String name, CreativeTabs tab, ArmorMaterial material, int renderIndex,
			EntityEquipmentSlot slot, EnumRarity rarity, boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, material, renderIndex, slot, rarity, hasEffect, tooltipLines, annotationLines);
	}

	public static final UUID HELMET_UUID = UUID.fromString("d7001182-9b4a-4f0b-b7b8-b118a82408ca");
	public static final UUID CHESTPLATE_UUID = UUID.fromString("d50b2f18-9d58-4cff-83a2-fc9766cbdef7");
	public static final UUID LEGGINGS_UUID = UUID.fromString("d8b159cc-a00d-4a6f-80be-386d1bfee754");
	public static final UUID BOOTS_UUID = UUID.fromString("8f1c66f4-d278-4109-84ed-87f5d152d3af");

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		Multimap<String, AttributeModifier> attributes = LinkedHashMultimap.create();
		if (slot == this.getEquipmentSlot()) {
			attributes.putAll(super.getAttributeModifiers(this.getEquipmentSlot(), new ItemStack(this)));
			if (GearConfig.PROPERTIES.ARMOR_KNOCKBACK_RESISTANCE) {
				ModArmorHelper.addKnockbackResistanceModifier(attributes, this, slot, HELMET_UUID, CHESTPLATE_UUID,
						LEGGINGS_UUID, BOOTS_UUID, 0.25);
			}
			return attributes;
		}
		return attributes;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (ModArmorHelper.hasFullArmorSet(player, ModItems.OEDLDOEDL_HELMET, ModItems.OEDLDOEDL_CHESTPLATE,
				ModItems.OEDLDOEDL_LEGGINGS, ModItems.OEDLDOEDL_BOOTS)) {
			if (GearConfig.PROPERTIES.ARMOR_STEP_UP) {
				player.stepHeight = 1.1f;
			}
			if (GearConfig.PROPERTIES.ARMOR_UNLIMITED_AIR) {
				player.setAir(300);
			}
			if (GearConfig.PROPERTIES.ARMOR_NIGHT_VISION) {
				player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0, false, false));
			}
		} else {
			player.stepHeight = 0.6F;
		}
	}

	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".oedldoedl_armor";

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip()) {
			for (int i = 1; i <= annotationLines; ++i) {
				ModTooltips.addAnnotation(tooltip, this.getUnlocalizedName(), i);
			}
		}
		if (ModTooltips.showInfoTip()) {
			for (int i = 1; i <= tooltipLines; ++i) {
				ModTooltips.addInformation(tooltip, this.getUnlocalizedName(), i);
			}
		} else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0)) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}

		if (ModTooltips.showEffectTip()) {
			ModTooltips.addEffectHeader(tooltip, ModTooltips.EFFECT_FULL_ARMOR);
			ModTooltips.addPotionEffect(tooltip, MobEffects.NIGHT_VISION.getName(), false, 1, 400);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 2);
		} else if (ModTooltips.showEffectTipKey()) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
	}
}