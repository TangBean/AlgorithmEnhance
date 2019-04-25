package org.luogu.part1.ch6.p1217;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        /*
        偶数位数的回文数，除了 11 之外，一定不是质数。
        使用这种方法可以将搜索范围缩小 10 倍，可以防止 TLE。
         */
        b = (b > 9999999) ? 9999999 : b;

        boolean[] prime = getPrimeList(a, b);
        for (int i = a; i <= b; i++) {
            if (prime[i - a] && isPalindromes(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean[] getPrimeList(int a, int b) {
        boolean[] prime = new boolean[b - a + 1];  // begin = a, end = b (include b)
        Arrays.fill(prime, true);

        int end = (int) Math.sqrt(b);
        boolean[] helper = new boolean[end + 1];  // begin = 2, end = end (include end)
        Arrays.fill(helper, true);

        for (int i = 2; i <= end; i++) {
            if (helper[i]) {
                for (int j = i << 1; j <= end; j += i) {
                    helper[j] = false;
                }
                /*
                j 开始的位置：Math.max(2, (a + i - 1) / i) * i 很关键！
                为什么要 (a + i - 1) / i < 2 时要取 2 呢？
                因为我们使用埃氏筛法的过程是：
                1. 找到当前区间中最小的质数
                2. 把这个质数的 2，3，4 ... 以上的倍数划去
                可以看到，是从 2 倍开始的，所以要和 2 取一下 max。
                 */
                for (int j = Math.max(2, (a + i - 1) / i) * i; j <= b; j += i) {
                    prime[j - a] = false;
                }
            }
        }
        return prime;
    }

    public static boolean isPalindromes(int num) {
        int x = num, reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse == num;
    }
}
