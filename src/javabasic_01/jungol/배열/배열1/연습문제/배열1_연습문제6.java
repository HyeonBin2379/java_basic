package javabasic_01.jungol.배열.배열1.연습문제;

import java.util.Arrays;
import java.util.Scanner;

public class 배열1_연습문제6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(arr[arr.length-1]);
    }
}
