package org.leetcode.p316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 全排列非递归和递归解法：https://www.cnblogs.com/pmars/p/3458289.html
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if (map.containsKey(sArr[i])) {
                map.get(sArr[i]).add(i);
            } else {
                map.put(sArr[i], new ArrayList<>(Arrays.asList(i)));
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicateLetters("cbacdcbc"));
    }
}
