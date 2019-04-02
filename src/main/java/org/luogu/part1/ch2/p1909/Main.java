package org.luogu.part1.ch2.p1909;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble(); // 要用 double 类型接！不然后面 Math.ceil 会自动取整 ...
        int money = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int num = in.nextInt();
            int price = in.nextInt();
            int moneyNeed = (int) Math.ceil(n / num) * price;
            money = Math.min(money, moneyNeed);
        }
        System.out.println(money);
    }
}
