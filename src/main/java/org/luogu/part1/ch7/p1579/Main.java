package org.luogu.part1.ch7.p1579;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int MAX_NUM = 20000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] primes = getPrimeList(MAX_NUM);
        int numRange = n / 3;
        for (int i = 2; i <= numRange; i++) {
            if (primes[i]) {
                for (int j = i; j <= 2 * numRange; j++) {
                    if (primes[j]) {
                        int thirdNum = n - i - j;
                        if (primes[thirdNum]) {
                            System.out.println(i + " " + j + " " + thirdNum);
                            return;
                        }
                    }
                }
            }
        }
    }

    private static boolean[] getPrimeList(int end) {
        boolean[] primes = new boolean[end + 1];
        Arrays.fill(primes, 2, end + 1, true);
        for (int i = 2; i < end; i++) {
            if (primes[i]) {
                for (int j = i << 1; j <= end; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
}
