package net.thep2wking.oedldoedlgear.config.conditions;

import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.thep2wking.oedldoedlgear.OedldoedlGear;
import net.thep2wking.oedldoedlgear.config.GearConfig;

public class EnableModRecipes implements ICondition
{ 
	private static final ResourceLocation ID = new ResourceLocation(OedldoedlGear.MODID, "enable_mod_recipes");

	@Override
	public ResourceLocation getID() 
	{
		return ID;
	}

	@Override
	public boolean test() 
	{
		return GearConfig.enable_mod_recipes.get();
	}

	public static class Serializer implements IConditionSerializer<EnableModRecipes> 
	{
		public static final EnableModRecipes.Serializer INSTANCE = new EnableModRecipes.Serializer();

		public void write(JsonObject json, EnableModRecipes value) 
		{

		}

		public EnableModRecipes read(JsonObject json) 
		{
			return new EnableModRecipes();
		}

		public ResourceLocation getID() 
		{
			return EnableModRecipes.ID;
		}
	}
}