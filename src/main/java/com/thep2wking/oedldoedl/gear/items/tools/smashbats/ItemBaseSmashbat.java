package com.thep2wking.oedldoedl.gear.items.tools.smashbats;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;
import com.thep2wking.oedldoedl.core.OedldoedlCore;
import com.thep2wking.oedldoedl.core.config.CoreConfig;
import com.thep2wking.oedldoedl.core.util.interfaces.IHasModel;
import com.thep2wking.oedldoedl.core.util.tooltips.TooltipShiftInfo;
import com.thep2wking.oedldoedl.gear.OedldoedlGear;
import com.thep2wking.oedldoedl.gear.ReferenceGear;
import com.thep2wking.oedldoedl.gear.init.ItemInit;
import com.thep2wking.oedldoedl.gear.init.SoundInit;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBaseSmashbat extends ItemTool implements IHasModel
{
	private static Set<Block> effectiveBlocks = Sets.newHashSet(Blocks.AIR);

	public ItemBaseSmashbat(String name, float attackDamageIn, float attackSpeedIn, ToolMaterial materialIn) 
	{
		super(attackDamageIn, attackSpeedIn, materialIn, effectiveBlocks);
		setUnlocalizedName(ReferenceGear.MODID+":"+name);
		setRegistryName(ReferenceGear.MODID+":"+name);
		setCreativeTab(OedldoedlGear.TAB);
		setMaxStackSize(1);
		ItemInit.ITEMS.add(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels()
	{
		OedldoedlCore.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) 
	{
		stack.damageItem(-1, attacker);
		target.motionX *= 8.0;
		target.motionY *= 4.0;
		target.motionZ *= 8.0;
		return super.hitEntity(stack, target, attacker);
	}
	
	@Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) 
    {
        entity.world.playSound(player, player.getPosition(), SoundInit.SOUND_SMASH_METAL, SoundCategory.MASTER, 10.0f, 1.0f);
        return super.onLeftClickEntity(stack, player, entity);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) 
	{
  		if (CoreConfig.GENEREL.tooltips.itemInformation) 
  		{
			TooltipShiftInfo.addTooltipText(tooltip, new String[] 
			{
				TextFormatting.GREEN+I18n.format("item.oedldoedl.base_smashbat.tip"),
			});
  		}
	}
}