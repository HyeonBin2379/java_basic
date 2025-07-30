package javabasic_01.jungol.배열.배열1.자가진단;

import java.util.Scanner;

public class 배열1_자가진단6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int min = 1000;

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(arr[i], min);
        }
        System.out.println(min);
    }
}
