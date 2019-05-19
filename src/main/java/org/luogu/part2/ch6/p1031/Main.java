package org.luogu.part2.ch6.p1031;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
            sum += nums[i];
        }
        int finalNum = sum / N;

        int moveCnt = 0;
        int i = 0, j = N - 1;
        while (i < j) {
            if (nums[i] != finalNum) {
                nums[i + 1] -= finalNum - nums[i];
                moveCnt++;
            }
            i++;
            if (nums[j] != finalNum) {
                nums[j - 1] -= finalNum - nums[j];
                moveCnt++;
            }
            j--;
        }
        System.out.println(moveCnt);
    }
}
