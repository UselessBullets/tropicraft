package cookie.tropicraft.entity.render;

import net.minecraft.core.util.helper.MathHelper;
import useless.dragonfly.model.entity.BenchEntityModel;

public class ModelVervet extends BenchEntityModel {

	@Override
	public void setRotationAngles(float limbSwing, float limbYaw, float ticksExisted, float headYaw, float headPitch, float scale) {
		super.setRotationAngles(limbSwing, limbYaw, ticksExisted, headYaw, headPitch, scale);
		if (getIndexBones().containsKey("face"))
			getIndexBones().get("face").setRotationAngle((float) Math.toRadians(headPitch), (float) Math.toRadians(headYaw), 0.0F);
		if (getIndexBones().containsKey("head"))
			getIndexBones().get("head").setRotationAngle((float) Math.toRadians(headPitch), (float) Math.toRadians(headYaw), 0.0F);

		if (getIndexBones().containsKey("body"))
			getIndexBones().get("body").setRotationAngle(0.0F, 0.0F, 0.0F);

		if (getIndexBones().containsKey("legLeftFront"))
			this.getIndexBones().get("legLeftFront").setRotationAngle(MathHelper.cos(limbSwing * 0.0055F) * 2.0F * limbYaw, 0.0F, 0.0F);
		if (getIndexBones().containsKey("legRightBack"))
			this.getIndexBones().get("legRightBack").setRotationAngle(MathHelper.cos(limbSwing * 0.0055F) * 2.0F * limbYaw, 0.0F, 0.0F);
		if (getIndexBones().containsKey("legRightBack"))
			this.getIndexBones().get("legRightBack").setRotationAngle(MathHelper.cos(limbSwing * 0.0055F + (float) Math.PI) * 1.4F * limbYaw, 0.0F, 0.0F);
		if (getIndexBones().containsKey("legLeftBack"))
			this.getIndexBones().get("legLeftBack").setRotationAngle(MathHelper.cos(limbSwing * 0.0055F + (float) Math.PI) * 1.4F * limbYaw, 0.0F, 0.0F);

		if (getIndexBones().containsKey("tailBottom")) {
			getIndexBones().get("tailBottom").setRotationAngle(0.0F, MathHelper.cos(limbSwing * 0.030F) * 2.0F * limbYaw, 0.0F);
			this.getIndexBones().get("tailBottom").rotateAngleX = -45.0F;
		}
		if (getIndexBones().containsKey("tailTop")) {
			getIndexBones().get("tailTop").setRotationAngle(0.0F, MathHelper.cos(limbSwing * 0.030F) * 2.0F * limbYaw, 0.0F);
			this.getIndexBones().get("tailTop").rotateAngleX = 67.5F;
		}
	}
}
