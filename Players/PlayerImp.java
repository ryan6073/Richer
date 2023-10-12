package com.github.ryan6073.Richer.Players;

import com.github.ryan6073.Richer.Blocks.Block;

import java.util.ArrayList;
import com.github.ryan6073.Richer.Rand.Rand;
import com.github.ryan6073.Richer.Players.Dir.Direction;
import com.github.ryan6073.Richer.Strategy.StepStrategy;
public class PlayerImp {
    private Block mpStand; // 所在的Block
    private Direction mEnterDir = Direction.UNKNOW; // 进入的方向
    private String mName = ""; // 姓名
    private int mMoney = 0; // 金钱
    private int mHp = 100; // 体力
    private Player mpPlayer = null;

    public PlayerImp() {
        mpStand = null;
    }

    public void forceAdvance() {
        // 确定移动步数
        int steps = decideSteps();

        boolean goon = true;
        while (goon && steps > 0) {
            goon = moveStep(); // 向前移动一步
            steps--;
        }
    }

    public boolean moveStep() {
        // 确定移动方向
        Dir.Direction dir = decideMoveDir();
        // 取得目标Block
        Block nextBlock = mpStand.getNeighbor(dir);
        // 进入目标Block，目标的进入方向正好与dir相反
        Dir oppositeDir = new Dir(dir);
        setStand(oppositeDir.opposite(), nextBlock);
        // 处理进入后果，返回是否可继续移动
        return nextBlock.enterBy(mpPlayer);
    }

    // 确定前进方向
    public Dir.Direction decideMoveDir() {
        // 取得所有可用方向(不含进入方向)，放入ArrayList中
        ArrayList<Dir.Direction> dirs = new ArrayList<>();
        for (Dir.Direction dir : Dir.Direction.values()) {
            if (dir != mEnterDir && mpStand.getNeighbor(dir) != null) {
                dirs.add(dir);
            }
        }

        // 初始无进入方向时，任选一个方向
        if (mEnterDir == Dir.Direction.UNKNOW) {
            // 从dirs中随机选一个
            return dirs.get(Rand.byRange(0, dirs.size() - 1));
        }

        // 只有进入方向，无其他可用方向，原路返回
        if (dirs.isEmpty()) {
            return mEnterDir.opposite();//真不行
        }

        return dirs.get(Rand.byRange(0, dirs.size() - 1));
    }

    public void setName(String name) {
        mName = name;
    }

    public int getMoney() {
        return mMoney;
    }

    public void setMoney(int money) {
        mMoney = money;
    }

    public int getHp() {
        return mHp;
    }

    public void setHp(int hp) {
        mHp = hp;
    }

    public Block getStand() {
        return mpStand;
    }

    public Dir.Direction getEnterDir() {
        return mEnterDir;
    }

    public void setStand(Dir.Direction enterDir, Block stand) {
        mEnterDir = enterDir;
        mpStand = stand;
    }

    public void setPlayer(Player player) {
        mpPlayer = player;
    }

    // 添加辅助方法（可选）
    public int addMoney(int add) {
        mMoney += add;
        return mMoney;
    }

    public int addHp(int add) {
        mHp += add;
        return mHp;
    }

    public char flagChar(Dir.Direction d) {
        // Implement this in subclasses
        return '?';
    }

    public boolean advance() {
        return false;
    }



    protected int decideSteps() {
        // Implement this in subclasses
        return mpPlayer.getStepStrategy().determineSteps(mpPlayer);
    }
}

