package javabasic_01.jungol.배열.배열2.연습문제;

import java.util.Scanner;

public class 배열2_연습문제1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[11];

        while (true) {
            int num = sc.nextInt();

            if (num == 0) {
                break;
            }
            arr[num]++;
        }

        for (int i = 1; i <= 10; i++) {
            if (arr[i] >= 1) {
                System.out.printf("%d : %d개\n", i, arr[i]);
            }
        }
    }
}
