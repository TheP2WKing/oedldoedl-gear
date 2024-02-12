package net.thep2wking.oedldoedlgear.util;

import net.thep2wking.oedldoedlcore.util.ModRenderHelper;
import net.thep2wking.oedldoedlgear.content.entity.EntityChargedSnowball;
import net.thep2wking.oedldoedlgear.content.entity.EntityExplosiveSnowball;
import net.thep2wking.oedldoedlgear.content.entity.EntityRockySnowball;
import net.thep2wking.oedldoedlgear.init.ModItems;

public class ModRenderer {
	public static void registerRenderer() {
		ModRenderHelper.addThrowableRender(EntityRockySnowball.class, ModItems.ROCKY_SNOWBALL);
		ModRenderHelper.addThrowableRender(EntityExplosiveSnowball.class, ModItems.EXPLOSIVE_SNOWBALL);
		ModRenderHelper.addThrowableRender(EntityChargedSnowball.class, ModItems.CHARGED_SNOWBALL);
	}
}