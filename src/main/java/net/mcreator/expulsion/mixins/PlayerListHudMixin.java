package net.mcreator.expulsion.mixins;

import net.mcreator.expulsion.ExpulsionMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(PlayerListHud.class)
public abstract class PlayerListHudMixin {
    @Shadow protected abstract List<PlayerListEntry> collectPlayerEntries();

   // @ModifyVariable(method = "collectPlayerEntries", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/client/network/ClientPlayNetworkHandler;getListedPlayerListEntries()Ljava/util/Collection;"))
//    private PlayerListHud eplayers$modifyDeathMessage(PlayerListHud value) {
   //     List<PlayerListEntry> list = this.collectPlayerEntries();
  //      list.removeIf((entry) -> ExpulsionMod.bannedUuids.contains(entry.getProfile().getId()));
   //     return (PlayerListHud) list;
  //  }
    // tbh idk why i even bothered to try this thing up here im just keeping it to remind me of my failures
    @Inject(method = "collectPlayerEntries", at = @At("HEAD"))
        private void pleaseletthisworkiwillcry(CallbackInfoReturnable<List<PlayerListEntry>> cir){
        List<PlayerListEntry> list = this.collectPlayerEntries();
        list.removeIf((entry) -> ExpulsionMod.bannedUuids.contains(entry.getProfile().getId()));

    }
}
