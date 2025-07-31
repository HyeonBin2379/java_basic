package jungol.배열.배열1.형성평가;

import java.util.Scanner;

public class 배열1_형성평가9 {

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

        System.out.println(len);
        for (int i = 0; i < len; i++) {
            arr[i] = (arr[i] % 2 == 0) ? arr[i]/2 : arr[i]*2;
            System.out.print(arr[i] + " ");
        }
    }
}
