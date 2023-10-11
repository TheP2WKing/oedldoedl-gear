package net.thep2wking.oedldoedlgear.content.item.tool;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.thep2wking.oedldoedlcore.api.tool.ModItemSmashbatBase;
import net.thep2wking.oedldoedlcore.util.ModHitSound;

@Mod.EventBusSubscriber
public class ItemLaunchingSmashbat extends ModItemSmashbatBase {
	public ItemLaunchingSmashbat(String modid, String name, CreativeTabs tab, ToolMaterial material, float attackDamage,
			float attackSpeed, double horizontalMotion, double verticalMotion, ModHitSound hitSound, EnumRarity rarity,
			boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, material, attackDamage, attackSpeed, horizontalMotion, verticalMotion, hitSound, rarity,
				hasEffect, tooltipLines, annotationLines);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		target.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0f, 0.5f);
		explosionEvent.put(target.getEntityId(), new DelayedExplosionEvent());
		return super.hitEntity(stack, target, attacker);
	}

	@SuppressWarnings("all")
	public static HashMap<Integer, DelayedExplosionEvent> explosionEvent = new HashMap();

	public static class DelayedExplosionEvent {
		public int targetEntityId;
		public int attackerEntityId;
	}
}