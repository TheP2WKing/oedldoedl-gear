package net.thep2wking.oedldoedlgear.config.categories;

import net.minecraftforge.common.config.Config;


public class Content {
	@Config.Name("Chailmail Gives Paper And Notes")
	public boolean CHAINMAIL_GIVES_PAPER_AND_NOTES = true;

	@Config.Name("Chailmail Note Of Suffering Chance")
	@Config.RangeDouble(min = 0, max = 1)
	public double CHAINMAIL_NOTE_OF_SUFFERING_CHANCE = 0.05;

	@Config.Name("Wizard Hats Store Potions")
	public boolean WIZARED_HAT_STORE_POTIONS = true;

	@Config.Name("Gamemode Chestplate Switch Gamemodes")
	public boolean GAMEMODE_CHESTPLATE_SWITCH_GAMEMODES = true;

	@Config.Name("Dirt Armor Spawns Diamonds")
	public boolean DIRT_ARMOR_SPAWNS_DIAMONDS = true;

	@Config.Name("Pork Hammer Spawns Porkchop")
	public boolean PORK_HAMMER_SPAWNS_PORKCHOP = true;

	@Config.Name("Bref Power Cooldown")
	@Config.RangeInt(min = 0, max = 1000)
	public int BREF_POWER_COOLDOWN = 10;

	@Config.Name("Bref Power Sound")
	public boolean BREF_POWER_SOUND = true;

	@Config.Name("Fly Swatter Sound")
	public boolean FLY_SWATTER_SOUND = true;

	@Config.Name("jumppads")
	public final Jumppads JUMPPADS = new Jumppads();

	public static class Jumppads {
		@Config.Name("Jump Pad Motion")
		@Config.RangeDouble(min = 0, max = 8)
		public double JUMP_PAD_MOTION = 0.05;

		@Config.Name("Jump Pad+ Motion")
		@Config.RangeDouble(min = 0, max = 8)
		public double JUMP_PAD_PLUS_MOTION = 0.5;

		@Config.Name("Jump Pad++ Motion")
		@Config.RangeDouble(min = 0, max = 8)
		public double JUMP_PAD_PLUS_PLUS_MOTION = 0.9;

		@Config.Name("Jump Pad+++ Motion")
		@Config.RangeDouble(min = 0, max = 8)
		public double JUMP_PAD_PLUS_PLUS_PLUS_MOTION = 1.2;
	}

	@Config.Name("snowballs")
	public final Snowballs SNOWBALLS = new Snowballs();

	public static class Snowballs {
		@Config.Name("Rocky Snowball Damage")
		@Config.RangeInt(min = 0, max = 100)
		public int ROCKY_SNOWBALL_DAMAGE = 2;

		@Config.Name("Explosive Snowball Explosion Strength")
		@Config.RangeInt(min = 0, max = 16)
		public int EXPLOSIVE_SNOWBALL_EXPLOSION_STRENGTH = 1;

		@Config.Name("Explosive Snowball Explosion Damage")
		public boolean EXPLOSIVE_SNOWBALL_EXPLOSION_DAMAGE = true;

		@Config.Name("Explosive Snowball Explosion Fire")
		public boolean EXPLOSIVE_SNOWBALL_EXPLOSION_FIRE = false;

		@Config.Name("Charged Snowball Lightnings")
		public boolean CHARGED_SNOWBALL_LIGHTNINGS = true;
	}

	@Config.Name("admintools")
	public final Admintools ADMINTOOLS = new Admintools();

	public static class Admintools {
		@Config.Name("Enable Ban Hammer")
		public boolean ENABLE_BAN_HAMMER = true;

		@Config.Name("Enable Kick Stick")
		public boolean ENABLE_KICK_STICK = true;

		@Config.Name("Enable Admin Staff")
		public boolean ENABLE_ADMIN_STAFF = true;

		@Config.Name("Ban Message")
		public String BAN_MESSAGE = "You have been Banned!";

