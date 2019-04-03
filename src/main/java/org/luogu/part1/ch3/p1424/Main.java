package org.luogu.part1.ch3.p1424;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start = in.nextInt() - 1;
        int n = in.nextInt();
        int i = 0;
        int dis = 0;
        while (i++ < n) {
            if (start < 5) {
                dis += 250;
            }
            start = (start + 1) % 7;
        }
        System.out.println(dis);
    }
}
