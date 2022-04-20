package net.thep2wking.oedldoedlgear.util;

import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.init.ModItems;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = OedldoedlGear.MODID, value = Dist.CLIENT)
public class ModPredicates 
{
    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) 
    {
        event.enqueueWork(() -> 
        {
        	//infinity tools
            ItemModelsProperties.registerProperty(ModItems.INFINITY_PICKAXE.get(), new ResourceLocation(OedldoedlGear.MODID, "hammer"), (itemStack, clientWorld, livingEntity) 
            		-> itemStack.getOrCreateTag().getInt("Hammer"));
            
            ItemModelsProperties.registerProperty(ModItems.INFINITY_SHOVEL.get(), new ResourceLocation(OedldoedlGear.MODID, "excavator"), (itemStack, clientWorld, livingEntity) 
            		-> itemStack.getOrCreateTag().getInt("Excavator"));
            
            ItemModelsProperties.registerProperty(ModItems.INFINITY_PAXEL.get(), new ResourceLocation(OedldoedlGear.MODID, "demolisher"), (itemStack, clientWorld, livingEntity) 
            		-> itemStack.getOrCreateTag().getInt("Demolisher"));
            
            //shields
            ItemModelsProperties.registerProperty(ModItems.EMERALD_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.FLINT_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.OEDLDOEDL_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.UNSTABLE_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.WOODEN_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.STONE_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.GOLDEN_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.IRON_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.DIAMOND_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.NETHERITE_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.BASE_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.GREMORIUM_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.HIMEJIMARIUM_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.TOUJOURIUM_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.ARGENTORIUM_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
            
            ItemModelsProperties.registerProperty(ModItems.INFINITY_SHIELD.get(), new ResourceLocation(OedldoedlGear.MODID, "blocking"), (itemStack, clientWorld, livingEntity) 
            		-> livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
        });
    }
}