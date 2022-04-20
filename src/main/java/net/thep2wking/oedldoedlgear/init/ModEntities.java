package net.thep2wking.oedldoedlgear.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.content.entity.NukeEntity;
import net.thep2wking.oedldoedlgear.content.entity.TrollTNTEntity;

public class ModEntities 
{
	public static DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, OedldoedlGear.MODID);

	public static final RegistryObject<EntityType<Entity>> NUKE = ENTITIES.register("nuke",
	        () -> EntityType.Builder.create(NukeEntity::new, EntityClassification.MISC).size(1f, 1f).build(new ResourceLocation(OedldoedlGear.MODID, "nuke").toString()));
	
	public static final RegistryObject<EntityType<Entity>> TROLL_TNT = ENTITIES.register("troll_tnt",
	        () -> EntityType.Builder.create(TrollTNTEntity::new, EntityClassification.MISC).size(1f, 1f).build(new ResourceLocation(OedldoedlGear.MODID, "troll_tnt").toString()));

	@ObjectHolder(OedldoedlGear.MODID + ":nuke")
	public static EntityType<NukeEntity> nuke;
	
	@ObjectHolder(OedldoedlGear.MODID + ":troll_tnt")
	public static EntityType<TrollTNTEntity> troll_tnt;
	
	public static void register(IEventBus eventBus) 
	{
		ENTITIES.register(eventBus);
		
		OedldoedlGear.LOGGER.info("Registerd Entities for " + OedldoedlGear.MODID + "!");
	}
}