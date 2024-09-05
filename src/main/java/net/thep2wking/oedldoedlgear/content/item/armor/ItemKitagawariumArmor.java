package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;
import javax.annotation.Nullable;

import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.AttributeModifierOperation;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.armor.ModItemArmorBase;
import net.thep2wking.oedldoedlcore.init.ModPotions;
import net.thep2wking.oedldoedlcore.util.ModArmorHelper;
import net.thep2wking.oedldoedlcore.util.ModReferences;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;
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
		if (ModArmorHelper.hasFullArmorSet(player, ModItems.KITAGAWARIUM_HELMET, ModItems.KITAGAWARIUM_CHESTPLATE,
				ModItems.KITAGAWARIUM_LEGGINGS, ModItems.KITAGAWARIUM_BOOTS)) {
			if (GearConfig.PROPERTIES.ARMOR_STEP_UP) {
				player.stepHeight = 1.1f;
			}
			if (GearConfig.PROPERTIES.ARMOR_UNLIMITED_AIR) {
				player.setAir(300);
			}
			if (GearConfig.PROPERTIES.ARMOR_NIGHT_VISION) {
				player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0, false, false));
			}

			player.addPotionEffect(new PotionEffect(ModPotions.DOLPHIN_GRACE, 200, 2, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 200, 0, false, false));

			double radius = 6.0D;
			AxisAlignedBB area = player.getEntityBoundingBox().grow(radius);
			List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(player, area);
			for (Entity entity : entities) {
				if (entity.isEntityAlive() && !player.isSneaking() && entity instanceof IMob) {
					if (player.ticksExisted % 20 == 0) {
						entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 4.0F);
					}
					if (world.isDaytime()) {
						entity.setFire(5);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event.getSource().getTrueSource() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
			World world = event.getEntityLiving().getEntityWorld();
			if (ModArmorHelper.hasFullArmorSet(player, ModItems.KITAGAWARIUM_HELMET, ModItems.KITAGAWARIUM_CHESTPLATE,
					ModItems.KITAGAWARIUM_LEGGINGS, ModItems.KITAGAWARIUM_BOOTS)) {
				EntityLivingBase target = event.getEntityLiving();
				if (world.isDaytime()) {
					target.setFire(5);
				}
			}
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
			ModTooltips.addPotionEffect(tooltip, MobEffects.WATER_BREATHING.getName(), false, 1, 200);
			ModTooltips.addPotionEffect(tooltip, ModPotions.DOLPHIN_GRACE.getName(), false, 3, 200);
			ModTooltips.addPotionEffect(tooltip, MobEffects.NIGHT_VISION.getName(), false, 1, 400);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 2);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 3);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 4);
		} else if (ModTooltips.showEffectTipKey()) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
	}
}