package javabasic_01.jungol.선택제어문.과제;

import java.util.Scanner;

public class 선택제어문_연습문제1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(num);
        if (num > 10) {
            System.out.println("10보다 큰 수를 입력하셨습니다.");
        }
    }
}
