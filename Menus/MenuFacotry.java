package com.github.ryan6073.Richer.Menus;

public class MenuFacotry {
    public static final Menu[] menus = new Menu[MenuType.TOTAL_COUNT];

    public static Menu createMenu(int menuType) {
        if (menus[menuType] != null) {
            return menus[menuType];
        }
        switch (menuType) {
            case MenuType.MAIN_MENU:
                menus[menuType] = new MainMenu();
                break;
            case MenuType.NEW_MENU:
                menus[menuType] = new NewMenu();
                break;
            case MenuType.LOAD_MENU:
                menus[menuType] = new LoadMenu();
                break;
            case MenuType.OPTION_MENU:
                menus[menuType] = new OptionMenu();
                break;
            case MenuType.PLAY_MENU:
                menus[menuType] = new PlayMenu();
                break;
            case MenuType.SAVE_MENU:
                menus[menuType] = new SaveMenu();
                break;
            case MenuType.PAUSE_MENU:
                menus[menuType] = new PauseMenu();
                break;
            case MenuType.ANIMATE_MENU:
                menus[menuType] = new AnimateMenu();
                break;
            case MenuType.MUSIC_MENU:
                menus[menuType] = new MusicMenu();
                break;
            case MenuType.PLAYER_COUNT_MENU:
                menus[menuType] = new PlayerCountMenu();
                break;
            case MenuType.DIFFICULTY_MENU:
                menus[menuType] = new DifficultyMenu();
                break;
            case MenuType.ABOUT_MENU:
                menus[menuType] = new AboutMenu();
                break;
            default:
                System.out.println("MenuFacotry: createMenu: Unknown menu type " + menuType);
                break;
        }
        return menus[menuType];
    }
}
