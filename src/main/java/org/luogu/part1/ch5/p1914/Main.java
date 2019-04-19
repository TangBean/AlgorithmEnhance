package org.luogu.part1.ch5.p1914;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String pwd = in.next();
        int a = (int) 'a';
        for (char c : pwd.toCharArray()) {
            int m = (((int) c - a) + n) % 26;
            char r = (char) (m + a);
            System.out.print(r);
        }
    }
}
