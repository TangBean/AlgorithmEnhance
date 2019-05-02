package org.luogu.part1.ch8.p1014;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int n = 1;
        while (n * (n + 1) / 2 < N) {
            n++;
        }
        int up = N - n * (n - 1) / 2;
        int down = n * (n + 1) / 2 - N + 1;
        if ((n & 1) == 0) {
            System.out.println(up + "/" + down);
        } else {
            System.out.println(down + "/" + up);
        }
    }
}
