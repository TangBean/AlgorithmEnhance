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
            Set<String> res = new TreeSet<>();
            getDivision(N, res);
            if (res.isEmpty()) {
                System.out.println("There are no solutions for " + N + ".");
            } else {
                for (String str : res) {
                    System.out.println(str);
                }
            }
        }
    }

    private static void getDivision(int N, Set<String> res) {

    }

    private static void permutation() {

    }

    private static String isAnswer(int[] arr, int N) {
        boolean[] map = new boolean[10];
        int divisor = 0;
        for (int i = 0; i < 4; i++) {
            map[arr[i]] = true;
            divisor += arr[i] * (4 - i) * 10;
        }
        map[arr[4]] = true;
        divisor += arr[4];
        int dividend = divisor * N;
        int i = 1;
        int tmp;
        while ((tmp = dividend / i) != 0) {
            if (map[tmp]) {
                return null;
            } else {
                map[tmp] = true;
            }
            i *= 10;
        }
        StringBuilder res = new StringBuilder();
        res.append(dividend);
        res.append(" / ");
        for (int j = 0; j < 5; j++) {
            res.append(arr[i]);
        }
        res.append(" = ");
        res.append(N);
        return res.toString();
    }
}
