package org.luogu.part2.ch1.p1328;

import java.util.Scanner;

public class Main {
    private static final int[][] relationship = {
            {0, -1, 1, 1, -1},
            {1, 0, -1, 1, -1},
            {-1, 1, 0, -1, 1},
            {-1, -1, 1, 0, 1},
            {1, 1, -1, -1, 0}
    };
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int NA = in.nextInt(), NB = in.nextInt();
        int[] xa = new int[NA];
        int[] xb = new int[NB];
        for (int i = 0; i < NA; i++) {
            xa[i] = in.nextInt();
        }
        for (int i = 0; i < NB; i++) {
            xb[i] = in.nextInt();
        }

        int scoreA = 0, scoreB = 0;
        for (int i = 0; i < N; i++) {
            if (relationship[xa[i % NA]][xb[i % NB]] == 1) {
                scoreA++;
            } else if (relationship[xa[i % NA]][xb[i % NB]] == -1) {
                scoreB++;
            }
        }
        System.out.println(scoreA + " " + scoreB);
    }
}
