package org.luogu.part1.ch5.p1553;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int separator;
        if ((separator = s.indexOf(".")) > -1) {
        } else if ((separator = s.indexOf("/")) > -1) {
        } else if ((separator = s.indexOf("%")) > -1) {
        } else {
            separator = s.length();
        }
        String front = reverseNum(s.substring(0, separator));

        if (separator == s.length()) {
            System.out.println(front);
        } else if (separator == s.length() - 1) {
            System.out.println(front + "%");
        } else {
            String after = reverseNum(s.substring(separator + 1));
            System.out.println(front + s.charAt(separator) + after);
        }
    }

    private static String reverseNum(String numStr) {
        BigInteger numInt = new BigInteger(numStr);
        BigInteger res = BigInteger.ZERO;
        BigInteger bigTen = new BigInteger("10");
        while (!numInt.equals(BigInteger.ZERO)) {
            res = res.multiply(bigTen).add(numInt.mod(bigTen));
            numInt = numInt.divide(bigTen);
        }
        return res.toString();
    }
}
