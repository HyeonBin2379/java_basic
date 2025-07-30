package javabasic_01.jungol.배열.배열1.자가진단;

import java.util.Scanner;

public class 배열1_자가진단5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] scoreAvg = {85.6, 79.5, 83.1, 80.0, 78.2, 75.0};
        int a = sc.nextInt();
        int b = sc.nextInt();

        double sum = scoreAvg[a-1]+scoreAvg[b-1];
        System.out.printf("%.1f\n", sum);
    }
}