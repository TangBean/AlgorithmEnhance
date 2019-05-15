package org.luogu.part2.ch4.p1309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
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
            return this.score != o.score ? this.score - o.score : o.no_ - this.no_;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), R = in.nextInt(), Q = in.nextInt();
        Player[] players = new Player[2 * N];
        for (int i = 1; i <= 2 * N; i++) {
            players[i - 1] = new Player(i, in.nextInt(), 0);
        }
        for (int i = 0; i < 2 * N; i++) {
            players[i].weight = in.nextInt();
        }
        Arrays.sort(players);
        Player[] win = new Player[N];
        Player[] lose = new Player[N];

        while (R-- > 0) {
            for (int i = 0; i < N; i ++) {
                if (players[2 * i].weight > players[2 * i + 1].weight) {
                    players[2 * i].score++;
                    win[i] = players[2 * i];
                    lose[i] = players[2 * i + 1];
                } else {
                    players[2 * i + 1].score++;
                    win[i] = players[2 * i + 1];
                    lose[i] = players[2 * i];
                }
            }
            merge(players, win, lose);
        }
        System.out.println(players[Q - 1].no_);
    }

    private static void merge(Player[] players, Player[] win, Player[] lose) {
        int i = 0, j = 0, N = win.length;
        for (int k = 0; k < players.length; k++) {
            if (i >= N) {
                players[k] = lose[j++];
            } else if (j >= N) {
                players[k] = win[i++];
            } else if (win[i].compareTo(lose[j]) > 0) {
                players[k] = win[i++];
            } else {
                players[k] = lose[j++];
            }
        }
    }

/*
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
        int len = mid - lo + 1;
        Player[] tmp = new Player[len];
        System.arraycopy(players, lo, tmp, 0, len);
        int i = 0, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i >= len) {
                players[k] = players[j++];
            } else if (j > hi) {
                players[k] = tmp[i++];
            } else if (tmp[i].compareTo(players[j]) < 0) {
                players[k] = tmp[i++];
            } else {
                players[k] = players[j++];
            }
        }
    }
*/
}
