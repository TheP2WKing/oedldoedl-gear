package net.thep2wking.oedldoedlgear.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.content.entity.EntityChargedDynamite;
import net.thep2wking.oedldoedlgear.content.entity.EntityChargedEssence;
import net.thep2wking.oedldoedlgear.content.entity.EntityCombatDynamite;
import net.thep2wking.oedldoedlgear.content.entity.EntityDynamite;
import net.thep2wking.oedldoedlgear.content.entity.EntityExplosionCore;
import net.thep2wking.oedldoedlgear.content.entity.EntityExplosiveSnowball;
import net.thep2wking.oedldoedlgear.content.entity.EntityRockySnowball;

public class ModEntities {
	public static void registerEntities() {
		ModLogger.registeredEntitiesLogger(OedldoedlGear.MODID);

		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "rocky_snowball"),
				EntityRockySnowball.class, OedldoedlGear.MODID + "." + "rocky_snowball", 0, OedldoedlGear.INSTANCE, 64,
				10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "explosive_snowball"),
				EntityExplosiveSnowball.class, OedldoedlGear.MODID + "." + "explosive_snowball", 1,
				OedldoedlGear.INSTANCE, 64, 10, true);

		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "dynamite"),
				EntityDynamite.class, OedldoedlGear.MODID + "." + "dynamite", 2, OedldoedlGear.INSTANCE, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "combat_dynamite"),
				EntityCombatDynamite.class, OedldoedlGear.MODID + "." + "combat_dynamite", 3, OedldoedlGear.INSTANCE,
				64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "charged_dynamite"),
				EntityChargedDynamite.class, OedldoedlGear.MODID + "." + "charged_dynamite", 4, OedldoedlGear.INSTANCE,
				64, 10, true);

		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "explosion_core"),
				EntityExplosionCore.class, OedldoedlGear.MODID + "." + "explosion_core", 5, OedldoedlGear.INSTANCE, 64,
				10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "charged_essence"),
				EntityChargedEssence.class, OedldoedlGear.MODID + "." + "charged_essence", 6, OedldoedlGear.INSTANCE,
				64, 10, true);
	}
}