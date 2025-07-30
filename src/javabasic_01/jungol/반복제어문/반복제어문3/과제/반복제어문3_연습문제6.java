package javabasic_01.jungol.반복제어문.반복제어문3.과제;

import java.util.Scanner;

public class 반복제어문3_연습문제6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int num = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(++num + " ");
            }
            System.out.println();
        }
    }
}
