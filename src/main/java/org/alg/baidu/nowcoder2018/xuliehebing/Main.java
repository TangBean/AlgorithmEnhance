package org.alg.baidu.nowcoder2018.xuliehebing;

import java.util.Arrays;
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
                return o2 - o1;
            }
        });
        int[] cur = new int[k];
        Arrays.fill(cur, 1);
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = 0; i < k; i++) {
                int curRes = func(cur[i], coefficient[i]);
                if (heap.size() < n) {
                    heap.offer(curRes);
                    cur[i]++;
                    end = false;
                } else {
                    if (curRes < heap.peek()) {
                        heap.poll();
                        heap.offer(curRes);
                        cur[i]++;
                        end = false;
                    }
                }
            }
        }
        return heap.peek();
    }

    private static int func(int n, int[] coefficient) {
        int res = 0;
        for (int i = 0; i < 8; i++) {
            res += coefficient[7 - i] * Math.pow(n, i);
        }
        return res;
    }
}
