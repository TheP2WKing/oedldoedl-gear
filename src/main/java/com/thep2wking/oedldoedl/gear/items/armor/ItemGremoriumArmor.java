package com.thep2wking.oedldoedl.gear.items.armor;

import java.util.List;

import com.thep2wking.oedldoedl.core.OedldoedlCore;
import com.thep2wking.oedldoedl.core.config.CoreConfig;
import com.thep2wking.oedldoedl.core.init.RarityInit;
import com.thep2wking.oedldoedl.core.util.interfaces.IHasModel;
import com.thep2wking.oedldoedl.core.util.tooltips.TooltipControlEffectInfo;
import com.thep2wking.oedldoedl.core.util.tooltips.TooltipShiftInfo;
import com.thep2wking.oedldoedl.gear.OedldoedlGear;
import com.thep2wking.oedldoedl.gear.ReferenceGear;
import com.thep2wking.oedldoedl.gear.config.GearConfig;
import com.thep2wking.oedldoedl.gear.init.ItemInit;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGremoriumArmor extends ItemArmor implements IHasModel
{
	public ItemGremoriumArmor(String name, ArmorMaterial armorMaterial, int renderIndexIn, EntityEquipmentSlot slot)
	{
		super(ItemInit.ARMOR_MATERIAL_GREMORIUM, renderIndexIn, slot);
		setUnlocalizedName(ReferenceGear.MODID+":"+name);
		setRegistryName(ReferenceGear.MODID+":"+name);
		setCreativeTab(OedldoedlGear.TAB);
		setMaxDamage(9958);
		setMaxStackSize(1);
		ItemInit.ITEMS.add(this);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void registerModels()
	{
		OedldoedlCore.proxy.registerItemRenderer(this, 0, "inventory");
	}
    
    @Override
	@SideOnly (Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) 
    {
    	return RarityInit.DARK_RED;
    }
    
    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) 
    {
    	return 0x990000;
    }
    
    @Override
    public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) 
    {
        ItemStack chest = entity.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        ItemStack feet = entity.getItemStackFromSlot(EntityEquipmentSlot.FEET);
        ItemStack head = entity.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        ItemStack legs = entity.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
        if (((!head.isEmpty()) && (head.getItem() == ItemInit.ITEM_GREMORIUM_HELMET) && (!chest.isEmpty()) && (chest.getItem() == ItemInit.ITEM_GREMORIUM_CHESTPLATE) && (!legs.isEmpty()) && (legs.getItem() == ItemInit.ITEM_GREMORIUM_LEGGINGS) && (!feet.isEmpty()) && (feet.getItem() == ItemInit.ITEM_GREMORIUM_BOOTS)) || (entity.capabilities.isCreativeMode) || (entity.isSpectator())) 
        {
            boolean flying = entity instanceof EntityPlayer && ((EntityPlayer) entity).capabilities.isFlying;
            if (entity.onGround || flying && GearConfig.ARMOR.gremoriumArmor.abilities && GearConfig.GENEREL.effects.armorGiveEffects) 
            {
                boolean sneaking = entity.isSneaking();
                float speed = 0.01f * (flying ? 1.1f : 1.0f) * (sneaking ? 0.1f : 1.0f);

                if (entity.moveForward > 0f) 
                {
                    entity.moveRelative(0f, 0f, 1f, speed);
                } 
                else if (entity.moveForward < 0f) 
                {
                    entity.moveRelative(0f, 0f, 1f, -speed * 0.3f);
                }
                if (entity.moveStrafing != 0f) 
                {
                    entity.moveRelative(1f, 0f, 0f, speed * 0.5f * Math.signum(entity.moveStrafing));
                }
            }
            
      		if (GearConfig.ARMOR.gremoriumArmor.abilities && GearConfig.GENEREL.effects.armorGiveEffects) 
      		{
      			((EntityPlayer) entity).getFoodStats().addStats(20, 20F);
                
                entity.stepHeight = 1.0625F;
                
                entity.capabilities.allowFlying = true;
      		}
      		
      		if (GearConfig.ARMOR.gremoriumArmor.effectsEnabled && GearConfig.GENEREL.effects.armorGiveEffects) 
      		{
      			entity.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0, false, false));
      		}
		}
    	else
    	{
            entity.stepHeight = 0.5F;
            entity.capabilities.allowFlying = false;
            entity.capabilities.isFlying = false;
        }
    }

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) 
	{
  		if (CoreConfig.GENEREL.tooltips.itemInformation)
  		{
  			TooltipShiftInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.GREEN+I18n.format("item.oedldoedl.gremorium_armor.tip"),
  			});
  		}
  		
  		if (CoreConfig.GENEREL.tooltips.potionInformation && GearConfig.GENEREL.effects.armorGiveEffects) 
  		{
  			TooltipControlEffectInfo.addTooltipText(tooltip, new String[] 
  			{
  				TextFormatting.DARK_GREEN+""+I18n.format("core.oedldoedl.full.effects.tip"),
  				TextFormatting.YELLOW+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.gremorium_armor.effects.tip"),
  				TextFormatting.YELLOW+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.gremorium_armor.effects.tip2"),
  				TextFormatting.YELLOW+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.gremorium_armor.effects.tip3"),
  				TextFormatting.WHITE+""+TextFormatting.ITALIC+I18n.format("item.oedldoedl.gremorium_armor.effects.tip4")+TextFormatting.RED+""+TextFormatting.ITALIC+" (1) ",
  			});
  		}
	}
}