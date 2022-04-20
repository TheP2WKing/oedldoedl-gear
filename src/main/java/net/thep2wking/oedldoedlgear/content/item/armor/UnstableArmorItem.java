package net.thep2wking.oedldoedlgear.content.item.armor;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.world.Explosion;
import net.minecraft.world.Explosion.Mode;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thep2wking.oedldoedlcore.api.ModArmorItemBase;
import net.thep2wking.oedldoedlresources.config.ResourcesConfig;
import net.thep2wking.oedldoedlresources.util.ModDamageSources;

@Mod.EventBusSubscriber
public class UnstableArmorItem extends ModArmorItemBase
{
	public UnstableArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
    {
		super(materialIn, slot, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}
	
	@SubscribeEvent
	public static void onItemDrop(ItemTossEvent e) 
	{  
	    PlayerEntity p = e.getPlayer();
	    ItemEntity entityItem = e.getEntityItem();
	    ItemStack stack = entityItem.getItem();
	    if (check(stack) && ResourcesConfig.enable_unstable_explosion.get() && !p.isCreative() && !p.isSpectator())
	    {
		    p.world.createExplosion(e.getPlayer(), e.getPlayer().getPosX(), e.getPlayer().getPosY(), e.getPlayer().getPosZ(), 10, Explosion.Mode.NONE);
		    p.attackEntityFrom(ModDamageSources.UNSTABLE, 1000);
		    e.setCanceled(true);
	    }
	}
	
	public static boolean check(ItemStack stack) 
	{
		return stack.getItem() instanceof UnstableArmorItem;
	}
	
	@Override
	public boolean isDamageable() 
	{
		return false;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) 
	{
		target.world.createExplosion(target, target.getPosX(), target.getPosY(), target.getPosZ(), 1, Mode.NONE);
		return super.hitEntity(stack, target, attacker);
	}
}