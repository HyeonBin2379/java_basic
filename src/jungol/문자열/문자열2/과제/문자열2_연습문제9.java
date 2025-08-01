package jungol.문자열.문자열2.과제;

import java.util.Arrays;
import java.util.Scanner;

public class 문자열2_연습문제9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("단어 5개를 입력하세요.");
        String[] strings = new String[5];
        for (int i = 0; i < 5; i++) {
            strings[i] = sc.nextLine();
        }
        Arrays.sort(strings);

        for (int i = 0; i < 5; i++) {
            System.out.println(strings[i]);
        }
    }
}
