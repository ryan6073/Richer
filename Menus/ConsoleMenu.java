package com.github.ryan6073.Richer.Menus;

import java.util.Scanner;
import java.io.IOException;
import com.github.ryan6073.Richer.IO.IO;
public class ConsoleMenu extends Menu {
    public boolean process() {
        try {
            clearConsole();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
        display();
        int choice = selectMenuItem();
        return doAction(choice);
    }

    protected void display() {
        IO.println("This is a menu.");
    }
    static void clearConsole() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    protected int selectMenuItem() {
//        Scanner scanner = new Scanner(System.in);
//        int choice = -1;
//        while (choice < 0 || choice > 9) {
//            choice = scanner.nextInt();
//        }
//        return choice;
        return IO.readDigital();
    }

    protected boolean doAction(int choice) {
        return true;
    }

}
