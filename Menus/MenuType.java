package com.github.ryan6073.Richer.Menus;

public class MenuType {
    public static final int MAIN_MENU = 0;
    public static final int NEW_MENU = 1;
    public static final int LOAD_MENU = 2;
    public static final int OPTION_MENU = 3;
    public static final int PLAY_MENU = 4;
    public static final int SAVE_MENU = 5;
    public static final int PAUSE_MENU = 6;
    public static final int ANIMATE_MENU = 7;
    public static final int MUSIC_MENU = 8;
    public static final int PLAYER_COUNT_MENU = 9;
    public static final int DIFFICULTY_MENU = 10;
    public static final int ABOUT_MENU = 11;
    public static final int TOTAL_COUNT = ABOUT_MENU + 1;  //菜单个数

    public static int totalCount() {
        return TOTAL_COUNT;
    }
}