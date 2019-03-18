package org.alg.purplebook.ch7.example1;

import java.util.Scanner;

/**
 * UVA-725: Division
 * 简单搜索的题，就是遍历可能的情况，当然我们并不需要遍历 10 个数所有可能的组合，
 * 因为是 abcde / fghij = N，我们只需要遍历 fghij 这 5 个数就可以了，这样其实就几万种可能。
 * 而且！不用排列组合啥的，就是直接从 divisor = 1234 用 divisor++ 一个一个往下遍历就行，真是简单粗暴啊...
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = 0;
        while (true) {
            int N = in.nextInt();
            if (N == 0) {
                break;
            }
            if (m++ > 0) {
                System.out.println();
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
        if (dividend > 98765) {
            return false;
        }
        while (divisor > 0) {
            int cur = divisor % 10;
            if (map[cur]) {
                return false;
            }
            map[cur] = true;
            divisor /= 10;
        }
        while (dividend > 0) {
            int cur = dividend % 10;
            if (map[cur]) {
                return false;
            }
            map[cur] = true;
            dividend /= 10;
        }
        boolean res = true;
        for (int i = 0; i < 10; i++) {
            res = res && map[i];
        }
        return res;
    }
}
