package org.luogu.part2.ch5.p1603;

import java.util.*;

public class Main {
    // 构建 dic：平方直接算好，用两个 array 提前准备好 dic 的 key 和 val，然后直接 put 进 map 即可
    // 注意 val 不用 int 存，用 String，反正后面用的时候用的也是 String，而且存 String 可以处理 00, 01, 04 等以 0 开头的情况
    private static final String[] DIC_KEY = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen", "twenty", "a", "both", "another", "first", "second", "third"};

    private static final String[] DIC_VAL = {"00", "01", "04", "09", "16", "25", "36", "49", "64", "81", "00",
            "21", "44", "69", "96", "25", "56", "89", "24", "61", "00", "01", "04", "01", "01", "04", "09"};

    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<>();
        for (int i = 0; i < DIC_KEY.length; i++) {
            dic.put(DIC_KEY[i], DIC_VAL[i]);
        }
        Scanner in = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String cur;
        while (!(cur = in.next()).equals(".")) {
            if (dic.containsKey(cur)) {
                input.add(dic.get(cur));
            }
        }
        if (input.isEmpty()) {
            System.out.println(0);
            return;
        }

        input.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String leftRight = o1 + o2;
                String rightLeft = o2 + o1;
                return Integer.parseInt(leftRight) - Integer.parseInt(rightLeft);
            }
        });
        StringBuilder res = new StringBuilder();
        res.append(Integer.parseInt(input.get(0)));
        for (int i = 1; i < input.size(); i++) {
            res.append(input.get(i));
        }

        System.out.println(res.toString().replaceFirst("^0*", ""));  // 通过 replace + regular 去除结果开头的 0 们
    }
}
