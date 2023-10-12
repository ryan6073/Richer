package com.github.ryan6073.Richer.Blocks;

import com.github.ryan6073.Richer.Players.Dir;
import com.github.ryan6073.Richer.Players.Player;
import com.github.ryan6073.Richer.Players.PlayerMgr;
import com.github.ryan6073.Richer.IO.IO;

public class NormalBlock extends Block {
    @Override
    public void draw() {
        // 获取站在本Block上的玩家
        Player player = PlayerMgr.getInstance().findPlayerOnBlock(this);
        if (player == null) { // 无Player站
            IO.print(" A ");
        } else { // 不同Player，显示不同的字符标记
            IO.print(player.flagChar(Dir.Direction.LEFT));
            IO.print("A");
            IO.print(player.flagChar(Dir.Direction.RIGHT));
        }
    }

    @Override
    public NormalBlock clone() {
        return new NormalBlock();
    }

    @Override
    public boolean enterBy(Player player) {
        return true;
    }
}
