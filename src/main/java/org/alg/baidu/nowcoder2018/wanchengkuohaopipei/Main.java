package org.alg.baidu.nowcoder2018.wanchengkuohaopipei;

import java.util.Scanner;

/**
 * 题目：完成括号匹配
 * 牛牛现在给出一个括号序列s,牛牛允许你执行的操作是:在s的开始和结尾处添加一定数量的左括号('[')或者右括号(']')
 * 使其变为一个合法的括号匹配序列。牛牛希望你能求出添加最少的括号之后的合法的括号匹配序列是什么。
 *
 * 输入描述:
 * 输入包括一个字符串s,s的长度length(1 ≤ length ≤ 50),s中只包含'['和']'。
 * 输出描述:
 * 输出一个字符串,表示括号完全匹配的序列。
 *
 * 示例1
 * 输入：
 * ][
 * 输出：
 * [][]
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String output = getLegalOutput(input);
        System.out.println(output);
    }

    private static String getLegalOutput(String input) {
        StringBuilder res = new StringBuilder(input);
        int cur = 0;
        int left = 0;
        char[] inputArr = input.toCharArray();
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == '[') {
                cur++;
            } else {
                cur--;
            }
            if (cur < left) {
                left = cur;
            }
        }
        while (left < 0) {
            res.insert(0, '[');
            left++;
        }

        cur = 0;
        int right = 0;
        for (int i = inputArr.length - 1; i >= 0; i--) {
            if (inputArr[i] == ']') {
                cur++;
            } else {
                cur--;
            }
            if (cur < right) {
                right = cur;
            }
        }
        while (right < 0) {
            res.append(']');
            right++;
        }
        return res.toString();
    }
}
