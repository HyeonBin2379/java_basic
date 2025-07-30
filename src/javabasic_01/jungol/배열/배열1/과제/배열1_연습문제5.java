package javabasic_01.jungol.배열.배열1.과제;

import java.util.Scanner;

public class 배열1_연습문제5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] leapYear = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] normalYear = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        while (true) {
            System.out.print("YEAR = ");
            int year = sc.nextInt();

            System.out.print("MONTH = ");
            int month = sc.nextInt();

            if (month == 0) {
                break;
            } else if (month < 1 || month > 12) {
                System.out.println("잘못 입력하였습니다.");
                continue;
            }

            if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) {
                System.out.printf("입력하신 달의 날 수는 %d일입니다.\n", leapYear[month]);
            } else {
                System.out.printf("입력하신 달의 날 수는 %d일입니다.\n", normalYear[month]);
            }
        }
    }
}
