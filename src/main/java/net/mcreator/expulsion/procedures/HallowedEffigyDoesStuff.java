package net.mcreator.expulsion.procedures;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.mcreator.expulsion.init.ExpulsionModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class HallowedEffigyDoesStuff {
    public static final Set<UUID> playersWithEffigy = new HashSet<>();

    public static void DoThefunny() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (entity instanceof PlayerEntity player) {
                if (player.getHealth() - amount <= 0) { // Check if the player will die
                    ItemStack offHand = player.getOffHandStack();
                    ItemStack mainHand = player.getMainHandStack();

                    // Mark players who hold the effigy
                    if (offHand.getItem() == ExpulsionModItems.HALLOWED_ECHO_EFFIGY
                            || mainHand.getItem() == ExpulsionModItems.HALLOWED_ECHO_EFFIGY) {
                        playersWithEffigy.add(player.getUuid());
                    }
                }
            }
            return true; // Allow the damage
        });


        ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
            if (entity instanceof PlayerEntity player && playersWithEffigy.contains(player.getUuid())) {
                if (player.getWorld() instanceof ServerWorld world) {
                    // Summon the lightning
                    LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                    lightning.setPos(player.getX(), player.getY(), player.getZ());
                    world.spawnEntity(lightning);

                    // Remove the effigy
                    ItemStack offHand = player.getOffHandStack();
                    ItemStack mainHand = player.getMainHandStack();

                    if (offHand.getItem() == ExpulsionModItems.HALLOWED_ECHO_EFFIGY) {
                        player.setStackInHand(Hand.OFF_HAND, ItemStack.EMPTY);
                    } else if (mainHand.getItem() == ExpulsionModItems.HALLOWED_ECHO_EFFIGY) {
                        player.setStackInHand(Hand.MAIN_HAND, ItemStack.EMPTY);
                    }

                    player.sendMessage(Text.literal("Hallowed Echo Effigy activated and removed!"));
                }

                // Clean up
                playersWithEffigy.remove(player.getUuid());
            }
        });

    }
}
