package jungol.문자열.문자열1;

import java.util.Scanner;

public class 문자열1_연습문제8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");

        for (String word : words) {
            System.out.println(word);
        }
    }
}
