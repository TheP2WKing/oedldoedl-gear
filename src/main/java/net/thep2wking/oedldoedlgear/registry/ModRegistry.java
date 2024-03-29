package net.thep2wking.oedldoedlgear.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.init.ModBlocks;
import net.thep2wking.oedldoedlgear.init.ModItems;
import net.thep2wking.oedldoedlgear.init.ModPotions;
import net.thep2wking.oedldoedlgear.init.ModSounds;

@Mod.EventBusSubscriber
public class ModRegistry {
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		ModRegistryHelper.registerModels(event, OedldoedlGear.MODID);
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		ModLogger.registeredBlocksLogger(OedldoedlGear.MODID);

		ModRegistryHelper.registerBlock(event, ModBlocks.BADROCK);
		ModRegistryHelper.registerBlock(event, ModBlocks.ENHANCED_DIRT);
		ModRegistryHelper.registerBlock(event, ModBlocks.MAGICAL_WOOD);
		ModRegistryHelper.registerBlock(event, ModBlocks.MAGICAL_WOOD_PLANKS);

		ModRegistryHelper.registerBlock(event, ModBlocks.JUMP_PAD);
		ModRegistryHelper.registerBlock(event, ModBlocks.JUMP_PAD_PLUS);
		ModRegistryHelper.registerBlock(event, ModBlocks.JUMP_PAD_PLUS_PLUS);
		ModRegistryHelper.registerBlock(event, ModBlocks.JUMP_PAD_PLUS_PLUS_PLUS);
		ModRegistryHelper.registerBlock(event, ModBlocks.IMPACT_PAD);
	}

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		ModLogger.registeredItemsLogger(OedldoedlGear.MODID);

		ModRegistryHelper.registerItemBlock(event, ModItems.BADROCK);
		ModRegistryHelper.registerItemBlock(event, ModItems.ENHANCED_DIRT);
		ModRegistryHelper.registerItemBlock(event, ModItems.MAGICAL_WOOD);
		ModRegistryHelper.registerItemBlock(event, ModItems.MAGICAL_WOOD_PLANKS);

		ModRegistryHelper.registerItemBlock(event, ModItems.JUMP_PAD);
		ModRegistryHelper.registerItemBlock(event, ModItems.JUMP_PAD_PLUS);
		ModRegistryHelper.registerItemBlock(event, ModItems.JUMP_PAD_PLUS_PLUS);
		ModRegistryHelper.registerItemBlock(event, ModItems.JUMP_PAD_PLUS_PLUS_PLUS);
		ModRegistryHelper.registerItemBlock(event, ModItems.IMPACT_PAD);

		ModRegistryHelper.registerItem(event, ModItems.BASE_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.BASE_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.BASE_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.BASE_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.DIRT_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.DIRT_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.DIRT_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.DIRT_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.WOODEN_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.WOODEN_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.WOODEN_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.WOODEN_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.EMERALD_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.EMERALD_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.EMERALD_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.EMERALD_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.SLIME_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.SLIME_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.SLIME_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.SLIME_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.GREMORIUM_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.GREMORIUM_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.GREMORIUM_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.GREMORIUM_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.HIMEJIMARIUM_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.HIMEJIMARIUM_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.HIMEJIMARIUM_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.HIMEJIMARIUM_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.TOUJOURIUM_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.TOUJOURIUM_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.TOUJOURIUM_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.TOUJOURIUM_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.ARGENTORIUM_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.ARGENTORIUM_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.ARGENTORIUM_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.ARGENTORIUM_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.QUARTARIUM_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.QUARTARIUM_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.QUARTARIUM_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.QUARTARIUM_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.NAGATORIUM_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.NAGATORIUM_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.NAGATORIUM_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.NAGATORIUM_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.SAKURAJIMARIUM_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.SAKURAJIMARIUM_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.SAKURAJIMARIUM_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.SAKURAJIMARIUM_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.KITAGAWARIUM_HELMET);
		ModRegistryHelper.registerItem(event, ModItems.KITAGAWARIUM_CHESTPLATE);
		ModRegistryHelper.registerItem(event, ModItems.KITAGAWARIUM_LEGGINGS);
		ModRegistryHelper.registerItem(event, ModItems.KITAGAWARIUM_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.BLACK_WIZARD_HAT);
		ModRegistryHelper.registerItem(event, ModItems.BLUE_WIZARD_HAT);

		ModRegistryHelper.registerItem(event, ModItems.GAMEMODE_CHESTPLATE);

		ModRegistryHelper.registerItem(event, ModItems.CLASSIC_FLYING_SHOOTING_HOODIE);
		ModRegistryHelper.registerItem(event, ModItems.BLACK_FLYING_SHOOTING_HOODIE);
		ModRegistryHelper.registerItem(event, ModItems.WHITE_FLYING_SHOOTING_HOODIE);
		ModRegistryHelper.registerItem(event, ModItems.FLYING_SHOOTING_COLLEGE_JACKET);

		ModRegistryHelper.registerItem(event, ModItems.GRADIENT_GUEFFY_TAG_QUILTED_JACKET);

		ModRegistryHelper.registerItem(event, ModItems.TRAVELLERS_BOOTS);
		ModRegistryHelper.registerItem(event, ModItems.TRAVELLERS_GOLDEN_BOOTS);
		ModRegistryHelper.registerItem(event, ModItems.TRAVELLERS_IRON_BOOTS);
		ModRegistryHelper.registerItem(event, ModItems.TRAVELLERS_DIAMOND_BOOTS);
		ModRegistryHelper.registerItem(event, ModItems.TRAVELLERS_EMERALD_BOOTS);

		ModRegistryHelper.registerItem(event, ModItems.LONG_FALL_BOOTS);
		ModRegistryHelper.registerItem(event, ModItems.CROCS);

		ModRegistryHelper.registerItem(event, ModItems.BASE_HORSE_ARMOR);
		ModRegistryHelper.registerItem(event, ModItems.CHAINMAIL_HORSE_ARMOR);
		ModRegistryHelper.registerItem(event, ModItems.EMERALD_HORSE_ARMOR);

		ModRegistryHelper.registerItem(event, ModItems.BASE_SWORD);
		ModRegistryHelper.registerItem(event, ModItems.BASE_SHOVEL);
		ModRegistryHelper.registerItem(event, ModItems.BASE_PICKAXE);
		ModRegistryHelper.registerItem(event, ModItems.BASE_AXE);
		ModRegistryHelper.registerItem(event, ModItems.BASE_HOE);
		ModRegistryHelper.registerItem(event, ModItems.BASE_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.BASE_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.BASE_SHEARS);
		ModRegistryHelper.registerItem(event, ModItems.BASE_SHIELD);

		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_SWORD);
		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_SHOVEL);
		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_PICKAXE);
		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_AXE);
		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_HOE);
		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_SHEARS);
		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_SHIELD);

		ModRegistryHelper.registerItem(event, ModItems.DIRT_SWORD);
		ModRegistryHelper.registerItem(event, ModItems.DIRT_SHOVEL);
		ModRegistryHelper.registerItem(event, ModItems.DIRT_PICKAXE);
		ModRegistryHelper.registerItem(event, ModItems.DIRT_AXE);
		ModRegistryHelper.registerItem(event, ModItems.DIRT_HOE);
		ModRegistryHelper.registerItem(event, ModItems.DIRT_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.DIRT_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.DIRT_SHEARS);

		ModRegistryHelper.registerItem(event, ModItems.EMERALD_SWORD);
		ModRegistryHelper.registerItem(event, ModItems.EMERALD_SHOVEL);
		ModRegistryHelper.registerItem(event, ModItems.EMERALD_PICKAXE);
		ModRegistryHelper.registerItem(event, ModItems.EMERALD_AXE);
		ModRegistryHelper.registerItem(event, ModItems.EMERALD_HOE);
		ModRegistryHelper.registerItem(event, ModItems.EMERALD_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.EMERALD_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.EMERALD_SHEARS);

		ModRegistryHelper.registerItem(event, ModItems.SLIME_SWORD);
		ModRegistryHelper.registerItem(event, ModItems.SLIME_SHOVEL);
		ModRegistryHelper.registerItem(event, ModItems.SLIME_PICKAXE);
		ModRegistryHelper.registerItem(event, ModItems.SLIME_AXE);
		ModRegistryHelper.registerItem(event, ModItems.SLIME_HOE);
		ModRegistryHelper.registerItem(event, ModItems.SLIME_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.SLIME_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.SLIME_SHEARS);

		ModRegistryHelper.registerItem(event, ModItems.GREMORIUM_SWORD);
		ModRegistryHelper.registerItem(event, ModItems.GREMORIUM_SHOVEL);
		ModRegistryHelper.registerItem(event, ModItems.GREMORIUM_PICKAXE);
		ModRegistryHelper.registerItem(event, ModItems.GREMORIUM_AXE);
		ModRegistryHelper.registerItem(event, ModItems.GREMORIUM_HOE);
		ModRegistryHelper.registerItem(event, ModItems.GREMORIUM_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.GREMORIUM_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.GREMORIUM_SHEARS);
		ModRegistryHelper.registerItem(event, ModItems.GREMORIUM_SHIELD);

		ModRegistryHelper.registerItem(event, ModItems.HIMEJIMARIUM_SWORD);
		ModRegistryHelper.registerItem(event, ModItems.HIMEJIMARIUM_SHOVEL);
		ModRegistryHelper.registerItem(event, ModItems.HIMEJIMARIUM_PICKAXE);
		ModRegistryHelper.registerItem(event, ModItems.HIMEJIMARIUM_AXE);
		ModRegistryHelper.registerItem(event, ModItems.HIMEJIMARIUM_HOE);
		ModRegistryHelper.registerItem(event, ModItems.HIMEJIMARIUM_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.HIMEJIMARIUM_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.HIMEJIMARIUM_SHEARS);
		ModRegistryHelper.registerItem(event, ModItems.HIMEJIMARIUM_SHIELD);

		ModRegistryHelper.registerItem(event, ModItems.TOUJOURIUM_SWORD);
		ModRegistryHelper.registerItem(event, ModItems.TOUJOURIUM_SHOVEL);
		ModRegistryHelper.registerItem(event, ModItems.TOUJOURIUM_PICKAXE);
		ModRegistryHelper.registerItem(event, ModItems.TOUJOURIUM_AXE);
		ModRegistryHelper.registerItem(event, ModItems.TOUJOURIUM_HOE);
		ModRegistryHelper.registerItem(event, ModItems.TOUJOURIUM_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.TOUJOURIUM_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.TOUJOURIUM_SHEARS);
		ModRegistryHelper.registerItem(event, ModItems.TOUJOURIUM_SHIELD);

		ModRegistryHelper.registerItem(event, ModItems.ARGENTORIUM_SWORD);
		ModRegistryHelper.registerItem(event, ModItems.ARGENTORIUM_SHOVEL);
		ModRegistryHelper.registerItem(event, ModItems.ARGENTORIUM_PICKAXE);
		ModRegistryHelper.registerItem(event, ModItems.ARGENTORIUM_AXE);
		ModRegistryHelper.registerItem(event, ModItems.ARGENTORIUM_HOE);
		ModRegistryHelper.registerItem(event, ModItems.ARGENTORIUM_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.ARGENTORIUM_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.ARGENTORIUM_SHEARS);
		ModRegistryHelper.registerItem(event, ModItems.ARGENTORIUM_SHIELD);

		ModRegistryHelper.registerItem(event, ModItems.QUARTARIUM_SWORD);
		ModRegistryHelper.registerItem(event, ModItems.QUARTARIUM_SHOVEL);
		ModRegistryHelper.registerItem(event, ModItems.QUARTARIUM_PICKAXE);
		ModRegistryHelper.registerItem(event, ModItems.QUARTARIUM_AXE);
		ModRegistryHelper.registerItem(event, ModItems.QUARTARIUM_HOE);
		ModRegistryHelper.registerItem(event, ModItems.QUARTARIUM_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.QUARTARIUM_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.QUARTARIUM_SHEARS);
		ModRegistryHelper.registerItem(event, ModItems.QUARTARIUM_SHIELD);

		ModRegistryHelper.registerItem(event, ModItems.NAGATORIUM_SWORD);
		ModRegistryHelper.registerItem(event, ModItems.NAGATORIUM_SHOVEL);
		ModRegistryHelper.registerItem(event, ModItems.NAGATORIUM_PICKAXE);
		ModRegistryHelper.registerItem(event, ModItems.NAGATORIUM_AXE);
		ModRegistryHelper.registerItem(event, ModItems.NAGATORIUM_HOE);
		ModRegistryHelper.registerItem(event, ModItems.NAGATORIUM_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.NAGATORIUM_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.NAGATORIUM_SHEARS);
		ModRegistryHelper.registerItem(event, ModItems.NAGATORIUM_SHIELD);

		ModRegistryHelper.registerItem(event, ModItems.SAKURAJIMARIUM_SWORD);
		ModRegistryHelper.registerItem(event, ModItems.SAKURAJIMARIUM_SHOVEL);
		ModRegistryHelper.registerItem(event, ModItems.SAKURAJIMARIUM_PICKAXE);
		ModRegistryHelper.registerItem(event, ModItems.SAKURAJIMARIUM_AXE);
		ModRegistryHelper.registerItem(event, ModItems.SAKURAJIMARIUM_HOE);
		ModRegistryHelper.registerItem(event, ModItems.SAKURAJIMARIUM_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.SAKURAJIMARIUM_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.SAKURAJIMARIUM_SHEARS);
		ModRegistryHelper.registerItem(event, ModItems.SAKURAJIMARIUM_SHIELD);

		ModRegistryHelper.registerItem(event, ModItems.KITAGAWARIUM_SWORD);
		ModRegistryHelper.registerItem(event, ModItems.KITAGAWARIUM_SHOVEL);
		ModRegistryHelper.registerItem(event, ModItems.KITAGAWARIUM_PICKAXE);
		ModRegistryHelper.registerItem(event, ModItems.KITAGAWARIUM_AXE);
		ModRegistryHelper.registerItem(event, ModItems.KITAGAWARIUM_HOE);
		ModRegistryHelper.registerItem(event, ModItems.KITAGAWARIUM_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.KITAGAWARIUM_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.KITAGAWARIUM_SHEARS);
		ModRegistryHelper.registerItem(event, ModItems.KITAGAWARIUM_SHIELD);

		ModRegistryHelper.registerItem(event, ModItems.WOODEN_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.WOODEN_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.WOODEN_SHEARS);

		ModRegistryHelper.registerItem(event, ModItems.STONE_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.STONE_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.STONE_SHEARS);

		ModRegistryHelper.registerItem(event, ModItems.GOLDEN_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.GOLDEN_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.GOLDEN_SHEARS);

		ModRegistryHelper.registerItem(event, ModItems.IRON_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.IRON_SMASHBAT);

		ModRegistryHelper.registerItem(event, ModItems.DIAMOND_PAXEL);
		ModRegistryHelper.registerItem(event, ModItems.DIAMOND_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.DIAMOND_SHEARS);

		ModRegistryHelper.registerItem(event, ModItems.LAUNCHING_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.BLASTING_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.LIGHTNING_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.RIDING_SMASHBAT);
		ModRegistryHelper.registerItem(event, ModItems.GOLDEN_RIDING_SMASHBAT);

		ModRegistryHelper.registerItem(event, ModItems.PORK_HAMMER);
		ModRegistryHelper.registerItem(event, ModItems.BAN_HAMMER);
		ModRegistryHelper.registerItem(event, ModItems.KICK_STICK);
		ModRegistryHelper.registerItem(event, ModItems.EXPLOSION_STAFF);
		ModRegistryHelper.registerItem(event, ModItems.LIGHTNING_STAFF);
		ModRegistryHelper.registerItem(event, ModItems.FRIEREN_STAFF);
		ModRegistryHelper.registerItem(event, ModItems.ADMIN_STAFF);
		ModRegistryHelper.registerItem(event, ModItems.SKULL_WAND);
		ModRegistryHelper.registerItem(event, ModItems.FIRE_WAND);
		ModRegistryHelper.registerItem(event, ModItems.FLY_SWATTER);
		ModRegistryHelper.registerItem(event, ModItems.BEDROCK_BREAKER);
		ModRegistryHelper.registerItem(event, ModItems.NEEDLE);
		ModRegistryHelper.registerItem(event, ModItems.BREF_POWER);

		ModRegistryHelper.registerItem(event, ModItems.ROCKY_SNOWBALL);
		ModRegistryHelper.registerItem(event, ModItems.EXPLOSIVE_SNOWBALL);
		ModRegistryHelper.registerItem(event, ModItems.CHARGED_SNOWBALL);

		ModRegistryHelper.registerItem(event, ModItems.WHITE_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.ORANGE_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.MAGENTA_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.LIGHT_BLUE_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.YELLOW_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.LIME_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.PINK_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.GRAY_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.LIGHT_GRAY_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.CYAN_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.PURPLE_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.BLUE_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.BROWN_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.GREEN_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.RED_FABRIC);
		ModRegistryHelper.registerItem(event, ModItems.BLACK_FABRIC);

		ModRegistryHelper.registerItem(event, ModItems.TRAVELLERS_LEATHER);

		ModRegistryHelper.registerItem(event, ModItems.EXPLOSION_CORE);
		ModRegistryHelper.registerItem(event, ModItems.CHARGED_CORE);
		ModRegistryHelper.registerItem(event, ModItems.MYSTIC_CORE);

		ModRegistryHelper.registerItem(event, ModItems.CHAINMAIL);

		ModRegistryHelper.registerItem(event, ModItems.NOTE_OF_SUFFERING);
		ModRegistryHelper.registerItem(event, ModItems.BILL_OF_REVENGE);
		ModRegistryHelper.registerItem(event, ModItems.CRAFTING_LICENSE);
		ModRegistryHelper.registerItem(event, ModItems.OEDLDOEDL_TOS);
	}

	@SubscribeEvent
	public static void onSoundEventRegister(RegistryEvent.Register<SoundEvent> event) {
		ModLogger.registeredSoundEventsLogger(OedldoedlGear.MODID);

		ModRegistryHelper.registerSoundEvent(event, ModSounds.MEGUMIN);
		ModRegistryHelper.registerSoundEvent(event, ModSounds.QUIEK);
		ModRegistryHelper.registerSoundEvent(event, ModSounds.ONIISAN);
	}

	@SubscribeEvent
	public static void onPotionRegister(RegistryEvent.Register<Potion> event) {
		ModLogger.registeredPotionsLogger(OedldoedlGear.MODID);

		event.getRegistry().register(ModPotions.FLIGHT);
		event.getRegistry().register(ModPotions.MILK);
	}

	@SubscribeEvent
	public static void onPotionTypeRegister(RegistryEvent.Register<PotionType> event) {
		ModLogger.registeredPotionTypesLogger(OedldoedlGear.MODID);

		event.getRegistry().register(ModPotions.FLIGHT_NORMAL);
		event.getRegistry().register(ModPotions.FLIGHT_LONG);
		event.getRegistry().register(ModPotions.MILK_NORMAL);
	}
}