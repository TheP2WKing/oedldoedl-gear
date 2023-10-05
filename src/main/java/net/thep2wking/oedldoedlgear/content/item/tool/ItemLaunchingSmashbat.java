package net.thep2wking.oedldoedlgear.content.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.thep2wking.oedldoedlcore.api.tool.ModItemSmashbatBase;
import net.thep2wking.oedldoedlcore.util.ModHitSound;

@Mod.EventBusSubscriber
public class ItemLaunchingSmashbat extends ModItemSmashbatBase {
	public ItemLaunchingSmashbat(String modid, String name, CreativeTabs tab, ToolMaterial material, float attackDamage,
			float attackSpeed, double horizontalMotion, double verticalMotion, ModHitSound hitSound, EnumRarity rarity,
			boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, material, attackDamage, attackSpeed, horizontalMotion, verticalMotion, hitSound, rarity,
				hasEffect, tooltipLines, annotationLines);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		target.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0f, 0.5f);
		return super.hitEntity(stack, target, attacker);
	}

	// @SubscribeEvent
    // public static void onUpdate(LivingEvent.LivingUpdateEvent event) {
    //     Entity entity = event.getEntityLiving();
	// 	if(!entity.world.isRemote && (double)entity.fallDistance > 0.5 && ) {
	// 		entity.world.createExplosion(null, entity.posX, entity.posY, entity.posZ, 2.0f, false);
	// 	}
    // }
}