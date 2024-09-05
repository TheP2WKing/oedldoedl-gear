package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;

import javax.annotation.Nullable;

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
import net.thep2wking.oedldoedlcore.util.ModArmorHelper;
import net.thep2wking.oedldoedlcore.util.ModPotionUtil;
import net.thep2wking.oedldoedlcore.util.ModReferences;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;
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

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);
		if (slot == armorType && GearConfig.PROPERTIES.ARMOR_KNOCKBACK_RESISTANCE) {
			ModArmorHelper.addFullArmorModifier(multimap, stack, slot, SharedMonsterAttributes.KNOCKBACK_RESISTANCE,
					ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, 1, AttributeModifierOperation.ADD);
		}
		return multimap;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (ModArmorHelper.hasFullArmorSet(player, ModItems.NAGATORIUM_HELMET, ModItems.NAGATORIUM_CHESTPLATE,
				ModItems.NAGATORIUM_LEGGINGS, ModItems.NAGATORIUM_BOOTS)) {
			if (GearConfig.PROPERTIES.ARMOR_STEP_UP) {
				player.stepHeight = 1.1f;
			}
			if (GearConfig.PROPERTIES.ARMOR_UNLIMITED_AIR) {
				player.setAir(300);
			}
			if (GearConfig.PROPERTIES.ARMOR_NIGHT_VISION) {
				player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0, false, false));
			}

			ModPotionUtil.invertEffect(player, MobEffects.HUNGER, MobEffects.SATURATION, 200, 0);
			ModPotionUtil.invertEffect(player, MobEffects.INSTANT_DAMAGE, MobEffects.INSTANT_HEALTH, 200, 0);
			ModPotionUtil.invertEffect(player, MobEffects.MINING_FATIGUE, MobEffects.HASTE, 200, 0);
			ModPotionUtil.invertEffect(player, MobEffects.POISON, MobEffects.REGENERATION, 200, 0);
			ModPotionUtil.invertEffect(player, MobEffects.SLOWNESS, MobEffects.SPEED, 200, 0);
			ModPotionUtil.invertEffect(player, MobEffects.WEAKNESS, MobEffects.STRENGTH, 200, 0);
			ModPotionUtil.invertEffect(player, MobEffects.WITHER, MobEffects.REGENERATION, 200, 0);

			player.removePotionEffect(MobEffects.LEVITATION);
			player.removePotionEffect(MobEffects.BLINDNESS);
			player.removePotionEffect(MobEffects.GLOWING);
			player.removePotionEffect(MobEffects.INVISIBILITY);
			player.removePotionEffect(MobEffects.NAUSEA);
			player.removePotionEffect(MobEffects.UNLUCK);

			player.addPotionEffect(new PotionEffect(MobEffects.UNLUCK, 200, 9, false, false));
		}
	}

	@SubscribeEvent
	public static void onLivingHurt(LivingHurtEvent event) {
		if (event.getSource() instanceof EntityDamageSource
				&& !((EntityDamageSource) event.getSource()).getIsThornsDamage()) {
			if (event.getSource().getTrueSource() instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
				if (ModArmorHelper.hasFullArmorSet(player, ModItems.NAGATORIUM_HELMET, ModItems.NAGATORIUM_CHESTPLATE,
						ModItems.NAGATORIUM_LEGGINGS, ModItems.NAGATORIUM_BOOTS)) {
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
			ModTooltips.addPotionEffect(tooltip, MobEffects.UNLUCK.getName(), true, 10, 200);
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