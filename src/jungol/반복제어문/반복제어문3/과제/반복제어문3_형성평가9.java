package jungol.반복제어문.반복제어문3.과제;

import java.util.Scanner;

public class 반복제어문3_형성평가9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i < 2*n; i++) {
            int value = i-n;

            for (int j = 1; j <= value; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= n-Math.abs(value); j++) {
                System.out.print("#" + " ");
            }
            for (int j = 1; j <= value; j++) {
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
