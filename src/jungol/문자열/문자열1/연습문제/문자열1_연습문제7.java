package jungol.문자열.문자열1.연습문제;

import java.util.Scanner;

public class 문자열1_연습문제7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            if (Character.isLowerCase(input[i])) {
                input[i] = Character.toUpperCase(input[i]);
            } else if (Character.isUpperCase(input[i])) {
                input[i] = Character.toLowerCase(input[i]);
            }
        }
        System.out.println(input);
    }
}
