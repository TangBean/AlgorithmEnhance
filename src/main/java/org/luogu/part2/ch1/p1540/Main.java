package org.luogu.part2.ch1.p1540;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt(), N = in.nextInt();
        HashSet<String> cacheSet = new HashSet<>();
        LinkedList<String> cacheList = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String word = in.next();
            if (!cacheSet.contains(word)) {
                count++;
                if (cacheList.size() >= M) {
                    String deleteEle = cacheList.removeFirst();
                    cacheSet.remove(deleteEle);
                }
                cacheSet.add(word);
                cacheList.add(word);
            }
        }
        System.out.println(count);
    }
}
