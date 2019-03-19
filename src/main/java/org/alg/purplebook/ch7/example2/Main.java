package org.alg.purplebook.ch7.example2;

import java.util.Scanner;

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
                long tmp = pos + nums[i];
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
