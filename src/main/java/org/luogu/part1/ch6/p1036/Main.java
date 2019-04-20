package org.luogu.part1.ch6.p1036;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        Set<String> resSet = new HashSet<>();
        dfs(nums, n, k, 0, 0, 0, new StringBuilder(), resSet);
        System.out.println(resSet.size());
    }

    private static void dfs(int[] nums, int n, int k, int curN, int curK,
                            int sum, StringBuilder key, Set<String> resSet) {
        if (curK == k) {
            if (isPrime(sum)) {
                resSet.add(key.toString());
            }
            return;
        }
        if (n - curN < k - curK) {
            return;
        }
        for (int i = curN; i < n; i++) {
            sum += nums[i];
            key.append(",");
            key.append(i);
            dfs(nums, n, k, i + 1, curK + 1, sum, key, resSet);
            sum -= nums[i];
            key.delete(key.lastIndexOf(","), key.length());
        }
    }

    private static boolean isPrime(int num) {
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
