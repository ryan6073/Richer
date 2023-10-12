package com.github.ryan6073.Richer.Menus;

import com.github.ryan6073.Richer.IO.IO;
public class MainMenu extends ConsoleMenu {
    @Override
    protected void display() {
        IO.println("\n");
        IO.println("\t 主菜单");
        IO.println("\t--------");
        IO.println("\t1.新的游戏");
        IO.println("\t2.载入游戏");
        IO.println("\t3.选 项");
        IO.println("\t4.关 于");
        IO.println("\t0.退 出\n");
        IO.println("\t请选择(0-4):");
    }

    @Override
    protected boolean doAction(int choice) {
        if (choice == 0) {
            return false;
        } else if (choice == 1) {
            MenuMgr.getInstance().setActivedMenu(MenuType.NEW_MENU);
        } else if (choice == 2) {
            MenuMgr.getInstance().setActivedMenu(MenuType.LOAD_MENU);
        } else if (choice == 3) {
            MenuMgr.getInstance().setActivedMenu(MenuType.OPTION_MENU);
        } else if (choice == 4) {
            MenuMgr.getInstance().setActivedMenu(MenuType.ABOUT_MENU);
        }
        return true;
    }
    //单例模式
}