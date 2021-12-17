package com.thep2wking.oedldoedl.gear.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModelMinepods extends ModelBiped
{
    public ModelRenderer minepodsLeft1;
    public ModelRenderer minepodsLeft2;
    public ModelRenderer minepodsRight1;
    public ModelRenderer minepodsRight2;

    public ModelMinepods() 
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        
        this.minepodsLeft2 = new ModelRenderer(this, 60, 20);
        this.minepodsLeft2.setRotationPoint(-4.25F, -5.25F, -1.5F);
        this.minepodsLeft2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.minepodsRight1 = new ModelRenderer(this, 60, 30);
        this.minepodsRight1.setRotationPoint(3.4F, -5.5F, -0.5F);
        this.minepodsRight1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.minepodsRight2 = new ModelRenderer(this, 60, 40);
        this.minepodsRight2.setRotationPoint(3.25F, -5.25F, -1.5F);
        this.minepodsRight2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.minepodsLeft1 = new ModelRenderer(this, 60, 10);
        this.minepodsLeft1.setRotationPoint(-4.4F, -5.5F, -0.5F);
        this.minepodsLeft1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        
        this.bipedHeadwear = new ModelRenderer(this, 0, 0);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        
        this.bipedHead.addChild(minepodsLeft1);
        this.bipedHead.addChild(minepodsLeft2);
        this.bipedHead.addChild(minepodsRight1);
        this.bipedHead.addChild(minepodsRight2);
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