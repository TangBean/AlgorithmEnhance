package org.luogu.part1.ch4.p1047;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 本质上说，有 3 种可能：
 * 1. 新加入的区间包含在原来的区间中，无需改变 subway 区间集合
 * 2. 新加入的区间是一个独立的区间，把它插入 subway 区间即可
 * 3. 新加入的区间横跨了 subway 区间，subway 区间需要进行区间合并（最难处理！）
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt() + 1;
        int M = in.nextInt();
        LinkedList<int[]> subway = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            int lo = in.nextInt(), hi = in.nextInt();
            if (subway.isEmpty() || lo > subway.getLast()[1]) {
                subway.add(new int[]{lo, hi});
                continue;
            }
            if (lo >= subway.getLast()[0] && hi > subway.getLast()[1]) {
                subway.getLast()[1] = hi;
                continue;
            }

            int j = 0;
            while (j < subway.size() - 1 && lo < subway.get(j + 1)[0]) {
                j++;
            }
            if (lo > subway.get(j)[1] && hi < subway.get(j + 1)[0]) {
                subway.add(j + 1, new int[]{lo, hi});
                continue;
            }
            if (hi > subway.get(j)[1]) {
                subway.get(j++)[1] = hi;
            }
            while (j < subway.size() && subway.get(j)[1] <= hi) {
                subway.remove(j);
            }
            if (j != subway.size() && hi >= subway.get(j)[0]) {
                subway.get(j - 1)[1] = subway.get(j)[1];
                subway.remove(j);
            }
        }
        for (int[] interval : subway) {
            L -= interval[1] - interval[0] + 1;
        }
    }
}
