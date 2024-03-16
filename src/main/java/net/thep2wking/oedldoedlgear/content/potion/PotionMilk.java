package net.thep2wking.oedldoedlgear.content.potion;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.thep2wking.oedldoedlcore.api.potion.ModPotionBase;

public class PotionMilk extends ModPotionBase {
	public PotionMilk(String modid, String name, boolean isBad, boolean isInstant, int color, int posX, int posY) {
		super(modid, name, isBad, isInstant, color, posX, posY);
	}

	@Override
	public void affectEntity(Entity source, Entity indirectSource, EntityLivingBase entityLivingBaseIn, int amplifier,
			double health) {
		entityLivingBaseIn.clearActivePotions();
	}

	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
		entityLivingBaseIn.clearActivePotions();
	}

	@Override
	public boolean hasStatusIcon() {
		return false;
	}
}