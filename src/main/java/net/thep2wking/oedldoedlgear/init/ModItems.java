package net.thep2wking.oedldoedlgear.init;

import java.util.HashSet;

import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.thep2wking.oedldoedlcore.api.ModArmorItemBase;
import net.thep2wking.oedldoedlcore.api.ModAxeItemBase;
import net.thep2wking.oedldoedlcore.api.ModBlockItemBase;
import net.thep2wking.oedldoedlcore.api.ModHoeItemBase;
import net.thep2wking.oedldoedlcore.api.ModHorseArmorItemBase;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlcore.api.ModPaxelItemBase;
import net.thep2wking.oedldoedlcore.api.ModPickaxeItemBase;
import net.thep2wking.oedldoedlcore.api.ModShearsItemBase;
import net.thep2wking.oedldoedlcore.api.ModShieldItemBase;
import net.thep2wking.oedldoedlcore.api.ModShovelItemBase;
import net.thep2wking.oedldoedlcore.api.ModSmashbatItemBase;
import net.thep2wking.oedldoedlcore.api.ModSmashbatItemBase.HitSound;
import net.thep2wking.oedldoedlcore.api.ModSwordItemBase;
import net.thep2wking.oedldoedlcore.util.ModRarities;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.content.item.armor.ArgentoriumArmorItem;
import net.thep2wking.oedldoedlgear.content.item.armor.ArgentoriumArmorItem.AttributeUUIDArg;
import net.thep2wking.oedldoedlgear.content.item.armor.EmeraldArmorItem;
import net.thep2wking.oedldoedlgear.content.item.armor.GamemodeChestplateItem;
import net.thep2wking.oedldoedlgear.content.item.armor.GremoriumArmorItem;
import net.thep2wking.oedldoedlgear.content.item.armor.HimejimariumArmorItem;
import net.thep2wking.oedldoedlgear.content.item.armor.InfinityArmorItem;
import net.thep2wking.oedldoedlgear.content.item.armor.LongFallBootsItem;
import net.thep2wking.oedldoedlgear.content.item.armor.OedldoedlArmorItem;
import net.thep2wking.oedldoedlgear.content.item.armor.ToujouriumArmorItem;
import net.thep2wking.oedldoedlgear.content.item.armor.ToujouriumArmorItem.AttributeUUIDTou;
import net.thep2wking.oedldoedlgear.content.item.armor.UnstableArmorItem;
import net.thep2wking.oedldoedlgear.content.item.armor.travel.TravellersBootsItem;
import net.thep2wking.oedldoedlgear.content.item.armor.travel.TravellersDiamondBootsItem;
import net.thep2wking.oedldoedlgear.content.item.armor.travel.TravellersEmeraldBootsItem;
import net.thep2wking.oedldoedlgear.content.item.armor.travel.TravellersGoldenBootsItem;
import net.thep2wking.oedldoedlgear.content.item.armor.travel.TravellersIronBootsItem;
import net.thep2wking.oedldoedlgear.content.item.armor.travel.TravellersNetheriteBootsItem;
import net.thep2wking.oedldoedlgear.content.item.misc.ChainmailItem;
import net.thep2wking.oedldoedlgear.content.item.misc.ChargedDynamiteItem;
import net.thep2wking.oedldoedlgear.content.item.misc.ChargedEssenceItem;
import net.thep2wking.oedldoedlgear.content.item.misc.CombatDynamiteItem;
import net.thep2wking.oedldoedlgear.content.item.misc.DynamiteItem;
import net.thep2wking.oedldoedlgear.content.item.misc.ExplosionCoreItem;
import net.thep2wking.oedldoedlgear.content.item.misc.ExplosiveSnowballItem;
import net.thep2wking.oedldoedlgear.content.item.misc.NeedleItem;
import net.thep2wking.oedldoedlgear.content.item.misc.RockySnowballItem;
import net.thep2wking.oedldoedlgear.content.item.misc.SquidBucketItem;
import net.thep2wking.oedldoedlgear.content.item.tool.infinity.InfinityAxeItem;
import net.thep2wking.oedldoedlgear.content.item.tool.infinity.InfinityHoeItem;
import net.thep2wking.oedldoedlgear.content.item.tool.infinity.InfinityPaxelItem;
import net.thep2wking.oedldoedlgear.content.item.tool.infinity.InfinityPickaxeItem;
import net.thep2wking.oedldoedlgear.content.item.tool.infinity.InfinityShearsItem;
import net.thep2wking.oedldoedlgear.content.item.tool.infinity.InfinityShieldItem;
import net.thep2wking.oedldoedlgear.content.item.tool.infinity.InfinityShovelItem;
import net.thep2wking.oedldoedlgear.content.item.tool.infinity.InfinitySmashbatItem;
import net.thep2wking.oedldoedlgear.content.item.tool.infinity.InfinitySwordItem;
import net.thep2wking.oedldoedlgear.content.item.tool.misc.AttackDamageShieldItem;
import net.thep2wking.oedldoedlgear.content.item.tool.misc.BanHammerItem;
import net.thep2wking.oedldoedlgear.content.item.tool.misc.BedrockBreakerIem;
import net.thep2wking.oedldoedlgear.content.item.tool.misc.BrefPowerItem;
import net.thep2wking.oedldoedlgear.content.item.tool.misc.ExplosionStaffItem;
import net.thep2wking.oedldoedlgear.content.item.tool.misc.KickStickItem;
import net.thep2wking.oedldoedlgear.content.item.tool.misc.LightningStaffItem;
import net.thep2wking.oedldoedlgear.content.item.tool.misc.RidingSmashbatItem;
import net.thep2wking.oedldoedlgear.content.item.tool.misc.StoneShieldItem;
import net.thep2wking.oedldoedlgear.content.item.tool.unstable.UnstableAxeItem;
import net.thep2wking.oedldoedlgear.content.item.tool.unstable.UnstableHoeItem;
import net.thep2wking.oedldoedlgear.content.item.tool.unstable.UnstablePaxelItem;
import net.thep2wking.oedldoedlgear.content.item.tool.unstable.UnstablePickaxeItem;
import net.thep2wking.oedldoedlgear.content.item.tool.unstable.UnstableShearsItem;
import net.thep2wking.oedldoedlgear.content.item.tool.unstable.UnstableShieldItem;
import net.thep2wking.oedldoedlgear.content.item.tool.unstable.UnstableShovelItem;
import net.thep2wking.oedldoedlgear.content.item.tool.unstable.UnstableSmashbatItem;
import net.thep2wking.oedldoedlgear.content.item.tool.unstable.UnstableSwordItem;
import net.thep2wking.oedldoedlgear.util.ModArmorMaterial;
import net.thep2wking.oedldoedlgear.util.ModItemGroups;
import net.thep2wking.oedldoedlgear.util.ModItemTier;

