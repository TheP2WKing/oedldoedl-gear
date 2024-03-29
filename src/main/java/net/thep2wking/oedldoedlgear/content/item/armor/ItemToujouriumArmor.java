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
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.armor.ModItemArmorBase;
import net.thep2wking.oedldoedlcore.util.ModArmorHelper;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;

@Mod.EventBusSubscriber
public class ItemToujouriumArmor extends ModItemArmorBase {
	public enum ToujouriumUUIDs {
		HELMET_UUID("72973f80-73c6-434e-bbce-cb28a5c5d6c3"), CHESTPLATE_UUID("edddc8d4-84a4-42fa-8654-d5704ca26225"),
		LEGGINGS_UUID("0222ad71-5a72-4490-acce-fd8fb8eb70ee"), BOOTS_UUID("1229d236-1cbd-4415-b367-1f0ed5a00ae6");

		public String ids;

		ToujouriumUUIDs(String ids) {
			this.ids = ids;
		}
	}

	public ToujouriumUUIDs uuid;

	public ItemToujouriumArmor(String modid, String name, CreativeTabs tab, ArmorMaterial material, int renderIndex,
			EntityEquipmentSlot slot, ToujouriumUUIDs uuid, EnumRarity rarity, boolean hasEffect, int tooltipLines,
			int annotationLines) {
		super(modid, name, tab, material, renderIndex, slot, rarity, hasEffect, tooltipLines, annotationLines);
		this.uuid = uuid;
	}

	@Override
	public int getMaxDamage(ItemStack stack) {
		return 6757;
	}

	public static final UUID HELMET_UUID = UUID.fromString("9b138dbb-5bf2-4d7e-a847-4f00028282d5");
	public static final UUID CHESTPLATE_UUID = UUID.fromString("3e14006b-b061-442f-82c8-c01a45aa447e");
	public static final UUID LEGGINGS_UUID = UUID.fromString("f7a931a6-df2b-4252-af36-3b6ba816b698");
	public static final UUID BOOTS_UUID = UUID.fromString("85c94001-ad40-4dfc-8b7a-da670c35ec10");

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		Multimap<String, AttributeModifier> attributes = LinkedHashMultimap.create();
		if (slot == this.getEquipmentSlot()) {
			attributes.putAll(super.getAttributeModifiers(this.getEquipmentSlot(), new ItemStack(this)));
			if (GearConfig.PROPERTIES.ARMOR_KNOCKBACK_RESISTANCE) {
				ModArmorHelper.addKnockbackResistanceModifier(attributes, this, slot, HELMET_UUID, CHESTPLATE_UUID,
						LEGGINGS_UUID, BOOTS_UUID, 1);
			}
			return attributes;
		}
		return attributes;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (ModArmorHelper.hasFullArmorSet(player, ModItems.TOUJOURIUM_HELMET, ModItems.TOUJOURIUM_CHESTPLATE,
				ModItems.TOUJOURIUM_LEGGINGS, ModItems.TOUJOURIUM_BOOTS)) {
			if (GearConfig.PROPERTIES.ARMOR_STEP_UP) {
				player.stepHeight = 1.1f;
			}
			if (GearConfig.PROPERTIES.ARMOR_UNLIMITED_AIR) {
				player.setAir(300);
			}
			if (GearConfig.PROPERTIES.ARMOR_NIGHT_VISION) {
				player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0, false, false));
			}

			player.fallDistance = 0;

			player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 5, false, false));
		} else {
			player.stepHeight = 0.6F;
		}
	}

	@SubscribeEvent
	public static void onLivingFall(LivingFallEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			if (ModArmorHelper.hasFullArmorSet(player, ModItems.TOUJOURIUM_HELMET, ModItems.TOUJOURIUM_CHESTPLATE,
					ModItems.TOUJOURIUM_LEGGINGS, ModItems.TOUJOURIUM_BOOTS)) {
				event.setDamageMultiplier(0);
				event.setDistance(0);
			}
		}
	}

	@SubscribeEvent
	public static void onLivingKnockback(LivingKnockBackEvent event) {
		if (event.getAttacker() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getAttacker();
			if (ModArmorHelper.hasFullArmorSet(player, ModItems.TOUJOURIUM_HELMET, ModItems.TOUJOURIUM_CHESTPLATE,
					ModItems.TOUJOURIUM_LEGGINGS, ModItems.TOUJOURIUM_BOOTS)) {
				event.setStrength(3);
			}
		}
	}

	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".toujourium_armor";

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
			ModTooltips.addPotionEffect(tooltip, MobEffects.SPEED.getName(), false, 6, 200);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 2);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 3);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 4);
		} else if (ModTooltips.showEffectTipKey()) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
	}
}