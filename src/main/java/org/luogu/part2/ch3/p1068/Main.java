package org.luogu.part2.ch3.p1068;

import java.util.*;

public class Main {
    private static class Examinee {
        int no_;
        int score;

        public Examinee(int no_, int score) {
            this.no_ = no_;
            this.score = score;
        }

        @Override
        public String toString() {
            return this.no_ + " " + this.score;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = (int) (in.nextInt() * 1.5);

        PriorityQueue<Examinee> passer = new PriorityQueue<>(m, new Comparator<Examinee>() {
            @Override
            public int compare(Examinee o1, Examinee o2) {
                return (o1.score == o2.score) ? o1.no_ - o2.no_ : o2.score - o1.score;
            }
        });
        for (int i = 0; i < n; i++) {
            passer.offer(new Examinee(in.nextInt(), in.nextInt()));
        }

        List<Examinee> passerList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            passerList.add(passer.poll());
        }
        while (passer.peek().score == passerList.get(m - 1).score) {
            passerList.add(passer.poll());
        }

        int nums = passerList.size();
        System.out.println(passerList.get(nums - 1).score + " " + nums);
        for (Examinee examinee : passerList) {
            System.out.println(examinee);
        }
    }
}
