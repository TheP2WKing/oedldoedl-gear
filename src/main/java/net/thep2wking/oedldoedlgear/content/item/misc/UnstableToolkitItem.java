package net.thep2wking.oedldoedlgear.content.item.misc;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.world.Explosion;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlresources.config.ResourcesConfig;
import net.thep2wking.oedldoedlresources.util.ModDamageSources;

@Mod.EventBusSubscriber
public class UnstableToolkitItem extends ModItemBase
{
	public UnstableToolkitItem(Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
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
		return stack.getItem() instanceof UnstableToolkitItem;
	}
}