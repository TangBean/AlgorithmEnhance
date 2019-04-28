package org.luogu.part1.ch7.p2089;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 10 || n > 30) {
            System.out.println(0);
            return;
        }
        List<String> res = new ArrayList<>();
        plansHelper(n, 0, 0, new int[10], res);
        System.out.println(res.size());
        for (String r : res) {
            System.out.println(r);
        }
    }

    private static void plansHelper(int n, int curIndex, int curWeight, int[] curBasket, List<String> res) {
        if (curIndex == 9) {
            int tenthWeight = n - curWeight;
            if (tenthWeight >= 1 && tenthWeight <= 3) {
                StringBuilder curRes = new StringBuilder();
                for (int i = 0; i < 9; i++) {
                    curRes.append(curBasket[i]);
                    curRes.append(" ");
                }
                curRes.append(tenthWeight);
                res.add(curRes.toString());
            }
            return;
        }
        for (int cur = 1; cur <= 3; cur++) {
            curBasket[curIndex] = cur;
            plansHelper(n, curIndex + 1, curWeight + cur, curBasket, res);
        }
    }
}
