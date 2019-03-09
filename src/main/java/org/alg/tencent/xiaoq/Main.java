package org.alg.tencent.xiaoq;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.print(minOp(n, nums));
    }

    private static int minOp(int n, int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean isOrder = true;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            if (isOrder && i > 0 && nums[i - 1] > nums[i]) {
                isOrder = false;
            }
        }
        if (isOrder) {
            return 0;
        }
        if (nums[0] == min || nums[n - 1] == max) {
            return 1;
        }
        return 2;
    }
}
