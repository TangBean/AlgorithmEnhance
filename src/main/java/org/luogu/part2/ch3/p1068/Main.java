package org.luogu.part2.ch3.p1068;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

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
                return (o1.score == o2.score) ? o2.no_ - o1.no_ : o1.score - o2.score;
            }
        });
        for (int i = 0; i < n; i++) {
            int cur_no_ = in.nextInt(), cur_score = in.nextInt();
            if (passer.size() < m) {
                passer.offer(new Examinee(cur_no_, cur_score));
            }
            else {
                if (cur_score > passer.peek().score) {
                    passer.poll();
                    passer.offer(new Examinee(cur_no_, cur_score));
                } else if (cur_score == passer.peek().score) {
                    passer.offer(new Examinee(cur_no_, cur_score));
                }
            }
        }

        int nums = passer.size();
        Examinee[] passerList = new Examinee[nums];
        for (int i = nums - 1; i >= 0; i--) {
            passerList[i] = passer.poll();
        }

        System.out.println(passerList[nums - 1].score + " " + nums);
        for (int i = 0; i < nums; i++) {
            System.out.println(passerList[i]);
        }
    }
}
