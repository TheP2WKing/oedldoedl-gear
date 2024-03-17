package net.thep2wking.oedldoedlgear.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelCrocs extends ModelBiped {
	public final ResourceLocation texture;

	public ModelCrocs(float modelSize, ResourceLocation texture) {
		super(modelSize, 0, 128, 128);
		this.texture = texture;

		ModelRenderer left = new ModelRenderer(this);
		bipedLeftLeg.addChild(left);
		left.setRotationPoint(2f, 12, 0);
		left.setTextureOffset(96, 9).addBox(-4, -3, -4, 4, 3, 6, 0.001F);
		left.setTextureOffset(112, 14).addBox(-4, -5, -2, 4, 3, 4, 0.25F);

		ModelRenderer right = new ModelRenderer(this);
		bipedRightLeg.addChild(right);
		right.setRotationPoint(-2f, 12, 0);
		right.setTextureOffset(96, 0).addBox(0, -3, -4, 4, 3, 6, 0.001F);
		right.setTextureOffset(112, 5).addBox(0, -5, -2, 4, 3, 4, 0.25F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scale) {
		Minecraft.getMinecraft().getRenderManager().renderEngine.bindTexture(texture);
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}