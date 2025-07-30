package javabasic_01.jungol.배열.배열2.연습문제;

import java.util.Scanner;

public class 배열2_연습문제7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
