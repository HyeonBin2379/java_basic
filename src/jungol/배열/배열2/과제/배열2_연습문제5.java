package jungol.배열.배열2.과제;

import java.util.Scanner;

public class 배열2_연습문제5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr1 = new int[3][3];
        for (int i = 1; i <= 3; i++) {
            System.out.printf("첫 번째 배열 %d행 ", i);
            for (int j = 0; j < 3; j++) {
                arr1[i-1][j] = sc.nextInt();
            }
        }

        int[][] arr2 = new int[3][3];
        for (int i = 1; i <= 3; i++) {
            System.out.printf("두 번째 배열 %d행 ", i);
            for (int j = 0; j < 3; j++) {
                arr2[i-1][j] = sc.nextInt();
            }
        }

        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
