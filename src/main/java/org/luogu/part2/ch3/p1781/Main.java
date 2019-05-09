package org.luogu.part2.ch3.p1781;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int no_ = 0;
        BigInteger votes = new BigInteger("0");
        for (int i = 1; i <= n; i++) {
            BigInteger cur = new BigInteger(in.next());
            if (cur.compareTo(votes) == 1) {
                no_ = i;
                votes = cur;
            }
        }
        System.out.println(no_);
        System.out.println(votes);
    }
}
