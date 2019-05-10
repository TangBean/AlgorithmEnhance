package org.luogu.part2.ch4.p1583;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static class People {
        int no_;
        int weight;

        public People(int no_, int weight) {
            this.no_ = no_;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        People[] weights = new People[n];
        int[] extras = new int[10];
        for (int i = 0; i < 10; i++) {
            extras[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            weights[i - 1] = new People(i, in.nextInt());
        }

        Comparator<People> comparator = new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.weight != o2.weight ? o2.weight - o1.weight : o1.no_ - o2.no_;
            }
        };

        Arrays.sort(weights, comparator);
        for (int i = 1; i <= n; i++) {
            weights[i - 1].weight += extras[(i - 1) % 10];
        }
        Arrays.sort(weights, comparator);

        for (int i = 0; i < k; i++) {
            System.out.print(weights[i].no_ + " ");
        }
    }
}
