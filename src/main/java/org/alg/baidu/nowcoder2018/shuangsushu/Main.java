package org.alg.baidu.nowcoder2018.shuangsushu;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int res = getKthDualPrime(k);
        System.out.println(res);
    }

    private static int getKthDualPrime(int k) {

    }

    private static Set<Integer> getPrimesLessK(int K) {
        Set<Integer> res = new LinkedHashSet<>();
        int lastPrime = 1;
        res.add(lastPrime);
        while (lastPrime < K) {

        }
        return res;
    }
}
