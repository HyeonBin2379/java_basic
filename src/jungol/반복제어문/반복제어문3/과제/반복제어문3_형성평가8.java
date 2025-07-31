package jungol.반복제어문.반복제어문3.과제;

import java.util.Scanner;

public class 반복제어문3_형성평가8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < (n-i); j++) {
                System.out.print((++num) + " ");
            }
            System.out.println();
        }
    }
}
