package org.alg.tencent.shizihebing;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        int score = maxScore(w, n);
        System.out.println(score);
    }

    private static int maxScore(int[] w, int n) {
        Arrays.sort(w);
        int score = 0;
        int cur = w[n - 1];
        for (int i = n - 2; 0 <= i; i--) {
            score += cur * w[i];
            cur += w[i];
        }
        return score;
    }
}
