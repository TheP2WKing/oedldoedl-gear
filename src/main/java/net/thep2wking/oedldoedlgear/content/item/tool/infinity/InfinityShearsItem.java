package net.thep2wking.oedldoedlgear.content.item.tool.infinity;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.ModShearsItemBase;
import net.thep2wking.oedldoedlgear.util.ModItemTier;

public class InfinityShearsItem extends ModShearsItemBase
{
    public static final Set<Material> EFFECTIVE_MATERIALS = ImmutableSet.of(Material.CACTUS, Material.CAKE, Material.CARPET, Material.LEAVES, Material.NETHER_PLANTS, Material.OCEAN_PLANT,
    		Material.PLANTS, Material.SEA_GRASS, Material.TALL_PLANTS, Material.WEB,  Material.WOOL);

	public InfinityShearsItem(IItemTier itemTier, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(itemTier, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}

	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) 
	{
		return Integer.MAX_VALUE;
	}
	
	@Override
	public boolean isDamageable() 
	{
		return false;
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		return false;
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) 
	{
		Material material = state.getMaterial();
		return EFFECTIVE_MATERIALS.contains(material) ? ModItemTier.INFINITY.getEfficiency() : super.getDestroySpeed(stack, state);
	}

	@Override
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) 
	{
		if(isInGroup(group))
		{
			ItemStack stack = new ItemStack(this);
			stack.addEnchantment(Enchantments.EFFICIENCY, 10);
			items.add(stack);
		}
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) 
	{
		stack.addEnchantment(Enchantments.EFFICIENCY, 10);
		super.onCreated(stack, worldIn, playerIn);
	}
}