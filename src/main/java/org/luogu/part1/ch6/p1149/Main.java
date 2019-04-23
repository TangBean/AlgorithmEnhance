package org.luogu.part1.ch6.p1149;

import java.util.Scanner;

public class Main {
    private static final int[] dic = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() - 4;

    }

    public static int needMatchCount(int num) {
        int count = 0;
        while (num != 0) {
            count += dic[num % 10];
            num /= 10;
        }
        return count;
    }
}
