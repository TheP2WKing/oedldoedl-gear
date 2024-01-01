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
import net.thep2wking.oedldoedlcore.util.ModReferences;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;

@Mod.EventBusSubscriber
public class ItemArgentoriumArmor extends ModItemArmorBase {
	public enum AttributeUUIDArg {
		HELMET_UUID("711b80d3-e561-4a7d-9c4a-2edb008ccaad"), CHESTPLATE_UUID("faaea4eb-ca15-49e5-a741-46d169adf826"),
		LEGGINGS_UUID("123b072e-0e57-4535-9d3e-c80eb01bd09e"), BOOTS_UUID("5f2aed44-f8a9-483d-b513-d3bee1279dcb");

		public String ids;

		AttributeUUIDArg(String ids) {
			this.ids = ids;
		}
	}

	public AttributeUUIDArg uuid;

	public ItemArgentoriumArmor(String modid, String name, CreativeTabs tab, ArmorMaterial material, int renderIndex,
			EntityEquipmentSlot slot, AttributeUUIDArg uuid, EnumRarity rarity, boolean hasEffect, int tooltipLines,
			int annotationLines) {
		super(modid, name, tab, material, renderIndex, slot, rarity, hasEffect, tooltipLines, annotationLines);
		this.uuid = uuid;
	}

	@Override
	public int getMaxDamage(ItemStack stack) {
		return 8355;
	}

	public static final UUID HELMET_UUID = UUID.fromString("b50da645-e7f0-42f8-ae0f-53c638c8a699");
	public static final UUID CHESTPLATE_UUID = UUID.fromString("663d7a4b-a0cc-46e2-884c-a7e81f7b4853");
	public static final UUID LEGGINGS_UUID = UUID.fromString("ce943ee0-ba7e-41ee-930a-7f97e28d287c");
	public static final UUID BOOTS_UUID = UUID.fromString("68c8e01f-3a53-4e45-93f8-b822aecaff21");

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		Multimap<String, AttributeModifier> attributes = LinkedHashMultimap.create();
		if (slot == this.getEquipmentSlot()) {
			attributes.putAll(super.getAttributeModifiers(this.getEquipmentSlot(), new ItemStack(this)));
			attributes.put(SharedMonsterAttributes.MAX_HEALTH.getName(),
					new AttributeModifier(UUID.fromString(this.uuid.ids), ModReferences.ATTRIBUTE_MAX_HEALTH, 10,
							AttributeModifierOperation.ADD));
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
		if (ModArmorHelper.hasFullArmorSet(player, ModItems.ARGENTORIUM_HELMET, ModItems.ARGENTORIUM_CHESTPLATE,
				ModItems.ARGENTORIUM_LEGGINGS, ModItems.ARGENTORIUM_BOOTS)) {
			if (GearConfig.PROPERTIES.ARMOR_STEP_UP) {
				player.stepHeight = 1.1f;
			}
			if (GearConfig.PROPERTIES.ARMOR_UNLIMITED_AIR) {
				player.setAir(300);
			}
			if (GearConfig.PROPERTIES.ARMOR_NIGHT_VISION) {
				player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0, false, false));
			}

			if (player.isSneaking()) {
				player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 100, 0, false, false));
			}
			player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 200, 1, false, false));
		} else {
			player.stepHeight = 0.6F;
		}
	}

	@SubscribeEvent
	@SuppressWarnings("null")
	public static void onLivingHurt(LivingHurtEvent event) {
		if (event.getSource() instanceof EntityDamageSource
				&& !((EntityDamageSource) event.getSource()).getIsThornsDamage()) {
			if (event.getSource().getTrueSource() instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
				if (ModArmorHelper.hasFullArmorSet(player, ModItems.ARGENTORIUM_HELMET, ModItems.ARGENTORIUM_CHESTPLATE,
						ModItems.ARGENTORIUM_LEGGINGS, ModItems.ARGENTORIUM_BOOTS)) {
					if (event.getEntityLiving().isEntityUndead()) {
						event.getEntityLiving().setHealth(event.getEntityLiving().getHealth() - 14.5f);
					} else if (player.isSneaking()) {
						event.getEntityLiving()
								.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 40, 3, false, false));
					}
				}
			}
		}
	}

	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".argentorium_armor";

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
			ModTooltips.addPotionEffect(tooltip, MobEffects.SATURATION.getName(), false, 2, 200);
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