		@Config.Name("Kick Message")
		public String KICK_MESSAGE = "You have been Kicked!";
	}

	@Config.Name("bedrockbreaker")
	public final Bedrockbreaker BEDROCKBREAKER = new Bedrockbreaker();

	public static class Bedrockbreaker {
		@Config.Name("Bedrock Breaker Breaks Bedrock")
		public boolean BREAKS_BEDROCK = true;
	
		@Config.Name("Bedrock Breaker Debuffs")
		public boolean DEBUFFS = true;
	
		@Config.Name("Bedrock Breaker Cooldown")
		@Config.RangeInt(min = 0, max = 1000)
		public int COOLDOWN = 40;
	}

	@Config.Name("staffs")
	public final Staffs STAFFS = new Staffs();

	public static class Staffs {
		@Config.Name("Explosion Staff Range")
		@Config.RangeInt(min = 0, max = 100)
		public int EXPLOSION_STAFF_RANGE = 40;
	
		@Config.Name("Explosion Staff Explosion Strength")
		@Config.RangeInt(min = 0, max = 50)
		public int EXPLOSION_STAFF_EXPLOSION_STRENGTH = 15;

		@Config.Name("Explosion Staff Explosion Damage")
		public boolean EXPLOSION_STAFF_EXPLOSION_DAMAGE = true;

		@Config.Name("Explosion Staff Explosion Fire")
		public boolean EXPLOSION_STAFF_EXPLOSION_FIRE = false;

		@Config.Name("Explosion Staff Spawns Lightning")
		public boolean EXPLOSION_STAFF_SPAWNS_LIGHTNING = true;

		@Config.Name("Explosion Staff Sound")
		public boolean EXPLOSION_STAFF_SOUND = true;

		@Config.Name("Explosion Staff Cooldown")
		@Config.RangeInt(min = 0, max = 1000)
		public int EXPLOSION_STAFF_COOLDOWN = 100;

		@Config.Name("Explosion Staff Debuffs")
		public boolean EXPLOSION_STAFF_DEBUFFS = true;

		@Config.Name("Lighning Staff Range")
		@Config.RangeInt(min = 0, max = 100)
		public int LIGHTNING_STAFF_RANGE = 60;

		@Config.Name("Lighning Staff Cooldown")
		@Config.RangeInt(min = 0, max = 1000)
		public int LIGHTNING_STAFF_COOLDOWN = 60;

		@Config.Name("Frieren Staff Range")
		@Config.RangeInt(min = 0, max = 100)
		public int FRIEREN_STAFF_RANGE = 50;

		@Config.Name("Frieren Staff Cooldown")
		@Config.RangeInt(min = 0, max = 1000)
		public int FRIEREN_STAFF_COOLDOWN = 20;
	}

	@Config.Name("smashbats")
	public final Smashbats SMASHBATS = new Smashbats();

	public static class Smashbats {
		@Config.Name("Launching Smashbat Explosion Strength")
		@Config.RangeInt(min = 0, max = 50)
		public int LAUNCHING_SMASHBAT_EXPLOSION_STRENGTH = 2;

		@Config.Name("Launching Smashbat Explosion Damage")
		public boolean LAUNCHING_SMASHBAT_EXPLOSION_DAMAGE = false;

		@Config.Name("Launching Smashbat Explosion Fire")
		public boolean LAUNCHING_SMASHBAT_EXPLOSION_FIRE = false;

		@Config.Name("Blasting Smashbat Explosion Strength")
		@Config.RangeInt(min = 0, max = 50)
		public int BLASTING_SMASHBAT_EXPLOSION_STRENGTH = 1;

		@Config.Name("Blasting Smashbat Explosion Damage")
		public boolean BLASTING_SMASHBAT_EXPLOSION_DAMAGE = false;

		@Config.Name("Blasting Smashbat Explosion Fire")
		public boolean BLASTING_SMASHBAT_EXPLOSION_FIRE = false;
	}
}