package org.alg.baidu.nowcoder2018.zifuchuanpipei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 题目：字符串匹配
 * 牛牛有两个字符串 A 和 B，其中 A 串是一个 01 串，B 串中除了可能有 0 和 1，还可能有 '?'，B 中的 '?' 可以确定为 0 或者 1。
 * 寻找一个字符串 T 是否在字符串 S 中出现的过程，称为字符串匹配。牛牛现在考虑所有可能的字符串 B，有多少种可以在字符串 A 中完成匹配。
 * 例如:A = "00010001", B = "??"
 * 字符串 B 可能的字符串是 "00", "01", "10", "11"，只有 "11" 没有出现在字符串 A 中，所以输出 3
 *
 * 输入：
 * 输入包括两行,第一行一个字符串A,字符串A长度length(1 ≤ length ≤ 50),A中每个字符都是'0'或者'1'。
 * 第二行一个字符串B,字符串B长度length(1 ≤ length ≤ 50),B中的字符包括'0','1'和'?'。
 *
 * 输出：
 * 输出一个整数,表示能完成匹配的字符串种数。
 *
 * 示例 1：
 * 输入：
 * 00010001
 * ??
 *
 * 输出：
 * 3
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.next();
        String B = in.next();
        int count = matchCount(A, B);
        System.out.println(count);
    }

    private static int matchCount(String a, String b) {
        if (a.length() < b.length()) {
            return 0;
        }
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        HashSet<String> resSet = new HashSet<>();
        for (int lo = 0, hi = lo + bArr.length; hi <= aArr.length; lo++, hi++) {
            String aSubStr = a.substring(lo, hi);
            if (isMatched(aSubStr, b)) {
                resSet.add(aSubStr);
            }
        }
        return resSet.size();
    }

    private static boolean isMatched(String strA, String strB) {
        char[] aArr = strA.toCharArray();
        char[] bArr = strB.toCharArray();
        for (int i = 0; i < aArr.length; i++) {
            if (bArr[i] != '?' && aArr[i] != bArr[i]) {
                return false;
            }
        }
        return true;
    }
}
