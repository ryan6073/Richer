package com.github.ryan6073.Richer.Menus;
import java.util.Scanner;
public class AboutMenu extends ConsoleMenu {

    private boolean showAboutMenu = false;

    @Override
    protected void display() {
        System.out.println("\n\t 关于菜单");
        System.out.println("\t--------");
        System.out.println("\t1.基本信息\n");
        System.out.println("\t2.使用方法\n");
        System.out.println("\t3.历史信息\n");
        System.out.println("\t0.回主菜单\n\n");
        System.out.println("\t请选择(0-3):");
    }
    protected void displayAbout(int choice) {
        if (choice == 1) {
            System.out.println("\n\t 基本信息");
            System.out.println("\t--------");
            System.out.println("\t姓名：朱家顺\n");
            System.out.println("\t学号：55210425\n");
            System.out.println("\t电话：20031230\n");
            System.out.println("\t最新版本号：1.0\n");
            System.out.println("\t最新修改日期：2023-9-12\n");
        } else if (choice == 2) {
            System.out.println("\n\t 使用方法");
            System.out.println("\t--------");
            System.out.println("\t环境要求:IntelliJ IDEAUltimate 2023.2.1   JDK:openjdk-20.0.2\n");
            System.out.println("\t操作步骤说明:\n");
            System.out.println("\t游戏规则说明:\n");
        } else if (choice == 3) {  //历史信息：各版本的历史信息，包括各版本的主要修改及重构内容
            System.out.println("\n\t 历史信息");
            System.out.println("\t--------");
            System.out.println("\t1.0:完成MenuMgr,MenuFactory板块,添加关于菜单\n");
            System.out.println("\t1.0.1:完成Map/Block/Player等功能，使得程序能执行\n");
            System.out.println("\t1.0.2:将输入输出从Menu/Map等类中独立出来\n");
            System.out.println("\t1.1:完成Strategy/PlayerMgr/BlockMgr等功能，使得程序能执行\n");
        } else{
            System.out.println("\n\t 请输入正确的选项");
        }
    }

    @Override
    protected boolean doAction(int choice) {
        if (choice == 0) {
            MenuMgr.getInstance().setActivedMenu(MenuType.MAIN_MENU);
        } else{
            showAboutMenu = true;
            displayAbout(choice);
            waitForEnter();
            showAboutMenu = false;
        }

        return true;
    }

    private void waitForEnter() {
        System.out.println("\n\t按回车键返回...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
