package org.alg.pinduoduo.helpprewrittenexam.test2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] str = in.nextLine().toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            char cur = str[i];
            if ('A' <= str[i] && str[i] <= 'Z') {
                cur += 'a' - 'A';
            }
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
            str[i] = cur;
        }

        char res = 'z';
        for (int i = 0; i < str.length; i++) {
            if (str[i] < res) {
                res = str[i];
            }
            if (map.get(str[i]) > 1) {
                map.put(str[i], map.get(str[i]) - 1);
            } else {
                break;
            }
        }
        System.out.println(res);
    }
}
