package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
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
import net.thep2wking.oedldoedlcore.util.ModTooltips;

public class ItemTravellersBoots extends ModItemArmorBase {
	public final int speedAmplifier;
	public final int jumpBoostAmplifier;

	public ItemTravellersBoots(String modid, String name, CreativeTabs tab, ArmorMaterial material, int renderIndex,
			EntityEquipmentSlot slot, int speedAmplifier, int jumpBoostAmplifier, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, material, renderIndex, slot, rarity, hasEffect, tooltipLines, annotationLines);
		this.speedAmplifier = speedAmplifier;
		this.jumpBoostAmplifier = jumpBoostAmplifier;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		ItemStack feet = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
		if ((!feet.isEmpty()) && (feet.getItem() == this)) {
			player.stepHeight = 1.1f;
			if (jumpBoostAmplifier >= 1) {
				player.addPotionEffect(
						new PotionEffect(MobEffects.JUMP_BOOST, 200, jumpBoostAmplifier - 1, false, false));
			}
			player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, speedAmplifier - 1, false, false));
		} else {
			player.stepHeight = 0.6F;
		}
	}

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
			ModTooltips.addEffectHeader(tooltip, ModTooltips.EFFECT_BOOTS);
			if (jumpBoostAmplifier >= 1) {
				ModTooltips.addPotionEffect(tooltip, MobEffects.JUMP_BOOST.getName(), false, jumpBoostAmplifier, 200);
			}
			ModTooltips.addPotionEffect(tooltip, MobEffects.SPEED.getName(), false, speedAmplifier, 200);
		} else if (ModTooltips.showEffectTipKey()) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
	}
}