package jungol.문자열.문자열2;

import java.util.Scanner;

public class 문자열2_연습문제3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = {"champion", "class"};

        System.out.print("문자를 입력하세요. ");
        char ch = sc.nextLine().charAt(0);
        for (String word : words) {
            if (word.indexOf(ch) == 0) {
                System.out.println(word);
            }
        }
    }
}
