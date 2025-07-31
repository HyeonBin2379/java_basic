package jungol.도형만들기;

import java.util.Scanner;

public class 별삼각형3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 2 == 0 || n < 0 || n > 100) {
            System.out.println("INPUT ERROR!");
            return;
        }

        for (int i = 0; i < n; i++) {
            int value = (n/2)-Math.abs(n/2-i);
            for (int j = 1; j <= value; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*value+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
