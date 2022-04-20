package net.thep2wking.oedldoedlgear.init;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.conditions.EnableModRecipes;

public class ModConditions 
{
	@SubscribeEvent
	public void onRegisterSerializers(RegistryEvent.Register<IRecipeSerializer<?>> event) 
	{
		CraftingHelper.register(EnableModRecipes.Serializer.INSTANCE);
		
		OedldoedlGear.LOGGER.info("Registerd Serializers for " + OedldoedlGear.MODID + "!");
	}
}