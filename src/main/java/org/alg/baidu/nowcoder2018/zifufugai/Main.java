package org.alg.baidu.nowcoder2018.zifufugai;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 题目描述: 字符覆盖
 * 小度有一个小写字母组成的字符串s.字符串s已经被写在墙上了.
 * 小度还有很多卡片,每个卡片上有一个小写字母,组成一个字符串t。小度可以选择字符串t中任意一个字符,然后覆盖在字符串s的一个字符之上。
 * 小度想知道在选取一些卡片覆盖s的一些字符之后,可以得到的字典序最大的字符串是什么。
 *
 * 输入描述:
 * 输入包括两行,第一行一个字符串s,字符串s长度length(1 ≤ length ≤ 50),s中每个字符都是小写字母
 * 第二行一个字符串t,字符串t长度length(1 ≤ length ≤ 50),t中每个字符都是小写字母
 *
 * 输出描述:
 * 输出一个字符串,即可以得到的字典序最大字符串
 *
 * 示例1
 * 输入:
 * fedcba
 * ee
 *
 * 输出:
 * feeeba
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        String res = maxDicOrderStr(s, t);
        System.out.println(res);
    }

    private static String maxDicOrderStr(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);
        int i = 0, j = tArr.length - 1;
        while (i < sArr.length && j >= 0) {
            if (sArr[i] < tArr[j]) {
                sArr[i] = tArr[j];
                j--;
            }
            i++;
        }
        return new String(sArr);
    }
}
