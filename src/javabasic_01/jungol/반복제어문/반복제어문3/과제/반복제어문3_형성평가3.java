package javabasic_01.jungol.반복제어문.반복제어문3.과제;

import java.util.Scanner;

public class 반복제어문3_형성평가3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 1; i < 2*num; i++) {
            for (int j = 1; j <= Math.min(i, 2*num-i); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
