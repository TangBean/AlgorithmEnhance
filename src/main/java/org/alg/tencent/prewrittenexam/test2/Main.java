package org.alg.tencent.prewrittenexam.test2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        int[][] section = new int[q][2];
        for (int i = 0; i < q; i++) {
            int lo = in.nextInt();
            int hi = in.nextInt();
            if (lo == hi) {
                if ((lo & 1) == 0) {
                    System.out.println(lo);
                } else {
                    System.out.println(-lo);
                }
                continue;
            }

            int n = hi - lo + 1;
            if ((lo & 1) == 0) {
                int res = -n / 2;
                if ((n & 1) == 1) {
                    if ((hi & 1) == 0) {
                        res += hi;
                    } else {
                        res -= hi;
                    }
                }
                System.out.println(res);
            } else {
                int res = n / 2;
                if ((n & 1) == 1) {
                    if ((hi & 1) == 0) {
                        res += hi;
                    } else {
                        res -= hi;
                    }
                }
                System.out.println(res);
            }
        }
    }
}
