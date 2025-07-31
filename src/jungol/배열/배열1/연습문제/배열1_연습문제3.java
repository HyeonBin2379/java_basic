package jungol.배열.배열1.연습문제;

import java.util.Scanner;

public class 배열1_연습문제3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= 10; i++) {
            if (i == 3 || i == 5 || i == 10) {
                System.out.printf("%d ", arr[i-1]);
            }
        }
    }
}
