package net.thep2wking.oedldoedlgear.util;

import net.minecraft.entity.passive.HorseArmorType;
import net.thep2wking.oedldoedlcore.api.armor.ModHorseArmorMaterialBase;
import net.thep2wking.oedldoedlgear.OedldoedlGear;

public class ModHorseArmorMaterial {
	public static final HorseArmorType CHAIN = ModHorseArmorMaterialBase.addHorseArmorMaterial(OedldoedlGear.MODID,
			"chainmail", "chainmail_horse_armor", 4);
	public static final HorseArmorType EMERALD = ModHorseArmorMaterialBase.addHorseArmorMaterial(OedldoedlGear.MODID,
			"emerald", "emerald_horse_armor", 12);
	public static final HorseArmorType BASE = ModHorseArmorMaterialBase.addHorseArmorMaterial(OedldoedlGear.MODID,
			"base", "base_horse_armor", 6);
}
