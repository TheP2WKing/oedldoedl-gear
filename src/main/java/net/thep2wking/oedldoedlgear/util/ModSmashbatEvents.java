package net.thep2wking.oedldoedlgear.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemLaunchingSmashbat;
import net.thep2wking.oedldoedlgear.content.item.tool.ItemLightningSmashbat;

@Mod.EventBusSubscriber
public class ModSmashbatEvents {
    @SubscribeEvent
    public static void onEntityLivingFall(LivingFallEvent event) {
        ItemLightningSmashbat.lightningEvent.remove(event.getEntity().getEntityId());
        ItemLaunchingSmashbat.explosionEvent.remove(event.getEntity().getEntityId());
    }

    @SubscribeEvent
    public static void onEntityLivingDead(LivingDeathEvent event) {
        ItemLightningSmashbat.lightningEvent.remove(event.getEntity().getEntityId());
        ItemLaunchingSmashbat.explosionEvent.remove(event.getEntity().getEntityId());
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void onUpdate(LivingEvent.LivingUpdateEvent event) {
        ItemLightningSmashbat.DelayedLightningEvent lightningImpact;
        ItemLaunchingSmashbat.DelayedExplosionEvent explosionImpact;
        Entity entity = event.getEntity();
        if (!entity.world.isRemote && (double) entity.fallDistance > 0.25
                && (lightningImpact = ItemLightningSmashbat.lightningEvent.get(entity.getEntityId())) != null) {
            ItemLightningSmashbat.lightningEvent.remove(event.getEntity().getEntityId());
            entity.world.addWeatherEffect(
                    new EntityLightningBolt(entity.world, entity.posX, entity.posY, entity.posZ, false));
        }

        if (!entity.world.isRemote && (double) entity.fallDistance > 0.25
                && (explosionImpact = ItemLaunchingSmashbat.explosionEvent.get(entity.getEntityId())) != null) {
            ItemLaunchingSmashbat.explosionEvent.remove(event.getEntity().getEntityId());
            entity.world.newExplosion(null, entity.posX, entity.posY, entity.posZ,
                    GearConfig.CONTENT.SMASHBATS.LAUNCHING_SMASHBAT_EXPLOSION_STRENGTH,
                    GearConfig.CONTENT.SMASHBATS.LAUNCHING_SMASHBAT_EXPLOSION_FIRE,
                    GearConfig.CONTENT.SMASHBATS.LAUNCHING_SMASHBAT_EXPLOSION_DAMAGE);
        }
    }
}