package org.alg.baidu.nowcoder2018.shuangsushu;

import java.util.*;

/**
 * 题目描述
 * 一个正整数是素数当且仅当它除了1和自身以外没有其他因子，现在我们定义双素数；一个正整数是双素数当且仅当它本身是个素数，并且将他的十进制表示反转后得到数不等于它自身且也是个素数，如13就是一个双素数，因为13和31不相等且都是素数，现给出一个整数k,你需要找到第k小的双素数
 *
 * 输入描述:
 * 第一行包含一个整数k,1≤k≤10000
 *
 * 输出描述:
 * 若第k小的素数不超过10^6则输出它，否则输出-1
 *
 * 示例1
 * 输入:
 * 1
 * 输出:
 * 13
 *
 * 思路：
 * 给定 N = 10^6 了，先把 1 ~ 10^6 范围内的全部素数都求出来，然后一个一个的判断它们是不是双素数，直到判断到第 k 个
 * 求 1 ~ 10^6 范围内的全部素数可以用“埃氏筛法”！
 */
public class Main {
    private static final int N = 1000000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int res = getKthDualPrime(k);
        System.out.println(res);
    }

    private static int getKthDualPrime(int k) {
        boolean[] primeTab = getPrimesLessK(N);
        int count = 1;
        for (int i = 2; i < N; i++) {
            if (primeTab[i] && isDualPrime(i, primeTab)) {
                if (count == k) {
                    return i;
                } else if (count < k) {
                    count++;
                }
            }
        }
        return -1;
    }

    private static boolean isDualPrime(int prime, boolean[] primeTab) {
        int reverseNum = 0;
        int rawNum = prime;
        while (prime > 0) {
            reverseNum = reverseNum * 10 + prime % 10;
            prime /= 10;
        }
        return reverseNum != rawNum && primeTab[reverseNum];
    }

    private static boolean[] getPrimesLessK(int K) {
        boolean[] primeTab = new boolean[K];
        Arrays.fill(primeTab, true);
        primeTab[0] = primeTab[1] = false; // 最小的素数是2
        for (int i = 2; i < K; i++) {
            if (primeTab[i]) {
                for (int j = i * 2; j < N; j += i) {
                    primeTab[j] = false;
                }
            }
        }
        return primeTab;
    }
}
