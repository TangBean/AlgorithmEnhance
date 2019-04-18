package org.luogu.part1.ch5.p1308;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine().toLowerCase();
        String article = in.nextLine();
        String[] words = article.split(" ");
        int firstIndex = 0;
        int i = 0;
        for (; i < words.length; i++) {
            if (words[i].toLowerCase().equals(word)) {
                break;
            }
            firstIndex += words[i].length() + 1;
        }
        if (i == words.length) {
            System.out.println(-1);
            return;
        }
        int count = 1;
        for (i += 1; i < words.length; i++) {
            if (words[i].toLowerCase().equals(word)) {
                count++;
            }
        }
        System.out.println(count + " " + firstIndex);
    }
}
