package org.luogu.part2.ch7.p1101;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
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
                dfs(matrix, res, i, j, 0, N);
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(new String(res[i]));
        }
    }

    private static boolean dfs(char[][] matrix, char[][] res, int x, int y, int w, int N) {
        if (w == word.length) {
            return true;
        }
        if (x < 0 || x >= N || y < 0 || y >= N || matrix[x][y] != word[w]) {
            return false;
        }
        res[x][y] = matrix[x][y];
        boolean succeed = false;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                succeed = succeed || dfs(matrix, res, x + i, y + j, w + 1, N);
            }
        }
        if (!succeed) {
            res[x][y] = '*';
        }
        return succeed;
    }
}
