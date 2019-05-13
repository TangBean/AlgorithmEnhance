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
            return this.score != o.score ? o.score - this.score : this.no_ - o.no_;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), R = in.nextInt(), Q = in.nextInt();
        Player[] players = new Player[2*N];
        for (int i = 1; i <= 2*N; i++) {
            players[i - 1] = new Player(i, in.nextInt(), 0);
        }
        for (int i = 0; i < 2 * N; i++) {
            players[i].weight = in.nextInt();
        }
        Arrays.sort(players);

        while (R-- > 0) {
            for (int i = 0; i < N; i++) {
                if (players[i].weight > players[N + i].weight) {
                    players[i].score++;
                } else {
                    players[N + i].score++;
                }
            }
            Arrays.sort(players);
        }
        System.out.println(players[Q - 1].no_);
    }
}
