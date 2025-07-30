package javabasic_01.jungol.선택제어문.과제;

import java.util.Scanner;

public class 선택제어문_형성평가2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("minus");
        } else if (num == 0) {
            System.out.println("zero");
        } else {
            System.out.println("plus");
        }
    }
}
