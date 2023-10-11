package net.thep2wking.oedldoedlgear.content.item.tool;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.thep2wking.oedldoedlcore.api.tool.ModItemSmashbatBase;
import net.thep2wking.oedldoedlcore.util.ModHitSound;

public class ItemLightningSmashbat extends ModItemSmashbatBase {
	public ItemLightningSmashbat(String modid, String name, CreativeTabs tab, ToolMaterial material, float attackDamage,
			float attackSpeed, double horizontalMotion, double verticalMotion, ModHitSound hitSound, EnumRarity rarity,
			boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, material, attackDamage, attackSpeed, horizontalMotion, verticalMotion, hitSound, rarity,
				hasEffect, tooltipLines, annotationLines);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		lightningEvent.put(target.getEntityId(), new DelayedLightningEvent());
		return super.hitEntity(stack, target, attacker);
	}

	@SuppressWarnings("all")
	public static HashMap<Integer, DelayedLightningEvent> lightningEvent = new HashMap();

	public static class DelayedLightningEvent {
		public int targetEntityId;
		public int attackerEntityId;
	}
}