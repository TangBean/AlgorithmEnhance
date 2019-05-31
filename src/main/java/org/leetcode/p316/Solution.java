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
        int[] times = new int[26];
        for (int i = 0; i < sArr.length; i++) {
            times[sArr[i] - 'a']++;
        }
        boolean[] visited = new boolean[26];

        Stack<Character> stack = new Stack<>();
        char bottom = '0';
        stack.push(bottom);
        for (int i = 0; i < sArr.length; i++) {
            if (visited[sArr[i] - 'a'] && times[sArr[i] - 'a'] != 1) {
                continue;
            }
            visited[sArr[i] - 'a'] = true;
            while (stack.peek() != bottom && stack.peek() >= sArr[i]) {
                visited[stack.pop() - 'a'] = false;
            }
            if (times[sArr[i] - 'a'] == 1) {
                bottom = sArr[i];
            }
            stack.push(sArr[i]);
            times[sArr[i] - 'a']--;
        }

        char[] res = new char[stack.size() - 1];
        for (int i = stack.size() - 2; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String input = "cbacdcbc";
//        String input = "c";
//        String input = "ccacbaba";
//        String input = "abacb";
//        String input = "cbacdcbc";
        String input = "eywdgenmcnzhztolafcfnirfpuxmfcenlppegrcalgxjlajxmphwidqqtrqnmmbssotoywfrtylm";
        System.out.println(s.removeDuplicateLetters(input));
    }
}
