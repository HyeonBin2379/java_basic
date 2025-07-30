package javabasic_01.jungol.배열.배열2.형성평가;

import java.util.Scanner;

public class 배열2_형성평가8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] array = new int[4][2];
        int[] rowAvg = new int[4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                array[i][j] = sc.nextInt();
                rowAvg[i] += array[i][j];
            }
            rowAvg[i] /= array[i].length;
        }

        for (int i = 0; i < 4; i++) {
            System.out.print(rowAvg[i] + " ");
        }
        System.out.println();

        int[] colAvg = new int[2];
        int totalAvg = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                colAvg[i] += array[j][i];
            }
            totalAvg += colAvg[i];
            colAvg[i] /= array.length;
            System.out.print(colAvg[i] + " ");
        }
        System.out.println();

        totalAvg /= 8;
        System.out.println(totalAvg);
    }
}
