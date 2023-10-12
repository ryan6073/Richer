package com.github.ryan6073.Richer.Blocks;

import java.util.ArrayList;
import java.util.List;

public class BlockProtoFactory implements IBlockFactory {
    private static final BlockProtoFactory instance = new BlockProtoFactory();
    private final List<Block> mProtoBlocks;

    private BlockProtoFactory() {
        mProtoBlocks = new ArrayList<>();
        initialize();
    }

    public static BlockProtoFactory getInstance() {
        return instance;
    }

    @Override
    public Block createBlock(BlockType.Type type) {
        assert type.ordinal() < BlockType.TOTAL_COUNT;

        if (type == BlockType.Type.NORMAL_BLOCK) {
            return mProtoBlocks.get(0).clone(); // 通过原型模式创建Block
        } else if (type == BlockType.Type.MONEY_BLOCK)
            return mProtoBlocks.get(type.ordinal()).clone();
        else if (type == BlockType.Type.TRIP_BLOCK)
            return mProtoBlocks.get(type.ordinal()).clone();
        else if (type == BlockType.Type.BAR_BLOCK)
            return mProtoBlocks.get(type.ordinal()).clone();

        return null;
    }
    public void changePrototype(BlockType.Type type, Block block) {
        assert type.ordinal() < BlockType.TOTAL_COUNT;
        mProtoBlocks.set(type.ordinal(), block);
    }
    private void initialize() {
        mProtoBlocks.add(new NormalBlock());
        mProtoBlocks.add(new MoneyBlock());
        mProtoBlocks.add(new TripBlock());
        mProtoBlocks.add(new BarBlock());
    }
}
