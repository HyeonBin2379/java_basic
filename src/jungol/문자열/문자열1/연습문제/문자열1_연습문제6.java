package jungol.문자열.문자열1.연습문제;

import java.util.Scanner;

public class 문자열1_연습문제6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            char ch = sc.nextLine().charAt(0);
            if (Character.isLowerCase(ch)) {
                System.out.println("소문자입니다.");
            } else if (Character.isUpperCase(ch)) {
                System.out.println("대문자입니다.");
            } else if (Character.isDigit(ch)) {
                System.out.println("숫자문자입니다.");
            } else {
                System.out.println("영문, 숫자 이외의 문자입니다.");
                break;
            }
        }
    }
}
