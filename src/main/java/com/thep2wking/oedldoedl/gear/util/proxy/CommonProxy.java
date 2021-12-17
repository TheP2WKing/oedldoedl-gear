package com.thep2wking.oedldoedl.gear.util.proxy;

import com.thep2wking.oedldoedl.gear.util.handler.PacketHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event) 
	{
		 PacketHandler.setWrapper();
	}

	public void Init(FMLInitializationEvent event) 
	{

	}

	public void postInit(FMLPostInitializationEvent event) 
	{

	}
}