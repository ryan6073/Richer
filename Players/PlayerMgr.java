package com.github.ryan6073.Richer.Players;

import com.github.ryan6073.Richer.Blocks.Block;
import com.github.ryan6073.Richer.Maps.MapMgr;
import com.github.ryan6073.Richer.Strategy.FixedStepStrategy;
import com.github.ryan6073.Richer.Strategy.ProbabilityDirStrategy;
import com.github.ryan6073.Richer.Strategy.RandomDirStrategy;
import com.github.ryan6073.Richer.Strategy.RandomStepStrategy;

import java.util.ArrayList;
import java.util.List;

public class PlayerMgr {
    private static final PlayerMgr instance = new PlayerMgr();
    private Player mActivePlayer;
    private List<Player> mPlayers = new ArrayList<>();

    private PlayerMgr() {
        // Initialize the singleton
    }
    public static PlayerMgr getInstance() {
        return instance;
    }

    public void resetPlayers(int num) {
        // Ensure at least one player and at most 8 players
        if (num < 1) num = 1;
        if (num > 8) num = 8;

        String[] names = {
                "赵一伤",
                "钱二败",
                "孙三毁",
                "李四摧",
                "周五输",
                "吴六破",
                "郑七灭",
                "王八衰"
        };

        // Clear existing players
        mPlayers.clear();

        // Get the first block
        Block firstBlock = MapMgr.getInstance().activedMap().getBlockByIndex(0);

        // Create all players
        for (int i = 0; i < num; i++) {
            Player player = new Player();
            if (i == num - 1) {
                // 最后一个是用户玩家
                player.setImp(new StepUserPlayerImp());
                // 设置策略
                player.setStepStrategy(new FixedStepStrategy(2));
                // player.setDirStrategy(new StraightDirStrategy());
                player.setDirStrategy(new ProbabilityDirStrategy());
            } else {
                player.setImp(new StepAutoPlayerImp());
                // 设置策略
                // player.setStepStrategy(new FixedStepStrategy(3));
                player.setStepStrategy(new RandomStepStrategy());
                player.setDirStrategy(new RandomDirStrategy());
            }
            player.getImp().setName(names[i]);
            // Set the player's initial position
            player.getImp().setStand(Dir.Direction.UNKNOW, firstBlock);
            mPlayers.add(player);
        }

        // Current player is the first one
        setActivePlayer(mPlayers.get(0));
    }

    public List<Player> getAllPlayers() {
        return mPlayers;
    }

    public void addPlayer(Player player) {
        mPlayers.add(player);
    }

    public Player getActivePlayer() {
        return mActivePlayer;
    }

    public void setActivePlayer(Player player) {
        mActivePlayer = player;
    }

    public Player nextPlayer() {
        // Get the index of the current player
        int curPlayerIndex = mPlayers.indexOf(mActivePlayer);

        if (curPlayerIndex != -1 && curPlayerIndex < mPlayers.size() - 1) {
            // 下一个Player
            setActivePlayer(mPlayers.get(curPlayerIndex + 1));
        } else {
            // 已到最后，取第一个
            setActivePlayer(mPlayers.get(0));
        }

        return mActivePlayer;
    }

    // 取得站在Block上的玩家
    public Player findPlayerOnBlock(Block block) {
        Player found = null;
        for (Player player : mPlayers) {
            if (player.getImp().getStand() == block) {
                found = player;
                break;
            }
        }
        // 若多个玩家站在同一个Block上，返回UserPlayer
        return found;
    }
    public void startRound() {
        // 一直前进，直到遇到下一个UserPlayer
        boolean goon = mActivePlayer.advance();
        while (goon) {
            nextPlayer();
            goon = mActivePlayer.advance();
        }
    }
}


