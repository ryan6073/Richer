package com.github.ryan6073.Richer.Menus;

import com.github.ryan6073.Richer.IO.IO;
public class PauseMenu extends ConsoleMenu {
    @Override
    protected void display() {
        IO.println("\n\t 暂停菜单\n\n");
        IO.println("\t1.保存进度\n");
        IO.println("\t2.回主菜单\n");
        IO.println("\t0.继续游戏\n\n");
        IO.println("\t请选择(0-3):");
    }

    @Override
    protected boolean doAction(int choice) {
        if (choice == 1) {
            MenuMgr.getInstance().setActivedMenu(MenuType.SAVE_MENU);
        } else if (choice == 2) {
            MenuMgr.getInstance().setActivedMenu(MenuType.MAIN_MENU);
        } else {
            MenuMgr.getInstance().setActivedMenu(MenuType.PLAY_MENU);
        }
        return true;
    }
}