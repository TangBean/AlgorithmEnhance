package org.alg.bytedance.prewrittenexam.test4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] l = new int[N];
        for (int i = 0; i < N; i++) {
            l[i] = in.nextInt();
        }
        double res = getMaxLen(N, l, M);
        System.out.printf("%.2f", res);
    }

    private static double getMaxLen(int N, int[] l, int M) {
        Arrays.sort(l);
        if (M <= N) {
            return (double) l[N - M];
        }
        int mul = M / N;
        return 0.0;
    }
}
