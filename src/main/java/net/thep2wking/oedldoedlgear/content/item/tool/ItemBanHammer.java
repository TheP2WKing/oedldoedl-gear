package net.thep2wking.oedldoedlgear.content.item.tool;

import java.util.Date;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.UserListBansEntry;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlgear.config.GearConfig;

public class ItemBanHammer extends ModItemBase {
	public ItemBanHammer(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		setMaxStackSize(1);
	}

	@Override
	public boolean isDamageable() {
		return false;
	}

	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (target instanceof EntityPlayer && GearConfig.CONTENT.ADMINTOOLS.ENABLE_BAN_HAMMER) {
			EntityPlayer player = (EntityPlayer) attacker;
			EntityPlayer playerTarget = (EntityPlayer) target;
			World world = player.getEntityWorld();
			MinecraftServer server = world.getMinecraftServer();
			GameProfile profile = playerTarget.getGameProfile();
			Date expiryTime = null;
			UserListBansEntry banEntry = new UserListBansEntry(profile, new Date(),
					playerTarget.getDisplayName().toString(), expiryTime, GearConfig.CONTENT.ADMINTOOLS.BAN_MESSAGE);
			if (target instanceof EntityPlayer && server != null) {
				server.getPlayerList().getBannedPlayers().addEntry(banEntry);
				player.sendMessage(new TextComponentString("[")
						.appendSibling(new TextComponentString(
								TextFormatting.RED + I18n.format(this.getUnlocalizedName() + ".name")))
						.appendSibling(new TextComponentString("] "))
						.appendSibling(new TextComponentString(I18n.format(this.getUnlocalizedName() + ".tip2"))));
			}
		}
		return super.hitEntity(stack, target, attacker);
	}
}