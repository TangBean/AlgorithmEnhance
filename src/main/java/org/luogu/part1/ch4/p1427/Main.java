package org.luogu.part1.ch4.p1427;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        printNumLater();
    }

    private static void printNumLater() {
        int num = in.nextInt();
        if (num == 0) {
            return;
        }
        printNumLater();
        System.out.print(num + " ");
    }
}
