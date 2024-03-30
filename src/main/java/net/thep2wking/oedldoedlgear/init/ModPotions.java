package net.thep2wking.oedldoedlgear.init;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.thep2wking.oedldoedlcore.api.potion.ModPotionTypeBase;
import net.thep2wking.oedldoedlcore.util.ModPotionTypes;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.content.potion.PotionFlight;
import net.thep2wking.oedldoedlgear.content.potion.PotionMilk;
import net.thep2wking.oedldoedlgear.content.potion.PotionMosesBlood;

public class ModPotions {
	public static final Potion FLIGHT = new PotionFlight(OedldoedlGear.MODID, "flight", false, false, 0x8c8ca2 , 0, 0);
	public static final Potion MILK = new PotionMilk(OedldoedlGear.MODID, "milk", false, true, 0xffffff , 1, 0);
	public static final Potion MOSES_BLOOD = new PotionMosesBlood(OedldoedlGear.MODID, "moses_blood", false, true, 0x3f0000 , 2, 0);

	public static final PotionType FLIGHT_NORMAL = ModPotionTypeBase.addPotionType(FLIGHT, 3600, 1, ModPotionTypes.NORMAL);
	public static final PotionType FLIGHT_LONG = ModPotionTypeBase.addPotionType(FLIGHT, 9600, 1, ModPotionTypes.LONG);

	public static final PotionType MILK_NORMAL = ModPotionTypeBase.addPotionType(MILK, 0, 1, ModPotionTypes.NORMAL);

	public static final PotionType MOSES_BLOOD_NORMAL = ModPotionTypeBase.addPotionType(MOSES_BLOOD, 0, 1, ModPotionTypes.NORMAL);
}