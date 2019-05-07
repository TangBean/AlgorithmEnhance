package org.luogu.part2.ch1.p1056;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt(), N = in.nextInt();
        int K = in.nextInt(), L = in.nextInt();
        int D = in.nextInt();

        HashMap<Integer, Integer> KMap = new HashMap<>();
        HashMap<Integer, Integer> LMap = new HashMap<>();

        for (int i = 0; i < D; i++) {
            int x1 = in.nextInt(), y1 = in.nextInt();
            int x2 = in.nextInt(), y2 = in.nextInt();
            if (y1 == y2) {
                int separate = Math.min(x1, x2);
                if (KMap.containsKey(separate)) {
                    KMap.put(separate, KMap.get(separate) + 1);
                } else {
                    KMap.put(separate, 1);
                }
            } else {
                int separate = Math.min(x1, x2);
                if (LMap.containsKey(separate)) {
                    LMap.put(separate, LMap.get(separate) + 1);
                } else {
                    LMap.put(separate, 1);
                }
            }
        }

        List<Map.Entry<Integer, Integer>> KList = new ArrayList<>(KMap.entrySet());
        List<Map.Entry<Integer, Integer>> LList = new ArrayList<>(LMap.entrySet());
        KList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        LList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        TreeSet<Integer> KRes = new TreeSet<>();
        TreeSet<Integer> LRes = new TreeSet<>();
        for (int k = 0; k < K; k++) {
            KRes.add(KList.get(k).getKey());
        }
        for (int l = 0; l < L; l++) {
            LRes.add(LList.get(l).getKey());
        }

        for (int k : KRes) {
            System.out.print(k + " ");
        }
        System.out.println();
        for (int l : LRes) {
            System.out.print(l + " ");
        }
    }
}
