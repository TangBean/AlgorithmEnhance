package org.luogu.part2.ch6.p1223;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static class People implements Comparable<People> {
        int waterNeeded;
        int no_;

        public People(int waterNeeded, int no_) {
            this.waterNeeded = waterNeeded;
            this.no_ = no_;
        }

        @Override
        public int compareTo(People o) {
            return this.waterNeeded - o.waterNeeded;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        People[] peoples = new People[N];
        for (int i = 1; i <= N; i++) {
            peoples[i - 1] = new People(in.nextInt(), i);
        }
        Arrays.sort(peoples);

        double sumTime = 0;
        for (int i = 0; i < N; i++) {
            System.out.print(peoples[i].no_ + " ");
            sumTime += peoples[i].waterNeeded * (N - i - 1);
        }
        double averageTime = sumTime / N;
        System.out.printf("\n%.2f", averageTime);
    }
}
