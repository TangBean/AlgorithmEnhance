package org.luogu.part2.ch6.p1208;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static class MilkFarmer implements Comparable<MilkFarmer> {
        int pi;
        int ai;

        public MilkFarmer(int pi, int ai) {
            this.pi = pi;
            this.ai = ai;
        }

        @Override
        public int compareTo(MilkFarmer o) {
            return this.pi - o.pi;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt(), N = in.nextInt();
        MilkFarmer[] farmers = new MilkFarmer[N];
        for (int i = 0; i < N; i++) {
            farmers[i] = new MilkFarmer(in.nextInt(), in.nextInt());
        }

        Arrays.sort(farmers);

        int cost = 0, milkCount = 0;
        for (int i = 0; i < N; i++) {
            if (milkCount + farmers[i].ai < M) {
                cost += farmers[i].ai * farmers[i].pi;
                milkCount += farmers[i].ai;
            } else {
                cost += (M - milkCount) * farmers[i].pi;
                break;
            }
        }
        System.out.println(cost);
    }
}
