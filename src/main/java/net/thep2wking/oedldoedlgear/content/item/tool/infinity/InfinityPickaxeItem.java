package net.thep2wking.oedldoedlgear.content.item.tool.infinity;

import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thep2wking.oedldoedlcore.api.ModPickaxeItemBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlgear.config.GearConfig;
import net.thep2wking.oedldoedlgear.init.ModItems;
import net.thep2wking.oedldoedlgear.util.AOEBreaker;

@Mod.EventBusSubscriber
public class InfinityPickaxeItem extends ModPickaxeItemBase
{
    public static final Set<Block> EFFECTIVE_ON = ImmutableSet.of(Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, 
    		Blocks.POWERED_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, 
    		Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE, Blocks.CUT_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE, 
    		Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.GRANITE, Blocks.POLISHED_GRANITE, Blocks.DIORITE, Blocks.POLISHED_DIORITE, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, Blocks.STONE_SLAB, 
    		Blocks.SMOOTH_STONE_SLAB, Blocks.SANDSTONE_SLAB, Blocks.PETRIFIED_OAK_SLAB, Blocks.COBBLESTONE_SLAB, Blocks.BRICK_SLAB, Blocks.STONE_BRICK_SLAB, Blocks.NETHER_BRICK_SLAB, Blocks.QUARTZ_SLAB, 
    		Blocks.RED_SANDSTONE_SLAB, Blocks.PURPUR_SLAB, Blocks.SMOOTH_QUARTZ, Blocks.SMOOTH_RED_SANDSTONE, Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_STONE, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE, 
    		Blocks.POLISHED_GRANITE_SLAB, Blocks.SMOOTH_RED_SANDSTONE_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.POLISHED_DIORITE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.END_STONE_BRICK_SLAB, 
    		Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.SMOOTH_QUARTZ_SLAB, Blocks.GRANITE_SLAB, Blocks.ANDESITE_SLAB, Blocks.RED_NETHER_BRICK_SLAB, Blocks.POLISHED_ANDESITE_SLAB, Blocks.DIORITE_SLAB, 
    		Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, 
    		Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, 
    		Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.PISTON, Blocks.STICKY_PISTON, Blocks.PISTON_HEAD);
    public static final Set<Material> EFFECTIVE_MATERIALS = ImmutableSet.of(Material.ROCK, Material.IRON, Material.GLASS, Material.ICE, Material.PACKED_ICE, Material.ANVIL, Material.GLASS);
    
	public InfinityPickaxeItem(IItemTier itemTier, int attackDamage, float attackSpeed, Rarity rarity, boolean hasEffect, boolean fireImmunity, int tooltipLines, int annotationLines, Properties properties) 
	{
		super(itemTier, attackDamage, attackSpeed, rarity, hasEffect, fireImmunity, tooltipLines, annotationLines, properties);
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
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) 
	{
		if(isInGroup(group))
		{
			ItemStack stack = new ItemStack(this);
			stack.addEnchantment(Enchantments.FORTUNE, 10);
			items.add(stack);
		}
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) 
	{
		stack.addEnchantment(Enchantments.FORTUNE, 10);
		super.onCreated(stack, worldIn, playerIn);
	}
	
	@SubscribeEvent
	public static void onPlayerLeftClick(PlayerInteractEvent.LeftClickBlock event) 
	{
		World world = event.getWorld();
		BlockState state = world.getBlockState(event.getPos());
		Block block = state.getBlock();
		ItemStack stack = event.getItemStack();
		if (stack.isEmpty()||stack.getItem()!= ModItems.INFINITY_PICKAXE.get())
			return;

		if (state.getBlock().getDefaultState().getBlockHardness(world, event.getPos()) <= -1)
		{
			if(!world.isRemote && GearConfig.infinity_tools_break_unbreakable.get())
			{
				world.destroyBlock(event.getPos(), false);
				world.removeBlock(event.getPos(), false);
				world.addEntity(new ItemEntity(world, event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(block.getBlock().asItem())));
			}
		}
	}	
	
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) 
    {
        ItemStack stack = player.getHeldItem(hand);
        if (player.isSneaking() && GearConfig.infinity_tools_aoe.get()) 
        {
            CompoundNBT tags = stack.getOrCreateTag();
            tags.putBoolean("Hammer", !tags.getBoolean("Hammer"));
            stack.setTag(tags);
            player.swingArm(hand);
            return new ActionResult<>(ActionResultType.SUCCESS, stack);
        }
        return new ActionResult<>(ActionResultType.PASS, stack);
    }

	
    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving)
    {
        if (entityLiving instanceof PlayerEntity)
        {
        	if (stack.getOrCreateTag().getBoolean("Hammer") && GearConfig.infinity_tools_aoe.get()) 
            {
        		AOEBreaker.areaAttempt(world, pos, (PlayerEntity) entityLiving, EFFECTIVE_ON, EFFECTIVE_MATERIALS, true);
            }
        }
        return super.onBlockDestroyed(stack, world, state, pos, entityLiving);
    }
    
	public float getDestroySpeed(ItemStack stack, BlockState state) 
	{
		Material material = state.getMaterial();
		return EFFECTIVE_MATERIALS.contains(material) ? this.efficiency : super.getDestroySpeed(stack, state);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
    {
		if(ModTooltips.showAnnotationTip())
		{
			tooltip.add(new TranslationTextComponent(this.getTranslationKey()+".annotation1").mergeStyle(CoreConfig.information_annotation_formatting.get())
			.appendSibling(new StringTextComponent(" " + stack.getOrCreateTag().getBoolean("Hammer")).mergeStyle(TextFormatting.YELLOW)));
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