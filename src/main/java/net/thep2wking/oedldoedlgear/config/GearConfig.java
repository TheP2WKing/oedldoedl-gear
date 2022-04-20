package net.thep2wking.oedldoedlgear.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.world.Explosion.Mode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.EnumValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class GearConfig 
{ 
	//recipes
    public static BooleanValue enable_mod_recipes;
    
    //armor
    public static ConfigValue<String> gremorium_rgb_color;
    public static BooleanValue gremorium_abilities;
    
    public static ConfigValue<String> himejimarium_rgb_color;
    public static BooleanValue himejimarium_abilities;
    
    public static ConfigValue<String> toujourium_rgb_color;
    public static BooleanValue toujourium_abilities;
    
    public static ConfigValue<String> argentorium_rgb_color;
    public static BooleanValue argentorium_abilities;
    
    public static BooleanValue emerald_effects;
    
    public static BooleanValue infinity_abilities;
    public static BooleanValue infinity_invulnerability;
    
	//troll tnt
    public static BooleanValue troll_tnt_multiply_on_break;
    public static BooleanValue troll_tnt_cause_fire;
    public static IntValue troll_tnt_fuse_time;
    public static IntValue troll_tnt_explosion_strength;
    public static EnumValue<Mode> troll_tnt_explosion_mode;
    
    //admin tools
    public static BooleanValue enable_admin_tools;
    public static ConfigValue<String> ban_hammer_reason_message;
    public static ConfigValue<String> kick_stick_reason_message;
    
    //bedrock breaker
    public static IntValue bedrock_breaker_cooldown;
    
    //wands
    public static BooleanValue enable_wands;
    
    public static BooleanValue explosion_wand_cause_fire;
    public static IntValue explosion_wand_explosion_strength;
    public static IntValue explosion_wand_cooldown;
    public static IntValue explosion_wand_range;
    public static EnumValue<Mode> explosion_wand_explosion_mode;
    
    public static IntValue lightning_wand_cooldown;
    public static IntValue lightning_wand_range;
    
    //infinity tools
    public static BooleanValue infinity_tools_aoe;
    public static BooleanValue infinity_tools_break_unbreakable;
    
    //dynamite 
    public static IntValue dynamite_strength;
    public static IntValue charged_dynamite_strength;
    public static IntValue combat_dynamite_strength;

    public static void init() 
    {
        Pair<ConfigLoder, ForgeConfigSpec> gear_common_config = new ForgeConfigSpec.Builder().configure(ConfigLoder::new); 
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, gear_common_config.getRight());
    }

    public static class ConfigLoder 
    {
        public ConfigLoder(ForgeConfigSpec.Builder builder) 
        {
            builder.push("Content");
            
            builder.push("Equipment");
            
            builder.push("Gremorium");
            gremorium_rgb_color = builder.comment("Set rgb durability bar color (in hex). [Default: 990000]").define("rgb_bar_color", "990000");
            gremorium_abilities = builder.comment("Toggle abilities like potion effects / step up etc. [Default: true]").define("abilities", true);
            builder.pop();
            
            builder.push("Himejimarium");
            himejimarium_rgb_color = builder.comment("Set rgb durability bar color (in hex). [Default: 232033]").define("rgb_bar_color", "232033");
            himejimarium_abilities = builder.comment("Toggle abilities like potion effects / step up etc. [Default: true]").define("abilities", true);
            builder.pop();
            
            builder.push("Toujourium");
            toujourium_rgb_color = builder.comment("Set rgb durability bar color (in hex). [Default: c0c0c0]").define("rgb_bar_color", "c0c0c0");
            toujourium_abilities = builder.comment("Toggle abilities like potion effects / step up etc. [Default: true]").define("abilities", true);
            builder.pop();
            
            builder.push("Argentorium");
            argentorium_rgb_color = builder.comment("Set rgb durability bar color (in hex). [Default: fbd985]").define("rgb_bar_color", "fbd985");
            argentorium_abilities = builder.comment("Toggle abilities like potion effects / step up etc. [Default: true]").define("abilities", true);
            builder.pop();
            
            builder.push("Emerald");
            emerald_effects = builder.comment("Toggle potion effects. [Default: true]").define("effects", true);
            builder.pop();
            
            builder.push("Infinity");
            infinity_abilities = builder.comment("Toggle abilities like potion effects / step up etc. [Default: true]").define("abilities", true);
            infinity_invulnerability = builder.comment("Toggle invulnerability. [Default: true]").define("invulnerability", true);

            builder.pop();
            
            builder.pop();
            
            builder.push("Troll TNT");
            troll_tnt_multiply_on_break = builder.comment("Toggle if troll tnt can be broken. [Default: true]").define("multiply_on_break", true);
            troll_tnt_fuse_time = builder.comment("Set fuse time (in ticks) (20 = 1sec). [Default: 5]").defineInRange("fuse_time", 5, 5, 1200);
            troll_tnt_explosion_strength = builder.comment("Set the explosion strength. [Default: 3]").defineInRange("explosion_strength", 3, 1, 100);
            troll_tnt_cause_fire = builder.comment("Toggle fire. [Default: false]").define("cause_fire", false);
            troll_tnt_explosion_mode = builder.comment("Set explosion mode. [Default: DESTROY]").defineEnum("explosion_mode", Mode.DESTROY);
            builder.pop();
            
            builder.push("Admin Tools");
            enable_admin_tools = builder.comment("Toggle admin tools. [Default: false]").define("enabled", false);
            ban_hammer_reason_message = builder.comment("Set the default ban resason message. [Default: You deserve it!]").define("ban_reason", "You deserve it!");
            kick_stick_reason_message = builder.comment("Set the default kick resason message. [Default: You deserve it!]").define("kick_reason", "You deserve it!");
            builder.pop();
            
            builder.push("Staffs");
            enable_wands = builder.comment("Toggle wand effects. [Default: true]").define("enabled", true);
            builder.push("Explosion");
            explosion_wand_explosion_strength = builder.comment("Set the explosion strength (high values may cause lag). [Default: 15]").defineInRange("explosion_strength", 15, 0, 100);
            explosion_wand_cooldown = builder.comment("Set the cooldown (in ticks) (20 = 1sec). [Default: 80]").defineInRange("cooldown", 80, 0, 1200);
            explosion_wand_range = builder.comment("Set the range (in blocks) (high values may not work properly). [Default: 50]").defineInRange("range", 50, 1, 100);
            explosion_wand_cause_fire = builder.comment("Toggle fire. [Default: true]").define("cause_fire", false);
            explosion_wand_explosion_mode = builder.comment("Set explosion mode. [Default: DESTROY]").defineEnum("explosion_mode", Mode.DESTROY);
            builder.pop();
            builder.push("Lightning");
            lightning_wand_cooldown = builder.comment("Set the cooldown (in ticks) (20 = 1sec). [Default: 30]").defineInRange("cooldown", 30, 0, 1200);
            lightning_wand_range = builder.comment("Set the range (in blocks) (high values may not work properly). [Default: 40]").defineInRange("range", 40, 1, 100);
            builder.pop();
            builder.pop();
            
            bedrock_breaker_cooldown = builder.comment("Set the cooldown (in ticks) (20 = 1sec). [Default: 40]").defineInRange("bedrock_breaker_cooldown", 40, 0, 1200);
            
            builder.push("Infinity Tools");
            infinity_tools_aoe = builder.comment("Toggle infinity tools aoe. [Default: true]").define("aoe_break", true);
            infinity_tools_break_unbreakable = builder.comment("Toggle the ability to break unbreakable blocks with certain infity tools. [Default: true]").define("can_break_unbreakable", true);
            builder.pop();
            
            builder.push("Dynamite");
            dynamite_strength = builder.comment("Set the explosion strength. [Default: 3]").defineInRange("dynamite_strength", 3, 1, 50);
            charged_dynamite_strength = builder.comment("Set the explosion strength. [Default: 6]").defineInRange("charged_dynamite_strength", 6, 1, 50);
            combat_dynamite_strength = builder.comment("Set the explosion strength. [Default: 4]").defineInRange("combat_dynamite_strength", 4, 1, 50);
            builder.pop();
            
            builder.pop();
            
            enable_mod_recipes = builder.comment("Toggle all recipes from this mod. All recipes for items / blocks / liquids will be disabled. "
            		+ "This option is intended for use in a modpack with custom recipes so you do not have to remove them with Crafttweaker. "
            		+ "This can break certain recipes or other mechanics. [Default: true]").define("enable_mod_recipes", true);
        }
    }
}