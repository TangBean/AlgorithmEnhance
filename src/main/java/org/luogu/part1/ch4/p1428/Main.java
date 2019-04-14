package org.luogu.part1.ch4.p1428;

import java.util.Scanner;

/**
 * 归并排序求逆序对 + 把输入数据用一个类包装一下（因为需要额外记录每个输入数据在输入数组中的位置）
 */
public class Main {
    private static ValueWithIndex[] cuteNum;
    private static ValueWithIndex[] mergeHelper;
    private static int[] cuteCount;

    private static class ValueWithIndex {
        int val;
        int index;

        ValueWithIndex(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        cuteNum = new ValueWithIndex[n];
        for (int i = 0; i < n; i++) {
            cuteNum[i] = new ValueWithIndex(in.nextInt(), i);
        }
        mergeHelper = new ValueWithIndex[n];
        cuteCount = new int[n];
        sort(0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(cuteCount[i] + " ");
        }
    }

    private static void sort(int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(lo, mid);
        sort(mid+1, hi);
        merge(lo, mid, hi);
    }

    private static void merge(int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        System.arraycopy(cuteNum, lo, mergeHelper, lo, hi + 1 - lo);
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                cuteNum[k] = mergeHelper[j++];
            } else if (j > hi) {
                cuteNum[k] = mergeHelper[i++];
            } else if (mergeHelper[i].val >= mergeHelper[j].val) {
                cuteNum[k] = mergeHelper[i++];
            } else {
                cuteCount[mergeHelper[j].index] += mid - i + 1;  // 只有这一处逆序对的数量会发生变化
                cuteNum[k] = mergeHelper[j++];
            }
        }
    }
}
