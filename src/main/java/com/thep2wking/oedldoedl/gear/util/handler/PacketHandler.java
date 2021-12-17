package com.thep2wking.oedldoedl.gear.util.handler;

import com.thep2wking.oedldoedl.gear.ReferenceGear;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler 
{
    public static SimpleNetworkWrapper wrapper;
    private static int ID = 0;
    private static int getID() 
    {
        return ID++;
    }

    public static void setWrapper() 
    {
        wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(ReferenceGear.MODID);
        wrapper.registerMessage(LightEventHandler.LightMessageHandler.class, LightEventHandler.class, getID(), Side.SERVER);
        wrapper.registerMessage(LightEventHandler.LightMessageHandler.class, LightEventHandler.class, getID(), Side.CLIENT);
        wrapper.registerMessage(ExplosionEventHandler.ExplosionMessageHandler.class, ExplosionEventHandler.class, getID(), Side.SERVER);
        wrapper.registerMessage(ExplosionEventHandler.ExplosionMessageHandler.class, ExplosionEventHandler.class, getID(), Side.CLIENT);
    }
}