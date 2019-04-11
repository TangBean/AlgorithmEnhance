package org.luogu.part1.ch4.p1046;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] treeHeight = new int[10];
        for (int i = 0; i < 10; i++) {
            treeHeight[i] = in.nextInt();
        }
        int taoHeight = 30 + in.nextInt();
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (taoHeight >= treeHeight[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
