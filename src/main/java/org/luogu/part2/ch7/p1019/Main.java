package org.luogu.part2.ch7.p1019;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.Scanner;

/**
 * 要注意此题使用的是最小匹配原则，即 abababab 的自匹配为 ababab[ab]ababab，匹配的为中间的 ab！
 *
 * 解题思路：
 * 首先，这是一道 DFS 的题是肯定的了，重点在于这个前缀的保存问题，因为我们只需要得到最大的拼接长度，
 * 也就是说，我们不需要知道前缀是什么，只需要知道前缀的长度即可，
 * 所以，我们可以使用一个二维数组 overlap 来保存 words[k] 和 words[i] (i = 0~N) 的匹配前缀长度即可！
 */
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
        int maxLen = 1;
        int Nl = left.length(), Nr = right.length();
        int minLen = Math.min(Nl, Nr);
        while (maxLen < minLen && !left.substring(Nl - maxLen, Nl).equals(right.substring(0, maxLen))) {
            maxLen++;
        }
        return (maxLen == Nl || maxLen == Nr) ? 0 : maxLen;
    }
}
