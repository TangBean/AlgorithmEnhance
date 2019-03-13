package org.alg.baidu.nowcoder2018.xuliehebing;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int[][] coefficient = new int[k][8];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 8; j++) {
                coefficient[i][j] = in.nextInt();
            }
        }
        int n = in.nextInt();
        int kMax = getKMax(k, coefficient, n);
        System.out.println(kMax);
    }

    private static int getKMax(int k, int[][] coefficient, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        return 0;
    }
}
