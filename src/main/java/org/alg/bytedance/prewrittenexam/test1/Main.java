package org.alg.bytedance.prewrittenexam.test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = 1024 - in.nextInt();
        int count = 0;
        count += N >> 6;
        N &= 63;
        count += N >> 4;
        N &= 15;
        count += N >> 2;
        N &= 3;
        count += N;
        System.out.println(count);
    }
}
