package net.thep2wking.oedldoedlgear.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.thep2wking.oedldoedlgear.content.entity.EntityChargedEssence;
import net.thep2wking.oedldoedlgear.content.entity.EntityChargedSnowball;
import net.thep2wking.oedldoedlgear.content.entity.EntityExplosionCore;
import net.thep2wking.oedldoedlgear.content.entity.EntityExplosiveSnowball;
import net.thep2wking.oedldoedlgear.content.entity.EntityRockySnowball;
import net.thep2wking.oedldoedlgear.init.ModItems;

public class ModRenderer {
	@SuppressWarnings("deprecation")
	public static void registerRenderer() {
		RenderingRegistry.registerEntityRenderingHandler(EntityRockySnowball.class,
				new RenderSnowball<EntityRockySnowball>(Minecraft.getMinecraft().getRenderManager(),
						ModItems.ROCKY_SNOWBALL, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveSnowball.class,
				new RenderSnowball<EntityExplosiveSnowball>(Minecraft.getMinecraft().getRenderManager(),
						ModItems.EXPLOSIVE_SNOWBALL, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityChargedSnowball.class,
				new RenderSnowball<EntityChargedSnowball>(Minecraft.getMinecraft().getRenderManager(),
						ModItems.CHARGED_SNOWBALL, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(EntityExplosionCore.class,
				new RenderSnowball<EntityExplosionCore>(Minecraft.getMinecraft().getRenderManager(),
						ModItems.EXPLOSION_CORE, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityChargedEssence.class,
				new RenderSnowball<EntityChargedEssence>(Minecraft.getMinecraft().getRenderManager(),
						ModItems.CHARGED_ESSENCE, Minecraft.getMinecraft().getRenderItem()));
	}
}