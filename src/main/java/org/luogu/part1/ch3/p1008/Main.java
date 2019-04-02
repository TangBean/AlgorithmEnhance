package org.luogu.part1.ch3.p1008;

public class Main {
    public static void main(String[] args) {
        for (int i = 123; i < 333; i++) {
            if (isOkFirstNum(i)) {
                System.out.printf("%d %d %d\n", i, i << 1, i * 3);
            }
        }
    }

    private static boolean isOkFirstNum(int first) {
        int second = first << 1, third = first * 3;
        boolean[] map = new boolean[10];
        map[0] = true;
        return judgeNum(first, map) && judgeNum(second, map) && judgeNum(third, map);
    }

    private static boolean judgeNum(int num, boolean[] map) {
        for (int i = 0; i < 3; i++) {
            int cur = num % 10;
            if (map[cur]) {
                return false;
            }
            map[cur] = true;
            num /= 10;
        }
        return true;
    }
}
