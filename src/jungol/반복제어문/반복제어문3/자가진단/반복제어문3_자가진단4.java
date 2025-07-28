package jungol.반복제어문.반복제어문3.자가진단;

import java.util.Scanner;

public class 반복제어문3_자가진단4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (n-i); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
