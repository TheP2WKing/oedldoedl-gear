package net.thep2wking.oedldoedlgear.init;

import net.minecraftforge.fluids.Fluid;
import net.thep2wking.oedldoedlcore.api.fluid.ModFluidBase;
import net.thep2wking.oedldoedlcore.util.ModFluidUtil;
import net.thep2wking.oedldoedlcore.util.ModRarities;
import net.thep2wking.oedldoedlgear.OedldoedlGear;

public class ModFluids {
	public static final Fluid MOSES_BLOOD = new ModFluidBase(OedldoedlGear.MODID, "moses_blood", ModFluidUtil.LIQUID_STILL_BASE, ModFluidUtil.LIQUID_FLOW_BASE, 0x3f0000, 300, 1000, 1000, 0, false, ModRarities.YELLOW);
	public static final Fluid DEATH = new ModFluidBase(OedldoedlGear.MODID, "death", ModFluidUtil.LIQUID_STILL_BASE, ModFluidUtil.LIQUID_FLOW_BASE, 0x2d075e, 300, 1000, 1000, 0, false, ModRarities.LIGHT_PURPLE);
}