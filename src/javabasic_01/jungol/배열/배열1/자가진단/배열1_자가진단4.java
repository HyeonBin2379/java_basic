package javabasic_01.jungol.배열.배열1.자가진단;

import java.util.Scanner;

public class 배열1_자가진단4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int len = 0;

        for (int i = 0; i < 100; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            arr[len++] = num;
        }

        for (int i = len-1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
