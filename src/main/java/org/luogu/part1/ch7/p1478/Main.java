package org.luogu.part1.ch7.p1478;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), s = in.nextInt();
        int maxH = in.nextInt() + in.nextInt();

        TreeMap<Integer, Integer> touchedApples = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int xi = in.nextInt(), yi = in.nextInt();
            if (xi <= maxH) {
                if (touchedApples.containsKey(yi)) {
                    touchedApples.put(yi, touchedApples.get(yi) + 1);
                } else {
                    touchedApples.put(yi, 1);
                }
            }
        }
        int appleCount = 0;
        for (Integer si : touchedApples.keySet()) {
            while (touchedApples.get(si) > 0 && (s -= si) >= 0) {
                appleCount++;
                touchedApples.put(si, touchedApples.get(si) - 1);
            }
            if (s <= 0) {
                break;
            }
        }
        System.out.println(appleCount);
    }
}
