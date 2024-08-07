package com.zen.fogman.common.entity.the_man;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;

import java.util.function.Predicate;

public class TheManPredicates {
    public static final Predicate<BlockState> BLOCK_STATE_PREDICATE = blockState -> {

        if (blockState.isAir() || blockState.getBlock() instanceof LeavesBlock || blockState.getBlock() instanceof PlantBlock || blockState.getBlock() instanceof FenceBlock || blockState.getBlock() instanceof FenceGateBlock) {
            return false;
        }

        return blockState.isOpaque();
    };

    public static final Predicate<Entity> TARGET_PREDICATE = entity -> {
        if (!entity.isPlayer()) {
            return false;
        }
        PlayerEntity player = (PlayerEntity) entity;
        return !player.isCreative() && !player.isSpectator();
    };

    public static final Predicate<Entity> VALID_MAN = entity ->
            entity instanceof TheManEntity theMan && !theMan.isHallucination() && theMan.isAlive();

    public static final Predicate<Entity> VALID_MAN_HALLUCINATION = entity ->
            entity instanceof TheManEntity theMan && theMan.isHallucination() && !theMan.isParanoia() && theMan.isAlive();

    public static final Predicate<BlockState> EXCEPT_AIR = blockState -> !blockState.isAir();
}
