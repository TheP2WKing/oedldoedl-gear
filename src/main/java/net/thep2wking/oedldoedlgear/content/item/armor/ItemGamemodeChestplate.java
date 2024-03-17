package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.AttributeModifierOperation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.armor.ModItemArmorBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModArmorHelper;
import net.thep2wking.oedldoedlcore.util.ModReferences;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;

public class ItemGamemodeChestplate extends ModItemArmorBase {
	public ItemGamemodeChestplate(String modid, String name, CreativeTabs tab, ArmorMaterial material, int renderIndex,
			EntityEquipmentSlot slot, EnumRarity rarity, boolean hasEffect, int tooltipLines, int annotationLines) {
		super(modid, name, tab, material, renderIndex, slot, rarity, hasEffect, tooltipLines, annotationLines);
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return enchantment.type.canEnchantItem(stack.getItem())
				|| enchantment.canApply(new ItemStack(Items.IRON_CHESTPLATE));
	}

	public static final UUID CHESTPLATE_UUID = UUID.fromString("789e2e67-2351-483a-acd5-a2f1acfb7140");

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		Multimap<String, AttributeModifier> attributes = LinkedHashMultimap.create();
		if (slot == this.getEquipmentSlot()) {
			attributes.putAll(super.getAttributeModifiers(this.getEquipmentSlot(), new ItemStack(this)));
			if (GearConfig.PROPERTIES.ARMOR_KNOCKBACK_RESISTANCE) {
				ModArmorHelper.addChestplateModifier(attributes, this, slot,
						SharedMonsterAttributes.KNOCKBACK_RESISTANCE, ModReferences.ATTRIBUTE_KNOCKBACK_RESISTANCE, 20,
						AttributeModifierOperation.ADD, CHESTPLATE_UUID);
			}
			return attributes;
		}
		return attributes;
	}

	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isDamageable() {
		return false;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (isInCreativeTab(tab)) {
			ItemStack stack = new ItemStack(this);
			NBTTagCompound compound = new NBTTagCompound();
			compound.setBoolean("Gamemode", true);
			;
			stack.setTagCompound(compound);
			items.add(stack);
		}
	}

	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setBoolean("Gamemode", true);
		;
		stack.setTagCompound(compound);
		super.onCreated(stack, worldIn, playerIn);
	}

	public String getMode(ItemStack stack) {
		NBTTagCompound compound = stack.getTagCompound();
		if (compound == null)
			compound = new NBTTagCompound();
		if (compound.getBoolean("Gamemode")) {
			return GameType.CREATIVE.getName().substring(0, 1).toUpperCase() + GameType.CREATIVE.getName().substring(1);
		}
		return GameType.SURVIVAL.getName().substring(0, 1).toUpperCase() + GameType.SURVIVAL.getName().substring(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (GearConfig.CONTENT.GAMEMODE_CHESTPLATE_SWITCH_GAMEMODES) {
			ItemStack stack = player.getHeldItem(hand);
			if (!world.isRemote && player.isSneaking()) {
				NBTTagCompound compound = stack.getTagCompound();
				if (compound == null)
					compound = new NBTTagCompound();
				compound.setBoolean("Gamemode", !compound.getBoolean("Gamemode"));
				stack.setTagCompound(compound);
				player.swingArm(hand);
				if (!compound.getBoolean("Gamemode")) {
					player.sendMessage(
							new TextComponentString(
									CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor()
											+ I18n.format(this.getUnlocalizedName() + ".annotation1"))
									.appendSibling(new TextComponentString(
											" " + TextFormatting.YELLOW + getMode(stack).toString())));
				} else {
					player.sendMessage(
							new TextComponentString(
									CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor()
											+ I18n.format(this.getUnlocalizedName() + ".annotation1"))
									.appendSibling(new TextComponentString(
											" " + TextFormatting.YELLOW + getMode(stack).toString())));
				}
			} else if (!world.isRemote && !player.isSneaking() && !player.isCreative()) {
				ItemStack itemstack = player.getHeldItem(hand);
				EntityEquipmentSlot entityequipmentslot = EntityLiving.getSlotForItemStack(itemstack);
				ItemStack itemstack1 = player.getItemStackFromSlot(entityequipmentslot);
				if (itemstack1.isEmpty()) {
					player.setItemStackToSlot(entityequipmentslot, itemstack.copy());
					itemstack.setCount(0);
					return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
				} else {
					return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
				}
			}
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
		}
		return super.onItemRightClick(world, player, hand);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (player.inventory.armorInventory.get(2).getItem().equals(ModItems.GAMEMODE_CHESTPLATE)
				&& GearConfig.CONTENT.GAMEMODE_CHESTPLATE_SWITCH_GAMEMODES) {
			if (!world.isRemote) {
				NBTTagCompound compound = itemStack.getTagCompound();
				if (compound == null)
					compound = new NBTTagCompound();
				if (compound.getBoolean("Gamemode")) {
					player.setGameType(GameType.CREATIVE);
				} else {
					player.setGameType(GameType.SURVIVAL);
				}
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip()) {
			if (GearConfig.CONTENT.GAMEMODE_CHESTPLATE_SWITCH_GAMEMODES) {
				tooltip.add(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor()
						+ I18n.format(this.getUnlocalizedName() + ".annotation1") + " " + TextFormatting.YELLOW
						+ getMode(stack));
			}
		}
		if (ModTooltips.showInfoTip()) {
			for (int i = 1; i <= tooltipLines; ++i) {
				ModTooltips.addInformation(tooltip, this.getUnlocalizedName(), i);
			}
		} else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0)) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}
	}
}