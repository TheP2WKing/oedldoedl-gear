package net.thep2wking.oedldoedlgear;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModBlocks;
import net.thep2wking.oedldoedlgear.init.ModConditions;
import net.thep2wking.oedldoedlgear.init.ModEntities;
import net.thep2wking.oedldoedlgear.init.ModItems;
import net.thep2wking.oedldoedlgear.init.ModSounds;
import net.thep2wking.oedldoedlgear.util.ModDispenserBehavior;
import net.thep2wking.oedldoedlgear.util.NukeEntityRender;
import net.thep2wking.oedldoedlgear.util.TrollTNTEntityRender;

@Mod(OedldoedlGear.MODID)
public class OedldoedlGear
{
	public static final String MODID = "oedldoedlgear";
	public static final String NAME = "Oedldoedl Gear";
	public static final String VERSION = "1.16.5-3.1.0";
	
	public static OedldoedlGear INSTANCE;
	
    public static final Logger LOGGER = LogManager.getLogger();

    public OedldoedlGear() 
    {
    	GearConfig.init();
    	
    	LOGGER.info("Registerd Config for " + MODID + "!");
    	
    	IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	
    	ModBlocks.register(eventBus);
    	ModItems.register(eventBus);
    	ModEntities.register(eventBus);
    	ModSounds.register(eventBus);
    	
    	eventBus.register(new ModConditions());
    	
    	eventBus.addListener(this::onCommonSetup);
    	eventBus.addListener(this::onClientSetup);
    	eventBus.addListener(this::onEnqueueSetup);
    	eventBus.addListener(this::onLoadComplete);
        
        MinecraftForge.EVENT_BUS.register(this);
    }

	private void onCommonSetup(final FMLCommonSetupEvent event)
    {	
		ModDispenserBehavior.registerModDispenseBehavior();
        
    	LOGGER.info("Registerd Common Setup for " + MODID + "!");
    }

	private void onClientSetup(final FMLClientSetupEvent event) 
    {  
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.nuke, NukeEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.troll_tnt, TrollTNTEntityRender::new);
		
		LOGGER.info("Registerd Client Setup for " + MODID + "!");
    }
	
	private void onEnqueueSetup(final InterModEnqueueEvent event)
	{
		LOGGER.info("Registerd IMC Setup for " + MODID + "!");
	}
	
	private void onLoadComplete(final FMLLoadCompleteEvent event) 
	{
    	if (ModList.get().isLoaded("jei")) {LOGGER.info("Loaded JEI Compat for " + MODID + "!");}
    	if (ModList.get().isLoaded("configured")) {LOGGER.info("Loaded Configured Compat for " + MODID + "!");}
    	
    	LOGGER.info(NAME + " " + VERSION + " successfully loaded!");
	}
}