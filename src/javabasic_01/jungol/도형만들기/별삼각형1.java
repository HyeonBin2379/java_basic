package javabasic_01.jungol.도형만들기;

import java.util.Scanner;

public class 별삼각형1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (n > 100 || (m < 1 || m > 3)) {
            System.out.println("INPUT ERROR!");
            return;
        }

        switch (m) {
            case 1:
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i = n; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 3:
                for (int i = 1; i <= n; i++) {
                    for (int j = i; j < n; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 1; j < 2*i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
