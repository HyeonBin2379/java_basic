package javabasic_01.jungol.배열.배열1.형성평가;

import java.util.Scanner;

public class 배열1_형성평가7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];

        int max = -1000, min = 1000;
        for (int i = 0; i < 100; i++) {
            int num = sc.nextInt();

            if (num == 999) {
                break;
            }
            arr[i] = num;
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        System.out.println("max : " + max);
        System.out.println("min : " + min);
    }
}
