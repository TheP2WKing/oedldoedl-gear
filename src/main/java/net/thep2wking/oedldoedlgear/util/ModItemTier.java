package net.thep2wking.oedldoedlgear.util;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.common.Tags;
import net.thep2wking.oedldoedlresources.util.ModTags;

public enum ModItemTier implements IItemTier
{
	BASE(2, 420, 4f, 2f, 8, () -> Ingredient.fromTag(ModTags.Items.INGOTS_BASE)),
	FLINT(1, 125, 3f, 1f, 6, () -> Ingredient.fromTag(net.thep2wking.oedldoedlcore.util.ModTags.Items.FORGE_GEMS_FLINT)),
	EMERALD(3, 1789, 8.5f, 3.5f, 12, () -> Ingredient.fromTag(Tags.Items.GEMS_EMERALD)),
	OEDLDOEDL(5, 4096, 16f, 8f, 20, () -> Ingredient.fromTag(ModTags.Items.INGOTS_OEDLDOEDL)),
	INFINITY(100, 0, 100000f, 1f, 100, () -> Ingredient.fromTag(ModTags.Items.INGOTS_INFINITY)),
	
	UNSTABLE(4, 9999, 11f, 5f, 16, () -> Ingredient.fromTag(ModTags.Items.INGOTS_UNSTABLE)),
	CARROT(1, 10, 1f, 1f, 3, () -> Ingredient.fromItems(Items.CARROT)),
	GOLDEN_CARROT(1, 20, 1f, 1f, 6, () -> Ingredient.fromItems(Items.GOLDEN_CARROT)),
	
	GREMORIUM(6, 9958, 25f, 12f, 32, () -> Ingredient.fromTag(ModTags.Items.INGOTS_GREMORIUM)),
	HIMEJIMARIUM(6, 10260, 25f, 12f, 32, () -> Ingredient.fromTag(ModTags.Items.INGOTS_HIMEJIMARIUM)),
	TOUJOURIUM(6, 6757, 25f, 12f, 32, () -> Ingredient.fromTag(ModTags.Items.INGOTS_TOUJOURIUM)),
	ARGENTORIUM(6, 8355, 25f, 12f, 32, () -> Ingredient.fromTag(ModTags.Items.INGOTS_ARGENTORIUM)),
	;
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;

	private ModItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) 
	{
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = attackDamageIn;
		this.enchantability = enchantabilityIn;
		this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}

	@Override  
	public int getMaxUses() 
	{
		return maxUses;
	}

	@Override
	public float getEfficiency() 
	{
		return efficiency;
	}

	@Override
	public float getAttackDamage() 
	{
		return attackDamage;
	}

	@Override
	public int getHarvestLevel() 
	{
		return harvestLevel;
	}

	@Override
	public int getEnchantability() 
	{
		return enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return repairMaterial.getValue();
	}
}