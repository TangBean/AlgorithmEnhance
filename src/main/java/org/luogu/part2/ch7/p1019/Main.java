package org.luogu.part2.ch7.p1019;

import java.util.Scanner;

public class Main {
    private static int maxRes = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = in.next();
        }
        String start = in.next();

        int[][] overlap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                overlap[i][j] = getOverlap(words[i], words[j]);
            }
        }

        int[] visited = new int[N];
        for (int i = 0; i < N; i++) {
            if (words[i].startsWith(start)) {
                visited[i]++;
                maxRes = Math.max(maxRes, words[i].length());
                dfs(words, i, words[i].length(), N, visited, overlap);
                visited[i]--;
            }
        }
        System.out.println(maxRes);
    }

    private static void dfs(String[] words, int cur, int curLen, int N, int[] visited, int[][] overlap) {
        for (int i = 0; i < N; i++) {
            if (overlap[cur][i] > 0 && visited[i] < 2) {
                int lenAdd = words[i].length() - overlap[cur][i];
                curLen += lenAdd;
                visited[i]++;
                maxRes = Math.max(maxRes, curLen);
                dfs(words, i, curLen, N, visited, overlap);
                curLen -= lenAdd;
                visited[i]--;
            }
        }
    }

    private static int getOverlap(String left, String right) {
        int maxLen = Math.min(left.length(), right.length());
        int Nl = left.length(), Nr = right.length();
        if (!left.equals(right) && left.substring(Nl - maxLen, Nl).equals(right.substring(0, maxLen))) {
            return 0;
        }
        maxLen--;
        while (maxLen > 0 && !left.substring(Nl - maxLen, Nl).equals(right.substring(0, maxLen))) {
            maxLen--;
        }
        return maxLen;
    }
}
