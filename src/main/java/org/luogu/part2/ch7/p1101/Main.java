package org.luogu.part2.ch7.p1101;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int WORD_LEN = 7;
    private static char[] word = {'y', 'i', 'z', 'h', 'o', 'n', 'g'};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        char[][] matrix = new char[N][];
        for (int i = 0; i < N; i++) {
            matrix[i] = in.next().toCharArray();
        }

        char[][] res = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(res[i], '*');
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (dx == 0 && dy == 0) {
                            continue;
                        }
                        if (matrix[i][j] == word[0]) {
                            findWord(matrix, res, i, j, dx, dy, N);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(new String(res[i]));
        }
    }

    private static void findWord(char[][] matrix, char[][] res, int x, int y, int dx, int dy, int N) {
        int maxX = x + (WORD_LEN - 1) * dx, maxY = y + (WORD_LEN - 1) * dy;
        if (maxX < 0 || maxX >= N || maxY < 0 || maxY >= N) {
            return;
        }
        boolean succeed = true;
        for (int i = 1; i < WORD_LEN; i++) {
            if (matrix[x + i * dx][y + i * dy] != word[i]) {
                succeed = false;
                break;
            }
        }
        if (succeed) {
            for (int i = 0; i < WORD_LEN; i++) {
                res[x + i * dx][y + i * dy] = word[i];
            }
        }
    }
}
