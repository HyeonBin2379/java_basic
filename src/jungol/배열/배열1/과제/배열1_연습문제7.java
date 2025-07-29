package jungol.배열.배열1.과제;

import java.util.Scanner;

public class 배열1_연습문제7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int oddMin = 10000, evenMax = -10000;
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();

            if (Math.abs(arr[i]) % 2 == 0) {
                evenMax = Math.max(arr[i], evenMax);
            } else {
                oddMin = Math.min(arr[i], oddMin);
            }
        }
        System.out.println(oddMin + " " + evenMax);
    }
}