package org.alg.tencent.prewrittenexam.test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int count = m / n;
        count = (m % n == 0) ? count : count + 1;
        System.out.println(count);
    }
}
