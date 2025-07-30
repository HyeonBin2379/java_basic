package javabasic_01.jungol.배열.배열1.자가진단;

import java.util.Scanner;

public class 배열1_자가진단7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        int min = 10000;
        for (int i = 0; i < 10; i++) {
            if (arr[i] < 100) {
                max = Math.max(arr[i], max);
            } else {
                min = Math.min(arr[i], min);
            }
        }

        if (max == 0) {
            max = 100;
        }
        if (min == 10000) {
            min = 100;
        }
        System.out.println(max + " " + min);
    }
}
