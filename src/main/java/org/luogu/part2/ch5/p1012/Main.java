package org.luogu.part2.ch5.p1012;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.next();
        }
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String leftRight = o1 + o2;
                String rightLeft = o2 + o1;
                return rightLeft.compareTo(leftRight);
            }
        });
        for (String num : nums) {
            System.out.print(num);
        }
    }
}
