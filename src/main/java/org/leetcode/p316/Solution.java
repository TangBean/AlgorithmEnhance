package org.leetcode.p316;

import java.util.*;

/**
 * 全排列的非递归和递归解法：https://www.cnblogs.com/pmars/p/3458289.html
 *
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        char[] sArr = s.toCharArray();

        // 先统计所有出现过的字符的个数
        int resLen = 0;
        int[] times = new int[26];
        for (int i = 0; i < sArr.length; i++) {
            int curI = sArr[i] - 'a';
            if (times[curI] == 0) {
                resLen++;
            }
            times[curI]++;
        }

        char[] res = new char[resLen];
        Deque<Character> suspend = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < sArr.length && j < resLen; i++) {
            times[sArr[i] - 'a']--;
            if (times[sArr[i] - 'a'] == 0) {
                while (!suspend.isEmpty()) {
                    char tmp = suspend.poll();
                    if (tmp < sArr[i]) {
                        res[j++] = tmp;
                    }
                }
                res[j++] = sArr[i];
                continue;
            }
            while (!suspend.isEmpty() && suspend.peekLast() >= sArr[i]) {
                suspend.pollLast();
            }
            suspend.offer(sArr[i]);
        }
        while (!suspend.isEmpty()) {
            res[j++] = suspend.poll();
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String input = "cbacdcbc";
//        String input = "c";
        String input = "ccacbaba";
        System.out.println(s.removeDuplicateLetters(input));
    }
}
