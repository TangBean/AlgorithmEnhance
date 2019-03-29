package org.alg.baidu.nowcoder2018.zhengsanjiaoxing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        double[] input = new double[4];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 4; j++) {
                input[j] = in.nextDouble();
            }
            double[] output = getThirdPoints(input);
            System.out.printf("%.2f %.2f %.2f %.2f", output[0], output[1], output[2], output[3]);
        }
    }

    private static double[] getThirdPoints(double[] input) {

    }
}
