package org.luogu.part2.ch6.p1181;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 必须是连续划分... 仔细审题呀！
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), M = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        int curSum = 0;
        int countLeft = 0;
        for (int i = 0; i < N; i++) {
            if (curSum + nums[i] > M) {
                curSum = nums[i];
                countLeft++;
            } else {
                curSum += nums[i];
            }
        }
        if (curSum != 0) {
            curSum = 0;
            countLeft++;
        }
        int countRight = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (curSum + nums[i] > M) {
                curSum = nums[i];
                countRight++;
            } else {
                curSum += nums[i];
            }
        }
        if (curSum != 0) {
            countRight++;
        }
        System.out.println(Math.min(countLeft, countRight));

        // 不连续划分的方法，需要排序
//        Arrays.sort(nums);
//
//        int count = 0;
//        int i = 0, j = N - 1;
//        while (i < j) {
//            if (nums[i] + nums[j] <= M) {
//                i++;
//                j--;
//            } else {
//                j--;
//            }
//            count++;
//        }
//        if (i == j) {
//            count++;
//        }
//        System.out.println(count);
    }
}
