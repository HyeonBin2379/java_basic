package jungol.문자열.문자열1;

import java.util.Scanner;

public class 문자열1_연습문제1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch;
        do {
            ch = sc.nextLine().charAt(0);
            System.out.printf("%c -> %d\n", ch, (int)ch);
        } while (ch != '0');
    }
}
