package javabasic_01.jungol.배열.배열1.연습문제;

import java.util.Scanner;

public class 배열1_연습문제6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
        }
        System.out.println(max);
    }
}
