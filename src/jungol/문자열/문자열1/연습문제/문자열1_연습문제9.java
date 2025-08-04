package jungol.문자열.문자열1.연습문제;

import java.util.Scanner;

public class 문자열1_연습문제9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        for (int i = 1; i <= input.length(); i++) {
            String newStr = input.substring(i) + input.substring(0, i);
            System.out.println(newStr);
        }
    }
}
