package net.thep2wking.oedldoedlgear.content.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.thep2wking.oedldoedlcore.api.tool.ModItemSmashbatBase;
import net.thep2wking.oedldoedlcore.util.ModHitSound;

public class ItemBlastingSmashbat extends ModItemSmashbatBase {
	public ItemBlastingSmashbat(String modid, String name, CreativeTabs tab, ToolMaterial material, float attackDamage,
			float attackSpeed, double horizontalMotion, double verticalMotion, ModHitSound hitSound, EnumRarity rarity,
			boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, material, attackDamage, attackSpeed, horizontalMotion, verticalMotion, hitSound, rarity,
				hasEffect, tooltipLines, annotationLines);
	}

	@Override
	public void setEntitySmashMotion(EntityLivingBase target) {
		target.motionX *= (horizontalMotion / 2);
		target.motionY *= (verticalMotion / 4);
		target.motionZ *= (horizontalMotion / 2);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		target.world.newExplosion(attacker, target.posX, target.posY, target.posZ, 1.0f, false, false);
		this.setEntitySmashMotion(target);
		return super.hitEntity(stack, target, attacker);
	}
}