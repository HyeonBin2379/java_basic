package javabasic_01.jungol.반복제어문.반복제어문3.과제;

import java.util.Scanner;

public class 반복제어문3_형성평가4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i < 2*n; i++) {
            for (int j = 0; j < Math.min(i, 2*n-i)-1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*Math.abs(n-i)+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
