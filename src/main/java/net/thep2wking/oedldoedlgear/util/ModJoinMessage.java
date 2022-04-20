package net.thep2wking.oedldoedlgear.util;

import net.minecraft.util.Util;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlgear.OedldoedlGear;

@Mod.EventBusSubscriber
public class ModJoinMessage 
{	
	@SubscribeEvent
	public static void onPlayerWorldJoin(PlayerLoggedInEvent event)
	{
		IFormattableTextComponent message = new StringTextComponent("[")
		.appendSibling(new StringTextComponent(OedldoedlGear.NAME + " v" + OedldoedlGear.VERSION).mergeStyle(TextFormatting.GREEN))
		.appendSibling(new StringTextComponent("] "))
		.appendSibling(new TranslationTextComponent("message.oedldoedlcore.join"));

		if(CoreConfig.join_messages.get())
		{
			event.getPlayer().sendMessage(message, Util.DUMMY_UUID);
		}
	}
}