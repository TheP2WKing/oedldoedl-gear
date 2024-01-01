package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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

public class ItemDirtArmor extends ModItemArmorBase {
	public ItemDirtArmor(String modid, String name, CreativeTabs tab, ArmorMaterial material, int renderIndex,
			EntityEquipmentSlot slot, EnumRarity rarity, boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, material, renderIndex, slot, rarity, hasEffect, tooltipLines, annotationLines);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (ModArmorHelper.hasFullArmorSet(player, ModItems.DIRT_HELMET, ModItems.DIRT_CHESTPLATE,
				ModItems.DIRT_LEGGINGS, ModItems.DIRT_BOOTS)) {
			player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 200, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 200, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 200, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 200, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 200, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 200, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 200, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 200, 0, false, false));

			if (!world.isRemote && player.isSneaking() && GearConfig.CONTENT.DIRT_ARMOR_SPAWNS_DIAMONDS) {
				world.spawnEntity(new EntityItem(world, player.posX, player.posY, player.posZ,
						new ItemStack(Items.DIAMOND, 1, 0)));
			}
		}
	}

	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".dirt_armor";

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
			ModTooltips.addPotionEffect(tooltip, MobEffects.WATER_BREATHING.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.FIRE_RESISTANCE.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.REGENERATION.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.JUMP_BOOST.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.NIGHT_VISION.getName(), false, 1, 400);
			ModTooltips.addPotionEffect(tooltip, MobEffects.ABSORPTION.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.RESISTANCE.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.SATURATION.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.STRENGTH.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.GLOWING.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.SPEED.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.HASTE.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.LUCK.getName(), false, 1, 200);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
		} else if (ModTooltips.showEffectTipKey()) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
	}
}