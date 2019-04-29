package org.luogu.part1.ch8.p1426;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double s = in.nextInt(), x = in.nextInt();
        double site = 0, speed = 7;
        while (site < s - x) {
            site += speed;
            speed *= 0.98;
        }
        if (speed > s + x - site) {
            System.out.println("n");
        } else {
            System.out.println("y");
        }
    }
}
