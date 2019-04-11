package org.luogu.part1.ch4.p1047;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
            int loIndex = 0, hiIndex = subway.size() - 1;
            int index = 0;
            while (index < subway.size()) {
                int[] interval = subway.get(index);
                if (lo <= interval[1]) {
                    if (lo < interval[0]) {
                        interval[0] = lo;
                    }
                    break;
                }
                index++;
            }
            while (index < subway.size()) {
                int[] interval = subway.get(index);
                if (hi < interval[0]) {
                    if (hi > subway.get(index - 1)[1]) {
                        subway.get(index - 1)[1] = hi;
                        break;
                    }
                }
                index++;
            }
        }
        for (int[] interval : subway) {
            L -= interval[1] - interval[0] + 1;
        }
        System.out.println(L);
    }
}
