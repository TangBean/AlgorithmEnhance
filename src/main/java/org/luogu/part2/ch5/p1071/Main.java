package org.luogu.part2.ch5.p1071;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] map = new char[26];
        boolean[] msgMap = new boolean[26];
        boolean[] pwdMap = new boolean[26];
        char[] msgArr = in.next().toCharArray();
        char[] pwdArr = in.next().toCharArray();
        int count = 0;
        for (int i = 0; i < msgArr.length; i++) {
            if (!msgMap[msgArr[i] - 'A']) {
                if (pwdMap[pwdArr[i] - 'A']) {
                    System.out.println("Failed");
                    return;
                }
                map[msgArr[i] - 'A'] = pwdArr[i];
                msgMap[msgArr[i] - 'A'] = pwdMap[pwdArr[i] - 'A'] = true;
                count++;
            } else if (map[msgArr[i] - 'A'] != pwdArr[i]) {
                System.out.println("Failed");
                return;
            }
        }

        if (count != 26) {
            System.out.println("Failed");
            return;
        }

        char[] translateMsgArr = in.next().toCharArray();
        for (int i = 0; i < translateMsgArr.length; i++) {
            int curIndex = translateMsgArr[i] - 'A';
            if (map[curIndex] == 0) {
                System.out.println("Failed");
                return;
            } else {
                translateMsgArr[i] = map[curIndex];
            }
        }
        System.out.println(new String(translateMsgArr));
    }
}
