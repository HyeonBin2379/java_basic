package jungol.배열.배열1.자가진단;

import java.util.Scanner;

public class 배열1_자가진단8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] score = new int[10];
        for (int i = 0; i < 10; i++) {
            score[i] = sc.nextInt();
        }

        int evenIdxSum = 0;
        int oddIdxSum = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                evenIdxSum += score[i-1];
            } else {
                oddIdxSum += score[i-1];
            }
        }

        double oddAvg = (double)oddIdxSum/5;

        System.out.printf("sum : %d\n", evenIdxSum);
        System.out.printf("avg : %.1f\n", oddAvg);
    }
}
