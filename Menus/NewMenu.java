package com.github.ryan6073.Richer.Menus;

import com.github.ryan6073.Richer.Players.PlayerMgr;
import com.github.ryan6073.Richer.IO.IO;
public class NewMenu extends ConsoleMenu {
    @Override
    protected void display() {
        IO.println("\n\t 开始菜单\n\n");
        IO.println("\t1.玩家数量\n");
        IO.println("\t2.难度等级\n");
        IO.println("\t0.开始游戏\n\n");
        IO.println("\t请选择(0-2):");
    }

    @Override
    protected boolean doAction(int choice) {
        if (choice == 1) {
            MenuMgr.getInstance().setActivedMenu(MenuType.PLAYER_COUNT_MENU);
        } else if (choice == 2) {
            MenuMgr.getInstance().setActivedMenu(MenuType.DIFFICULTY_MENU);
        } else if (choice == 0) {
            // 开始游戏
            PlayerMgr.getInstance().startRound();
            MenuMgr.getInstance().setActivedMenu(MenuType.PLAY_MENU);
        }
        return true;
    }
}