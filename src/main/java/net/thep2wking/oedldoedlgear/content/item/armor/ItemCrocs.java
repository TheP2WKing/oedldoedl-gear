package net.thep2wking.oedldoedlgear.content.item.armor;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.armor.ModItemArmorBase;
import net.thep2wking.oedldoedlcore.util.ModArmorHelper;
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
					BlockPos playerPos = new BlockPos(player.getPosition().getX(), player.getPosition().getY() + 0.75,
							player.getPosition().getZ());
					BlockPos blockPos = playerPos.down();
					Block block = player.world.getBlockState(blockPos).getBlock();
					@SuppressWarnings("all")
					Material material = block.getMaterial(player.world.getBlockState(blockPos));
					if (material.isLiquid()) {
						player.motionY = 0.0D;
						player.fallDistance = 0.0F;
						player.onGround = true;
						if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) {
							player.motionY += 0.42D;
						}
					}
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
}