package org.luogu.part2.ch6.p1090;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(N, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < N; i++) {
            minHeap.offer(in.nextInt());
        }

        int cost = 0;
        while (minHeap.size() > 1) {
            int mergeCost = minHeap.poll() + minHeap.poll();
            cost += mergeCost;
            minHeap.offer(mergeCost);
        }
        System.out.println(cost);
    }
}
