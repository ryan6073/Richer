package com.github.ryan6073.Richer.Menus;

import com.github.ryan6073.Richer.IO.IO;
public class OptionMenu extends ConsoleMenu {
    @Override
    protected void display() {
        IO.println("\n\t 选项菜单\n\n");
        IO.println("\t1.动画开关\n");
        IO.println("\t2.音乐开关\n");
        IO.println("\t0.回主菜单\n\n");
        IO.println("\t请选择(0-2):");
    }

    @Override
    protected boolean doAction(int choice) {
        if (choice == 1) {
            MenuMgr.getInstance().setActivedMenu(MenuType.ANIMATE_MENU);
        } else if (choice == 2) {
            MenuMgr.getInstance().setActivedMenu(MenuType.MUSIC_MENU);
        } else if (choice == 0) {
            MenuMgr.getInstance().setActivedMenu(MenuType.MAIN_MENU);
        }
        return true;
    }
}