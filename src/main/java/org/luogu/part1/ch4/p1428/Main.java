package org.luogu.part1.ch4.p1428;

import java.util.Scanner;

/**
 * 逆序对！
 */
public class Main {
    private static int[] cuteNum;
    private static int[] mergeHelper;
    private static int[] cuteCount;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        cuteNum = new int[n];
        for (int i = 0; i < n; i++) {
            cuteNum[i] = in.nextInt();
        }
        mergeHelper = new int[n];
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
        for (int k = lo; k <= hi; k++) {
            mergeHelper[k] = cuteNum[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                cuteNum[k] = mergeHelper[j++];
            } else if (j > hi) {
                cuteCount[i]++;
                cuteNum[k] = mergeHelper[i++];
            } else if (mergeHelper[i] <= mergeHelper[j]) {
                cuteNum[k] = mergeHelper[i++];
            } else {
                cuteCount[j]++;
                cuteNum[k] = mergeHelper[j++];
            }
        }
    }
}
