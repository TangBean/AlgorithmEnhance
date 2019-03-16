package org.alg.bytedance.prewrittenexam.test2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = in.next();
        }
        for (int i = 0; i < N; i++) {
            System.out.println(fixStr(strs[i]));
        }
    }

    private static String fixStr(String beforeStr) {
        if (beforeStr.length() < 3) {
            return beforeStr;
        }
        StringBuilder sb = new StringBuilder(beforeStr);
        int i = 0;
        while (i < sb.length() - 2) {
            if (sb.charAt(i) != sb.charAt(i + 1)) {
                i++;
                continue;
            }
            while (i < sb.length() - 2 && sb.charAt(i) == sb.charAt(i + 2)) {
                sb.deleteCharAt(i + 2);
            }
            while (i < sb.length() - 3 && sb.charAt(i + 2) == sb.charAt(i + 3)) {
                sb.deleteCharAt(i + 3);
            }
            i += 2;
        }
        return sb.toString();
    }
}
