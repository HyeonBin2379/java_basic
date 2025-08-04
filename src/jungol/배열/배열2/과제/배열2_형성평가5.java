package jungol.배열.배열2.과제;

import java.util.Scanner;

public class 배열2_형성평가5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] resultByClass = new int[4][3];
        for (int i = 1; i <= 4; i++) {
            System.out.printf("%dclass? ", i);
            for (int j = 0; j < 3; j++) {
                resultByClass[i-1][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= 4; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += resultByClass[i-1][j];
            }
            System.out.printf("%dclass : %d\n", i, total);
        }
    }
}
