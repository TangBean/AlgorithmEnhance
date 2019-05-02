package org.luogu.part1.ch8.p1307;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int flag = 1;
        if (num < 0) {
            flag = -1;
            num = -num;
        }
        int res = 0;
        while (num > 0) {
            res = 10 * res + num % 10;
            num /= 10;
        }
        System.out.println(res * flag);
    }
}
