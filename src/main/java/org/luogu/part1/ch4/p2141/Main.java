package org.luogu.part1.ch4.p2141;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                set.add(nums[i] + nums[j]);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                count++;
            }
        }
        System.out.println(count);
    }
}
