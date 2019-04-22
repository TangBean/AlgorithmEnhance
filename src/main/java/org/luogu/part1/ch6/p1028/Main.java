package org.luogu.part1.ch6.p1028;

import java.util.Scanner;

public class Main {
    static int res = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        numCount(Integer.parseInt(n.substring(0, 1)));
        System.out.println(res);
    }

    private static void numCount(int n) {
        int curCount = n / 2;
        res += curCount;
        for (int i = 1; i <= curCount; i++) {
            numCount(i);
        }
    }
}
