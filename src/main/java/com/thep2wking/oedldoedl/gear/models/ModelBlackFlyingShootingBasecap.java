package com.thep2wking.oedldoedl.gear.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;

public class ModelBlackFlyingShootingBasecap extends ModelBiped
{
    public ModelRenderer capWallLeft;
    public ModelRenderer capWallRight;
    public ModelRenderer capWallBack1;
    public ModelRenderer capWallBack2;
    public ModelRenderer capWallBack3;
    public ModelRenderer capWallBack4;
    public ModelRenderer capWallFrontBase;
    
    public ModelRenderer capHatBase1;
    public ModelRenderer capHatBase2;
    public ModelRenderer capHatBase3;
    
    public ModelRenderer capHatFront1;
    public ModelRenderer capHatFront2;
    public ModelRenderer capHatFront3;
    public ModelRenderer capHatFront4;
    public ModelRenderer capHatFront5;
    public ModelRenderer capHatFront6;
    public ModelRenderer capHatFront7;
    public ModelRenderer capHatFront8;
    public ModelRenderer capHatFront9;
    public ModelRenderer capHatFront10;
    public ModelRenderer capHatFront11;
    public ModelRenderer capHatFront12;
    public ModelRenderer capHatFront13;
    public ModelRenderer capHatFront14;
    public ModelRenderer capHatFront15;

    public ModelBlackFlyingShootingBasecap() 
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        
        this.capHatFront2 = new ModelRenderer(this, 80, 20);
        this.capHatFront2.setRotationPoint(-2.5F, -6.0F, -9.5F);
        this.capHatFront2.addBox(0.0F, 0.0F, 0.0F, 5, 1, 2, 0.0F);
        this.capHatFront9 = new ModelRenderer(this, 80, 90);
        this.capHatFront9.setRotationPoint(2.5F, -5.0F, -9.0F);
        this.capHatFront9.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.capHatFront1 = new ModelRenderer(this, 80, 10);
        this.capHatFront1.setRotationPoint(-3.5F, -6.0F, -7.5F);
        this.capHatFront1.addBox(0.0F, 0.0F, 0.0F, 7, 1, 4, 0.0F);
        this.capHatFront13 = new ModelRenderer(this, 110, 30);
        this.capHatFront13.setRotationPoint(-2.0F, -6.5F, -7.5F);
        this.capHatFront13.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.capWallBack4 = new ModelRenderer(this, 40, 80);
        this.capWallBack4.setRotationPoint(-2.0F, -4.5F, 3.5F);
        this.capWallBack4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.capWallRight = new ModelRenderer(this, 40, 30);
        this.capWallRight.setRotationPoint(3.5F, -8.0F, -4.0F);
        this.capWallRight.addBox(0.0F, 0.0F, 0.0F, 1, 4, 8, 0.0F);
        this.capWallBack2 = new ModelRenderer(this, 40, 60);
        this.capWallBack2.setRotationPoint(2.0F, -8.0F, 3.5F);
        this.capWallBack2.addBox(0.0F, 0.0F, 0.0F, 2, 4, 1, 0.0F);
        this.capHatFront5 = new ModelRenderer(this, 80, 50);
        this.capHatFront5.setRotationPoint(-4.0F, -5.0F, -7.5F);
        this.capHatFront5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.capHatFront10 = new ModelRenderer(this, 80, 100);
        this.capHatFront10.setRotationPoint(-3.5F, -5.0F, -9.0F);
        this.capHatFront10.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.capWallLeft = new ModelRenderer(this, 40, 10);
        this.capWallLeft.setRotationPoint(-4.5F, -8.0F, -4.0F);
        this.capWallLeft.addBox(0.0F, 0.0F, 0.0F, 1, 4, 8, 0.0F);
        this.capHatFront14 = new ModelRenderer(this, 110, 40);
        this.capHatFront14.setRotationPoint(1.0F, -6.5F, -7.5F);
        this.capHatFront14.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.capHatFront3 = new ModelRenderer(this, 80, 30);
        this.capHatFront3.setRotationPoint(-1.5F, -6.0F, -10.5F);
        this.capHatFront3.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.capHatBase3 = new ModelRenderer(this, 40, 120);
        this.capHatBase3.setRotationPoint(-0.5F, -9.5F, -0.5F);
        this.capHatBase3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.capHatFront11 = new ModelRenderer(this, 110, 10);
        this.capHatFront11.setRotationPoint(-2.5F, -7.0F, -6.5F);
        this.capHatFront11.addBox(0.0F, 0.0F, 0.0F, 5, 1, 2, 0.0F);
        this.capHatFront7 = new ModelRenderer(this, 80, 70);
        this.capHatFront7.setRotationPoint(1.0F, -5.0F, -10.0F);
        this.capHatFront7.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.capHatFront4 = new ModelRenderer(this, 80, 40);
        this.capHatFront4.setRotationPoint(-2.0F, -5.0F, -11.0F);
        this.capHatFront4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.capHatBase2 = new ModelRenderer(this, 40, 110);
        this.capHatBase2.setRotationPoint(-2.5F, -9.0F, -2.5F);
        this.capHatBase2.addBox(0.0F, 0.0F, 0.0F, 5, 1, 5, 0.0F);
        this.capHatFront8 = new ModelRenderer(this, 80, 80);
        this.capHatFront8.setRotationPoint(-3.0F, -5.0F, -10.0F);
        this.capHatFront8.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.capWallBack3 = new ModelRenderer(this, 40, 70);
        this.capWallBack3.setRotationPoint(-2.0F, -8.0F, 3.5F);
        this.capWallBack3.addBox(0.0F, 0.0F, 0.0F, 4, 3, 1, 0.0F);
        this.capWallFrontBase = new ModelRenderer(this, 40, 90);
        this.capWallFrontBase.setRotationPoint(-4.0F, -8.0F, -4.5F);
        this.capWallFrontBase.addBox(0.0F, 0.0F, 0.0F, 8, 3, 1, 0.0F);
        this.capWallBack1 = new ModelRenderer(this, 40, 50);
        this.capWallBack1.setRotationPoint(-4.0F, -8.0F, 3.5F);
        this.capWallBack1.addBox(0.0F, 0.0F, 0.0F, 2, 4, 1, 0.0F);
        this.capHatFront6 = new ModelRenderer(this, 80, 60);
        this.capHatFront6.setRotationPoint(3.0F, -5.0F, -7.5F);
        this.capHatFront6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.capHatFront15 = new ModelRenderer(this, 110, 50);
        this.capHatFront15.setRotationPoint(-1.5F, -7.5F, -5.5F);
        this.capHatFront15.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.capHatBase1 = new ModelRenderer(this, 40, 100);
        this.capHatBase1.setRotationPoint(-4.0F, -8.5F, -4.0F);
        this.capHatBase1.addBox(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F);
        this.capHatFront12 = new ModelRenderer(this, 110, 20);
        this.capHatFront12.setRotationPoint(-1.0F, -6.5F, -8.5F);
        this.capHatFront12.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        
        this.bipedHeadwear = new ModelRenderer(this, 0, 0);
        this.bipedHead = new ModelRenderer(this, 0, 0);
           
