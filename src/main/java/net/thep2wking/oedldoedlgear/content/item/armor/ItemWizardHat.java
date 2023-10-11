package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.annotation.Nullable;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.armor.ModItemArmorBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.model.ModelWizardHat;

public class ItemWizardHat extends ModItemArmorBase {
	public ItemWizardHat(String modid, String name, CreativeTabs tab, ArmorMaterial material, int renderIndex,
			EntityEquipmentSlot slot, EnumRarity rarity, boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, material, renderIndex, slot, rarity, hasEffect, tooltipLines, annotationLines);
	}

	public ResourceLocation getTexture() {
		return new ResourceLocation(modid, "textures/models/armor/" + name + "_layer_" + (renderIndex + 1) + ".png");
	}

	@Override
	@Nullable
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot,
			ModelBiped _default) {
		ModelBiped model = new ModelWizardHat(maxStackSize, getTexture());
		model.isChild = _default.isChild;
		model.isRiding = _default.isRiding;
		model.isSneak = _default.isSneak;
		model.rightArmPose = _default.rightArmPose;
		model.leftArmPose = _default.leftArmPose;
		return model == null ? _default : model;
	}

	@SuppressWarnings("null")
	public static void setPotion(ItemStack src, String potionEffectCode) {
		NBTTagCompound tag;
		if (!src.hasTagCompound()) {
			tag = new NBTTagCompound();
		} else {
			tag = src.getTagCompound();
		}
		tag.setString("Potion", potionEffectCode);
		src.setTagCompound(tag);
	}

	@SuppressWarnings("null")
	public static String getPotion(ItemStack src) {
		if (!src.hasTagCompound())
			return null;
		NBTTagCompound tag = src.getTagCompound();
		if (tag.hasKey("Potion")) {
			return tag.getString("Potion");
		} else {
			return null;
		}
	}

	@SuppressWarnings("null")
	public static void setPotionEffectLevel(ItemStack src, int level) {
		NBTTagCompound tag;
		if (!src.hasTagCompound()) {
			tag = new NBTTagCompound();
		} else {
			tag = src.getTagCompound();
		}
		tag.setByte("PotionLvl", (byte) level);
		src.setTagCompound(tag);
	}

	@SuppressWarnings("null")
	public static int getPotionEffectLevel(ItemStack src) {
		if (!src.hasTagCompound())
			return 0;
		NBTTagCompound tag = src.getTagCompound();
		if (tag.hasKey("PotionLvl")) {
			return tag.getByte("PotionLvl");
		} else {
			return 0;
		}
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack src) {
		super.onArmorTick(world, player, src);
		if (getPotion(src) == null) {
			if (!player.getActivePotionEffects().isEmpty()) {
				Collection<PotionEffect> c = player.getActivePotionEffects();
				PotionEffect[] effect = c.toArray(new PotionEffect[c.size()]);
				int i = world.rand.nextInt(effect.length);
				String potionCode = Objects.requireNonNull(effect[i].getPotion().getRegistryName()).toString();
				setPotion(src, potionCode);
				setPotionEffectLevel(src, effect[i].getAmplifier());
				player.removePotionEffect(effect[i].getPotion());
			}
		} else {
			Potion potion = Potion.getPotionFromResourceLocation(getPotion(src));
			if (potion == null) {
				return;
			}
			int level = getPotionEffectLevel(src);
			player.addPotionEffect(new PotionEffect(potion, 400, level, false, false));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings("null")
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip()) {
			String potionID = getPotion(stack);
			if (potionID != null && Potion.getPotionFromResourceLocation(potionID) != null) {
				tooltip.add(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor()
						+ I18n.format(this.getUnlocalizedName() + ".annotation1") + " " + TextFormatting.YELLOW
						+ I18n.format(Objects.requireNonNull(Potion.getPotionFromResourceLocation(potionID).getName()))
						+ " (" + (getPotionEffectLevel(stack) + 1) + ")");
			} else {
				tooltip.add(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor()
						+ I18n.format(this.getUnlocalizedName() + ".annotation1") + " " + TextFormatting.YELLOW
						+ I18n.format(this.getUnlocalizedName() + ".annotation2"));
			}
		}
		if (ModTooltips.showInfoTip()) {
			for (int i = 1; i <= tooltipLines; ++i) {
				ModTooltips.addInformation(tooltip, this.getUnlocalizedName(), i);
			}
		} else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0)) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}
	}
}