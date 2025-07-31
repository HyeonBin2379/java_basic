package jungol.배열.배열1.형성평가;

import java.util.Scanner;

public class 배열1_형성평가8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];

        int count = 0;
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] == 0) {
                break;
            }
            if (arr[i] % 5 == 0) {
                sum += arr[i];
                count++;
            }
        }
        double avg = (double)sum/count;

        System.out.printf("Multiples of 5 : %d\n", count);
        System.out.printf("sum : %d\n", sum);
        System.out.printf("avg : %.1f\n", avg);
    }
}
