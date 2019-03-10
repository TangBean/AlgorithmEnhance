package org.alg.tencent.prewrittenexam.test4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = in.nextInt();
        }
        System.out.println(blowBalloonsCount(colors, n, m));
    }

    private static int blowBalloonsCount(int[] colors, int n, int m) {
        int minCount = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        int begin = 0;
        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) {
                if (map.size() == m) {
//                    System.out.println(map);
                    while (colors[begin] == 0 || map.get(colors[begin]) > 1) {
                        if (colors[begin] == 0) continue;
                        map.put(colors[begin], map.get(colors[begin]) - 1);
                        begin++;
                    }
//                    System.out.println(map);
//                    System.out.println(begin + " " + i);
                    minCount = Math.min(minCount, i - begin);
                    map.remove(colors[begin++]);
                    if (colors[begin] == 0) {
                        begin++;
                    }
                }
                if (map.containsKey(colors[i])) {
                    map.put(colors[i], map.get(colors[i]) + 1);
                } else {
                    map.put(colors[i], 1);
                }
            }
        }
//        System.out.println(map);
//        System.out.println(begin + " " + n);
        if (map.size() == m) {
            while (colors[begin] == 0 || map.get(colors[begin]) > 1) {
                if (colors[begin] == 0) continue;
                map.put(colors[begin], map.get(colors[begin]) - 1);
                begin++;
            }
//            System.out.println(begin);
            minCount = Math.min(minCount, n - begin);
            map.remove(colors[begin++]);
            if (colors[begin] == 0) {
                begin++;
            }
        }
//        System.out.println(begin + " " + n);
        return (minCount != Integer.MAX_VALUE) ? minCount : -1;
    }
}
