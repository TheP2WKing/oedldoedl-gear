package com.thep2wking.oedldoedl.gear.config;

import com.thep2wking.oedldoedl.gear.ReferenceGear;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = ReferenceGear.MODID, name = "oedldoedlgear", category = ReferenceGear.MODID)
public class GearConfig 
{
	//----------------------------------------------------------------------------------------------------------------
	
	@Config.Name("Generel")
	public static final Generel GENEREL = new Generel();
	
	public static class Generel
	{	
		@Config.Name("Recipes")
		public Recipes recipes = new Recipes();
		
		@Config.Name("Effects")
		public Effects effects = new Effects();
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class Effects
	{			
		@Config.Name("Items Give Effects")
		@Config.Comment("Enable or Disable potion effects given by items.")
		public boolean itemsGiveEffects = true;

		@Config.Name("Armor Give Effects")
		@Config.Comment("Enable or Disable potion effects given by armor.")
		public boolean armorGiveEffects = true;
		
		@Config.Name("Baubles Give Effects")
		@Config.Comment("Enable or Disable potion effects given by baubles.")
		public boolean baublesGiveEffects = true;
	}
	
	//----------------------------------------------------------------------------------------------------------------

	@Config.Name("Armor")
	public static final Armor ARMOR = new Armor();
	

	@Config.Name("Tools")
	public static final Tools TOOLS = new Tools();
	

