package org.luogu.part1.ch5.p1200;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String star = in.next();
        String group = in.next();
        int starNum = 1, groupNum = 1;
        for (char s : star.toCharArray()) {
            starNum *= (int) (s - 'A') + 1;
        }
        for (char s : group.toCharArray()) {
            groupNum *= (int) (s - 'A') + 1;
        }
        if (starNum % 47 == groupNum % 47) {
            System.out.println("GO");
        } else {
            System.out.println("STAY");
        }
    }
}
