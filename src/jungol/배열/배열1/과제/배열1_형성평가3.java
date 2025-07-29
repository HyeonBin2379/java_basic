package jungol.배열.배열1.과제;

import java.util.Scanner;

public class 배열1_형성평가3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        int oddIndexSum = 0;
        int evenIndexSum = 0;
        for (int i = 1; i <= 10; i++) {
            arr[i-1] = sc.nextInt();

            if (i % 2 == 1) {
                oddIndexSum += arr[i-1];
            } else {
                evenIndexSum += arr[i-1];
            }
        }
        System.out.println("odd : " + oddIndexSum);
        System.out.println("even : " + evenIndexSum);
    }
}
