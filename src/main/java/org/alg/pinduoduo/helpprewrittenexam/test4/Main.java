package org.alg.pinduoduo.helpprewrittenexam.test4;

import java.util.Scanner;

public class Main {
    private static long count = 0;
    private static int left = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        sortCount(str1.toCharArray(), 0, str2.toCharArray(), 0);
        System.out.println(count % 1000000007);
    }

    private static void sortCount(char[] str1, int s1, char[] str2, int s2) {
        if (s1 == str1.length && s2 == str2.length) {
            if (left == 0) {
                count++;
            }
            return;
        }
        if (s1 < str1.length) {
            if (str1[s1] == '(') {
                left++;
                sortCount(str1, s1 + 1, str2, s2);
                left--;
            } else {
                left--;
                if (left >= 0) {
                    sortCount(str1, s1 + 1, str2, s2);
                }
                left++;
            }
        }
        if (s2 < str2.length) {
            if (str2[s2] == '(') {
                left++;
                sortCount(str1, s1, str2, s2 + 1);
                left--;
            } else {
                left--;
                if (left >= 0) {
                    sortCount(str1, s1, str2, s2 + 1);
                }
                left++;
            }
        }
    }
}
