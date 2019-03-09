package org.alg.tencent.pincouyingbi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目链接：https://www.nowcoder.com/practice/2479839aa61e44f39aa3268160650e17?tpId=90&tqId=30956&tPage=10&rp=10&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 *
 * 题目描述：
 * 小Q十分富有，拥有非常多的硬币，小Q拥有的硬币是有规律的，对于所有的非负整数K，小Q恰好各有两个面值为2^K的硬币，
 * 所以小Q拥有的硬币就是1,1,2,2,4,4,8,8,…。小Q有一天去商店购买东西需要支付n元钱，小Q想知道有多少种方案从他拥
 * 有的硬币中选取一些拼凑起来恰好是n元（如果两种方案某个面值的硬币选取的个数不一样就考虑为不一样的方案）。
 *
 * 输入：
 * 输入包括一个整数n(1≤n≤10^18)，表示小Q需要支付多少钱。注意n的范围。
 *
 * 输出：
 * 输出一个整数，表示小Q可以拼凑出n元钱放的方案数。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.print(method1(n));
    }

    /**
     * 将硬币分为两份：1，2，4，8，16，.....和 1，2，4，8，16....
     * 组成两个数值为 a，b 的两个数字，他们的和是 a + b = n;
     * 然后通过“异或”去重
     */
    private static int method1(long n) {
        long hi = n / 2;
        Set<Long> resSet = new HashSet<Long>();
        for (long i = 1; i <= hi; i++) {
            resSet.add(i ^ (n - i));
        }
        return resSet.size();
    }

//    private static int methods(long n) {
//        int[] record = new int[64];
//        int hi = 0;
//        while (n != 0) {
//            record[hi++] = (int) n & 1;
//            n >>= 1;
//        }
//        return recurDfsHelper(record, hi) + 1;
//    }
//
//    private static int recurDfsHelper(int[] record, int hi) {
//        int count = 0;
//        for (int i = 1; i < hi; i++) {
//            if (record[i] > 0 && record[i - 1] == 0) {
//                record[i]--;
//                record[i - 1] = 2;
//                count += recurDfsHelper(record, hi) + 1;
//            }
//        }
//        return count;
//    }
}
