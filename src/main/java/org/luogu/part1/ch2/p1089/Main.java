package org.luogu.part1.ch2.p1089;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int money = 0;
        int mom = 0;
        for (int i = 1; i <= 12; i++) {
            money += 300;
            int cur = in.nextInt();
            if (money < cur) {
                System.out.print(-i);
                return;
            }
            money -= cur;
            if (money / 100 > 0) {
                int curMom = money / 100 * 100;
                mom += curMom;
                money -= curMom;
            }
        }
        int remain = (int) (mom * 1.2f) + money;
        System.out.print(remain);
    }
}
