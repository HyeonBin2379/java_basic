package javabasic_01.jungol.선택제어문.과제;

import java.util.Scanner;

public class 선택제어문_형성평가3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
            System.out.println("leap year");
        } else {
            System.out.println("common year");
        }
    }
}
