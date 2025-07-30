package javabasic_01.jungol.반복제어문.반복제어문2.형성평가;

import java.util.Scanner;

public class 반복제어문2_형성평가10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        for (int i = 1; i <= 9; i++) {
            if (num1 < num2) {
                for (int j = num1; j <= num2; j++) {
                    System.out.printf("%d * %d = %2d   ", j, i, i*j);
                }
                System.out.println();
            } else {
                for (int j = num1; j >= num2; j--) {
                    System.out.printf("%d * %d = %2d   ", j, i, i*j);
                }
                System.out.println();
            }
        }
    }
}
