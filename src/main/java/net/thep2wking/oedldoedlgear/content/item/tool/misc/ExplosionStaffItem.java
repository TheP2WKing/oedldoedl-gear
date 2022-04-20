package net.thep2wking.oedldoedlgear.content.item.tool.misc;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.thep2wking.oedldoedlcore.api.ModItemBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModSounds;
import net.thep2wking.oedldoedlgear.util.ModTags;

public class ExplosionStaffItem extends ModItemBase
{	
	public ExplosionStaffItem(Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties.maxDamage(100));
	}

	@Override
	public boolean isRepairable(ItemStack stack) 
	{
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) 
	{
		return ModTags.Items.MAGIC_WOOD.contains(repair.getItem()) || super.getIsRepairable(toRepair, repair);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) 
	{
        ItemStack stack = player.getHeldItem(hand);
        if (!world.isRemote && GearConfig.enable_wands.get()) 
        {
            Vector3d lookVec = player.getLookVec();
            Vector3d start = new Vector3d(player.getPosX(), player.getPosY() + player.getEyeHeight(), player.getPosZ());
            int distance = GearConfig.explosion_wand_range.get();
            boolean gothrough = false;
            if (player.isSneaking()) 
            {
                distance /= 2;
            }

            Vector3d end = start.add(lookVec.x * distance, lookVec.y * distance, lookVec.z * distance);
            RayTraceResult position;
            if (gothrough) 
            {
                position = null;
            } 
            else 
            {
                RayTraceContext context = new RayTraceContext(start, end, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, player);
                position = world.rayTraceBlocks(context);
            }
            if (position == null) 
            {
                if(gothrough) 
                {

                }
                else
                {
                    BlockPos blockPos = new BlockPos(end.x, end.y, end.z);
            		world.playSound(null, player.getPosition(), ModSounds.MEGUMIN.get(), SoundCategory.AMBIENT, 5, 1);
                	player.world.createExplosion(null, end.x, end.y, end.z, GearConfig.explosion_wand_explosion_strength.get(), 
                			GearConfig.explosion_wand_cause_fire.get(), GearConfig.explosion_wand_explosion_mode.get());
        	        LightningBoltEntity lightningBolt = EntityType.LIGHTNING_BOLT.create(player.world);
        	        if (lightningBolt != null) 
        	        {
        	        	lightningBolt.moveForced(Vector3d.copy(blockPos));
        	            lightningBolt.setCaster(player instanceof ServerPlayerEntity ? (ServerPlayerEntity) player : null);
        	            player.world.addEntity(lightningBolt);
        	        }
        	        player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 20, 0, false, false));
        	        player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 9, false, false));
        	        player.addPotionEffect(new EffectInstance(Effects.HUNGER, 100, 1, false, false));
        			player.getCooldownTracker().setCooldown(this, GearConfig.explosion_wand_cooldown.get());
        			stack.damageItem(1, player, e -> e.sendBreakAnimation(player.getActiveHand()));
                }
                return ActionResult.resultSuccess(stack);
            } 
            else 
            {
                BlockRayTraceResult result = (BlockRayTraceResult) position;
                BlockPos blockPos = result.getPos();
                int x = blockPos.getX();
                int y = blockPos.getY();
                int z = blockPos.getZ();

                world.playSound(null, player.getPosition(), ModSounds.MEGUMIN.get(), SoundCategory.AMBIENT, 5, 1);
                player.world.createExplosion(null, x, y+4, z, GearConfig.explosion_wand_explosion_strength.get(),
                		GearConfig.explosion_wand_cause_fire.get(), GearConfig.explosion_wand_explosion_mode.get());    
    	        LightningBoltEntity lightningBolt = EntityType.LIGHTNING_BOLT.create(player.world);
    	        if (lightningBolt != null) 
    	        {
    	        	lightningBolt.moveForced(Vector3d.copy(blockPos));
    	            lightningBolt.setCaster(player instanceof ServerPlayerEntity ? (ServerPlayerEntity) player : null);
    	            player.world.addEntity(lightningBolt);
    	        }
    	        player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 20, 0, false, false));
    	        player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 9, false, false));
    	        player.addPotionEffect(new EffectInstance(Effects.HUNGER, 100, 1, false, false));
    			player.getCooldownTracker().setCooldown(this, GearConfig.explosion_wand_cooldown.get());
    			stack.damageItem(1, player, e -> e.sendBreakAnimation(hand));
            }
            return ActionResult.resultSuccess(stack);
        }
        return ActionResult.resultPass(stack);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
    {
		if (ModTooltips.showAnnotationTip())
		{
			tooltip.add(new TranslationTextComponent(this.getTranslationKey()+".annotation1").mergeStyle(CoreConfig.information_annotation_formatting.get())
			.appendSibling(new StringTextComponent(" " + GearConfig.explosion_wand_range.get()).mergeStyle(TextFormatting.YELLOW)));
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