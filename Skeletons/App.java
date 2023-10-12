package com.github.ryan6073.Richer.Skeletons;

import com.github.ryan6073.Richer.Maps.MapID;
import com.github.ryan6073.Richer.Maps.MapMgr;
import com.github.ryan6073.Richer.Menus.Menu;
import com.github.ryan6073.Richer.Menus.MenuMgr;
import com.github.ryan6073.Richer.Players.PlayerMgr;

public class App {

    public void init() {
        // 初始化随机数发生器
        // private Random random = new Random();
//        Random random = new Random(System.currentTimeMillis());

        // 确定使用的Map工厂
//        MapFactory mapFac = MapFactory.getInstance();
        // 确定使用的Block工厂
//        BlockProtoFactory blockFac = BlockProtoFactory.getInstance();
        // 初始地图
        //MapMgr.getInstance().setActiveMap(MapID.Value.TOWN_MAP, mapFac, blockFac);
        MapMgr.getInstance().setActiveMap(MapID.Value.CITY_MAP);

        // 加载全部Players
        PlayerMgr.getInstance().resetPlayers(2);
    }

    public void run() {
        boolean running = true;
        while (running) {
            Menu pMenu = MenuMgr.getInstance().activedMenu();
            running = pMenu.process();
        }
    }

    public void term() {
    }
}
