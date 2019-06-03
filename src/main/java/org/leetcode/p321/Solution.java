package org.leetcode.p321;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    private int[] maxRes = null;

    private Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            for (int i = 0; i < o1.length; i++) {
                if (o1[i] < o2[i]) {
                    return -1;
                } else if (o1[i] > o2[i]) {
                    return 1;
                }
            }
            return 0;
        }
    };

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        maxRes = new int[k];
        int[] curNums = new int[k];
        dfs(nums1, 0, nums2, 0, k, 0, curNums);
        return maxRes;
    }

    public void dfs(int[] nums1, int i1, int[] nums2, int i2, int k, int curK, int[] curNums) {
        if (curK == k) {
            if (comparator.compare(curNums, maxRes) > 0) {
                maxRes = new int[k];
                System.arraycopy(curNums, 0, maxRes, 0, k);
            }
        }

        curNums[curK] = nums1[i1];
        dfs(nums1, i1 + 1, nums2, i2, k, curK + 1, curNums);
        curNums[curK] = nums2[i2];
        dfs(nums1, i1, nums2, i2 + 1, k, curK + 1, curNums);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        int[] res = s.maxNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(res));
    }
}
