package org.alg.tencent.pincouyingbi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.print(methods(n));
    }

    private static int methods(long n) {
        int[] record = new int[64];
        int hi = 0;
        while (n != 0) {
            record[hi++] = (int) n & 1;
            n >>= 1;
        }
        return recurDfsHelper(record, hi) + 1;
    }

    private static int recurDfsHelper(int[] record, int hi) {
        int count = 0;
        for (int i = 1; i < hi; i++) {
            if (record[i] > 0 && record[i - 1] == 0) {
                record[i]--;
                record[i - 1] = 2;
                count += recurDfsHelper(record, hi) + 1;
            }
        }
        return count;
    }
}
