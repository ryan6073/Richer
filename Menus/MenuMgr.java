package com.github.ryan6073.Richer.Menus;

import java.util.ArrayList;
import java.util.List;

public class MenuMgr {
    //饥饿模式
    private static final MenuMgr menuMgr = new MenuMgr();

    public static MenuMgr getInstance() {
        return menuMgr;
    }
    private MenuMgr() {
        mVctMenus.add(MenuFacotry.createMenu(MenuType.MAIN_MENU));
        mVctMenus.add(MenuFacotry.createMenu(MenuType.NEW_MENU));
        mVctMenus.add(MenuFacotry.createMenu(MenuType.LOAD_MENU));
        mVctMenus.add(MenuFacotry.createMenu(MenuType.OPTION_MENU));
        mVctMenus.add(MenuFacotry.createMenu(MenuType.PLAY_MENU));
        mVctMenus.add(MenuFacotry.createMenu(MenuType.SAVE_MENU));
        mVctMenus.add(MenuFacotry.createMenu(MenuType.PAUSE_MENU));
        mVctMenus.add(MenuFacotry.createMenu(MenuType.ANIMATE_MENU));
        mVctMenus.add(MenuFacotry.createMenu(MenuType.MUSIC_MENU));
        mVctMenus.add(MenuFacotry.createMenu(MenuType.PLAYER_COUNT_MENU));
        mVctMenus.add(MenuFacotry.createMenu(MenuType.DIFFICULTY_MENU));
        mVctMenus.add(MenuFacotry.createMenu(MenuType.ABOUT_MENU));

        setActivedMenu(MenuType.MAIN_MENU);
    }

    private Menu mCurMenu = null;
    private final List<Menu> mVctMenus = new ArrayList<>();

    public Menu activedMenu() {
        return mCurMenu;
    }

    public void setActivedMenu(int menuType) {
        mCurMenu = mVctMenus.get(menuType);
    }
}