package org.luogu.part1.ch1.p1425;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int hour, minute;
        if (d >= b) {
            minute = d - b;
        } else {
            minute = d + 60 - b;
            c--;
        }
        hour = c - a;
        System.out.printf("%d %d", hour, minute);
    }
}
