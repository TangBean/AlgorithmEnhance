package org.luogu.part1.ch6.p1028;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 这道题的关键点有两个：
 * 1. 递归函数的设计，递归函数传入：String preNum, int addNum
 * 2. 保存计算过的结果（记忆化搜索），防止递归栈深度过大导致的 MLE（过全部测试点的关键！）
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> cache = new HashMap<>();
        System.out.println(numCount("", n, cache));
    }

    private static int numCount(String preNum, int addNum, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(addNum)) {
            return cache.get(addNum);
        }
        int curCount = addNum / 2;
        int sum = 0;
        for (int i = 1; i <= curCount; i++) {
            sum += numCount(String.valueOf(i) + preNum, i, cache);
        }
        cache.put(addNum, sum + 1);
        return sum + 1;
    }
}
