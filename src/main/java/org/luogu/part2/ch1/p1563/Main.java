package org.luogu.part2.ch1.p1563;

import java.util.Scanner;

public class Main {
    private static class Description {
        int direct;
        String job;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        Description[] guys = new Description[n];
        for (int i = 0; i < n; i++) {
            guys[i] = new Description();
            guys[i].direct = in.nextInt();
            guys[i].job = in.next();
        }

        int cur = 0;
        for (int i = 0; i < m; i++) {
            int a = in.nextInt(), s = in.nextInt();
            if (guys[cur].direct == 0) {
                if (a == 0) {
                    cur = Math.floorMod(cur - s, n);
                } else {
                    cur = Math.floorMod(cur + s, n);
                }
            } else {
                if (a == 0) {
                    cur = Math.floorMod(cur + s, n);
                } else {
                    cur = Math.floorMod(cur - s, n);
                }
            }
        }
        System.out.println(guys[cur].job);
    }
}
