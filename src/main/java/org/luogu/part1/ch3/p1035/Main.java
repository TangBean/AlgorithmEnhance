package org.luogu.part1.ch3.p1035;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double K = in.nextDouble();
        double n = 0;
        double Sn = 0;
        while (Sn <= K) {
            Sn += 1 / ++n;
        }
        System.out.println((int) n);
    }
}
