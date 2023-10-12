package com.github.ryan6073.Richer.Menus;

import com.github.ryan6073.Richer.IO.IO;
public class LoadMenu extends ConsoleMenu {
    @Override
    protected void display() {
        IO.println("\n\t 载入进度菜单\n");
        IO.println("\t1.xxxx\n");
        IO.println("\t2.xxxx\n");
        IO.println("\t3.xxx\n");
        IO.println("\t0.返回游戏\n\n");
        IO.println("\t请选择(0-3):");
    }

    @Override
    protected boolean doAction(int choice) {
        //暂时，全部继续游戏
        MenuMgr.getInstance().setActivedMenu(MenuType.PLAY_MENU);
        return true;
    }
}