package org.alg.kuangbin.s1.easysearch.poj1321;

import java.util.*;

/**
 * DFS
 * 不要用 HashSet，用 boolean[]，1485ms -> 344ms
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            int k = in.nextInt();
            in.nextLine();
            if (k == -1) {
                break;
            }
            char[][] board = new char[n][];
            for (int i = 0; i < n; i++) {
                board[i] = in.nextLine().toCharArray();
            }
            System.out.println(outputCount(n, k, board, 0, new boolean[n], new boolean[n]));
        }
    }

    private static int outputCount(int n, int k, char[][] board, int curRow,
                                        boolean[] rowSet, boolean[] colSet) {
        if (curRow == n && k > 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        int count = 0;
        count += outputCount(n, k, board, curRow + 1, rowSet, colSet);
        if (!rowSet[curRow]) {
            for (int i = 0; i < n; i++) {
                if (board[curRow][i] == '#' && !colSet[i]) {
                    rowSet[curRow] = true;
                    colSet[i] = true;
                    count += outputCount(n, k - 1, board, curRow + 1, rowSet, colSet);
                    rowSet[curRow] = false;
                    colSet[i] = false;
                }
            }
        }
        return count;
    }
}
