package org.luogu.part1.ch4.p1047;

import java.util.*;

/**
 * 这道题本质上讲是一道区间合并的题
 * 1. 先对输入的区间按照区间的开始点进行排序
 * 2. 对已排好序的区间进行合并，合并原则：
 *     1. subway[i][1] < subway[i+1][0]
 *         - 当前区间不与下一个区间重合，当前区间已经结束，直接跳到下一区间即可
 *         - i++
 *     2. subway[i+1][0] <= subway[i][1] < subway[i+1][1]
 *         - 下一个区间的范围超过了当前区间，将当前区间的结束点设置为下一个区间的结束点，并将下一个区间删除
 *         - subway[i][1] = subway[i+1][1]
 *           subway.remove(i+1)
 *     3. subway[i][1] >= subway[i+1][1]
 *         - 当前区间完全包括了下一个区间，直接将下一个区间移除即可
 *         - subway.remove(i+1)
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt() + 1;
        int M = in.nextInt();
        LinkedList<int[]> subway = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            subway.add(new int[]{in.nextInt(), in.nextInt()});
        }
        subway.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        while (i < subway.size() - 1) {
            if (subway.get(i)[1] >= subway.get(i + 1)[1]) {
                subway.remove(i + 1);
            } else if (subway.get(i)[1] >= subway.get(i + 1)[0]) {
                subway.get(i)[1] = subway.get(i + 1)[1];
                subway.remove(i + 1);
            } else {
                i++;
            }
        }
        for (int[] interval : subway) {
            L -= interval[1] - interval[0] + 1;
        }
        System.out.println(L);
    }
}
