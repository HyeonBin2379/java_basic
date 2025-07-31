package jungol.배열.배열1.연습문제;

import java.util.Scanner;

public class 배열1_연습문제1_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
            System.out.print(arr[i] + " ");
        }
    }
}
