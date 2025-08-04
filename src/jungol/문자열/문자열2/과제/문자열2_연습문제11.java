package jungol.문자열.문자열2.과제;

import java.util.Scanner;

public class 문자열2_연습문제11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] tokens = new String[3][];
        for (int i = 0; i < 3; i++) {
            tokens[i] = String.format("%.2f", sc.nextDouble()).split("\\.");
        }

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                System.out.println(tokens[i][0]);
            } else if (i == 3) {
                System.out.println(tokens[i-1][1]);
            } else {
                System.out.println(tokens[i-1][1]+tokens[i][0]);
            }
        }
    }
}
