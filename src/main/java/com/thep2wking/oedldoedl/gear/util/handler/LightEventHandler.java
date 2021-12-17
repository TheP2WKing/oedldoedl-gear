package com.thep2wking.oedldoedl.gear.util.handler;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LightEventHandler implements IMessage 
{
    public int x, y, z;
    public int brightness;

    public LightEventHandler() {}

    public LightEventHandler(int x, int y, int z, int brightness) 
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.brightness = brightness;
    }
    
    @Override
    public void fromBytes(ByteBuf byteBuf) 
    {
        x = byteBuf.readInt();
        y = byteBuf.readInt();
        z = byteBuf.readInt();
        brightness = byteBuf.readInt();
    }

    @Override
    public void toBytes(ByteBuf byteBuf)
    {
        byteBuf.writeInt(x);
        byteBuf.writeInt(y);
        byteBuf.writeInt(z);
        byteBuf.writeInt(brightness);
    }

    public static class LightMessageHandler implements IMessageHandler<LightEventHandler, LightEventHandler> 
    {
        @Override
        public LightEventHandler onMessage(LightEventHandler lightMessage, MessageContext context) 
        {
            if (context.side.isServer()) 
            {
                handleMessageOnServer(lightMessage, context);
            }
            else 
            {
                handleMessageOnClient(lightMessage, context);
            }
            return null;
        }

        private void handleMessageOnServer(LightEventHandler message, MessageContext context) 
        {
            EntityPlayerMP player = context.getServerHandler().player;
            WorldServer world = player.getServerWorld();
            world.addScheduledTask(() -> 
            {
                BlockPos pos = new BlockPos(message.x, message.y, message.z);
            });
            PacketHandler.wrapper.sendToAll(message);
        }

        @SideOnly(Side.CLIENT)
        private void handleMessageOnClient(LightEventHandler message, MessageContext context) 
        {
            Minecraft.getMinecraft().addScheduledTask(() -> 
            {
                BlockPos pos = new BlockPos(message.x, message.y, message.z);
                EntityPlayerSP player = Minecraft.getMinecraft().player;
                World world = player.world;
                world.spawnEntity(new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), true));
            });
        }
    }
}
