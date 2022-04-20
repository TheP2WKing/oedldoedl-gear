package net.thep2wking.oedldoedlgear.content.item.tool.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.Util;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlgear.config.GearConfig;

public class KickStickItem extends ModItemBase
{
	public KickStickItem(Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}

	@Override
	public boolean isDamageable() 
	{
		return false;
	}
	
	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) 
	{
		return Integer.MAX_VALUE;
	}

	@SuppressWarnings("resource")
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) 
	{
		if(target instanceof CowEntity && GearConfig.enable_admin_tools.get())
		{
			PlayerEntity player = (PlayerEntity) attacker;
			PlayerEntity playerTarget = (PlayerEntity) target;
			if(target instanceof CowEntity && attacker.hasPermissionLevel(3))
			{
				Minecraft.getInstance().player.sendChatMessage("/kick " + playerTarget.getGameProfile().getName() + " " + GearConfig.kick_stick_reason_message.get());
				IFormattableTextComponent message = new StringTextComponent("[")
						.appendSibling(new TranslationTextComponent(this.getTranslationKey()).mergeStyle(TextFormatting.RED))
						.appendSibling(new StringTextComponent("] "))
						.appendSibling(new TranslationTextComponent("message.oedldoedlgear.kick_stick.succes").mergeStyle(TextFormatting.ITALIC));
				player.sendMessage(message, Util.DUMMY_UUID);
			}
			else if(target instanceof CowEntity && !attacker.hasPermissionLevel(3))
			{
				IFormattableTextComponent message = new StringTextComponent("[")
						.appendSibling(new TranslationTextComponent(this.getTranslationKey()).mergeStyle(TextFormatting.RED))
						.appendSibling(new StringTextComponent("] "))
						.appendSibling(new TranslationTextComponent("message.oedldoedlgear.kick_stick.fail").mergeStyle(TextFormatting.ITALIC));
				player.sendMessage(message, Util.DUMMY_UUID);
			}
			return super.hitEntity(stack, target, attacker);
		}
		return super.hitEntity(stack, target, attacker);
	}
}