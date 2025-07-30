package javabasic_01.jungol.도형만들기;

import java.util.Scanner;

public class 별삼각형2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 2 == 0 || n > 100 || n < 0) {
            System.out.println("INPUT ERROR!");
            return;
        }

        int len = (n+1)/2;
        for (int i = 1; i <= n; i++) {
            int value = i-len;
            int space = (value < 0) ? i-1 : len-1;

            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= Math.abs(value)+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
