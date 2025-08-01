package jungol.배열.배열2.과제;

import java.util.Scanner;

public class 배열2_형성평가7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("first array");
        int[][] array1 = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                array1[i][j] = sc.nextInt();
            }
        }

        System.out.println("second array");
        int[][] array2 = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                array2[i][j] = sc.nextInt();
            }
        }

        int[][] result = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = array1[i][j]*array2[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
