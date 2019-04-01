package org.luogu.part1.ch1.p1421;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        while (b >= 0.999999999999) {
            b /= 10;
        }
        double money = a + b;
        int num = (int) (money / 1.9);
        System.out.println(num);
    }
}
