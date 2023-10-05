package net.thep2wking.oedldoedlgear.content.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
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
		target.world.addWeatherEffect(new EntityLightningBolt(target.world, target.posX, target.posY, target.posZ, false));
		return super.hitEntity(stack, target, attacker);
	}
}