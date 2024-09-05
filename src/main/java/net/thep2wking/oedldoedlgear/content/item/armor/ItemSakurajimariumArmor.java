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
import net.thep2wking.oedldoedlcore.util.ModArmorHelper;
import net.thep2wking.oedldoedlcore.util.ModReferences;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;

@Mod.EventBusSubscriber
public class ItemSakurajimariumArmor extends ModItemArmorBase {
	public enum SakurajimariumUUIDs {
		HELMET_UUID("092d66c4-4e3f-4f0d-979e-4214d6b65bab"), CHESTPLATE_UUID("b5e3c8ca-413f-4d28-8926-884aec7fff2e"),
		LEGGINGS_UUID("7bd2e158-94b1-4eac-b2c6-0e22b4a0e682"), BOOTS_UUID("0339ce06-1dea-4b77-8e1c-3f36007a8876");

		public String ids;

		SakurajimariumUUIDs(String ids) {
			this.ids = ids;
		}
	}

	public SakurajimariumUUIDs uuid;

	public ItemSakurajimariumArmor(String modid, String name, CreativeTabs tab, ArmorMaterial material, int renderIndex,
			EntityEquipmentSlot slot, SakurajimariumUUIDs uuid, EnumRarity rarity, boolean hasEffect, int tooltipLines,
			int annotationLines) {
		super(modid, name, tab, material, renderIndex, slot, rarity, hasEffect, tooltipLines, annotationLines);
		this.uuid = uuid;
	}

	@Override
	public int getMaxDamage(ItemStack stack) {
		return 8054;
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		Multimap<String, AttributeModifier> multimap = LinkedHashMultimap.create();
		if (slot == armorType) {
			multimap.putAll(super.getAttributeModifiers(slot, stack));
		}
		if (slot == armorType && GearConfig.PROPERTIES.ARMOR_KNOCKBACK_RESISTANCE) {
			ModArmorHelper.addFullArmorModifier(multimap, stack, slot, SharedMonsterAttributes.KNOCKBACK_RESISTANCE,
					ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, 1, AttributeModifierOperation.ADD);
		}
		if (slot == armorType) {
			multimap.put(EntityPlayer.REACH_DISTANCE.getName(),
					new AttributeModifier(UUID.fromString(this.uuid.ids), ModReferences.ATTRIBUTE_REACH_DISTANCE, 0.5,
							AttributeModifierOperation.ADD));
		}
		return multimap;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (ModArmorHelper.hasFullArmorSet(player, ModItems.SAKURAJIMARIUM_HELMET, ModItems.SAKURAJIMARIUM_CHESTPLATE,
				ModItems.SAKURAJIMARIUM_LEGGINGS, ModItems.SAKURAJIMARIUM_BOOTS)) {
			if (GearConfig.PROPERTIES.ARMOR_STEP_UP) {
				player.stepHeight = 1.1f;
			}
			if (GearConfig.PROPERTIES.ARMOR_UNLIMITED_AIR) {
				player.setAir(300);
			}
			if (GearConfig.PROPERTIES.ARMOR_NIGHT_VISION) {
				player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0, false, false));
			}

			player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 200, 5, false, false));

			if (player.isSneaking()) {
				world.setWorldTime(world.getWorldTime() + 50);
			}
		}
	}

	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".sakurajimarium_armor";

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
			ModTooltips.addPotionEffect(tooltip, MobEffects.JUMP_BOOST.getName(), false, 6, 200);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 2);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 3);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 4);
		} else if (ModTooltips.showEffectTipKey()) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
	}
}