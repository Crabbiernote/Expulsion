package net.mcreator.expulsion.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.mcreator.expulsion.ExpulsionMod;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

import static net.mcreator.expulsion.ExpulsionMod.isGhost;
import static net.minecraft.server.command.CommandManager.literal;

public class GoingGhost<T> {
    public static void GoingGhost() {
        CommandRegistrationCallback.EVENT.register((commandDispatcher, commandRegistryAccess, registrationEnvironment) -> commandDispatcher.register(literal("goingghost")
                .executes(context -> {
                    if (ExpulsionMod.bannedUuids.contains(Objects.requireNonNull(context.getSource().getPlayer()).getUuid())) {
                        isGhost = !isGhost;
                        if (isGhost) {
                            context.getSource().sendFeedback(Text.literal("you are ghost now lmao"), false);
                        } else {
                            context.getSource().sendFeedback(Text.literal("you are not ghost now lmao"), false);
                        }
                    }

                    context.getSource().sendFeedback(Text.literal("Going Ghost"), false);

                    return 0;
                })
                .then(CommandManager.argument("player", StringArgumentType.string())
                        .executes(context -> {
                            if (ExpulsionMod.bannedUuids.contains(Objects.requireNonNull(context.getSource().getPlayer()).getUuid())) {
                                String playerName = StringArgumentType.getString(context, "player");
                                PlayerEntity targetPlayer = context.getSource().getServer().getPlayerManager().getPlayer(playerName);
                                PlayerEntity sourcePlayer = context.getSource().getPlayer();

                                if (targetPlayer != null && sourcePlayer != null) {
                                    BlockPos targetBlockPos = targetPlayer.getBlockPos();
                                    BlockPos sourceBlockPos = sourcePlayer.getBlockPos();
                                    net.minecraft.util.registry.RegistryKey<World> playerDimension = targetPlayer.getWorld().getRegistryKey();
                                    net.minecraft.util.registry.RegistryKey<World> sourceDimension = sourcePlayer.getWorld().getRegistryKey();
                                    context.getSource().sendFeedback(Text.literal(playerName + " is at ")
                                            .append(Text.literal(targetBlockPos.getX() + ", " + targetBlockPos.getY() + ", " + targetBlockPos.getZ())), false);
                                } else {
                                    context.getSource().sendError(Text.literal("Player not found"));
                                }
                            }
                            return 0;
                        })
                ))
        );
    }
}
