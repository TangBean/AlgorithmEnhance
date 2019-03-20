package org.alg.purplebook.ch7.example2;

import java.util.Scanner;

/**
 * 这道题的数据量很小，所以遍历所有的可能情况也可以，不过这种做法不是很好。
 *
 * 较好做法：DP 思想，在遍历 nums[i] 的过程中维护两个状态：
 * - pos: 以 nums[i] 为结尾的序列的最大正值
 * - neg: 以 nums[i] 为结尾的序列的最小负值
 * 这样做是因为：
 * - 如果当前 nums[i] > 0，那么就直接 pos = pos * nums[i] 和 neg = neg * nums[i] 就行
 * - 如果当前 nums[i] < 0，那么则需要交换 pos 和 neg 的值
 * - 如果当前 nums[i] == 0，需要把 pos 和 neg 设为 0
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 1;
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            long maxPdt = maxProduct(n, nums);
            System.out.printf("Case #%d: The maximum product is %d.\n\n", count++, maxPdt);
        }
    }

    private static long maxProduct(int n, int[] nums) {
        long max = 0, pos = 0, neg = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                pos = 0;
                neg = 0;
            } else if (nums[i] > 0) {
                pos *= nums[i];
                neg *= nums[i];
                if (pos == 0) {
                    pos = nums[i];
                }
            } else {
                long tmp = pos * nums[i];
                pos = neg * nums[i];
                neg = tmp;
                if (neg == 0) {
                    neg = nums[i];
                }
            }
            max = Math.max(max, pos);
        }
        return max;
    }
}