        this.bipedHead.addChild(capWallLeft);
        this.bipedHead.addChild(capWallRight);
        this.bipedHead.addChild(capWallBack1);
        this.bipedHead.addChild(capWallBack2);
        this.bipedHead.addChild(capWallBack3);
        this.bipedHead.addChild(capWallBack4);
        this.bipedHead.addChild(capWallFrontBase);
        
        this.bipedHead.addChild(capHatBase1);
        this.bipedHead.addChild(capHatBase2);
        this.bipedHead.addChild(capHatBase3);
        
        this.bipedHead.addChild(capHatFront1);
        this.bipedHead.addChild(capHatFront2);
        this.bipedHead.addChild(capHatFront3);
        this.bipedHead.addChild(capHatFront4);
        this.bipedHead.addChild(capHatFront5);
        this.bipedHead.addChild(capHatFront6);
        this.bipedHead.addChild(capHatFront7); 
        this.bipedHead.addChild(capHatFront8);
        this.bipedHead.addChild(capHatFront9);
        this.bipedHead.addChild(capHatFront10);
        this.bipedHead.addChild(capHatFront11);
        this.bipedHead.addChild(capHatFront12);
        this.bipedHead.addChild(capHatFront13);
        this.bipedHead.addChild(capHatFront14);
        this.bipedHead.addChild(capHatFront15);
    }

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) 
	{
		if (entityIn instanceof EntityArmorStand) 
			netHeadYaw = 0;
		
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, (float) 0.071); //size value wip (overlaps with 2nd layer of skin) 68
	}
	
	private void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}