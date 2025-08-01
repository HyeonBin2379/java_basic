package jungol.문자열.문자열2.과제;

import java.util.Scanner;

public class 문자열2_연습문제2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");

        for (String word : words) {
            System.out.println(word);
        }
    }
}
