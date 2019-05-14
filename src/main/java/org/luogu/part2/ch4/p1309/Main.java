package org.luogu.part2.ch4.p1309;

import java.util.Scanner;

public class Main {
    private static Player[] tmp;

    private static class Player implements Comparable<Player> {
        int no_;
        int score;
        int weight;

        public Player(int no_, int score, int weight) {
            this.no_ = no_;
            this.score = score;
            this.weight = weight;
        }

        @Override
        public int compareTo(Player o) {
            return this.score != o.score ? o.score - this.score : this.no_ - o.no_;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), R = in.nextInt(), Q = in.nextInt();
        Player[] players = new Player[2 * N];
        tmp = new Player[2 * N];
        for (int i = 1; i <= 2 * N; i++) {
            players[i - 1] = new Player(i, in.nextInt(), 0);
        }
        for (int i = 0; i < 2 * N; i++) {
            players[i].weight = in.nextInt();
        }
        mergeSort(players, 0, 2 * N - 1);

        while (R-- > 0) {
            for (int i = 0; i < 2 * N; i += 2) {
                if (players[i].weight > players[i + 1].weight) {
                    players[i].score++;
                } else {
                    players[i + 1].score++;
                }
            }
            mergeSort(players, 0, 2 * N - 1);
        }
        System.out.println(players[Q - 1].no_);
    }

    private static void mergeSort(Player[] players, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(players, lo, mid);
        mergeSort(players, mid + 1, hi);
        merge(players, lo, mid, hi);
    }

    private static void merge(Player[] players, int lo, int mid, int hi) {
        int len = hi - lo + 1;
        System.arraycopy(players, lo, tmp, lo, len);
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                players[k] = tmp[j++];
            } else if (j > hi) {
                players[k] = tmp[i++];
            } else if (tmp[i].compareTo(tmp[j]) < 0) {
                players[k] = tmp[i++];
            } else {
                players[k] = tmp[j++];
            }
        }
    }
}
