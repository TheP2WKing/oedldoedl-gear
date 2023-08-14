package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.AttributeModifierOperation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.armor.ModItemArmorBase;
import net.thep2wking.oedldoedlcore.util.ModReferences;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.init.ModItems;

@Mod.EventBusSubscriber
public class ItemKitagawariumArmor extends ModItemArmorBase {
	public ItemKitagawariumArmor(String modid, String name, CreativeTabs tab, ArmorMaterial material, int renderIndex,
			EntityEquipmentSlot slot, EnumRarity rarity, boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, material, renderIndex, slot, rarity, hasEffect, tooltipLines, annotationLines);
	}

	@Override
	public int getMaxDamage(ItemStack stack) {
		return 8658;
	}

	public static final UUID HELMET_UUID = UUID.fromString("71f82823-01c2-4f84-99f2-0911578165ce");
	public static final UUID CHESTPLATE_UUID = UUID.fromString("25a9184d-8712-44cd-abc6-bb94e979a92e");
	public static final UUID LEGGINGS_UUID = UUID.fromString("dfca663b-0fc4-4c48-83df-2a6a1c4711ca");
	public static final UUID BOOTS_UUID = UUID.fromString("83058706-db6e-4884-be09-a6d8d13fabf8");

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		Multimap<String, AttributeModifier> attributes = LinkedHashMultimap.create();
		if (slot == this.getEquipmentSlot()) {
			attributes.putAll(super.getAttributeModifiers(this.getEquipmentSlot(), new ItemStack(this)));
			if (slot == EntityEquipmentSlot.HEAD) {
				attributes.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(
						HELMET_UUID, ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, 1, AttributeModifierOperation.ADD));
			}
			if (slot == EntityEquipmentSlot.CHEST) {
				attributes.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(),
						new AttributeModifier(CHESTPLATE_UUID, ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, 1,
								AttributeModifierOperation.ADD));
			}
			if (slot == EntityEquipmentSlot.LEGS) {
				attributes.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(),
						new AttributeModifier(LEGGINGS_UUID, ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, 1,
								AttributeModifierOperation.ADD));
			}
			if (slot == EntityEquipmentSlot.FEET) {
				attributes.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(BOOTS_UUID,
						ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, 1, AttributeModifierOperation.ADD));
			}
			return attributes;
		}
		return attributes;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		ItemStack head = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		ItemStack legs = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
		ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
		ItemStack feet = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
		if (((!head.isEmpty()) && (head.getItem() == ModItems.KITAGAWARIUM_HELMET) && (!chest.isEmpty())
				&& (chest.getItem() == ModItems.KITAGAWARIUM_CHESTPLATE) && (!legs.isEmpty())
				&& (legs.getItem() == ModItems.KITAGAWARIUM_LEGGINGS) && (!feet.isEmpty())
				&& (feet.getItem() == ModItems.KITAGAWARIUM_BOOTS))) {
			player.stepHeight = 1.1f;
			player.setAir(300);

			player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 200, 1, false, false));
		}
	}

	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".kitagawarium_armor";

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
			ModTooltips.addPotionEffect(tooltip, MobEffects.WATER_BREATHING.getName(), false, 1, 200);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 2);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 3);
		} else if (ModTooltips.showEffectTipKey()) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
	}
}