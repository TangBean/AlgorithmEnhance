package org.alg.bytedance.interviewpractice.test1;

/**
 * 题目：
 * 给你一个有序整数数组，数组中的数可以是正数、负数、零，请实现一个函数，
 * 这个函数返回一个整数：返回这个数组所有数的平方值中有多少种不同的取值。
 *
 * 输入：
 * nums = {-1,0,1,2,3}
 *
 * 输出：
 * 4
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-10, -1, 0, 1, 2, 3};
        System.out.println(squareCount(nums));
    }

    private static int squareCount(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int count = 0;
        while (lo <= hi) {
            count++;
            if (Math.abs(nums[lo]) == Math.abs(nums[hi])) {
                lo++;
                hi--;
            } else if (Math.abs(nums[lo]) < Math.abs(nums[hi])) {
                hi--;
            } else {
                lo++;
            }
            while (lo > 0 && nums[lo] == nums[lo - 1]) {
                lo++;
            }
            while (hi < nums.length - 1 && nums[hi] == nums[hi + 1]) {
                hi--;
            }
        }
        return count;
    }
}
