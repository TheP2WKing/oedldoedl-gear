package com.thep2wking.oedldoedl.gear.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModelMinepodsPro extends ModelBiped
{
    public ModelRenderer minepodsProLeft1;
    public ModelRenderer minepodsProLeft2;
    public ModelRenderer minepodsProRight1;
    public ModelRenderer minepodsProRight2;

    public ModelMinepodsPro() 
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        
        this.minepodsProRight2 = new ModelRenderer(this, 60, 40);
        this.minepodsProRight2.setRotationPoint(3.25F, -5.25F, -1.5F);
        this.minepodsProRight2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.minepodsProLeft1 = new ModelRenderer(this, 60, 10);
        this.minepodsProLeft1.setRotationPoint(-4.4F, -5.5F, -0.5F);
        this.minepodsProLeft1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.minepodsProRight1 = new ModelRenderer(this, 60, 30);
        this.minepodsProRight1.setRotationPoint(3.4F, -5.5F, -0.5F);
        this.minepodsProRight1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.minepodsProLeft2 = new ModelRenderer(this, 60, 20);
        this.minepodsProLeft2.setRotationPoint(-4.25F, -5.25F, -1.5F);
        this.minepodsProLeft2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        
        this.bipedHeadwear = new ModelRenderer(this, 0, 0);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        
        this.bipedHead.addChild(minepodsProLeft1);
        this.bipedHead.addChild(minepodsProLeft2);
        this.bipedHead.addChild(minepodsProRight1);
        this.bipedHead.addChild(minepodsProRight2);
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