package net.mrstickson.daytimedetector.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DayTimeDetectorBlock extends Block {

    public DayTimeDetectorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!world.isClientSide) {
            world.scheduleTick(pos, this, 1);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        world.updateNeighborsAt(pos, this);
        world.scheduleTick(pos, this, 1);
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    public int getSignal(BlockState blockState, BlockGetter blockAccess, BlockPos pos, Direction side) {
        if (!(blockAccess instanceof ServerLevel world)) return 0;

        long time = world.getServer().getLevel(Level.OVERWORLD).getDayTime() % 24000;

        if (time >= 12300 && time <= 23850) {
            return 0;
        } else {
            return 15;
        }
    }
}
