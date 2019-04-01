package org.luogu.part1.ch2.p1422;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        double money = 0;
        if (input > 400) {
            money += (input - 400) * 0.5663f;
            input = 400;
        }
        if (input > 150) {
            money += (input - 150) * 0.4663f;
            input = 150;
        }
        money += input * 0.4463f;
        System.out.printf("%.1f", money);
    }
}
