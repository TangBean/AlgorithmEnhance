package org.luogu.part2.ch6.p1094;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int N = in.nextInt();
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = in.nextInt();
        }
        Arrays.sort(values);

        int groupCnt = 0;
        int i = 0, j = N - 1;
        while (i < j) {
            if (values[i] + values[j] <= W) {
                i++;
                j--;
            } else {
                j--;
            }
            groupCnt++;
        }
        if (i == j) {
            groupCnt++;
        }
        System.out.println(groupCnt);
    }
}
