package jungol.배열.배열1.과제;

import java.util.Scanner;

public class 배열1_형성평가2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int sum = 0;

        for (int i = 1; i <= 5; i++) {
            arr[i-1] = sc.nextInt();
            if (i % 2 == 1) {
                sum += arr[i-1];
            }
        }
        System.out.println(sum);
    }
}
