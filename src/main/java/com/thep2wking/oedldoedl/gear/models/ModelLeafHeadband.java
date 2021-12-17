package com.thep2wking.oedldoedl.gear.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModelLeafHeadband extends ModelBiped 
{
    public ModelRenderer bandFront;
    public ModelRenderer bandBack;
    public ModelRenderer bandRight;
    public ModelRenderer bandLeft;
    public ModelRenderer band1;
    public ModelRenderer band2;
    public ModelRenderer band3;
    public ModelRenderer band4;
    public ModelRenderer band5;
    public ModelRenderer band6;
    public ModelRenderer band7;

    public ModelLeafHeadband() 
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        
        this.bandFront = new ModelRenderer(this, 60, 10);
        this.bandFront.setRotationPoint(-4.0F, -6.5F, -4.5F);
        this.bandFront.addBox(0.0F, 0.0F, 0.0F, 8, 2, 1, 0.0F);
        this.bandLeft = new ModelRenderer(this, 60, 50);
        this.bandLeft.setRotationPoint(-4.5F, -6.5F, -4.0F);
        this.bandLeft.addBox(0.0F, 0.0F, 0.0F, 1, 2, 8, 0.0F);
        this.band3 = new ModelRenderer(this, 80, 30);
        this.band3.setRotationPoint(-1.8F, -3.5F, 3.5F);
        this.band3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.band5 = new ModelRenderer(this, 80, 50);
        this.band5.setRotationPoint(1.3F, -2.5F, 3.5F);
        this.band5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.band1 = new ModelRenderer(this, 80, 10);
        this.band1.setRotationPoint(0.3F, -4.5F, 3.5F);
        this.band1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.band2 = new ModelRenderer(this, 80, 20);
        this.band2.setRotationPoint(-1.3F, -4.5F, 3.5F);
        this.band2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.bandBack = new ModelRenderer(this, 60, 20);
        this.bandBack.setRotationPoint(-4.0F, -6.5F, 3.5F);
        this.bandBack.addBox(0.0F, 0.0F, 0.0F, 8, 2, 1, 0.0F);
        this.band4 = new ModelRenderer(this, 80, 40);
        this.band4.setRotationPoint(0.8F, -3.5F, 3.5F);
        this.band4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.band6 = new ModelRenderer(this, 80, 60);
        this.band6.setRotationPoint(1.8F, -0.5F, 3.5F);
        this.band6.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.bandRight = new ModelRenderer(this, 60, 30);
        this.bandRight.setRotationPoint(3.5F, -6.5F, -4.0F);
        this.bandRight.addBox(0.0F, 0.0F, 0.0F, 1, 2, 8, 0.0F);
        this.band7 = new ModelRenderer(this, 80, 70);
        this.band7.setRotationPoint(-2.3F, -1.5F, 3.5F);
        this.band7.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
         
        this.bipedHeadwear = new ModelRenderer(this, 0, 0);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        
        this.bipedHead.addChild(bandFront);
        this.bipedHead.addChild(bandBack);
        this.bipedHead.addChild(bandRight);
        this.bipedHead.addChild(bandLeft);
        
        this.bipedHead.addChild(band1);
        this.bipedHead.addChild(band2);
        this.bipedHead.addChild(band3);
        this.bipedHead.addChild(band4);
        this.bipedHead.addChild(band5);
        this.bipedHead.addChild(band6);
        this.bipedHead.addChild(band7);
    }

	@Override
	@SideOnly(Side.CLIENT)
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) 
	{
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}
	
	private void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}