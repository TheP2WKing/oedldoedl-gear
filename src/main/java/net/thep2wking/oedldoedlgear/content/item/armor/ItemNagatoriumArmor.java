package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.AttributeModifierOperation;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.armor.ModItemArmorBase;
import net.thep2wking.oedldoedlcore.util.ModReferences;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.init.ModItems;

@Mod.EventBusSubscriber
public class ItemNagatoriumArmor extends ModItemArmorBase {
	public ItemNagatoriumArmor(String modid, String name, CreativeTabs tab, ArmorMaterial material, int renderIndex,
			EntityEquipmentSlot slot, EnumRarity rarity, boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, material, renderIndex, slot, rarity, hasEffect, tooltipLines, annotationLines);
	}

	@Override
	public int getMaxDamage(ItemStack stack) {
		return 7656;
	}

	public static final UUID HELMET_UUID = UUID.fromString("8ffc6b5f-b61a-4ba8-842b-e031f51faee0");
	public static final UUID CHESTPLATE_UUID = UUID.fromString("f21ebcb6-3726-46d2-b7b2-3ee77ff303ef");
	public static final UUID LEGGINGS_UUID = UUID.fromString("dfa3b11d-4b9e-4fef-be21-3727a64cf7b4");
	public static final UUID BOOTS_UUID = UUID.fromString("5f8d64cc-bfff-404e-8528-8a1fbd10e33a");

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

	public static void effectToInvert(EntityPlayer player, Potion effectIn, Potion effectOut) {
		if (player.isPotionActive(effectIn)) {
			player.removePotionEffect(effectIn);
			player.addPotionEffect(new PotionEffect(effectOut, 200, 1, false, false));
		}
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		ItemStack head = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		ItemStack legs = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
		ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
		ItemStack feet = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
		if (((!head.isEmpty()) && (head.getItem() == ModItems.NAGATORIUM_HELMET) && (!chest.isEmpty())
				&& (chest.getItem() == ModItems.NAGATORIUM_CHESTPLATE) && (!legs.isEmpty())
				&& (legs.getItem() == ModItems.NAGATORIUM_LEGGINGS) && (!feet.isEmpty())
				&& (feet.getItem() == ModItems.NAGATORIUM_BOOTS))) {
			player.stepHeight = 1.1f;
			player.setAir(300);

			player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 200, 9, false, false));

			effectToInvert(player, MobEffects.HUNGER, MobEffects.SATURATION);
			effectToInvert(player, MobEffects.INSTANT_DAMAGE, MobEffects.INSTANT_HEALTH);
			effectToInvert(player, MobEffects.MINING_FATIGUE, MobEffects.HASTE);
			effectToInvert(player, MobEffects.POISON, MobEffects.REGENERATION);
			effectToInvert(player, MobEffects.SLOWNESS, MobEffects.SPEED);
			effectToInvert(player, MobEffects.WEAKNESS, MobEffects.STRENGTH);
			effectToInvert(player, MobEffects.WITHER, MobEffects.REGENERATION);

			player.removePotionEffect(MobEffects.LEVITATION);
			player.removePotionEffect(MobEffects.BLINDNESS);
			player.removePotionEffect(MobEffects.GLOWING);
			player.removePotionEffect(MobEffects.INVISIBILITY);
			player.removePotionEffect(MobEffects.NAUSEA);
			player.removePotionEffect(MobEffects.UNLUCK);
		}
	}

	@SubscribeEvent
	@SuppressWarnings("null")
	public static void onLivingHurt(LivingHurtEvent event) {
		if (event.getSource() instanceof EntityDamageSource
				&& !((EntityDamageSource) event.getSource()).getIsThornsDamage()) {
			if (event.getSource().getTrueSource() instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
				ItemStack head = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
				ItemStack legs = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
				ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
				ItemStack feet = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
				if (((!head.isEmpty()) && (head.getItem() == ModItems.NAGATORIUM_HELMET) && (!chest.isEmpty())
						&& (chest.getItem() == ModItems.NAGATORIUM_CHESTPLATE) && (!legs.isEmpty())
						&& (legs.getItem() == ModItems.NAGATORIUM_LEGGINGS) && (!feet.isEmpty())
						&& (feet.getItem() == ModItems.NAGATORIUM_BOOTS))) {
					EntityLivingBase target = event.getEntityLiving();
					target.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 60, 0, false, false));
					target.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 60, 3, false, false));
					target.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100, 0, false, false));
					target.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 60, 4, false, false));
					target.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 60, 0, false, false));
					target.addPotionEffect(new PotionEffect(MobEffects.POISON, 60, 3, false, false));
					target.addPotionEffect(new PotionEffect(MobEffects.UNLUCK, 60, 9, false, false));
					target.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 60, 2, false, false));
					target.addPotionEffect(new PotionEffect(MobEffects.WITHER, 60, 2, false, false));

					if (player.isSneaking()) {
						target.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 100, 100, false, false));
					}
				}
			}
		}
	}

	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".nagatorium_armor";

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
			ModTooltips.addPotionEffect(tooltip, MobEffects.LUCK.getName(), false, 10, 200);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 2);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 3);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 4);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 5);
		} else if (ModTooltips.showEffectTipKey()) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
	}
}