package org.luogu.part2.ch4.p1051;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String bestName = "";
        int bestMoney = 0;
        int sumMoney = 0;
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String name = in.next();
            int meanScore = in.nextInt();
            int classScore = in.nextInt();
            boolean isLeader = in.next().equals("Y");
            boolean isWestern = in.next().equals("Y");
            int paperNum = in.nextInt();

            int money = 0;
            if (meanScore > 80 && paperNum > 0) {
                money += 8000;
            }
            if (meanScore > 85 && classScore > 80) {
                money += 4000;
            }
            if (meanScore > 90) {
                money += 2000;
            }
            if (isWestern && meanScore > 85) {
                money += 1000;
            }
            if (isLeader && classScore > 80) {
                money += 850;
            }

            if (money > bestMoney) {
                bestMoney = money;
                bestName = name;
            }
            sumMoney += money;
        }
        System.out.printf("%s\n%d\n%d", bestName, bestMoney, sumMoney);
    }
}
