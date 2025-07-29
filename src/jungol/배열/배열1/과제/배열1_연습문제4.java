package jungol.배열.배열1.과제;

import java.util.Scanner;

public class 배열1_연습문제4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int index = 0;

        while (true) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            arr[index++] = num;
        }

        for (int i = 0; i < index; i++) {
            if (i % 2 == 1) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
