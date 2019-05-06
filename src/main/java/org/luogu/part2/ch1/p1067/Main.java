package org.luogu.part2.ch1.p1067;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean isFirst = true;
        for (int i = 0; i < n; i++) {
            int coefficient = in.nextInt();
            if (coefficient == 0) {
                continue;
            }
            if (isFirst) {
                isFirst = false;
            } else {
                if (coefficient > 0) {
                    System.out.print("+");
                }
            }
            if (coefficient < 0) {
                System.out.print("-");
                coefficient = -coefficient;
            }
            if (coefficient != 1) {
                System.out.print(coefficient);
            }
            if (n - i > 1) {
                System.out.printf("x^%d", n - i);
            } else {
                System.out.print("x");
            }
        }
        int coefficient = in.nextInt();
        if (coefficient > 0) {
            System.out.println("+" + coefficient);
        } else if (coefficient < 0) {
            System.out.println(coefficient);
        }
    }
}
