package org.luogu.part2.ch7.p1219;

import java.util.Scanner;

public class Main {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] cur = new int[N];
        boolean[] col = new boolean[N];
        boolean[] firstDiag = new boolean[2 * N - 1];
        boolean[] secondDiag = new boolean[2 * N - 1];
        siteFinder(0, N, cur, col, firstDiag, secondDiag);
        System.out.println(count);
    }

    private static void siteFinder(int row, int N, int[] cur,
                                   boolean[] col, boolean[] firstDiag, boolean[] secondDiag) {
        if (row == N) {
            if (count < 3) {
                for (int i : cur) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!col[i]) {
                int fdIndex = N - 1 + i - row;
                int sdIndex = N - 1 + N - i - 1 - row;
                if (firstDiag[fdIndex] || secondDiag[sdIndex]) {
                    return;
                }
                col[i] = true;
                firstDiag[fdIndex] = true;
                secondDiag[sdIndex] = true;
                cur[row] = i + 1;
                siteFinder(row + 1, N, cur, col, firstDiag, secondDiag);
                col[i] = false;
                firstDiag[fdIndex] = false;
                secondDiag[sdIndex] = false;
            }
        }
    }
}