public class ModItems 
{
	//deferred register
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OedldoedlGear.MODID);

	//misc blockitems
	public static final RegistryObject<Item> BADROCK = ITEMS.register("badrock", 
			() -> new ModBlockItemBase(ModBlocks.BADROCK.get(), ModRarities.WHITE, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> MAGICAL_WOOD = ITEMS.register("magical_wood", 
			() -> new ModBlockItemBase(ModBlocks.MAGICAL_WOOD.get(), ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> NUKE = ITEMS.register("nuke", 
			() -> new ModBlockItemBase(ModBlocks.NUKE.get(), ModRarities.RED, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TROLL_TNT = ITEMS.register("troll_tnt", 
			() -> new ModBlockItemBase(ModBlocks.TROLL_TNT.get(), ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//jump pad blockitems
	public static final RegistryObject<Item> JUMP_PAD = ITEMS.register("jump_pad", 
			() -> new ModBlockItemBase(ModBlocks.JUMP_PAD.get(), ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> JUMP_PAD_PLUS = ITEMS.register("jump_pad_plus", 
			() -> new ModBlockItemBase(ModBlocks.JUMP_PAD_PLUS.get(), ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> JUMP_PAD_PLUS_PLUS = ITEMS.register("jump_pad_plus_plus", 
			() -> new ModBlockItemBase(ModBlocks.JUMP_PAD_PLUS_PLUS.get(), ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> JUMP_PAD_PLUS_PLUS_PLUS = ITEMS.register("jump_pad_plus_plus_plus", 
			() -> new ModBlockItemBase(ModBlocks.JUMP_PAD_PLUS_PLUS_PLUS.get(), ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//base armor
	public static final RegistryObject<Item> BASE_HELMET = ITEMS.register("base_helmet", 
			() -> new ModArmorItemBase(ModArmorMaterial.BASE, EquipmentSlotType.HEAD, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BASE_CHESTPLATE = ITEMS.register("base_chestplate", 
			() -> new ModArmorItemBase(ModArmorMaterial.BASE, EquipmentSlotType.CHEST, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BASE_LEGGINGS = ITEMS.register("base_leggings", 
			() -> new ModArmorItemBase(ModArmorMaterial.BASE, EquipmentSlotType.LEGS, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BASE_BOOTS = ITEMS.register("base_boots", 
			() -> new ModArmorItemBase(ModArmorMaterial.BASE, EquipmentSlotType.FEET, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//wooden armor
	public static final RegistryObject<Item> WOODEN_HELMET = ITEMS.register("wooden_helmet", 
			() -> new ModArmorItemBase(ModArmorMaterial.WOOD, EquipmentSlotType.HEAD, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> WOODEN_CHESTPLATE = ITEMS.register("wooden_chestplate", 
			() -> new ModArmorItemBase(ModArmorMaterial.WOOD, EquipmentSlotType.CHEST, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> WOODEN_LEGGINGS = ITEMS.register("wooden_leggings", 
			() -> new ModArmorItemBase(ModArmorMaterial.WOOD, EquipmentSlotType.LEGS, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> WOODEN_BOOTS = ITEMS.register("wooden_boots", 
			() -> new ModArmorItemBase(ModArmorMaterial.WOOD, EquipmentSlotType.FEET, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//flint armor
	public static final RegistryObject<Item> FLINT_HELMET = ITEMS.register("flint_helmet", 
			() -> new ModArmorItemBase(ModArmorMaterial.FLINT, EquipmentSlotType.HEAD, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> FLINT_CHESTPLATE = ITEMS.register("flint_chestplate", 
			() -> new ModArmorItemBase(ModArmorMaterial.FLINT, EquipmentSlotType.CHEST, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> FLINT_LEGGINGS = ITEMS.register("flint_leggings", 
			() -> new ModArmorItemBase(ModArmorMaterial.FLINT, EquipmentSlotType.LEGS, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> FLINT_BOOTS = ITEMS.register("flint_boots", 
			() -> new ModArmorItemBase(ModArmorMaterial.FLINT, EquipmentSlotType.FEET, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//emerald armor
	public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet", 
			() -> new EmeraldArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.HEAD, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", 
			() -> new EmeraldArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.CHEST, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", 
			() -> new EmeraldArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.LEGS, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots", 
			() -> new EmeraldArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.FEET, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//oedldoedl armor
	public static final RegistryObject<Item> OEDLDOEDL_HELMET = ITEMS.register("oedldoedl_helmet",
			() -> new OedldoedlArmorItem(ModArmorMaterial.OEDLDOEDL, EquipmentSlotType.HEAD, ModRarities.LIGHT_PURPLE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> OEDLDOEDL_CHESTPLATE = ITEMS.register("oedldoedl_chestplate", 
			() -> new ModArmorItemBase(ModArmorMaterial.OEDLDOEDL, EquipmentSlotType.CHEST, ModRarities.LIGHT_PURPLE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> OEDLDOEDL_LEGGINGS = ITEMS.register("oedldoedl_leggings", 
			() -> new ModArmorItemBase(ModArmorMaterial.OEDLDOEDL, EquipmentSlotType.LEGS, ModRarities.LIGHT_PURPLE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> OEDLDOEDL_BOOTS = ITEMS.register("oedldoedl_boots", 
			() -> new ModArmorItemBase(ModArmorMaterial.OEDLDOEDL, EquipmentSlotType.FEET, ModRarities.LIGHT_PURPLE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//unstable armor
	public static final RegistryObject<Item> UNSTABLE_HELMET = ITEMS.register("unstable_helmet", 
			() -> new UnstableArmorItem(ModArmorMaterial.UNSTABLE, EquipmentSlotType.HEAD, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> UNSTABLE_CHESTPLATE = ITEMS.register("unstable_chestplate", 
			() -> new UnstableArmorItem(ModArmorMaterial.UNSTABLE, EquipmentSlotType.CHEST, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> UNSTABLE_LEGGINGS = ITEMS.register("unstable_leggings", 
			() -> new UnstableArmorItem(ModArmorMaterial.UNSTABLE, EquipmentSlotType.LEGS, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> UNSTABLE_BOOTS = ITEMS.register("unstable_boots", 
			() -> new UnstableArmorItem(ModArmorMaterial.UNSTABLE, EquipmentSlotType.FEET, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//gremorium armor
	public static final RegistryObject<Item> GREMORIUM_HELMET = ITEMS.register("gremorium_helmet", 
			() -> new GremoriumArmorItem(ModArmorMaterial.GREMORIUM, EquipmentSlotType.HEAD, ModRarities.DARK_RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GREMORIUM_CHESTPLATE = ITEMS.register("gremorium_chestplate", 
			() -> new GremoriumArmorItem(ModArmorMaterial.GREMORIUM, EquipmentSlotType.CHEST, ModRarities.DARK_RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GREMORIUM_LEGGINGS = ITEMS.register("gremorium_leggings", 
			() -> new GremoriumArmorItem(ModArmorMaterial.GREMORIUM, EquipmentSlotType.LEGS, ModRarities.DARK_RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GREMORIUM_BOOTS = ITEMS.register("gremorium_boots", 
			() -> new GremoriumArmorItem(ModArmorMaterial.GREMORIUM, EquipmentSlotType.FEET, ModRarities.DARK_RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//himejimarium armor
	public static final RegistryObject<Item> HIMEJIMARIUM_HELMET = ITEMS.register("himejimarium_helmet", 
			() -> new HimejimariumArmorItem(ModArmorMaterial.HIMEJIMARIUM, EquipmentSlotType.HEAD, ModRarities.DARK_BLUE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> HIMEJIMARIUM_CHESTPLATE = ITEMS.register("himejimarium_chestplate", 
			() -> new HimejimariumArmorItem(ModArmorMaterial.HIMEJIMARIUM, EquipmentSlotType.CHEST, ModRarities.DARK_BLUE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> HIMEJIMARIUM_LEGGINGS = ITEMS.register("himejimarium_leggings", 
			() -> new HimejimariumArmorItem(ModArmorMaterial.HIMEJIMARIUM, EquipmentSlotType.LEGS, ModRarities.DARK_BLUE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> HIMEJIMARIUM_BOOTS = ITEMS.register("himejimarium_boots", 
			() -> new HimejimariumArmorItem(ModArmorMaterial.HIMEJIMARIUM, EquipmentSlotType.FEET, ModRarities.DARK_BLUE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));

	//toujourium armor
	public static final RegistryObject<Item> TOUJOURIUM_HELMET = ITEMS.register("toujourium_helmet", 
			() -> new ToujouriumArmorItem(ModArmorMaterial.TOUJOURIUM, EquipmentSlotType.HEAD, AttributeUUIDTou.HELMET_UUID, ModRarities.GRAY, true, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TOUJOURIUM_CHESTPLATE = ITEMS.register("toujourium_chestplate", 
			() -> new ToujouriumArmorItem(ModArmorMaterial.TOUJOURIUM, EquipmentSlotType.CHEST, AttributeUUIDTou.CHESTPLATE_UUID, ModRarities.GRAY, true, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TOUJOURIUM_LEGGINGS = ITEMS.register("toujourium_leggings", 
			() -> new ToujouriumArmorItem(ModArmorMaterial.TOUJOURIUM, EquipmentSlotType.LEGS, AttributeUUIDTou.LEGGINGS_UUID, ModRarities.GRAY, true, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TOUJOURIUM_BOOTS = ITEMS.register("toujourium_boots", 
			() -> new ToujouriumArmorItem(ModArmorMaterial.TOUJOURIUM, EquipmentSlotType.FEET, AttributeUUIDTou.BOOTS_UUID, ModRarities.GRAY, true, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//argentorium armor
	public static final RegistryObject<Item> ARGENTORIUM_HELMET = ITEMS.register("argentorium_helmet", 
			() -> new ArgentoriumArmorItem(ModArmorMaterial.ARGENTORIUM, EquipmentSlotType.HEAD, AttributeUUIDArg.HELMET_UUID, ModRarities.YELLOW, true, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> ARGENTORIUM_CHESTPLATE = ITEMS.register("argentorium_chestplate", 
			() -> new ArgentoriumArmorItem(ModArmorMaterial.ARGENTORIUM, EquipmentSlotType.CHEST, AttributeUUIDArg.CHESTPLATE_UUID, ModRarities.YELLOW, true, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> ARGENTORIUM_LEGGINGS = ITEMS.register("argentorium_leggings", 
			() -> new ArgentoriumArmorItem(ModArmorMaterial.ARGENTORIUM, EquipmentSlotType.LEGS, AttributeUUIDArg.LEGGINGS_UUID, ModRarities.YELLOW, true, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> ARGENTORIUM_BOOTS = ITEMS.register("argentorium_boots", 
			() -> new ArgentoriumArmorItem(ModArmorMaterial.ARGENTORIUM, EquipmentSlotType.FEET, AttributeUUIDArg.BOOTS_UUID, ModRarities.YELLOW, true, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//infinity armor
	public static final RegistryObject<Item> INFINITY_HELMET = ITEMS.register("infinity_helmet", 
			() -> new InfinityArmorItem(ModArmorMaterial.INFINITY, EquipmentSlotType.HEAD, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> INFINITY_CHESTPLATE = ITEMS.register("infinity_chestplate", 
			() -> new InfinityArmorItem(ModArmorMaterial.INFINITY, EquipmentSlotType.CHEST, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> INFINITY_LEGGINGS = ITEMS.register("infinity_leggings", 
			() -> new InfinityArmorItem(ModArmorMaterial.INFINITY, EquipmentSlotType.LEGS, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> INFINITY_BOOTS = ITEMS.register("infinity_boots", 
			() -> new InfinityArmorItem(ModArmorMaterial.INFINITY, EquipmentSlotType.FEET, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//gamemode armor
	public static final RegistryObject<Item> GAMEMODE_CHESTPLATE = ITEMS.register("gamemode_chestplate", 
			() -> new GamemodeChestplateItem(ModArmorMaterial.GAMEMODE_CHESTPLATE, EquipmentSlotType.CHEST, ModRarities.RED, true, true, 2, 1, new Item.Properties().group(ModItemGroups.TAB_GEAR)));

	//flying shooting armor
	public static final RegistryObject<Item> CLASSIC_FLYING_SHOOTING_HOODIE = ITEMS.register("classic_flying_shooting_hoodie", 
			() -> new ModArmorItemBase(ModArmorMaterial.FLYING_SHOOTING_CLASSIC, EquipmentSlotType.CHEST, ModRarities.AQUA, false, true, 2, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));

	public static final RegistryObject<Item> BLACK_FLYING_SHOOTING_HOODIE = ITEMS.register("black_flying_shooting_hoodie", 
			() -> new ModArmorItemBase(ModArmorMaterial.FLYING_SHOOTING_BLACK, EquipmentSlotType.CHEST, ModRarities.AQUA, false, true, 2, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));

	public static final RegistryObject<Item> WHITE_FLYING_SHOOTING_HOODIE = ITEMS.register("white_flying_shooting_hoodie", 
			() -> new ModArmorItemBase(ModArmorMaterial.FLYING_SHOOTING_WHITE, EquipmentSlotType.CHEST, ModRarities.AQUA, false, true, 2, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));

	public static final RegistryObject<Item> FLYING_SHOOTING_COLLEGE_JACKET = ITEMS.register("flying_shooting_college_jacket", 
			() -> new ModArmorItemBase(ModArmorMaterial.FLYING_SHOOTING_COLLEGE_JACKET, EquipmentSlotType.CHEST, ModRarities.LIGHT_PURPLE, false, true, 3, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//travellers armor
	public static final RegistryObject<Item> TRAVELLERS_BOOTS = ITEMS.register("travellers_boots", 
			() -> new TravellersBootsItem(ModArmorMaterial.TRAVELLERS_BOOTS, EquipmentSlotType.FEET, ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TRAVELLERS_GOLD_BOOTS = ITEMS.register("travellers_golden_boots",
			() -> new TravellersGoldenBootsItem(ModArmorMaterial.TRAVELLERS_IRON_BOOTS, EquipmentSlotType.FEET, ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TRAVELLERS_IRON_BOOTS = ITEMS.register("travellers_iron_boots", 
			() -> new TravellersIronBootsItem(ModArmorMaterial.TRAVELLERS_GOLDEN_BOOTS, EquipmentSlotType.FEET, ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TRAVELLERS_DIAMOND_BOOTS = ITEMS.register("travellers_diamond_boots", 
			() -> new TravellersDiamondBootsItem(ModArmorMaterial.TRAVELLERS_DIAMOND_BOOTS, EquipmentSlotType.FEET, ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TRAVELLERS_EMERALD_BOOTS = ITEMS.register("travellers_emerald_boots", 
			() -> new TravellersEmeraldBootsItem(ModArmorMaterial.TRAVELLERS_EMERALD_BOOTS, EquipmentSlotType.FEET, ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TRAVELLERS_NETHERITE_BOOTS = ITEMS.register("travellers_netherite_boots", 
			() -> new TravellersNetheriteBootsItem(ModArmorMaterial.TRAVELLERS_NETHERITE_BOOTS, EquipmentSlotType.FEET, ModRarities.YELLOW, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//long fall armor
	public static final RegistryObject<Item> LONG_FALL_BOOTS = ITEMS.register("long_fall_boots", 
			() -> new LongFallBootsItem(ModArmorMaterial.LONG_FALL_BOOTS, EquipmentSlotType.FEET, ModRarities.AQUA, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));

	//horsearmor
	public static final RegistryObject<Item> BASE_HORSE_ARMOR = ITEMS.register("base_horse_armor", 
			() -> new ModHorseArmorItemBase(OedldoedlGear.MODID, "base_horse_armor", 6, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EMERALD_HORSE_ARMOR = ITEMS.register("emerald_horse_armor", 
			() -> new ModHorseArmorItemBase(OedldoedlGear.MODID, "emerald_horse_armor", 12, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> CHAINMAIL_HORSE_ARMOR = ITEMS.register("chainmail_horse_armor", 
			() -> new ModHorseArmorItemBase(OedldoedlGear.MODID, "chainmail_horse_armor", 4, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> NETHERITE_HORSE_ARMOR = ITEMS.register("netherite_horse_armor",
			() -> new ModHorseArmorItemBase(OedldoedlGear.MODID, "netherite_horse_armor", 14, ModRarities.WHITE, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));

	//base tools
	public static final RegistryObject<Item> BASE_SWORD = ITEMS.register("base_sword", 
			() -> new ModSwordItemBase(ModItemTier.BASE, 3, -2.4f, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BASE_SHOVEL = ITEMS.register("base_shovel", 
			() -> new ModShovelItemBase(ModItemTier.BASE, 1.5f, -3f, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BASE_PICKAXE = ITEMS.register("base_pickaxe", 
			() -> new ModPickaxeItemBase(ModItemTier.BASE, 1, -2.8f, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BASE_AXE = ITEMS.register("base_axe", 
			() -> new ModAxeItemBase(ModItemTier.BASE, 6.0f, -3.1f, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BASE_HOE = ITEMS.register("base_hoe", 
			() -> new ModHoeItemBase(ModItemTier.BASE, -2, -1.0f, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BASE_PAXEL = ITEMS.register("base_paxel",
			() -> new ModPaxelItemBase(ModItemTier.BASE, 4f, -3f, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BASE_SMASHBAT = ITEMS.register("base_smashbat",
			() -> new ModSmashbatItemBase(ModItemTier.BASE, 0, -2f, 9, 4.5, HitSound.METAL, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BASE_SHEARS = ITEMS.register("base_shears", 
			() -> new ModShearsItemBase(ModItemTier.BASE, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BASE_SHIELD = ITEMS.register("base_shield", 
			() -> new ModShieldItemBase(ModItemTier.BASE, net.thep2wking.oedldoedlresources.init.ModItems.BASE_INGOT.get(), ModRarities.WHITE, false, false, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//flint tools
	public static final RegistryObject<Item> FLINT_SWORD = ITEMS.register("flint_sword", 
			() -> new ModSwordItemBase(ModItemTier.FLINT, 3, -2.4f, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> FLINT_SHOVEL = ITEMS.register("flint_shovel", 
			() -> new ModShovelItemBase(ModItemTier.FLINT, 1.5f, -3f, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> FLINT_PICKAXE = ITEMS.register("flint_pickaxe", 
			() -> new ModPickaxeItemBase(ModItemTier.FLINT, 1, -2.8f, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> FLINT_AXE = ITEMS.register("flint_axe", 
			() -> new ModAxeItemBase(ModItemTier.FLINT, 6.0f, -3.1f, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> FLINT_HOE = ITEMS.register("flint_hoe", 
			() -> new ModHoeItemBase(ModItemTier.FLINT, -1, -2, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> FLINT_PAXEL = ITEMS.register("flint_paxel",
			() -> new ModPaxelItemBase(ModItemTier.FLINT, 4f, -3f, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> FLINT_SMASHBAT = ITEMS.register("flint_smashbat",
			() -> new ModSmashbatItemBase(ModItemTier.FLINT, 0, -2f, 5, 2.5, HitSound.WOOD, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> FLINT_SHEARS = ITEMS.register("flint_shears", 
			() -> new ModShearsItemBase(ModItemTier.FLINT, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> FLINT_SHIELD = ITEMS.register("flint_shield", 
			() -> new ModShieldItemBase(ModItemTier.FLINT, Items.FLINT, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//emerald tools
	public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", 
			() -> new ModSwordItemBase(ModItemTier.EMERALD, 3, -2.4f, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", 
			() -> new ModShovelItemBase(ModItemTier.EMERALD, 1.5f, -3f, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", 
			() -> new ModPickaxeItemBase(ModItemTier.EMERALD, 1, -2.8f, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", 
			() -> new ModAxeItemBase(ModItemTier.EMERALD, 6.0f, -3.0f, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", 
			() -> new ModHoeItemBase(ModItemTier.EMERALD, -3, 0, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EMERALD_PAXEL = ITEMS.register("emerald_paxel",
			() -> new ModPaxelItemBase(ModItemTier.EMERALD, 4f, -3f, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EMERALD_SMASHBAT = ITEMS.register("emerald_smashbat",
			() -> new ModSmashbatItemBase(ModItemTier.EMERALD, 0, -2f, 11, 5.5, HitSound.GEM, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EMERALD_SHEARS = ITEMS.register("emerald_shears", 
			() -> new ModShearsItemBase(ModItemTier.EMERALD, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EMERALD_SHIELD = ITEMS.register("emerald_shield", 
			() -> new ModShieldItemBase(ModItemTier.EMERALD, Items.EMERALD, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//oedldoedl tools
	public static final RegistryObject<Item> OEDLDOEDL_SWORD = ITEMS.register("oedldoedl_sword", 
			() -> new ModSwordItemBase(ModItemTier.OEDLDOEDL, 3, -2.4f, ModRarities.LIGHT_PURPLE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> OEDLDOEDL_SHOVEL = ITEMS.register("oedldoedl_shovel", 
			() -> new ModShovelItemBase(ModItemTier.OEDLDOEDL, 1.5f, -3f, ModRarities.LIGHT_PURPLE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> OEDLDOEDL_PICKAXE = ITEMS.register("oedldoedl_pickaxe", 
			() -> new ModPickaxeItemBase(ModItemTier.OEDLDOEDL, 1, -2.8f, ModRarities.LIGHT_PURPLE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> OEDLDOEDL_AXE = ITEMS.register("oedldoedl_axe", 
			() -> new ModAxeItemBase(ModItemTier.OEDLDOEDL, 5f, -3f, ModRarities.LIGHT_PURPLE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> OEDLDOEDL_HOE = ITEMS.register("oedldoedl_hoe", 
			() -> new ModHoeItemBase(ModItemTier.OEDLDOEDL, -5, 0, ModRarities.LIGHT_PURPLE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> OEDLDOEDL_PAXEL = ITEMS.register("oedldoedl_paxel",
			() -> new ModPaxelItemBase(ModItemTier.OEDLDOEDL, 4f, -3f, new HashSet<>(), ModRarities.LIGHT_PURPLE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> OEDLDOEDL_SMASHBAT = ITEMS.register("oedldoedl_smashbat", 
			() -> new ModSmashbatItemBase(ModItemTier.OEDLDOEDL, 0, -2f, 16, 8, HitSound.GEM ,new HashSet<>(), ModRarities.LIGHT_PURPLE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> OEDLDOEDL_SHEARS = ITEMS.register("oedldoedl_shears", 
			() -> new ModShearsItemBase(ModItemTier.OEDLDOEDL, ModRarities.LIGHT_PURPLE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> OEDLDOEDL_SHIELD = ITEMS.register("oedldoedl_shield", 
			() -> new ModShieldItemBase(ModItemTier.OEDLDOEDL, net.thep2wking.oedldoedlresources.init.ModItems.OEDLDOEDL_INGOT.get(), ModRarities.LIGHT_PURPLE, true, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//unstable tools
	public static final RegistryObject<Item> UNSTABLE_SWORD = ITEMS.register("unstable_sword", 
			() -> new UnstableSwordItem(ModItemTier.UNSTABLE, 3, -2.4f, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> UNSTABLE_SHOVEL = ITEMS.register("unstable_shovel", 
			() -> new UnstableShovelItem(ModItemTier.UNSTABLE, 1.5f, -3f, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> UNSTABLE_PICKAXE = ITEMS.register("unstable_pickaxe", 
			() -> new UnstablePickaxeItem(ModItemTier.UNSTABLE, 1, -2.8f, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> UNSTABLE_AXE = ITEMS.register("unstable_axe", 
			() -> new UnstableAxeItem(ModItemTier.UNSTABLE, 5f, -3f, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> UNSTABLE_HOE = ITEMS.register("unstable_hoe", 
			() -> new UnstableHoeItem(ModItemTier.UNSTABLE, -3, 0, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> UNSTABLE_PAXEL = ITEMS.register("unstable_paxel",
			() -> new UnstablePaxelItem(ModItemTier.UNSTABLE, 4f, -3f, new HashSet<>(), ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> UNSTABLE_SMASHBAT = ITEMS.register("unstable_smashbat", 
			() -> new UnstableSmashbatItem(ModItemTier.UNSTABLE, 0, -2f, 13, 6.5, HitSound.METAL, new HashSet<>(), ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> UNSTABLE_SHEARS = ITEMS.register("unstable_shears", 
			() -> new UnstableShearsItem(ModItemTier.UNSTABLE, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> UNSTABLE_SHIELD = ITEMS.register("unstable_shield", 
			() -> new UnstableShieldItem(ModItemTier.UNSTABLE, net.thep2wking.oedldoedlresources.init.ModItems.UNSTABLE_INGOT.get(), ModRarities.RED, false, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//gremorium tools
	public static final RegistryObject<Item> GREMORIUM_SWORD = ITEMS.register("gremorium_sword", 
			() -> new ModSwordItemBase(ModItemTier.GREMORIUM, 3, -2.4f, ModRarities.DARK_RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GREMORIUM_SHOVEL = ITEMS.register("gremorium_shovel", 
			() -> new ModShovelItemBase(ModItemTier.GREMORIUM, 1.5f, -3f, ModRarities.DARK_RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GREMORIUM_PICKAXE = ITEMS.register("gremorium_pickaxe", 
			() -> new ModPickaxeItemBase(ModItemTier.GREMORIUM, 1, -2.8f, ModRarities.DARK_RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GREMORIUM_AXE = ITEMS.register("gremorium_axe", 
			() -> new ModAxeItemBase(ModItemTier.GREMORIUM, 5f, -3f, ModRarities.DARK_RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GREMORIUM_HOE = ITEMS.register("gremorium_hoe", 
			() -> new ModHoeItemBase(ModItemTier.GREMORIUM, -6, 0, ModRarities.DARK_RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GREMORIUM_PAXEL = ITEMS.register("gremorium_paxel",
			() -> new ModPaxelItemBase(ModItemTier.GREMORIUM, 4f, -3f, new HashSet<>(), ModRarities.DARK_RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GREMORIUM_SMASHBAT = ITEMS.register("gremorium_smashbat", 
			() -> new ModSmashbatItemBase(ModItemTier.GREMORIUM, 0, -2f, 20, 10, HitSound.METAL, new HashSet<>(), ModRarities.DARK_RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GREMORIUM_SHEARS = ITEMS.register("gremorium_shears", 
			() -> new ModShearsItemBase(ModItemTier.GREMORIUM, ModRarities.DARK_RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GREMORIUM_SHIELD = ITEMS.register("gremorium_shield", 
			() -> new AttackDamageShieldItem(ModItemTier.GREMORIUM, 4.0, net.thep2wking.oedldoedlresources.init.ModItems.GREMORIUM_INGOT.get(), ModRarities.DARK_RED, true, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//himejimarium tools
	public static final RegistryObject<Item> HIMEJIMARIUM_SWORD = ITEMS.register("himejimarium_sword", 
			() -> new ModSwordItemBase(ModItemTier.HIMEJIMARIUM, 3, -2.4f, ModRarities.DARK_BLUE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> HIMEJIMARIUM_SHOVEL = ITEMS.register("himejimarium_shovel", 
			() -> new ModShovelItemBase(ModItemTier.HIMEJIMARIUM, 1.5f, -3f, ModRarities.DARK_BLUE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> HIMEJIMARIUM_PICKAXE = ITEMS.register("himejimarium_pickaxe", 
			() -> new ModPickaxeItemBase(ModItemTier.HIMEJIMARIUM, 1, -2.8f, ModRarities.DARK_BLUE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> HIMEJIMARIUM_AXE = ITEMS.register("himejimarium_axe", 
			() -> new ModAxeItemBase(ModItemTier.HIMEJIMARIUM, 5f, -3f, ModRarities.DARK_BLUE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> HIMEJIMARIUM_HOE = ITEMS.register("himejimarium_hoe", 
			() -> new ModHoeItemBase(ModItemTier.HIMEJIMARIUM, -6, 0, ModRarities.DARK_BLUE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> HIMEJIMARIUM_PAXEL = ITEMS.register("himejimarium_paxel",
			() -> new ModPaxelItemBase(ModItemTier.HIMEJIMARIUM, 4f, -3f, new HashSet<>(), ModRarities.DARK_BLUE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> HIMEJIMARIUM_SMASHBAT = ITEMS.register("himejimarium_smashbat", 
			() -> new ModSmashbatItemBase(ModItemTier.HIMEJIMARIUM, 0, -2f, 20, 10, HitSound.METAL, new HashSet<>(), ModRarities.DARK_BLUE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> HIMEJIMARIUM_SHEARS = ITEMS.register("himejimarium_shears", 
			() -> new ModShearsItemBase(ModItemTier.HIMEJIMARIUM, ModRarities.DARK_BLUE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> HIMEJIMARIUM_SHIELD = ITEMS.register("himejimarium_shield", 
			() -> new AttackDamageShieldItem(ModItemTier.HIMEJIMARIUM, 4.0, net.thep2wking.oedldoedlresources.init.ModItems.HIMEJIMARIUM_INGOT.get(), ModRarities.DARK_BLUE, true, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//toujourium tools
	public static final RegistryObject<Item> TOUJOURIUM_SWORD = ITEMS.register("toujourium_sword", 
			() -> new ModSwordItemBase(ModItemTier.TOUJOURIUM, 3, -2.4f, ModRarities.GRAY, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TOUJOURIUM_SHOVEL = ITEMS.register("toujourium_shovel", 
			() -> new ModShovelItemBase(ModItemTier.TOUJOURIUM, 1.5f, -3f, ModRarities.GRAY, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TOUJOURIUM_PICKAXE = ITEMS.register("toujourium_pickaxe", 
			() -> new ModPickaxeItemBase(ModItemTier.TOUJOURIUM, 1, -2.8f, ModRarities.GRAY, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TOUJOURIUM_AXE = ITEMS.register("toujourium_axe", 
			() -> new ModAxeItemBase(ModItemTier.TOUJOURIUM, 5f, -3f, ModRarities.GRAY, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TOUJOURIUM_HOE = ITEMS.register("toujourium_hoe", 
			() -> new ModHoeItemBase(ModItemTier.TOUJOURIUM, -6, 0, ModRarities.GRAY, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TOUJOURIUM_PAXEL = ITEMS.register("toujourium_paxel",
			() -> new ModPaxelItemBase(ModItemTier.TOUJOURIUM, 4f, -3f, new HashSet<>(), ModRarities.GRAY, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TOUJOURIUM_SMASHBAT = ITEMS.register("toujourium_smashbat", 
			() -> new ModSmashbatItemBase(ModItemTier.TOUJOURIUM, 0, -2f, 20, 10, HitSound.METAL, new HashSet<>(), ModRarities.GRAY, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TOUJOURIUM_SHEARS = ITEMS.register("toujourium_shears", 
			() -> new ModShearsItemBase(ModItemTier.TOUJOURIUM, ModRarities.GRAY, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TOUJOURIUM_SHIELD = ITEMS.register("toujourium_shield", 
			() -> new AttackDamageShieldItem(ModItemTier.TOUJOURIUM, 4.0, net.thep2wking.oedldoedlresources.init.ModItems.TOUJOURIUM_INGOT.get(), ModRarities.GRAY, true, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//argentorium tools
	public static final RegistryObject<Item> ARGENTORIUM_SWORD = ITEMS.register("argentorium_sword", 
			() -> new ModSwordItemBase(ModItemTier.ARGENTORIUM, 3, -2.4f, ModRarities.YELLOW, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> ARGENTORIUM_SHOVEL = ITEMS.register("argentorium_shovel", 
			() -> new ModShovelItemBase(ModItemTier.ARGENTORIUM, 1.5f, -3f, ModRarities.YELLOW, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> ARGENTORIUM_PICKAXE = ITEMS.register("argentorium_pickaxe", 
			() -> new ModPickaxeItemBase(ModItemTier.ARGENTORIUM, 1, -2.8f, ModRarities.YELLOW, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> ARGENTORIUM_AXE = ITEMS.register("argentorium_axe", 
			() -> new ModAxeItemBase(ModItemTier.ARGENTORIUM, 5f, -3f, ModRarities.YELLOW, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> ARGENTORIUM_HOE = ITEMS.register("argentorium_hoe", 
			() -> new ModHoeItemBase(ModItemTier.ARGENTORIUM, -6, 0, ModRarities.YELLOW, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> ARGENTORIUM_PAXEL = ITEMS.register("argentorium_paxel",
			() -> new ModPaxelItemBase(ModItemTier.ARGENTORIUM, 4f, -3f, new HashSet<>(), ModRarities.YELLOW, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> ARGENTORIUM_SMASHBAT = ITEMS.register("argentorium_smashbat", 
			() -> new ModSmashbatItemBase(ModItemTier.ARGENTORIUM, 0, -2f, 20, 10, HitSound.METAL, new HashSet<>(), ModRarities.YELLOW, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> ARGENTORIUM_SHEARS = ITEMS.register("argentorium_shears", 
			() -> new ModShearsItemBase(ModItemTier.ARGENTORIUM, ModRarities.YELLOW, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> ARGENTORIUM_SHIELD = ITEMS.register("argentorium_shield", 
			() -> new AttackDamageShieldItem(ModItemTier.ARGENTORIUM, 4.0, net.thep2wking.oedldoedlresources.init.ModItems.ARGENTORIUM_INGOT.get(), ModRarities.YELLOW, true, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//infinity tools
	public static final RegistryObject<Item> INFINITY_SWORD = ITEMS.register("infinity_sword", 
			() -> new InfinitySwordItem(ModItemTier.INFINITY, -1, -2.4f, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> INFINITY_SHOVEL = ITEMS.register("infinity_shovel", 
			() -> new InfinityShovelItem(ModItemTier.INFINITY,  12.5f, -3f, ModRarities.RED, false, true, 1, 1, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> INFINITY_PICKAXE = ITEMS.register("infinity_pickaxe", 
			() -> new InfinityPickaxeItem(ModItemTier.INFINITY, 12, -2.8f, ModRarities.RED, false, true, 1, 1, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> INFINITY_AXE = ITEMS.register("infinity_axe", 
			() -> new InfinityAxeItem(ModItemTier.INFINITY, 16f, -3f, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> INFINITY_HOE = ITEMS.register("infinity_hoe", 
			() -> new InfinityHoeItem(ModItemTier.INFINITY, 10, 0, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> INFINITY_PAXEL = ITEMS.register("infinity_paxel",
			() -> new InfinityPaxelItem(ModItemTier.INFINITY, 20f, -2.8f, new HashSet<>(), ModRarities.RED, false, true, 1, 1, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> INFINITY_SMASHBAT = ITEMS.register("infinity_smashbat", 
			() -> new InfinitySmashbatItem(ModItemTier.INFINITY, 8, -2f, 50, 20, HitSound.GEM, new HashSet<>(), ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> INFINITY_SHEARS = ITEMS.register("infinity_shears", 
			() -> new InfinityShearsItem(ModItemTier.INFINITY, ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> INFINITY_SHIELD = ITEMS.register("infinity_shield", 
			() -> new InfinityShieldItem(ModItemTier.INFINITY, 10.0, net.thep2wking.oedldoedlresources.init.ModItems.INFINITY_INGOT.get(), ModRarities.RED, false, true, 1, 0, 
					new Item.Properties().group(ModItemGroups.TAB_GEAR)));

	//wooden tools  
	public static final RegistryObject<Item> WOODEN_PAXEL = ITEMS.register("wooden_paxel",
			() -> new ModPaxelItemBase(ItemTier.WOOD, 4f, -3f, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> WOODEN_SMASHBAT = ITEMS.register("wooden_smashbat", 
			() -> new ModSmashbatItemBase(ItemTier.WOOD, 0, -2f, 4, 2, HitSound.WOOD, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> WOODEN_SHEARS = ITEMS.register("wooden_shears", 
			() -> new ModShearsItemBase(ItemTier.WOOD, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> WOODEN_SHIELD = ITEMS.register("wooden_shield", 
			() -> new ModShieldItemBase(ItemTier.WOOD, null, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//stone tools
	public static final RegistryObject<Item> STONE_PAXEL = ITEMS.register("stone_paxel",
			() -> new ModPaxelItemBase(ItemTier.STONE, 4f, -3f, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> STONE_SMASHBAT = ITEMS.register("stone_smashbat", 
			() -> new ModSmashbatItemBase(ItemTier.STONE, 0, -2f, 6, 3, HitSound.WOOD, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> STONE_SHEARS = ITEMS.register("stone_shears", 
			() -> new ModShearsItemBase(ItemTier.STONE, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> STONE_SHIELD = ITEMS.register("stone_shield", 
			() -> new StoneShieldItem(ItemTier.STONE, null, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//golden tools
	public static final RegistryObject<Item> GOLDEN_PAXEL = ITEMS.register("golden_paxel",
			() -> new ModPaxelItemBase(ItemTier.GOLD, 4f, -3f, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GOLDEN_SMASHBAT = ITEMS.register("golden_smashbat", 
			() -> new ModSmashbatItemBase(ItemTier.GOLD, 0, -2f, 4, 12, HitSound.METAL, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GOLDEN_SHEARS = ITEMS.register("golden_shears", 
			() -> new ModShearsItemBase(ItemTier.GOLD, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GOLDEN_SHIELD = ITEMS.register("golden_shield", 
			() -> new ModShieldItemBase(ItemTier.GOLD, Items.GOLD_INGOT, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));

	//iron tools
	public static final RegistryObject<Item> IRON_PAXEL = ITEMS.register("iron_paxel",
			() -> new ModPaxelItemBase(ItemTier.IRON, 4f, -3f, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> IRON_SMASHBAT = ITEMS.register("iron_smashbat", 
			() -> new ModSmashbatItemBase(ItemTier.IRON, 0, -2f, 8, 4, HitSound.METAL, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> IRON_SHIELD = ITEMS.register("iron_shield", 
			() -> new ModShieldItemBase(ItemTier.IRON, Items.IRON_INGOT, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//diamond tools
	public static final RegistryObject<Item> DIAMOND_PAXEL = ITEMS.register("diamond_paxel",
			() -> new ModPaxelItemBase(ItemTier.DIAMOND, 4f, -3f, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> DIAMOND_SMASHBAT = ITEMS.register("diamond_smashbat", 
			() -> new ModSmashbatItemBase(ItemTier.DIAMOND, 0, -2f, 10, 5, HitSound.GEM, new HashSet<>(), ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> DIAMOND_SHEARS = ITEMS.register("diamond_shears", 
			() -> new ModShearsItemBase(ItemTier.DIAMOND, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> DIAMOND_SHIELD = ITEMS.register("diamond_shield", 
			() -> new ModShieldItemBase(ItemTier.DIAMOND, Items.DIAMOND, ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//netherite tools
	public static final RegistryObject<Item> NETHERITE_PAXEL = ITEMS.register("netherite_paxel",
			() -> new ModPaxelItemBase(ItemTier.NETHERITE, 4f, -3f, new HashSet<>(), ModRarities.WHITE, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> NETHERITE_SMASHBAT = ITEMS.register("netherite_smashbat", 
			() -> new ModSmashbatItemBase(ItemTier.NETHERITE, 0, -2f, 12, 6, HitSound.GEM, new HashSet<>(), ModRarities.WHITE, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> NETHERITE_SHEARS = ITEMS.register("netherite_shears", 
			() -> new ModShearsItemBase(ItemTier.NETHERITE, ModRarities.WHITE, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> NETHERITE_SHIELD = ITEMS.register("netherite_shield", 
			() -> new ModShieldItemBase(ItemTier.NETHERITE, Items.NETHERITE_INGOT, ModRarities.WHITE, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//carrot tools
	public static final RegistryObject<Item> RIDING_SMASHBAT = ITEMS.register("riding_smashbat", 
			() -> new RidingSmashbatItem(ModItemTier.CARROT, -1f, -2f, 15, 5, HitSound.WOOD, new HashSet<>(), ModRarities.GOLD, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GOLDEN_RIDING_SMASHBAT = ITEMS.register("golden_riding_smashbat", 
			() -> new RidingSmashbatItem(ModItemTier.GOLDEN_CARROT, -1f, -2f, 20, 7, HitSound.WOOD, new HashSet<>(), ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));

	//misc tools
	public static final RegistryObject<Item> BAN_HAMMER = ITEMS.register("ban_hammer", 
			() -> new BanHammerItem(ModRarities.RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> KICK_STICK = ITEMS.register("kick_stick", 
			() -> new KickStickItem(ModRarities.RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BEDROCK_BREAKER = ITEMS.register("bedrock_breaker", 
			() -> new BedrockBreakerIem(ModRarities.RED, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EXPLOSION_STAFF = ITEMS.register("explosion_staff", 
			() -> new ExplosionStaffItem(ModRarities.RED, false, false, 1, 1, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> LIGHTNING_STAFF = ITEMS.register("lightning_staff", 
			() -> new LightningStaffItem(ModRarities.AQUA, false, false, 1, 1, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BREF_POWER = ITEMS.register("bref_power", 
			() -> new BrefPowerItem(ModRarities.AQUA, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//throwables
	public static final RegistryObject<Item> ROCKY_SNOWBALL = ITEMS.register("rocky_snowball", 
			() -> new RockySnowballItem(ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> EXPLOSIVE_SNOWBALL = ITEMS.register("explosive_snowball", 
			() -> new ExplosiveSnowballItem(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> DYNAMITE = ITEMS.register("dynamite", 
			() -> new DynamiteItem(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> COMBAT_DYNAMITE = ITEMS.register("combat_dynamite", 
			() -> new CombatDynamiteItem(ModRarities.GREEN, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> CHARGED_DYNAMITE = ITEMS.register("charged_dynamite", 
			() -> new ChargedDynamiteItem(ModRarities.AQUA, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	//ingredients
	public static final RegistryObject<Item> BASE_TOOLKIT = ITEMS.register("base_toolkit", 
			() -> new ModItemBase(ModRarities.WHITE, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> OEDLDOEDL_TOOLKIT = ITEMS.register("oedldoedl_toolkit", 
			() -> new ModItemBase(ModRarities.LIGHT_PURPLE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GREMORIUM_TOOLKIT = ITEMS.register("gremorium_toolkit", 
			() -> new ModItemBase(ModRarities.DARK_RED, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> HIMEJIMARIUM_TOOLKIT = ITEMS.register("himejimarium_toolkit", 
			() -> new ModItemBase(ModRarities.DARK_BLUE, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TOUJOURIUM_TOOLKIT = ITEMS.register("toujourium_toolkit", 
			() -> new ModItemBase(ModRarities.GRAY, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> ARGENTORIUM_TOOLKIT = ITEMS.register("argentorium_toolkit", 
			() -> new ModItemBase(ModRarities.YELLOW, true, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	public static final RegistryObject<Item> WHITE_FABRIC = ITEMS.register("white_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> ORANGE_FABRIC = ITEMS.register("orange_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> MAGENTA_FABRIC = ITEMS.register("magenta_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> LIGHT_BLUE_FABRIC = ITEMS.register("light_blue_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> YELLOW_FABRIC = ITEMS.register("yellow_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> LIME_FABRIC = ITEMS.register("lime_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> PINK_FABRIC = ITEMS.register("pink_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GRAY_FABRIC = ITEMS.register("gray_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> LIGHT_GRAY_FABRIC = ITEMS.register("light_gray_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> CYAN_FABRIC = ITEMS.register("cyan_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> PURPLE_FABRIC = ITEMS.register("purple_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BLUE_FABRIC = ITEMS.register("blue_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BROWN_FABRIC = ITEMS.register("brown_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> GREEN_FABRIC = ITEMS.register("green_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> RED_FABRIC = ITEMS.register("red_fabric",
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> BLACK_FABRIC = ITEMS.register("black_fabric", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	public static final RegistryObject<Item> HARDENED_LEATHER = ITEMS.register("hardened_leather", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> TRAVELLERS_LEATHER = ITEMS.register("travellers_leather", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	public static final RegistryObject<Item> NEEDLE = ITEMS.register("needle", 
			() -> new NeedleItem(ModRarities.YELLOW, false, false, 1, 1, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> LEATHER_STICK = ITEMS.register("leather_stick", 
			() -> new ModItemBase(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> OBSIDIAN_STICK = ITEMS.register("obsidian_stick", 
			() -> new ModItemBase(ModRarities.AQUA, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> NEUTRONIUM_STICK = ITEMS.register("neutronium_stick", 
			() -> new ModItemBase(ModRarities.AQUA, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	public static final RegistryObject<Item> EXPLOSION_CORE = ITEMS.register("explosion_core", 
			() -> new ExplosionCoreItem(ModRarities.RED, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> CHARGED_ESSENCE = ITEMS.register("charged_essence", 
			() -> new ChargedEssenceItem(ModRarities.AQUA, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));

	public static final RegistryObject<Item> CHAINMAIL = ITEMS.register("chainmail", 
			() -> new ChainmailItem(ModRarities.YELLOW, false, false, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	public static final RegistryObject<Item> NOTE_OF_SUFFERING = ITEMS.register("note_of_suffering", 
			() -> new ModItemBase(ModRarities.LIGHT_PURPLE, false, true, 5, 1, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	  
	//misc
	public static final RegistryObject<Item> SQUID_BUCKET = ITEMS.register("squid_bucket", 
			() -> new SquidBucketItem(() -> Fluids.WATER, ModRarities.YELLOW, false, true, 1, 0, new Item.Properties().group(ModItemGroups.TAB_GEAR)));
	
	public static void register(IEventBus eventBus)
	{
		ITEMS.register(eventBus);
		
		OedldoedlGear.LOGGER.info("Registerd Items for " + OedldoedlGear.MODID + "!");
	}
}