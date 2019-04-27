package org.luogu.part1.ch7.p1618;

import java.util.Scanner;

public class Main {
    private static final double eps = 1e-3;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt(), B = in.nextInt(), C = in.nextInt();
        if (A == B || A == C || B == C) {
            System.out.println("No!!!");
            return;
        }

        boolean found = false;
        for (double i = 123; i < 330; i++) {
            // i 也要用 double，不然下 4 行代码无效
            double timesB = i / A * B;
            if (timesB - Math.floor(timesB) > eps) continue;
            double timesC = i / A * C;
            if (timesC - Math.floor(timesC) > eps) continue;

            if (threeIsRight(new int[]{(int) i, (int) timesB, (int) timesC})) {
                System.out.println((int) i + " " + (int) timesB + " " + (int) timesC);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No!!!");
        }
    }

    private static boolean threeIsRight(int[] nums) {
        boolean[] visited = new boolean[9];
        for (int i = 0; i < 3; i++) {
            if (!oneIsRight(nums[i], visited)) {
                return false;
            }
        }
        return true;
    }

    private static boolean oneIsRight(int num, boolean[] visited) {
        int cur;
        while (num > 0) {
            cur = num % 10 - 1;
            if (cur < 0 || visited[cur]) return false;
            else visited[cur] = true;
            num /= 10;
        }
        return true;
    }
}
