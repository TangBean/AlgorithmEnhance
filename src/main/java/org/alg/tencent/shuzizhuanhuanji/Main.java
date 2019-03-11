package org.alg.tencent.shuzizhuanhuanji;

import java.util.Scanner;

/**
 * 题目链接：https://www.nowcoder.com/practice/e870b63e149341c8b6441bc9ebf963d6?tpId=90&tqId=30957&tPage=10&rp=10&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 *
 * 题目描述：
 * 小Q从牛博士那里获得了一个数字转换机，这台数字转换机必须同时输入两个正数a和b，并且这台数字转换机有一个红色的按钮和一个蓝色的按钮：
 * 当按下了红色按钮，两个数字同时加1。
 * 当按下了蓝色按钮，两个数字同时乘2。
 * 小Q现在手中有四个整数a，b，A，B，他希望将输入的两个整数a和b变成A，B（a对应A，b对应B）。
 * 因为牛博士允许小Q使用数字转换机的时间有限，所以小Q希望按动按钮的次数越少越好。请你帮帮小Q吧。
 *
 * 输入：
 * 输入包括一行，一行中有四个正整数a，b，A，B，（1≤a，b，A，B≤10^9）。
 *
 * 输出：
 * 如果小Q可以完成转换，输出最少需要按动按钮的次数，否则输出-1。
 *
 * 参考思路：(未写)
 * 先取两者各自相除和取余。相等则继续，否则直接 -1 结束；(注意这个判断方法！)
 */
public class Main {
    private static boolean succeed = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        int count = operationCount(a, b, A, B);
        if (succeed) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    private static int operationCount(int a, int b, int A, int B) {
        if (a == A && b == B) {
            succeed = true;
            return 0;
        }
        if (!(a < A && b < B)) {
            return 0;
        }
        if (((A & 1) == 1 && (B & 1) == 0) || ((A & 1) == 0 && (B & 1) == 1)) {
            if (B - b == A - a) {
                succeed = true;
                return A - a;
            } else {
                return 0;
            }
        }
        if ((A & 1) == 0 && (B & 1) == 0) {
            if ((a * 2 <= A) && (b * 2 <= B)) {
                return operationCount(a, b, A / 2, B / 2) + 1;
            } else {
                if (B - b == A - a) {
                    succeed = true;
                    return A - a;
                } else {
                    return 0;
                }
            }
        }
        return operationCount(a, b, A - 1, B - 1) + 1;
    }
}
