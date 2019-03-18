package org.alg.purplebook.ch7;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int N = in.nextInt();
            if (N == 0) {
                break;
            }
            getDivision(N);
        }
    }

    private static void getDivision(int N) {
        boolean nonRes = true;
        for (int divisor = 1234; divisor <= 98765; divisor++) {
            if (isAnswer(divisor, N)) {
                System.out.printf("%d / %05d = %d\n", divisor * N, divisor, N);
                nonRes = false;
            }
        }
        if (nonRes) {
            System.out.println("There are no solutions for " + N + ".");
        }
    }

    private static boolean isAnswer(int divisor, int N) {
        int dividend = divisor * N;
        boolean[] map = new boolean[10];
        if (divisor / 10000 == 0) {
            map[0] = true;
        }
        while (divisor > 0) {
            int cur = divisor % 10;
            if (map[cur]) {
                return false;
            }
            map[cur] = true;
            divisor /= 10;
        }
        if (dividend > 98765) {
            return false;
        }
        while (dividend > 0) {
            int cur = dividend % 10;
            if (map[cur]) {
                return false;
            }
            map[cur] = true;
            dividend /= 10;
        }
        return true;
    }
}
