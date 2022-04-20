package net.thep2wking.oedldoedlgear.content.item.tool.unstable;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.world.Explosion;
import net.minecraft.world.Explosion.Mode;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thep2wking.oedldoedlcore.api.ModShovelItemBase;
import net.thep2wking.oedldoedlresources.config.ResourcesConfig;
import net.thep2wking.oedldoedlresources.util.ModDamageSources;

@Mod.EventBusSubscriber
public class UnstableShovelItem extends ModShovelItemBase
{
	public UnstableShovelItem(IItemTier itemTier, float attackDamage, float attackSpeed, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(itemTier, attackDamage, attackSpeed, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
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
		return stack.getItem() instanceof UnstableShovelItem;
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