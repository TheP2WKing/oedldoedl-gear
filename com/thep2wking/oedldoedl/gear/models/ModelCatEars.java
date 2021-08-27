package com.thep2wking.oedldoedl.gear.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

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
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        
        this.RightEarHead5 = new ModelRenderer(this, 90, 50);
        this.RightEarHead5.func_78793_a(2.0F, -12.0F, -1.0F);
        this.RightEarHead5.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftEarHead5 = new ModelRenderer(this, 110, 50);
        this.LeftEarHead5.func_78793_a(-6.0F, -10.0F, -1.0F);
        this.LeftEarHead5.func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.RightEarHead2 = new ModelRenderer(this, 90, 20);
        this.RightEarHead2.func_78793_a(4.0F, -12.0F, -1.0F);
        this.RightEarHead2.func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.LeftEarHead7 = new ModelRenderer(this, 110, 70);
        this.LeftEarHead7.func_78793_a(-4.0F, -12.0F, 0.0F);
        this.LeftEarHead7.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftEarHead2 = new ModelRenderer(this, 110, 20);
        this.LeftEarHead2.func_78793_a(-3.0F, -12.0F, -1.0F);
        this.LeftEarHead2.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftHeadSupport2 = new ModelRenderer(this, 60, 40);
        this.LeftHeadSupport2.func_78793_a(-5.0F, -9.0F, -1.0F);
        this.LeftHeadSupport2.func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
        this.LeftHeadSupport1 = new ModelRenderer(this, 60, 30);
        this.LeftHeadSupport1.func_78793_a(-5.0F, -8.0F, -1.0F);
        this.LeftHeadSupport1.func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.LeftEarHead3 = new ModelRenderer(this, 110, 30);
        this.LeftEarHead3.func_78793_a(-4.0F, -13.0F, -1.0F);
        this.LeftEarHead3.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftEarHead6 = new ModelRenderer(this, 110, 60);
        this.LeftEarHead6.func_78793_a(-4.0F, -11.0F, 0.0F);
        this.LeftEarHead6.func_78790_a(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.RightEarHead4 = new ModelRenderer(this, 90, 40);
        this.RightEarHead4.func_78793_a(3.0F, -12.0F, 0.0F);
        this.RightEarHead4.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftEarHead8 = new ModelRenderer(this, 110, 80);
        this.LeftEarHead8.func_78793_a(-5.0F, -10.0F, 0.0F);
        this.LeftEarHead8.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LeftEarHead1 = new ModelRenderer(this, 110, 10);
        this.LeftEarHead1.func_78793_a(-2.0F, -11.0F, -1.0F);
        this.LeftEarHead1.func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.RightHeadSupport1 = new ModelRenderer(this, 60, 10);
        this.RightHeadSupport1.func_78793_a(2.0F, -9.0F, -1.0F);
        this.RightHeadSupport1.func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
        this.RightEarHead8 = new ModelRenderer(this, 90, 80);
        this.RightEarHead8.func_78793_a(4.0F, -10.0F, 0.0F);
        this.RightEarHead8.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.RightEarHead7 = new ModelRenderer(this, 90, 70);
        this.RightEarHead7.func_78793_a(5.0F, -10.0F, -1.0F);
        this.RightEarHead7.func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.LeftEarHead4 = new ModelRenderer(this, 110, 40);
        this.LeftEarHead4.func_78793_a(-5.0F, -12.0F, -1.0F);
        this.LeftEarHead4.func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.RightEarHead1 = new ModelRenderer(this, 90, 10);
        this.RightEarHead1.func_78793_a(1.0F, -11.0F, -1.0F);
        this.RightEarHead1.func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.RightEarHead3 = new ModelRenderer(this, 90, 30);
        this.RightEarHead3.func_78793_a(2.0F, -11.0F, 0.0F);
        this.RightEarHead3.func_78790_a(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.RightHeadSupport2 = new ModelRenderer(this, 60, 20);
        this.RightHeadSupport2.func_78793_a(2.0F, -8.0F, -1.0F);
        this.RightHeadSupport2.func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.RightEarHead6 = new ModelRenderer(this, 90, 60);
        this.RightEarHead6.func_78793_a(3.0F, -13.0F, -1.0F);
        this.RightEarHead6.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        
        this.field_178720_f = new ModelRenderer(this, 0, 0);
        this.field_78116_c = new ModelRenderer(this, 0, 0);
        
        this.field_78116_c.func_78792_a(RightHeadSupport1);
        this.field_78116_c.func_78792_a(RightHeadSupport2);
        
        this.field_78116_c.func_78792_a(LeftHeadSupport1);
        this.field_78116_c.func_78792_a(LeftHeadSupport2);
        
        this.field_78116_c.func_78792_a(RightEarHead1);
        this.field_78116_c.func_78792_a(RightEarHead2);
        this.field_78116_c.func_78792_a(RightEarHead3);
        this.field_78116_c.func_78792_a(RightEarHead4);
        this.field_78116_c.func_78792_a(RightEarHead5);
        this.field_78116_c.func_78792_a(RightEarHead6);
        this.field_78116_c.func_78792_a(RightEarHead7);
        this.field_78116_c.func_78792_a(RightEarHead8);
        
        this.field_78116_c.func_78792_a(LeftEarHead1);
        this.field_78116_c.func_78792_a(LeftEarHead2);
        this.field_78116_c.func_78792_a(LeftEarHead3);
        this.field_78116_c.func_78792_a(LeftEarHead4);
        this.field_78116_c.func_78792_a(LeftEarHead5);
        this.field_78116_c.func_78792_a(LeftEarHead6);
        this.field_78116_c.func_78792_a(LeftEarHead7);
        this.field_78116_c.func_78792_a(LeftEarHead8);
    }

	@Override
	public void func_78088_a(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) 
	{
		super.func_78088_a(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}
	
	private void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.field_78795_f = x;
		modelRenderer.field_78796_g = y;
		modelRenderer.field_78808_h = z;
	}
}