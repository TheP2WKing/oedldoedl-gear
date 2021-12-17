package com.thep2wking.oedldoedl.gear.init;

import java.util.ArrayList;
import java.util.List;

import com.thep2wking.oedldoedl.gear.ReferenceGear;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SoundInit
{
	public static final List<SoundEvent> SOUND_EVENTS = new ArrayList<>();
	
	public static final SoundEvent SOUND_MEGUMIN = new SoundEvent(new ResourceLocation(ReferenceGear.MODID, "megumin")).setRegistryName(ReferenceGear.MODID+":"+"megumin");
	public static final SoundEvent SOUND_SMASH_WOOD = new SoundEvent(new ResourceLocation(ReferenceGear.MODID, "smash_wood")).setRegistryName(ReferenceGear.MODID+":"+"smash_wood");
	public static final SoundEvent SOUND_SMASH_METAL = new SoundEvent(new ResourceLocation(ReferenceGear.MODID, "smash_metal")).setRegistryName(ReferenceGear.MODID+":"+"smash_metal");
	public static final SoundEvent SOUND_SMASH_DIAMOND = new SoundEvent(new ResourceLocation(ReferenceGear.MODID, "smash_diamond")).setRegistryName(ReferenceGear.MODID+":"+"smash_diamond");
	
	@Mod.EventBusSubscriber(modid = ReferenceGear.MODID)
	public static class RegistrationHandler 
	{
		@SubscribeEvent
		public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event) 
		{
			for (SoundEvent soundEvent : SOUND_EVENTS) 
			{
				event.getRegistry().register(soundEvent);
			}
		}
	}
}