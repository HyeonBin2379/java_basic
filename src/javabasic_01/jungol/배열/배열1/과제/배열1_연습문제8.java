package javabasic_01.jungol.배열.배열1.과제;

import java.util.Scanner;

public class 배열1_연습문제8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        double avg = (double)sum/10;
        System.out.printf("총점 = %d\n", sum);
        System.out.printf("평균 = %.1f\n", avg);
    }
}
