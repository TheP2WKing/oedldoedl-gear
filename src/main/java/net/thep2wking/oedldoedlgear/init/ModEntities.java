package net.thep2wking.oedldoedlgear.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.content.entity.EntityChargedDynamite;
import net.thep2wking.oedldoedlgear.content.entity.EntityChargedEssence;
import net.thep2wking.oedldoedlgear.content.entity.EntityChunkTNTPrimed;
import net.thep2wking.oedldoedlgear.content.entity.EntityCombatDynamite;
import net.thep2wking.oedldoedlgear.content.entity.EntityDynamite;
import net.thep2wking.oedldoedlgear.content.entity.EntityExplosionCore;
import net.thep2wking.oedldoedlgear.content.entity.EntityExplosiveSnowball;
import net.thep2wking.oedldoedlgear.content.entity.EntityNukePrimed;
import net.thep2wking.oedldoedlgear.content.entity.EntityRockySnowball;
import net.thep2wking.oedldoedlgear.content.entity.EntityTrollTNTPrimed;

public class ModEntities {
	public static void registerEntities() {
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "nuke"),
				EntityNukePrimed.class, OedldoedlGear.MODID + "." + "nuke", 0, OedldoedlGear.INSTANCE, 160, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "troll_tnt"),
				EntityTrollTNTPrimed.class, OedldoedlGear.MODID + "." + "troll_tnt", 1, OedldoedlGear.INSTANCE, 160, 10,
				true);

		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "rocky_snowball"),
				EntityRockySnowball.class, OedldoedlGear.MODID + "." + "rocky_snowball", 2, OedldoedlGear.INSTANCE, 64,
				10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "explosive_snowball"),
				EntityExplosiveSnowball.class, OedldoedlGear.MODID + "." + "explosive_snowball", 3,
				OedldoedlGear.INSTANCE, 64, 10, true);

		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "dynamite"),
				EntityDynamite.class, OedldoedlGear.MODID + "." + "dynamite", 4, OedldoedlGear.INSTANCE, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "combat_dynamite"),
				EntityCombatDynamite.class, OedldoedlGear.MODID + "." + "combat_dynamite", 5, OedldoedlGear.INSTANCE,
				64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "charged_dynamite"),
				EntityChargedDynamite.class, OedldoedlGear.MODID + "." + "charged_dynamite", 6, OedldoedlGear.INSTANCE,
				64, 10, true);

		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "explosion_core"),
				EntityExplosionCore.class, OedldoedlGear.MODID + "." + "explosion_core", 7, OedldoedlGear.INSTANCE, 64,
				10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "charged_essence"),
				EntityChargedEssence.class, OedldoedlGear.MODID + "." + "charged_essence", 8, OedldoedlGear.INSTANCE,
				64, 10, true);

		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlGear.MODID, "chunk_tnt"),
				EntityChunkTNTPrimed.class, OedldoedlGear.MODID + "." + "chunk_tnt", 10, OedldoedlGear.INSTANCE, 160, 10,
				true);

	}
}