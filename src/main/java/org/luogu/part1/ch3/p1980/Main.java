package org.luogu.part1.ch3.p1980;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        System.out.println(countNumX(n, x));
    }

    private static int countNumX(int n, int x) {
        int m = 1, count = 0;
        while (m <= n) {
            // 例如 728 的 m = 10 的情况：
            // hi = 7, cur = 2, lo = 8
            int hi = n / (m * 10);
            int cur = n / m % 10;
            int lo = n % m;
            System.out.println(hi + " " + cur + " " + lo);
            if (x != 0) {
                if (cur < x) {
                    count += hi * m;  // 如求 1~728 中十位7的个数，则为 7*10 个
                } else if (cur == x) {
                    count += hi * m + lo + 1;  // 如求 1~728 中百位 7 的个数，则为 0*100+28+1=29
                } else {
                    count += (hi + 1) * m;  // 如求 1~728 中个位 7 的个数，则为 (72+1)*1=73
                }
            } else {
                if (cur == 0) {
                    count += hi * m;
                } else {
                    count += (hi - 1) * m + lo + 1;
                }
            }
            m *= 10;
        }
        return count;
    }
}
