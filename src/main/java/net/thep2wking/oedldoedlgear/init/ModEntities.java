package net.thep2wking.oedldoedlgear.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.content.entity.EntityChargedSnowball;
import net.thep2wking.oedldoedlgear.content.entity.EntityExplosiveSnowball;
import net.thep2wking.oedldoedlgear.content.entity.EntityRockySnowball;

public class ModEntities {
	public static void registerEntities() {
		ModLogger.registeredEntitiesLogger(OedldoedlGear.MODID);

		int id = 0;
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "rocky_snowball"),
				EntityRockySnowball.class, OedldoedlGear.MODID + "." + "rocky_snowball", id++, OedldoedlGear.INSTANCE, 64,
				10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "explosive_snowball"),
				EntityExplosiveSnowball.class, OedldoedlGear.MODID + "." + "explosive_snowball", id++,
				OedldoedlGear.INSTANCE, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "charged_snowball"),
				EntityChargedSnowball.class, OedldoedlGear.MODID + "." + "charged_snowball", id++,
				OedldoedlGear.INSTANCE, 64, 10, true);
	}
}