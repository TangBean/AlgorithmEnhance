package org.luogu.part1.ch4.p1567;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        int maxDayCnt = 0, curDayCnt = 1;
        for (int i = 1; i < N - 1; i++) {
            if (nums[i] > nums[i - 1]) {
                curDayCnt++;
                maxDayCnt = Math.max(maxDayCnt, curDayCnt);
            } else {
                curDayCnt = 1;
            }
        }
        System.out.println(maxDayCnt);
    }
}
