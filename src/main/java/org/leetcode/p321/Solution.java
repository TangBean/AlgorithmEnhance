package org.leetcode.p321;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * DFS will TLE, need another method.
 */
public class Solution {
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
        int N = nums1.length, M = nums2.length;
        int[] res = new int[k];
        for (int i = 0; i <= k; i++) {
            int j = k - i;
            if (i > N || j > M) {
                continue;
            }
            int[] first = maxKNums(nums1, i);
            int[] second = maxKNums(nums2, j);
            int[] cur = merge(first, second);
            if (comparator.compare(cur, res) > 0) {
                res = cur;
            }
        }
        return res;
    }

    private int[] maxKNums(int[] nums, int k) {
        int[] res = new int[k];
        Arrays.fill(res, -1);
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums.length - i > k - j && j > 0 && res[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int N = nums1.length, M = nums2.length;
        int[] res = new int[N + M];
        int i = 0, j = 0;
        for (int k = 0; k < N + M; k++) {
            if (i >= N) {
                res[k] = nums2[j++];
            } else if (j >= M) {
                res[k] = nums1[i++];
            } else {
                if (nums1[i] > nums2[j]) {
                    res[k] = nums1[i++];
                } else {
                    res[k] = nums2[j++];
                }
            }
        }
        return res;
    }

/* DFS method, TLE.
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        maxRes = new int[k];
        int[] curNums = new int[k];
        dfs(nums1, 0, nums2, 0, k, 0, curNums);
        return maxRes;
    }

    public void dfs(int[] nums1, int i1, int[] nums2, int i2, int k, int curK, int[] curNums) {
        if (nums1.length + nums2.length - i1 - i2 < k - curK) {
            return;
        }
        if (curK == k) {
//            System.out.println(Arrays.toString(curNums));
            if (comparator.compare(curNums, maxRes) > 0) {
                maxRes = new int[k];
                System.arraycopy(curNums, 0, maxRes, 0, k);
            }
            return;
        }

        if (i1 == nums1.length) {
            dfs(nums1, i1, nums2, i2 + 1, k, curK, curNums);
            curNums[curK] = nums2[i2];
            dfs(nums1, i1, nums2, i2 + 1, k, curK + 1, curNums);
        } else if (i2 == nums2.length) {
            dfs(nums1, i1 + 1, nums2, i2, k, curK, curNums);
            curNums[curK] = nums1[i1];
            dfs(nums1, i1 + 1, nums2, i2, k, curK + 1, curNums);
        } else {
            dfs(nums1, i1 + 1, nums2, i2, k, curK, curNums);
            curNums[curK] = nums1[i1];
            dfs(nums1, i1 + 1, nums2, i2, k, curK + 1, curNums);
            dfs(nums1, i1, nums2, i2 + 1, k, curK, curNums);
            curNums[curK] = nums2[i2];
            dfs(nums1, i1, nums2, i2 + 1, k, curK + 1, curNums);
        }
    }*/

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] nums1 = {3, 4, 6, 5};
//        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int[] nums1 = {6, 7};
        int[] nums2 = {6, 0, 4};
        int k = 5;
        int[] res = s.maxNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(res));
    }
}
