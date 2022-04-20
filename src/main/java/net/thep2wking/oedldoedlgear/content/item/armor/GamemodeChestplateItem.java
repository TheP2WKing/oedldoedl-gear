package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.thep2wking.oedldoedlcore.api.ModArmorItemBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;

public class GamemodeChestplateItem extends ModArmorItemBase
{
	public GamemodeChestplateItem(IArmorMaterial materialIn, EquipmentSlotType slot, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
    {
		super(materialIn, slot, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
	}

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) 
    {
        ItemStack stack = player.getHeldItem(hand);
        if (player.isSneaking() && GearConfig.enable_admin_tools.get()) 
        {
            CompoundNBT tags = stack.getOrCreateTag();
            tags.putBoolean("Gamemode", !tags.getBoolean("Gamemode"));
            stack.setTag(tags);
            player.swingArm(hand);
            return new ActionResult<>(ActionResultType.SUCCESS, stack);
        }
        return new ActionResult<>(ActionResultType.PASS, stack);
    }
    
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
    {
    	if (player.inventory.armorInventory.get(2).getItem().equals(ModItems.GAMEMODE_CHESTPLATE.get()) && GearConfig.enable_admin_tools.get())
    	{
    		if(!world.isRemote)
    		{
            	if (stack.getOrCreateTag().getBoolean("Gamemode")) 
                {
            		player.setGameType(GameType.CREATIVE);
                }
            	else
            	{
            		player.setGameType(GameType.SURVIVAL);
            	}
    		}
    	}
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
	
	public String getMode(ItemStack stack)
	{
		if(stack.getOrCreateTag().getBoolean("Gamemode"))
		{
			return GameType.CREATIVE.getName();
		}
		return GameType.SURVIVAL.getName();
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
    {
		if(ModTooltips.showAnnotationTip() && GearConfig.enable_admin_tools.get())
		{
			tooltip.add(new TranslationTextComponent(this.getTranslationKey()+".annotation1").mergeStyle(CoreConfig.information_annotation_formatting.get())
			.appendSibling(new StringTextComponent(" " + getMode(stack)).mergeStyle(TextFormatting.YELLOW)));
		}
		if (ModTooltips.showInfoTip())
		{   
		    for (int i = 1; i <= tooltipLines; ++i) 
		    {
				ModTooltips.addInformation(tooltip, this.getTranslationKey(), i);
		    }
		}
		else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0))
		{
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}
    }
}