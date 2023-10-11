package net.thep2wking.oedldoedlgear.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelWizardHat extends ModelBiped {
	public final ResourceLocation texture;

	public ModelWizardHat(float modelSize, ResourceLocation texture) {
		super(modelSize, 0, 128, 128);
		this.texture = texture;

		ModelRenderer main_hat = new ModelRenderer(this);
		bipedHead.addChild(main_hat);
		main_hat.setRotationPoint(0, 24, 0);
		main_hat.setTextureOffset(80, 0).addBox(-6, -32.55F, -6, 12, 1, 12, false);

		ModelRenderer cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0, 0, 0);
		main_hat.addChild(cube_r1);
		setRotateAngle(cube_r1, -0.5672F, 0.1309F, 0.4363F);
		cube_r1.setTextureOffset(80, 0).addBox(-17, -34, -21.4F, 2, 4, 2, false);

		ModelRenderer cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0, 0, 0);
		main_hat.addChild(cube_r2);
		setRotateAngle(cube_r2, -0.3054F, 0.0873F, 0.2618F);
		cube_r2.setTextureOffset(104, 13).addBox(-11.3F, -37.5F, -13.2F, 4, 4, 4, false);

		ModelRenderer cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0, 0, 0);
		main_hat.addChild(cube_r3);
		setRotateAngle(cube_r3, -0.1745F, 0.0436F, 0.1309F);
		cube_r3.setTextureOffset(80, 24).addBox(-7.5F, -36.5F, -9, 6, 3, 6, false);

		ModelRenderer cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0, 0, 0);
		main_hat.addChild(cube_r4);
		setRotateAngle(cube_r4, -0.0436F, 0.0436F, 0.0436F);
		cube_r4.setTextureOffset(80, 13).addBox(-5.5F, -35, -5.5F, 8, 3, 8, false);
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