package jungol.선택제어문.과제;

import java.util.Scanner;

public class 선택제어문_형성평가5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();

        int days = 0;
        switch (month) {
            case 1:
                days = 31;
                break;
            case 2:
                days = 28;
                break;
            case 3:
                days = 31;
                break;
            case 4:
                days = 30;
                break;
            case 5:
                days = 31;
                break;
            case 6:
                days = 30;
                break;
            case 7:
                days = 31;
                break;
            case 8:
                days = 31;
                break;
            case 9:
                days = 30;
                break;
            case 10:
                days = 31;
                break;
            case 11:
                days = 30;
                break;
            case 12:
                days = 31;
                break;
        }
        System.out.println(days);
    }
}
