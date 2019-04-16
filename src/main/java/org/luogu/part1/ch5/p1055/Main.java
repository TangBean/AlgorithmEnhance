package org.luogu.part1.ch5.p1055;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String isbn = in.next();
        int separator = isbn.lastIndexOf('-');
        String last = isbn.substring(separator + 1);
        int first = Integer.parseInt(isbn.substring(0, separator).replaceAll("-", ""));
        int idCode = 0;
        for (int i = 9; i > 0; i--) {
            idCode += first % 10 * i;
            first /= 10;
        }
        idCode %= 11;
        String idCodeStr;
        if (idCode == 10) {
            idCodeStr = "X";
        } else {
            idCodeStr = Integer.toString(idCode);
        }
        if (idCodeStr.equals(last)) {
            System.out.println("Right");
        } else {
            System.out.println(isbn.substring(0, separator + 1) + idCodeStr);
        }
    }
}
