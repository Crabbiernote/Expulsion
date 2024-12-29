package net.mcreator.expulsion.mixins;
import net.mcreator.expulsion.ExpulsionMod;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin extends PlayerEntity {
    public AbstractClientPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile profile) {
        super(world, pos, yaw, profile);
    }
    @Override
    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
            if (ExpulsionMod.bannedUuids.contains(this.getUuid()) && (MinecraftClient.getInstance().getCameraEntity().getRotationVecClient().dotProduct(this.getPos().subtract(cameraX, cameraY, cameraZ).normalize()) > 0.5 || this.isInSneakingPose() || MinecraftClient.getInstance().options.getPerspective().isFrontView())) {
                return false;
            }
            if (!ExpulsionMod.isGhost) {
                return true;
            }
        return super.shouldRender(cameraX, cameraY, cameraZ);
    }
    @Override
    public boolean shouldRenderName() {
        return !ExpulsionMod.bannedUuids.contains(this.getUuid());
    }
    @Inject(method = "getSkinTexture", at = @At("HEAD"), cancellable = true)
    private void getDriderSkinTexture(CallbackInfoReturnable<Identifier> cir) {
        if(ExpulsionMod.bannedUuids.contains(this.getUuid())) {
            cir.setReturnValue(new Identifier("expulsion", "textures/entity/ghostyboy.png"));
        }
    }
    @Inject(method = "getModel", at = @At("HEAD"), cancellable = true)
    private void getDriderSlimModel(CallbackInfoReturnable<String> cir) {
        if(ExpulsionMod.bannedUuids.contains(this.getUuid())) {
            cir.setReturnValue("slim");
        }
    }
}
