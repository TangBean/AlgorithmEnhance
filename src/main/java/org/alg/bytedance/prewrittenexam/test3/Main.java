package org.alg.bytedance.prewrittenexam.test3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            int N = in.nextInt();
            int[] scores = new int[N + 2];
            for (int j = 1; j <= N; j++) {
                scores[j] = in.nextInt();
            }
            scores[0] = scores[N];
            scores[N + 1] = scores[1];
            results[i] = minPrices(N + 2, scores);
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(results[i]);
        }
    }

    private static int minPrices(int n, int[] scores) {
        int[] priceNum = new int[n];
        Arrays.fill(priceNum, 1);
        for (int i = 0; i < n - 1; i++) {
            if (scores[i + 1] > scores[i]) {
                priceNum[i + 1] = priceNum[i] + 1;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (scores[i] < scores[i - 1]) {
                priceNum[i - 1] = Math.max(priceNum[i - 1], priceNum[i] + 1);
            }
        }
        int total = 0;
        for (int i = 1; i < n - 1; i++) {
            total += priceNum[i];
        }
        return total;
    }
}
