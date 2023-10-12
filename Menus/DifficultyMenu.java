package com.github.ryan6073.Richer.Menus;

import com.github.ryan6073.Richer.IO.IO;
public class DifficultyMenu extends ConsoleMenu {
    @Override
    protected void display() {
        IO.println("\n\t 难度等级菜单\n\n");
        IO.println("\t1.菜鸟\n");
        IO.println("\t2.普通\n");
        IO.println("\t3.困难\n");
        IO.println("\t4.骨灰\n");
        IO.println("\t0.返回\n\n");

        IO.println("\t请选择(0-4):");
    }

    @Override
    protected boolean doAction(int choice) {
        if (choice >= 1 && choice <= 4) {
            //记录难度等级
            // (to be done)
        }
        if (choice >= 0 && choice <= 4)
            MenuMgr.getInstance().setActivedMenu(MenuType.NEW_MENU);
        return true;
    }
}