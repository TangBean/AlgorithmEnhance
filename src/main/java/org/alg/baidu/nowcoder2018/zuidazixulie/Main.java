package org.alg.baidu.nowcoder2018.zuidazixulie;

import java.util.Scanner;

/**
 * 题目描述: 最大子序列
 * 对于字符串x和y, 如果擦除x中的某些字母(有可能全擦掉或者都不擦)能够得到y,我们就称y是x的子序列。
 * 例如."ncd"是"nowcoder"的子序列,而"xt"不是。
 * 现在对于给定的一个字符串s,请计算出字典序最大的s的子序列。
 *
 * 输入描述:
 * 输入包括一行,一个字符串s,字符串s长度length(1 ≤ length ≤ 50).
 * s中每个字符都是小写字母
 *
 * 输出描述:
 * 输出一个字符串,即字典序最大的s的子序列。
 *
 * 示例1:
 * 输入:
 * test
 *
 * 输出:
 * tt
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        StringBuilder res = new StringBuilder();
        maxSubSeq(s, res);
        System.out.println(res.toString());
    }

    private static void maxSubSeq(String s, StringBuilder res) {
        if (s.length() == 0) {
            return;
        }
        char[] sArr = s.toCharArray();
        int maxIndex = 0;
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[maxIndex] < sArr[i]) {
                maxIndex = i;
            }
        }
        res.append(sArr[maxIndex]);
        maxSubSeq(s.substring(maxIndex + 1, s.length()), res);
    }
}
