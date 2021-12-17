package com.thep2wking.oedldoedl.gear.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModelCatEars extends ModelBiped
{
    public ModelRenderer RightHeadSupport1;
    public ModelRenderer RightHeadSupport2;
    public ModelRenderer LeftHeadSupport1;
    public ModelRenderer LeftHeadSupport2;
    public ModelRenderer RightEarHead1;
    public ModelRenderer RightEarHead2;
    public ModelRenderer RightEarHead3;
    public ModelRenderer RightEarHead4;
    public ModelRenderer RightEarHead5;
    public ModelRenderer RightEarHead6;
    public ModelRenderer RightEarHead7;
    public ModelRenderer RightEarHead8;
    public ModelRenderer LeftEarHead1;
    public ModelRenderer LeftEarHead2;
    public ModelRenderer LeftEarHead3;
    public ModelRenderer LeftEarHead4;
    public ModelRenderer LeftEarHead5;
    public ModelRenderer LeftEarHead6;
    public ModelRenderer LeftEarHead7;
    public ModelRenderer LeftEarHead8;

    public ModelCatEars() 
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        
        this.RightEarHead5 = new ModelRenderer(this, 90, 50);
        this.RightEarHead5.setRotationPoint(2.0F, -12.0F, -1.0F);
        this.RightEarHead5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftEarHead5 = new ModelRenderer(this, 110, 50);
        this.LeftEarHead5.setRotationPoint(-6.0F, -10.0F, -1.0F);
        this.LeftEarHead5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.RightEarHead2 = new ModelRenderer(this, 90, 20);
        this.RightEarHead2.setRotationPoint(4.0F, -12.0F, -1.0F);
        this.RightEarHead2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.LeftEarHead7 = new ModelRenderer(this, 110, 70);
        this.LeftEarHead7.setRotationPoint(-4.0F, -12.0F, 0.0F);
        this.LeftEarHead7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftEarHead2 = new ModelRenderer(this, 110, 20);
        this.LeftEarHead2.setRotationPoint(-3.0F, -12.0F, -1.0F);
        this.LeftEarHead2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftHeadSupport2 = new ModelRenderer(this, 60, 40);
        this.LeftHeadSupport2.setRotationPoint(-5.0F, -9.0F, -1.0F);
        this.LeftHeadSupport2.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
        this.LeftHeadSupport1 = new ModelRenderer(this, 60, 30);
        this.LeftHeadSupport1.setRotationPoint(-5.0F, -8.0F, -1.0F);
        this.LeftHeadSupport1.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.LeftEarHead3 = new ModelRenderer(this, 110, 30);
        this.LeftEarHead3.setRotationPoint(-4.0F, -13.0F, -1.0F);
        this.LeftEarHead3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftEarHead6 = new ModelRenderer(this, 110, 60);
        this.LeftEarHead6.setRotationPoint(-4.0F, -11.0F, 0.0F);
        this.LeftEarHead6.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.RightEarHead4 = new ModelRenderer(this, 90, 40);
        this.RightEarHead4.setRotationPoint(3.0F, -12.0F, 0.0F);
        this.RightEarHead4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftEarHead8 = new ModelRenderer(this, 110, 80);
        this.LeftEarHead8.setRotationPoint(-5.0F, -10.0F, 0.0F);
        this.LeftEarHead8.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftEarHead1 = new ModelRenderer(this, 110, 10);
        this.LeftEarHead1.setRotationPoint(-2.0F, -11.0F, -1.0F);
        this.LeftEarHead1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.RightHeadSupport1 = new ModelRenderer(this, 60, 10);
        this.RightHeadSupport1.setRotationPoint(2.0F, -9.0F, -1.0F);
        this.RightHeadSupport1.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
        this.RightEarHead8 = new ModelRenderer(this, 90, 80);
        this.RightEarHead8.setRotationPoint(4.0F, -10.0F, 0.0F);
        this.RightEarHead8.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.RightEarHead7 = new ModelRenderer(this, 90, 70);
        this.RightEarHead7.setRotationPoint(5.0F, -10.0F, -1.0F);
        this.RightEarHead7.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.LeftEarHead4 = new ModelRenderer(this, 110, 40);
        this.LeftEarHead4.setRotationPoint(-5.0F, -12.0F, -1.0F);
        this.LeftEarHead4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.RightEarHead1 = new ModelRenderer(this, 90, 10);
        this.RightEarHead1.setRotationPoint(1.0F, -11.0F, -1.0F);
        this.RightEarHead1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.RightEarHead3 = new ModelRenderer(this, 90, 30);
        this.RightEarHead3.setRotationPoint(2.0F, -11.0F, 0.0F);
        this.RightEarHead3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.RightHeadSupport2 = new ModelRenderer(this, 60, 20);
        this.RightHeadSupport2.setRotationPoint(2.0F, -8.0F, -1.0F);
        this.RightHeadSupport2.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.RightEarHead6 = new ModelRenderer(this, 90, 60);
        this.RightEarHead6.setRotationPoint(3.0F, -13.0F, -1.0F);
        this.RightEarHead6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        
        this.bipedHeadwear = new ModelRenderer(this, 0, 0);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        
        this.bipedHead.addChild(RightHeadSupport1);
        this.bipedHead.addChild(RightHeadSupport2);
        
        this.bipedHead.addChild(LeftHeadSupport1);
        this.bipedHead.addChild(LeftHeadSupport2);
        
        this.bipedHead.addChild(RightEarHead1);
        this.bipedHead.addChild(RightEarHead2);
        this.bipedHead.addChild(RightEarHead3);
        this.bipedHead.addChild(RightEarHead4);
        this.bipedHead.addChild(RightEarHead5);
        this.bipedHead.addChild(RightEarHead6);
        this.bipedHead.addChild(RightEarHead7);
        this.bipedHead.addChild(RightEarHead8);
        
        this.bipedHead.addChild(LeftEarHead1);
        this.bipedHead.addChild(LeftEarHead2);
        this.bipedHead.addChild(LeftEarHead3);
        this.bipedHead.addChild(LeftEarHead4);
        this.bipedHead.addChild(LeftEarHead5);
        this.bipedHead.addChild(LeftEarHead6);
        this.bipedHead.addChild(LeftEarHead7);
        this.bipedHead.addChild(LeftEarHead8);
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