package javabasic_01.jungol.배열.배열2.과제;

import java.util.Scanner;

public class 배열2_형성평가3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 0:
                    arr[i] = num1;
                    break;
                case 1:
                    arr[i] = num2;
                    break;
                default:
                    arr[i] = (arr[i-2]+arr[i-1]) % 10;
            }
            System.out.print(arr[i] + " ");
        }
    }
}
