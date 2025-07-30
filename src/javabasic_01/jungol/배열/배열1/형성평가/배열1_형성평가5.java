package javabasic_01.jungol.배열.배열1.형성평가;

import java.util.Scanner;

public class 배열1_형성평가5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] weight = new double[6];

        double total = 0;
        for (int i = 0; i < 6; i++) {
            weight[i] = sc.nextDouble();
            total += weight[i];
        }

        double avg = total/6;
        System.out.printf("%.1f\n", avg);
    }
}
