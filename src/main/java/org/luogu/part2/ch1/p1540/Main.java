package org.luogu.part2.ch1.p1540;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt(), N = in.nextInt();
        LinkedHashMap<String, String> cache = new LinkedHashMap<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String word = in.next();
            if (!cache.containsKey(word)) {
                count++;
                if (cache.size() >= M) {
                    // TODO
                }
            }
        }
        System.out.println(count);
    }
}
