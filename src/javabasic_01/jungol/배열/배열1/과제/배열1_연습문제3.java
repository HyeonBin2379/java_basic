package javabasic_01.jungol.배열.배열1.과제;

import java.util.Scanner;

public class 배열1_연습문제3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.printf("%d %d %d\n", arr[2], arr[4], arr[9]);
    }
}
