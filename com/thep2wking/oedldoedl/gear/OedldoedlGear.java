package com.thep2wking.oedldoedl.gear;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thep2wking.oedldoedl.gear.util.handler.RegistryHandler;
import com.thep2wking.oedldoedl.gear.util.proxy.CommonProxy;
import com.thep2wking.oedldoedl.gear.util.tabs.TabOedldoedlGear;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ReferenceGear.MODID, name = ReferenceGear.NAME, version = ReferenceGear.VERSION, dependencies = ReferenceGear.DEPENDENCIES)

public class OedldoedlGear 
{
	public static final Logger logger = LogManager.getLogger(ReferenceGear.NAME);
	
	@SidedProxy(clientSide = ReferenceGear.CLIENT_PROXY_CLASS, serverSide = ReferenceGear.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
    @Instance
    public static OedldoedlGear instance;
    
    public static final CreativeTabs TAB = new TabOedldoedlGear("tab_oedldoedl_gear");
	
	@EventHandler
	public static void preInt(FMLPreInitializationEvent event)
	{
		proxy.preInit(event);
		logger.info("Starting FML Pre-Initialization");
		RegistryHandler.preInitRegistries(event);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		proxy.Init(event);
		logger.info("Starting FML Initialization");
		System.out.println("Oedldoedl Core Mod is installed: "+Loader.isModLoaded("oedldoedlcore"));
		System.out.println("Baubles is installed: "+Loader.isModLoaded("baubles"));
	}
   
	@EventHandler
	public static void postinit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
		logger.info("Starting FML Post-Initialization");
	}	
	
	@EventHandler
	public void loadComplete(FMLLoadCompleteEvent event) 
	{
		logger.info(ReferenceGear.NAME+" "+ReferenceGear.VERSION+" loaded!");
	}  
}