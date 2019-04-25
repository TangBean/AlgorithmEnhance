package org.luogu.part1.ch6.p1217;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        boolean[] prime = getPrimeList(a, b);
        for (int i = a; i <= b; i++) {
            if (prime[i - a] && isPalindromes(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean[] getPrimeList(int a, int b) {
        boolean[] prime = new boolean[b - a + 1];  // begin = a, end = b (include b)
        Arrays.fill(prime, true);

        int end = (int) Math.sqrt(b);
        boolean[] helper = new boolean[end + 1];  // begin = 2, end = end (include end)
        Arrays.fill(helper, true);

        for (int i = 2; i <= end; i++) {
            if (helper[i]) {
                for (int j = i << 1; j <= end; j += i) {
                    helper[j] = false;
                }
                for (int j = Math.max(2, (a + i - 1) / i) * i; j <= b; j += i) {
                    prime[j - a] = false;
                }
            }
        }
        return prime;
    }

    public static boolean isPalindromes(int num) {
        int x = num, reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse == num;
    }
}