	@Config.Name("Baubles")
	public static final Baubles BAUBLES = new Baubles();

	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class Armor
	{	
		@Config.Name("Base")
		public BaseArmor baseArmor = new BaseArmor();
		
		@Config.Name("Oedldoedl")
		public OedldoedlArmor oedldoedlArmor = new OedldoedlArmor();
		
		@Config.Name("Gremorium")
		public GremoriumArmor gremoriumArmor = new GremoriumArmor();
		
		@Config.Name("Himejimarium")
		public HimejimariumArmor himejimariumArmor = new HimejimariumArmor();
		
		@Config.Name("FlyingShooting")
		public FlyingShootingArmor flyingShootingArmor = new FlyingShootingArmor();
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class GremoriumArmor
	{	
		@Config.Name("Enabled")
		@Config.Comment("Enable or Disable the gremorium armor.")
		public boolean enabled = true;
		
		@Config.Name("Effects")
		@Config.Comment("Enable or Disable all effects from the gremorium armor.")
		public boolean effectsEnabled = true;
		
		@Config.Name("Abilities")
		@Config.Comment("Enable or Disable all abilities given by the gremorium armor.")
		public boolean abilities = true;

	    public enum gremoriumArmorTexture 
	    {normal, alternative} 
	     
		@Config.Name("Armor Model")
		@Config.Comment("Set the armor model for the gremorium armor.")
	    public gremoriumArmorTexture armorModel = gremoriumArmorTexture.normal;	
	}
	
	//----------------------------------------------------------------------------------------------------------------

	public static class HimejimariumArmor
	{	
		@Config.Name("Enabled")
		@Config.Comment("Enable or Disable the himejimarium armor.")
		public boolean enabled = true;
		
		@Config.Name("Effects")
		@Config.Comment("Enable or Disable all effects from the himejimarium armor.")
		public boolean effectsEnabled = true;
		
		@Config.Name("Abilities")
		@Config.Comment("Enable or Disable all abilities given by the himejimarium armor.")
		public boolean abilities = true;
		
		@Config.Name("Resistance Effect Amplifier")
		@Config.Comment("Set the amplifier of the resistance effect given by the himejimarium armor.")
		@Config.RangeInt(min = 1, max = 255)
		public int resistanceAmplifier = 3;

	    public enum gremoriumArmorTexture 
	    {normal, alternative} 
	     
		@Config.Name("Armor Model")
		@Config.Comment("Set the armor model for the himejimarium armor.")
	    public gremoriumArmorTexture armorModel = gremoriumArmorTexture.normal;
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class BaseArmor
	{	
		@Config.Name("Enabled")
		@Config.Comment("Enable or Disable the base armor.")
		public boolean enabled = true;
		
		@Config.Name("Helmet Gives Night Vision")
		@Config.Comment("Enable or Disable the night vision effect give by the base helmet.")
		public boolean helmetGivesNightVision = false;
		
		@Config.Name("Armor Amplifier")
		@Config.Comment("Set the armor amplifier for the base armor.")
		@Config.RangeInt(min = 0, max = 10)
		public double armorAmplifier = 3.0;
		
		@Config.Name("Armor Toughness Amplifier")
		@Config.Comment("Set the armor toughness amplifier for the base armor.")
		@Config.RangeInt(min = 0, max = 10)
		public double armorToughnessAmplifier = 0.5;
		
		@Config.Name("Armor Durability")
		@Config.Comment("Set the durability for the base armor.")
		@Config.RangeInt(min = 1, max = 9999)
		public int armorDurability = 200;
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class OedldoedlArmor
	{	
		@Config.Name("Enabled")
		@Config.Comment("Enable or Disable the oedldoedl armor.")
		public boolean enabled = true;
		
		@Config.Name("Helmet Gives Night Vision")
		@Config.Comment("Enable or Disable the night vision effect give by the oedldoedl helmet.")
		public boolean helmetGivesNightVision = true;
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class FlyingShootingArmor
	{	
		@Config.Name("Enabled")
		@Config.Comment("Enable or Disable the flying shooting armor.")
		public boolean enabled = true;
		
		@Config.Name("Helmet Gives Night Vision")
		@Config.Comment("Enable or Disable the night vision effect give by the flying shooting basecap.")
		public boolean helmetGivesNightVision = true;
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class Tools
	{	
		@Config.Name("Base")
		public BaseTools baseTools = new BaseTools();
		
		@Config.Name("Oedldoedl")
		public OedldoedlTools oedldoedlTools = new OedldoedlTools();
		
		@Config.Name("Explosion Staff")
		public ExplosionStaff explosionStaff = new ExplosionStaff();
		
		@Config.Name("Smashbats")
		@Config.Comment("Enable or Disable all smashbats.")
		public boolean smshbats = true;
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class ExplosionStaff
	{	
		@Config.Name("Enabled")
		@Config.Comment("Enable or Disable the base tools.")
		public boolean enabled = true;
		
		@Config.Name("Tool Durability")
		@Config.Comment("Set the durability for the base tools.")
		@Config.RangeInt(min = 1, max = 50)
		public int explosionStrength = 15;
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class BaseTools
	{	
		@Config.Name("Enabled")
		@Config.Comment("Enable or Disable the base tools.")
		public boolean enabled = true;
		
		@Config.Name("Tool Durability")
		@Config.Comment("Set the durability for the base tools.")
		@Config.RangeInt(min = 1, max = 9999)
		public int toolDurability = 200;
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class OedldoedlTools
	{	
		@Config.Name("Enabled")
		@Config.Comment("Enable or Disable the oedldoedl tools.")
		public boolean enabled = true;
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class Baubles
	{	
		@Config.Name("Bauble Render")
		@Config.Comment("Enable or Disable the rendering of baubles when worn by a player.")
		public boolean baubleRender = true;
		
		@Config.Name("Bauble Slot Any")
		@Config.Comment("Enable or Disable the ability to put baubles in any slot.")
		public boolean baubleSlotAny = false;
		
		@Config.Name("Argentorium Amulet")
		@Config.Comment("Enable or Disable the argentorium amulet.")
		public boolean argentoriumAmulet = true;
		
		@Config.Name("Quartarium Amulet")
		@Config.Comment("Enable or Disable the quartarium amulet.")
		public boolean quartariumAmulet = true;
		
		@Config.Name("Bedrockium Ring")
		@Config.Comment("Enable or Disable the bedrockium ring.")
		public boolean bedrockiumRing = true;
		
		@Config.Name("Oedldoedl Ring")
		@Config.Comment("Enable or Disable the oedldoedl ring.")
		public boolean oedldoedlRing = true;
		
		@Config.Name("Bauble Accessoires")
		@Config.Comment("Enable or Disable bauble accessoires.")
		public boolean baubleAccessoires = true;
		
		@Config.Name("HimejimariumAmulet")
		public HimejimariumAmulet himejimariumAmulet = new HimejimariumAmulet();
		
		@Config.Name("GremoriumAmulet")
		public GremoriumAmulet gremoriumAmulet = new GremoriumAmulet();
		
		@Config.Name("ToujouriumAmulet")
		public ToujouriumAmulet toujouriumAmulet = new ToujouriumAmulet();
		
		@Config.Name("Minepods")
		public Minepods minepods = new Minepods();
		
		@Config.Name("MinepodsPro")
		public MinepodsPro minepodsPro = new MinepodsPro();

	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class GremoriumAmulet
	{	
		@Config.Name("Enabled")
		@Config.Comment("Enable or Disable the gremorium amulet.")
		public boolean enabled = true;
		
		@Config.Name("Effects")
		@Config.Comment("Enable or Disable all effects from the gremorium amulet.")
		public boolean effectsEnabled = true;
		
		@Config.Name("Abilities")
		@Config.Comment("Enable or Disable all abilities given by the gremorium amulet.")
		public boolean abilities = true;
	}

	//----------------------------------------------------------------------------------------------------------------
	
	public static class HimejimariumAmulet
	{	
		@Config.Name("Enabled")
		@Config.Comment("Enable or Disable the himejimarium amulet.")
		public boolean enabled = true;
		
		@Config.Name("Effects")
		@Config.Comment("Enable or Disable all effects from the himejimarium amulet.")
		public boolean effectsEnabled = true;
		
		@Config.Name("Abilities")
		@Config.Comment("Enable or Disable all abilities given by the himejimarium amulet.")
		public boolean abilities = true;
		
		@Config.Name("Resistance Effect Amplifier")
		@Config.Comment("Set the amplifier of the resistance effect given by the himejimarium amulet.")
		@Config.RangeInt(min = 1, max = 255)
		public int resistanceAmplifier = 2;
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class ToujouriumAmulet
	{	
		@Config.Name("Enabled")
		@Config.Comment("Enable or Disable the toujourium amulet.")
		public boolean enabled = true;
		
		@Config.Name("Effects")
		@Config.Comment("Enable or Disable all effects from the toujourium amulet.")
		public boolean effectsEnabled = true;
		
		@Config.Name("Abilities")
		@Config.Comment("Enable or Disable all abilities given by the toujourium amulet.")
		public boolean abilities = true;
		
		@Config.Name("Jump Boost Effect Amplifier")
		@Config.Comment("Set the amplifier of the jump boost effect given by the toujourium amulet.")
		@Config.RangeInt(min = 1, max = 255)
		public int jumpboostAmplifier = 3;
		
		@Config.Name("Speed Effect Amplifier")
		@Config.Comment("Set the amplifier of the speed effect given by the toujourium amulet.")
		@Config.RangeInt(min = 1, max = 255)
		public int speedAmplifier = 4;
	}

	//----------------------------------------------------------------------------------------------------------------
	
	public static class Minepods
	{	
		@Config.Name("Enabled")
		@Config.Comment("Enable or Disable the minepods.")
		public boolean enabled = true;
		
		@Config.Name("Effects")
		@Config.Comment("Enable or Disable all effects from the minepods.")
		public boolean effectsEnabled = true;
		
		@Config.Name("Speed Effect Amplifier")
		@Config.Comment("Set the amplifier of the speed effect given by the minepods.")
		@Config.RangeInt(min = 1, max = 255)
		public int speedAmplifier = 2;
	}

	//----------------------------------------------------------------------------------------------------------------
	
	public static class MinepodsPro
	{	
		@Config.Name("Enabled")
		@Config.Comment("Enable or Disable the minepods pro.")
		public boolean enabled = true;
		
		@Config.Name("Effects")
		@Config.Comment("Enable or Disable all effects from the minepods pro.")
		public boolean effectsEnabled = true;
		
		@Config.Name("Speed Effect Amplifier")
		@Config.Comment("Set the amplifier of the speed effect given by the minepods pro.")
		@Config.RangeInt(min = 1, max = 255)
		public int speedAmplifier = 3;
		
		@Config.Name("Jump Boost Effect Amplifier")
		@Config.Comment("Set the amplifier of the jump boost effect given by the minepods pro.")
		@Config.RangeInt(min = 1, max = 255)
		public int jumpboostAmplifier = 1;
	}
		
	//----------------------------------------------------------------------------------------------------------------
	
	public static class Recipes
	{
		@Config.Name("Crafting")
		public Crafting crafting = new Crafting();
		
		@Config.Name("Smelting")
		public Smelting smelting = new Smelting();
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class Crafting
	{	
		//wip
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public static class Smelting
	{	
		//wip
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	@Config.Name("Integration")
	public static final Integration INTEGRATION = new Integration();
	
	public static class Integration
	{	
		//wip
	}
	
	//----------------------------------------------------------------------------------------------------------------

    @Mod.EventBusSubscriber
    public static class ConfigHolder 
    {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) 
        {
            if (event.getModID().equals(ReferenceGear.MODID)) 
            {
                ConfigManager.sync(ReferenceGear.MODID, Config.Type.INSTANCE);
            }
        }
    }
}