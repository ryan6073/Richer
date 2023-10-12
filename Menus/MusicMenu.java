package com.github.ryan6073.Richer.Menus;

import com.github.ryan6073.Richer.IO.IO;
public class MusicMenu extends ConsoleMenu {
    @Override
    protected void display() {
        IO.println("\n\t 音乐菜单\n\n");
        IO.println("\t1.开\n");
        IO.println("\t2.关\n\n");
        IO.println("\t请选择(1-2):");
    }

    @Override
    protected boolean doAction(int choice) {
        if (choice == 1) {
            //处理开音乐
        } else if (choice == 2) {
            //处理关闭音乐
        }
        MenuMgr.getInstance().setActivedMenu(MenuType.OPTION_MENU);
        return true;
    }
}