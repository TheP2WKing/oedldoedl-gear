package net.thep2wking.oedldoedlgear.content.item.armor;

import java.util.List;
import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.armor.ModItemArmorBase;
import net.thep2wking.oedldoedlcore.util.ModArmorHelper;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;
import net.thep2wking.oedldoedlgear.model.ModelCrocs;

@Mod.EventBusSubscriber
public class ItemCrocs extends ModItemArmorBase {
	public ItemCrocs(String modid, String name, CreativeTabs tab, ArmorMaterial material, int renderIndex,
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
				|| enchantment.canApply(new ItemStack(Items.IRON_BOOTS));
	}

	@SubscribeEvent
	public static void livingUpdate(LivingUpdateEvent event) {
		if (event.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			if (!player.isSneaking()) {
				if (ModArmorHelper.hasBoots(player, ModItems.CROCS)) {
					BlockPos liquid = new BlockPos(Math.floor(player.posX), Math.floor(player.posY),
							Math.floor(player.posZ));
					BlockPos air = new BlockPos((int) player.posX, (int) (player.posY + player.height),
							(int) player.posZ);
					Block liquidBlock = player.world.getBlockState(liquid).getBlock();
					@SuppressWarnings("deprecation")
					Material liquidMaterial = liquidBlock.getMaterial(player.world.getBlockState(liquid));
					if ((GearConfig.CONTENT.CROCS_CAN_WALK_ON_LAVA
							? (liquidMaterial == Material.WATER || liquidMaterial == Material.LAVA)
							: liquidMaterial == Material.WATER)
							&& player.world.getBlockState(air).getBlock().isAir(player.world.getBlockState(air),
									player.world, air)) {
						player.motionY = 0.0D;
						player.fallDistance = 0.0F;
						player.onGround = true;
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onLivingHurt(LivingHurtEvent event) {
		if (event.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			if (ModArmorHelper.hasBoots(player, ModItems.CROCS)
					&& (event.getSource() == DamageSource.IN_FIRE || event.getSource() == DamageSource.LAVA)) {
				BlockPos liquid = new BlockPos(Math.floor(player.posX), Math.floor(player.posY),
						Math.floor(player.posZ));
				BlockPos air = new BlockPos((int) player.posX, (int) (player.posY + player.height),
						(int) player.posZ);
				Block liquidBlock = player.world.getBlockState(liquid).getBlock();
				Block headBlock = player.world.getBlockState(player.getPosition().up()).getBlock();
				@SuppressWarnings("deprecation")
				Material liquidMaterial = liquidBlock.getMaterial(player.world.getBlockState(liquid));
				@SuppressWarnings("deprecation")
				Material headMaterial = headBlock.getMaterial(player.world.getBlockState(player.getPosition().up()));
				if (GearConfig.CONTENT.CROCS_CAN_WALK_ON_LAVA && liquidMaterial == Material.LAVA
						&& player.world.getBlockState(air).getBlock().isAir(player.world.getBlockState(air),
								player.world, air)
						&& headMaterial != Material.LAVA) {
					player.extinguish();
					event.setCanceled(true);
					event.setAmount(0);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public ResourceLocation getTexture() {
		ResourceLocation texture1 = new ResourceLocation(modid,
				"textures/models/armor/" + name + "_layer_" + (renderIndex + 1) + ".png");
		ResourceLocation texture2 = new ResourceLocation(modid,
				"textures/models/armor/" + name + "_2_layer_" + (renderIndex + 1) + ".png");
		ResourceLocation texture3 = new ResourceLocation(modid,
				"textures/models/armor/" + name + "_3_layer_" + (renderIndex + 1) + ".png");
		ResourceLocation texture4 = new ResourceLocation(modid,
				"textures/models/armor/" + name + "_4_layer_" + (renderIndex + 1) + ".png");

		long time = System.currentTimeMillis();
		int variant = (int) ((time / 250) % 8) + 1;
		ResourceLocation currentTexture;
		switch (variant) {
			case 1:
				currentTexture = texture1;
				break;
			case 2:
				currentTexture = texture2;
				break;
			case 3:
				currentTexture = texture3;
				break;
			case 4:
				currentTexture = texture4;
				break;
			case 5:
				currentTexture = texture4;
				break;
			case 6:
				currentTexture = texture3;
				break;
			case 7:
				currentTexture = texture2;
				break;
			case 8:
				currentTexture = texture1;
				break;
			default:
				currentTexture = texture1;
				break;
		}
		return currentTexture;
	}

	@Override
	@Nullable
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot,
			ModelBiped _default) {
		ModelBiped model = new ModelCrocs(1, getTexture());
		model.isChild = _default.isChild;
		model.isRiding = _default.isRiding;
		model.isSneak = _default.isSneak;
		model.rightArmPose = _default.rightArmPose;
		model.leftArmPose = _default.leftArmPose;
		return model == null ? _default : model;
	}

	public static final String ARMOR_NAME = "item." + OedldoedlGear.MODID + ".crocs_armor";

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip()) {
			for (int i = 1; i <= annotationLines; ++i) {
				ModTooltips.addAnnotation(tooltip, this.getUnlocalizedName(), i);
			}
		}
		if (ModTooltips.showInfoTip()) {
			for (int i = 1; i <= tooltipLines; ++i) {
				ModTooltips.addInformation(tooltip, this.getUnlocalizedName(), i);
			}
		} else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0)) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}

		if (ModTooltips.showEffectTip()) {
			ModTooltips.addEffectHeader(tooltip, ModTooltips.EFFECT_BOOTS);
			ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 1);
			if (GearConfig.CONTENT.CROCS_CAN_WALK_ON_LAVA) {
				ModTooltips.addCustomEffectInformation(tooltip, ARMOR_NAME, 2);
			}
		} else if (ModTooltips.showEffectTipKey()) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_EFFECTS);
		}
	}
}