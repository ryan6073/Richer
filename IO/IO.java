package com.github.ryan6073.Richer.IO;

import java.io.IOException;
import java.util.Scanner;

public class IO {

    public static int readDigital() {
        int digital = 0xFF;
        Scanner scanner = new Scanner(System.in);

        while (digital < 0 || digital > 9) {
            try {
                digital = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Handle non-integer input
            }
        }

        System.out.print(digital);
        return digital;
    }
    public static void cls() throws IOException, InterruptedException{
        // Clear console screen
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static <T> void print(T value) {
        System.out.print(value);
    }

    @SafeVarargs
    public static <T, TArgs> void print(T value, TArgs... args) {
        print(value);
        if (args.length > 0) {
            print(' ');
            print(args);
        }
    }

    @SafeVarargs
    public static <T, TArgs> void println(T value, TArgs... args) {
        print(value, args);
        print('\n');
    }
}

