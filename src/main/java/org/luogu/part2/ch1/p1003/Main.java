package org.luogu.part2.ch1.p1003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] inData = new int[n][4];
        for (int i = 0; i < n; i++) {
            inData[i][0] = in.nextInt();
            inData[i][1] = in.nextInt();
            inData[i][2] = in.nextInt();
            inData[i][3] = in.nextInt();
        }
        int x = in.nextInt(), y = in.nextInt();
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (x >= inData[i][0] && x < inData[i][0] + inData[i][2]
                    && y >= inData[i][1] && y < inData[i][1] + inData[i][3]) {
                res = i + 1;
            }
        }
        System.out.println(res);
    }
}
