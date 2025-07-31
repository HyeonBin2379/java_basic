package jungol.배열.배열1.형성평가;

import java.util.Scanner;

public class 행복 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        System.out.println(max-min);
    }
}
