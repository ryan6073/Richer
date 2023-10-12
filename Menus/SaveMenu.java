package com.github.ryan6073.Richer.Menus;

import com.github.ryan6073.Richer.IO.IO;
public class SaveMenu extends ConsoleMenu {
    @Override
    protected void display() {
        IO.println("\n\t 保存进度菜单\n");
        IO.println("\t1.xxxx\n");
        IO.println("\t2.xxxx\n");
        IO.println("\t3.xxx\n\n");
        IO.println("\t请选择(1-3):");
    }

    @Override
    protected boolean doAction(int choice) {
        if (choice >= 1 && choice <= 3) {
            //保存到对应存档
            // (to be done)

            //直接继续游戏
            MenuMgr.getInstance().setActivedMenu(MenuType.PLAY_MENU);
        }
        return true;
    }
}