package org.luogu.part2.ch6.p1080;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 将序列抽象为：
 *  A      B
 * a_i    b_i
 * a_i1   b_i1
 *
 * 我们要使得 max{ A/b_i, A*a_i/b_i1, A/B_i1, A*a_i1/bi} 最小
 * 因为 a_i >= 1, a_i1 >= 1，所以有：
 * max{ A/b_i, A*a_i/b_i1, A/B_i1, A*a_i1/bi}
 * = max{ A*a_i/b_i1, A*a_i1/bi } = max{ a_i/b_i1, a_i1/bi }
 *
 * 如果 a_i/b_i1 >= a_i1/bi，则 a_i*b_i >= a_i1*b_i1
 * 如果 a_i/b_i1 <= a_i1/bi，则 a_i*b_i <= a_i1*b_i1
 *
 * 也就是说，安照 a_i*b_i 排序就可以啦！
 *
 * 最后要注意高精度的问题，也就是说，需要使用 BigInteger
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int kingLeft = in.nextInt(), kingRight = in.nextInt();
        int[][] seq = new int[N][2];
        for (int i = 0; i < N; i++) {
            seq[i][0] = in.nextInt();
            seq[i][1] = in.nextInt();
        }
        Arrays.sort(seq, ((o1, o2) -> o1[0] * o1[1] - o2[0] * o2[1]));

        BigInteger prod = new BigInteger(String.valueOf(kingLeft));
        BigInteger reward = BigInteger.ZERO;
        for (int i = 0; i < N; i++) {
            reward = reward.max(prod.divide(new BigInteger(String.valueOf(seq[i][1]))));
            prod = prod.multiply(new BigInteger(String.valueOf(seq[i][0])));
        }
        System.out.println(reward);
    }
}
