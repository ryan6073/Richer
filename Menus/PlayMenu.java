package com.github.ryan6073.Richer.Menus;

import com.github.ryan6073.Richer.Maps.MapMgr;
import com.github.ryan6073.Richer.Players.Player;
import com.github.ryan6073.Richer.Players.PlayerImp;
import com.github.ryan6073.Richer.Players.PlayerMgr;
import com.github.ryan6073.Richer.IO.IO;

import java.io.IOException;

public class PlayMenu extends ConsoleMenu {
    @Override
    protected void display() {
//        clearConsole();
        try{
            IO.cls();
        } catch (IOException | InterruptedException e) {
                System.out.println("Error clearing console: " + e.getMessage());
            }
        MapMgr.getInstance().activedMap().show();
        IO.println("\n");
        IO.println("\t1.前进  0.暂停 \t请选择(0-1):");
    }

    @Override
    protected boolean doAction(int choice) {
        if (choice == 0) {
            MenuMgr.getInstance().setActivedMenu(MenuType.PAUSE_MENU);
        } else if (choice == 1) {
            // 玩家前进
            PlayerImp playerimp = PlayerMgr.getInstance().getActivePlayer().getImp();
            playerimp.forceAdvance();


            // 设置下一个为ActivePlayer
            PlayerMgr.getInstance().nextPlayer();

            // 继续开始新一轮前进
            PlayerMgr.getInstance().startRound();

            MenuMgr.getInstance().setActivedMenu(MenuType.PLAY_MENU);
        }
        return true;
    }
}