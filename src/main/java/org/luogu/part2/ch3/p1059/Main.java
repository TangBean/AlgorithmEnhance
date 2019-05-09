package org.luogu.part2.ch3.p1059;

import java.util.Scanner;

public class Main {
    private static final boolean[] bucket = new boolean[1001];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = 0;
        for (int i = 0; i < N; i++) {
            int cur = in.nextInt();
            if (!bucket[cur]) {
                bucket[cur] = true;
                M++;
            }
        }
        System.out.println(M);
        for (int i = 1; i <= 1000; i++) {
            if (bucket[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
