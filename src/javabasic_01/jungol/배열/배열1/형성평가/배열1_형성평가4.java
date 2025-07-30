package javabasic_01.jungol.배열.배열1.형성평가;

import java.util.Scanner;

public class 배열1_형성평가4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int len = 0;

        for (int i = 0; i < 100; i++) {
            int num = sc.nextInt();
            if (num == -1) {
                break;
            }
            arr[len++] = num;
        }

        for (int i = Math.max(len-3, 0); i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
