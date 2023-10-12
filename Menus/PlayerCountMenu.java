package com.github.ryan6073.Richer.Menus;

import com.github.ryan6073.Richer.Players.PlayerMgr;
import com.github.ryan6073.Richer.IO.IO;

public class PlayerCountMenu extends ConsoleMenu {
    @Override
    protected void display() {
        IO.println("\n\t 玩家数量菜单\n\n");
        IO.println("\t1.玩家数量(1)\n");
        IO.println("\t2.玩家数量(2)\n");
        IO.println("\t3.玩家数量(3)\n");
        IO.println("\t4.玩家数量(4)\n");
        IO.println("\t5.玩家数量(5)\n");
        IO.println("\t0.返回\n\n");

        IO.println("\t请选择(0-5):");
    }

    @Override
    protected boolean doAction(int choice) {
        if (choice >= 1 && choice <= 5) {
            //记录玩家数量
            PlayerMgr.getInstance().resetPlayers(choice);
        }
        if (choice >= 0 && choice <= 5)
            MenuMgr.getInstance().setActivedMenu(MenuType.NEW_MENU);
        return true;
    }
}