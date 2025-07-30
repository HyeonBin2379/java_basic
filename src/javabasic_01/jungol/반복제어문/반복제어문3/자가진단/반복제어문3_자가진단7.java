package javabasic_01.jungol.반복제어문.반복제어문3.자가진단;

import java.util.Scanner;

public class 반복제어문3_자가진단7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int num = 0;
        char ch = 'A';
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print((++num) + " ");
            }
            for (int j = 1; j <= (n+1-i); j++) {
                System.out.print((ch++) + " ");
            }
            System.out.println();
        }
    }
}
