package org.luogu.part1.ch2.p1085;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res = 0, max = 0, time;
        for (int i = 1; i <= 7; i++) {
            time = in.nextInt() + in.nextInt();
            if (time > 8 && time > max) {
                max = time;
                res = i;
            }
        }
        System.out.print(res);
    }
}
