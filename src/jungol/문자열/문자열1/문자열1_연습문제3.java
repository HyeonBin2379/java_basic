package jungol.문자열.문자열1;

import java.util.Scanner;

public class 문자열1_연습문제3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = "jungol olympiad".toCharArray();
        for (int i = 1; i <= 5; i++) {
            int index = sc.nextInt();
            System.out.print(input[index]);
        }
    }
}
