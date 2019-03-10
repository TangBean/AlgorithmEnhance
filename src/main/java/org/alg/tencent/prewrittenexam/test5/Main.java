package org.alg.tencent.prewrittenexam.test5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int L = in.nextInt();
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = in.nextInt();
        }
        System.out.println(houseQueueCount(colors, n, L));
    }

    private static int houseQueueCount(int[] colors, int n, int L) {
        return A(n);
    }

    private static int A(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
