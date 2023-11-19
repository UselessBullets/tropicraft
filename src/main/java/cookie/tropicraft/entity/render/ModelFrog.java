package cookie.tropicraft.entity.render;

import net.minecraft.core.util.helper.MathHelper;
import useless.dragonfly.model.entity.BenchEntityModel;

public class ModelFrog extends BenchEntityModel {

	@Override
	public void setRotationAngles(float limbSwing, float limbYaw, float ticksExisted, float headYaw, float headPitch, float scale) {
		super.setRotationAngles(limbSwing, limbYaw, ticksExisted, headYaw, headPitch, scale);
		if (getIndexBones().containsKey("body"))
            this.getIndexBones().get("body").setRotationAngle(0.0F, 0.0F, 0.0F);

		if (getIndexBones().containsKey("legFrontLeft")) {
			this.getIndexBones().get("legFrontLeft").setRotationAngle(MathHelper.cos(limbSwing * 0.375F) * 1.4F * limbYaw, 0.0F, 0.0F);
			this.getIndexBones().get("legFrontLeft").rotateAngleX = -0.30F;
		}
		if (getIndexBones().containsKey("footFrontLeft"))
			this.getIndexBones().get("footFrontLeft").setRotationAngle(MathHelper.cos(limbSwing * 0.225F) * 1.4F * limbYaw, 0.0F, 0.0F);
		if (getIndexBones().containsKey("legBackRight")) {
			this.getIndexBones().get("legBackRight").setRotationAngle(MathHelper.cos(limbSwing * 0.375F) * 1.4F * limbYaw, 0.0F, 0.0F);
			this.getIndexBones().get("legBackRight").rotateAngleX = 0.30F;
		}
		if (getIndexBones().containsKey("footBackRight"))
			this.getIndexBones().get("footBackRight").setRotationAngle(MathHelper.cos(limbSwing * 0.225F) * 1.4F * limbYaw, 0.0F, 0.0F);

		if (getIndexBones().containsKey("legFrontRight")) {
			this.getIndexBones().get("legFrontRight").setRotationAngle(MathHelper.cos(limbSwing * 0.375F + (float) Math.PI) * 1.4F * limbYaw, 0.0F, 0.0F);
			this.getIndexBones().get("legFrontRight").rotateAngleX = -0.30F;
		}
		if (getIndexBones().containsKey("footFrontRight"))
			this.getIndexBones().get("footFrontRight").setRotationAngle(MathHelper.cos(limbSwing * 0.225F + (float) Math.PI) * 1.4F * limbYaw, 0.0F, 0.0F);
		if (getIndexBones().containsKey("legBackLeft")) {
			this.getIndexBones().get("legBackLeft").setRotationAngle(MathHelper.cos(limbSwing * 0.375F + (float) Math.PI) * 1.4F * limbYaw, 0.0F, 0.0F);
			this.getIndexBones().get("legBackLeft").rotateAngleX = 0.30F;
		}
		if (getIndexBones().containsKey("footBackLeft"))
			this.getIndexBones().get("footBackLeft").setRotationAngle(MathHelper.cos(limbSwing * 0.225F + (float) Math.PI) * 1.4F * limbYaw, 0.0F, 0.0F);
	}
}
