package org.luogu.part1.ch3.p1423;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double distance = in.nextDouble();
        double reachDis = 0.0;
        int step = 1;
        double stepLen = 2.0;
        while ((reachDis += stepLen) < distance) {
            step++;
            stepLen *= 0.98;
        }
        System.out.println(step);
    }
}
