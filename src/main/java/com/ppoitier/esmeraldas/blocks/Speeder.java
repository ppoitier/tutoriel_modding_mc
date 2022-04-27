package com.ppoitier.esmeraldas.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class Speeder extends Block {

    public static final BooleanProperty ENABLED = BooleanProperty.create("enabled");
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    private static final double speed = 0.2d;

    public Speeder() {
        super(BlockBehaviour.Properties
                .of(Material.METAL, MaterialColor.EMERALD)
                .requiresCorrectToolForDrops()
                .strength(5.0F, 6.0F)
                .sound(SoundType.METAL));

        this.registerDefaultState(this.defaultBlockState()
                .setValue(ENABLED, false)
                .setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(ENABLED, context.getLevel().hasNeighborSignal(context.getClickedPos()))
                .setValue(FACING, context.getHorizontalDirection());
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighBlock, BlockPos neighPos, boolean p_60514_) {

        if (!level.isClientSide()) {
            final boolean enabled = state.getValue(ENABLED);
            final boolean powered = level.hasNeighborSignal(pos);
            if (powered != enabled) {
                level.setBlock(pos, state.setValue(ENABLED, powered), 3);
            }
        }

        super.neighborChanged(state, level, pos, neighBlock, neighPos, p_60514_);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entityIn) {

        if (state.getValue(ENABLED)) {
            final Direction dir = state.getValue(FACING);
            double dx = 0d;
            double dy = 0d;
            double dz = 0d;

            if (dir == Direction.NORTH) {
                dz = -speed;
            } else if (dir == Direction.SOUTH) {
                dz = speed;
            } else if (dir == Direction.EAST) {
                dx = speed;
            } else {
                dx = -speed;
            }

            entityIn.setDeltaMovement(entityIn.getDeltaMovement().add(dx, dy, dz));
        }

        super.stepOn(level, pos, state, entityIn);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ENABLED, FACING);
    }
}
