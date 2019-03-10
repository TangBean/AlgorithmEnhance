package org.alg.tencent.prewrittenexam.test3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int count = selectCount(n, s);
        System.out.println(count);
    }

    private static int selectCount(int n, int s) {
        long count = combination(n, s);
        for (int i = 0; i < n - s; i++) {
            count = (count * 2) % 1000000007;
        }
        return (int) count;
    }

    private static long combination(int m, int n) {
        if (m < n) {
            return 0;
        }
        long k = 1;
        long j = 1;
        for (int i = n; i >= 1; i--) {
            k = k * m;
            j = j * n;
            m--;
            n--;
        }
        return k / j;
    }
}
