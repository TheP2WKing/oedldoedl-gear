package net.thep2wking.oedldoedlgear.util;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.Tags;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlresources.util.ModTags;

public enum ModArmorMaterial implements IArmorMaterial
{
	BASE("base", 20, new int[] {3, 6, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f, 0.0f, () -> Ingredient.fromTag(ModTags.Items.INGOTS_BASE)),
	WOOD("wood", 8, new int[] {1, 3, 2, 1}, 6, SoundEvents.BLOCK_WOOD_PLACE, 0.0f, 0.0f, () -> Ingredient.fromTag(ItemTags.LOGS)),
	FLINT("flint", 10, new int[] {2, 4, 3, 2}, 6, SoundEvents.BLOCK_GRAVEL_STEP, 0.0f, 0.0f, () -> Ingredient.fromTag(net.thep2wking.oedldoedlcore.util.ModTags.Items.FORGE_GEMS_FLINT)),
	EMERALD("emerald", 35, new int[]{4, 7, 9, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.05f, () -> Ingredient.fromTag(Tags.Items.GEMS_EMERALD)),
	OEDLDOEDL("oedldoedl", 140, new int[] {6, 10, 12, 6}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.0f, 0.1f, () -> Ingredient.fromTag(ModTags.Items.INGOTS_OEDLDOEDL)),
	UNSTABLE("unstable", 0, new int[] {4, 7, 9, 4}, 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0f, 0.0f, () -> Ingredient.fromTag(ModTags.Items.INGOTS_UNSTABLE)),
	INFINITY("infinity", 0, new int[] {20, 26, 34, 20}, 200, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0f, 0.5f, () -> Ingredient.fromTag(ModTags.Items.INGOTS_INFINITY)),
	
	GREMORIUM("gremorium", 9958, new int[]{10, 16, 20, 10}, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8.0f, 0.25f, () -> Ingredient.fromTag(ModTags.Items.INGOTS_GREMORIUM)),
	HIMEJIMARIUM("himejimarium", 10260, new int[]{10, 16, 20, 10}, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8.0f, 0.25f, () -> Ingredient.fromTag(ModTags.Items.INGOTS_HIMEJIMARIUM)),
	TOUJOURIUM("toujourium", 6757, new int[]{10, 16, 20, 10}, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8.0f, 0.25f, () -> Ingredient.fromTag(ModTags.Items.INGOTS_TOUJOURIUM)),
	ARGENTORIUM("argentorium", 8355, new int[]{10, 16, 20, 10}, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8.0f, 0.25f, () -> Ingredient.fromTag(ModTags.Items.INGOTS_ARGENTORIUM)),
	
	TRAVELLERS_BOOTS("travellers_boots", 5, new int[] {2, 0, 0, 0}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, () -> Ingredient.fromTag(net.thep2wking.oedldoedlgear.util.ModTags.Items.TRAVELLERS_LEATHER)),
	TRAVELLERS_IRON_BOOTS("travellers_iron_boots", 15, new int[] {3, 0, 0, 0}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0f, 0.0f, () -> Ingredient.fromTag(Tags.Items.INGOTS_IRON)),
	TRAVELLERS_GOLDEN_BOOTS("travellers_golden_boots", 7, new int[] {3, 0, 0, 0}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0f, 0.0f, () -> Ingredient.fromTag(Tags.Items.INGOTS_GOLD)),
	TRAVELLERS_DIAMOND_BOOTS("travellers_diamond_boots", 33, new int[] {4, 0, 0, 0}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f, 0.0f, () -> Ingredient.fromTag(Tags.Items.GEMS_DIAMOND)),
	TRAVELLERS_EMERALD_BOOTS("travellers_emerald_boots", 35, new int[] {5, 0, 0, 0}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f, 0.05f, () -> Ingredient.fromTag(Tags.Items.GEMS_EMERALD)),
	TRAVELLERS_NETHERITE_BOOTS("travellers_netherite_boots", 37, new int[] {5, 0, 0, 0}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0f, 0.1f, () -> Ingredient.fromTag(Tags.Items.INGOTS_NETHERITE)),
	
	LONG_FALL_BOOTS("long_fall_boots", 0, new int[] {4, 0, 0, 0}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0f, 0.0f, () -> Ingredient.fromTag(Tags.Items.OBSIDIAN)),
	GAMEMODE_CHESTPLATE("gamemode_chestplate", 0, new int[] {0, 0, 20, 0}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 20.0f, 2.0f, () -> Ingredient.fromTag(net.thep2wking.oedldoedlgear.util.ModTags.Items.COMMAND_BLOCKS)),

	FLYING_SHOOTING_CLASSIC("classic_flying_shooting_hoodie", 100, new int[] {0, 0, 8, 0}, 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 4.0f, 0.0f, () -> Ingredient.fromTag(net.thep2wking.oedldoedlgear.util.ModTags.Items.FABRIC_BLUE)),
	FLYING_SHOOTING_BLACK("black_flying_shooting_hoodie", 100, new int[] {0, 0, 8, 0}, 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 4.0f, 0.0f, () -> Ingredient.fromTag(net.thep2wking.oedldoedlgear.util.ModTags.Items.FABRIC_BLACK)),
	FLYING_SHOOTING_WHITE("white_flying_shooting_hoodie", 100, new int[] {0, 0, 8, 0}, 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 4.0f, 0.0f, () -> Ingredient.fromTag(net.thep2wking.oedldoedlgear.util.ModTags.Items.FABRIC_WHITE)),
	FLYING_SHOOTING_COLLEGE_JACKET("flying_shooting_college_jacket", 150, new int[] {0, 0, 10, 0}, 30, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 6.0f, 0.1f, () -> Ingredient.fromTag(net.thep2wking.oedldoedlgear.util.ModTags.Items.FABRIC_BLACK)),
	;
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyValue<Ingredient> repairMaterial;

	private ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) 
	{
		this.name = name;
	    this.maxDamageFactor = maxDamageFactor;
	    this.damageReductionAmountArray = damageReductionAmountArray;
	    this.enchantability = enchantability;
	    this.soundEvent = soundEvent;
	    this.toughness = toughness;
	    this.knockbackResistance = knockbackResistance;
	    this.repairMaterial = new LazyValue<>(repairMaterial);
	}
	
	public int getMaxDurability() 
	{
		return this.maxDamageFactor;
	}
	   
	@Override
	public int getDurability(EquipmentSlotType slotIn) 
	{
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) 
	{
		return damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() 
	{
		return enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return repairMaterial.getValue();
	}

	@Override
	public String getName() 
	{
		return OedldoedlGear.MODID + ":" + name;
	}

	@Override
	public float getToughness()
	{
		return toughness;
	}

	@Override
	public float getKnockbackResistance() 
	{
		return knockbackResistance;
	}
}