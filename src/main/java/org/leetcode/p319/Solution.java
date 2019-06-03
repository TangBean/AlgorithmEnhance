package org.leetcode.p319;

public class Solution {
    public int bulbSwitch(int n) {
        int remain = 0;
        while ((remain + 1) * (remain + 1) <= n) {
            remain++;
        }
        return remain;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.bulbSwitch(9));
    }
}
