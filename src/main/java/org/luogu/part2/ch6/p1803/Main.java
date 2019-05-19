package org.luogu.part2.ch6.p1803;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] contests = new int[N][2];
        for (int i = 0; i < N; i++) {
            contests[i][0] = in.nextInt();
            contests[i][1] = in.nextInt();
        }
        // 先对所有比赛的开始时间排个序
        Arrays.sort(contests, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int joinCnt = 0;
        int lastEnd = 0;  // 记录上一次比赛的结束时间
        for (int i = 0; i < N; i++) {
            if (contests[i][0] >= lastEnd) {
                // 当前比赛的开始时间晚于上一场比赛，可参加，更新 lastEnd
                lastEnd = contests[i][1];
                joinCnt++;
            } else {
                // 当前比赛与上一场比赛时间冲突，参加结束时间早的比赛
                if (contests[i][1] < lastEnd) {
                    lastEnd = contests[i][1];
                }
            }
        }
        System.out.println(joinCnt);
    }
}
