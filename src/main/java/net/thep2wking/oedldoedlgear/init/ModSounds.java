package net.thep2wking.oedldoedlgear.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.thep2wking.oedldoedlgear.OedldoedlGear;

public class ModSounds 
{
	//deferred register
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, OedldoedlGear.MODID);
	
	//sounds
	public static final RegistryObject<SoundEvent> NUKE_ALARM = registerSoundEvent("nuke_alarm");
	public static final RegistryObject<SoundEvent> MEGUMIN = registerSoundEvent("megumin");
	public static final RegistryObject<SoundEvent> QUIEK = registerSoundEvent("quiek");
	
	private static RegistryObject<SoundEvent> registerSoundEvent(String name)
	{
		return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(OedldoedlGear.MODID, name)));
	}
	
	public static void register(IEventBus eventBus)
	{
		SOUNDS.register(eventBus);
		
		OedldoedlGear.LOGGER.info("Registerd Sounds for " + OedldoedlGear.MODID + "!");
	}
}