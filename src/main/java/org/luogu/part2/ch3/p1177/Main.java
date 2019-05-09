package org.luogu.part2.ch3.p1177;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        stack.push(N - 1);
        stack.push(0);
        partitionByLo(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void partitionByLo(int[] nums) {
        if (stack.isEmpty()) {
            return;
        }
        int lo = stack.pop(), hi = stack.pop();
        int i = lo, j = hi;
        while (i < j) {
            while (i < j && nums[j] >= nums[lo]) {
                j--;
            }
            while (i < j && nums[i] <= nums[lo]) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, lo, i);
        stack.push(hi);
        stack.push(i + 1);
        stack.push(lo);
        stack.push(i - 1);
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
