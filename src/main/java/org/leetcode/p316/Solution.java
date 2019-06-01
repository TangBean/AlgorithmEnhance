package org.leetcode.p316;

import java.util.*;

/**
 * 解题思路：
 * - 使用 Stack
 * - 如果当前元素已经访问过了，就将它的次数 -1，然后跳过
 * - 如果当前元素还没有被访问，看看栈中有没有比当前元素小，并且处于待定状态（次数 != 0 的元素）的元素，
 *   如果有，说明下一个位置不取这个元素，将它 pop 出去，等到之后再遇到它，要记得将它的 visited 状态修改为 false
 * - 将当前的元素 push 到栈中，并更新它的 times 和 visited
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
            if (visited[sArr[i] - 'a']) {
                times[sArr[i] - 'a']--;
                continue;
            }
            while (stack.peek() != bottom && stack.peek() > sArr[i] && times[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(sArr[i]);
            times[sArr[i] - 'a']--;
            visited[sArr[i] - 'a'] = true;
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
