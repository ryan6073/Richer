package com.github.ryan6073.Richer.Blocks;

import com.github.ryan6073.Richer.Players.Dir;
import com.github.ryan6073.Richer.Players.Player;
import com.github.ryan6073.Richer.Players.PlayerImp;
import com.github.ryan6073.Richer.Players.PlayerMgr;
import com.github.ryan6073.Richer.IO.IO;

public class MoneyBlock extends Block {
    @Override
    public void draw() {
        // 获取站在本Block上的玩家
        Player player = PlayerMgr.getInstance().findPlayerOnBlock(this);
        if (player == null) { // 无Player站
            IO.print(" B ");
        } else { // 不同Player，显示不同的字符标记
            IO.print(player.flagChar(Dir.Direction.LEFT));
            IO.print("B");
            IO.print(player.flagChar(Dir.Direction.RIGHT));
        }
    }

    @Override
    public MoneyBlock clone() {
        return new MoneyBlock();
    }

    @Override
    public boolean enterBy(Player player) {
        player.getImp().addMoney(100);
        return true;
    }
}
