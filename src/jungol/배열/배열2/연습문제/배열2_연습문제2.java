package jungol.배열.배열2.연습문제;

import java.util.Scanner;

public class 배열2_연습문제2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] digitCount = new int[10];
        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            digitCount[num % 10]++;
        }

        for (int i = 0; i < 10; i++) {
            if (digitCount[i] >= 1) {
                System.out.printf("%d : %d개\n", i, digitCount[i]);
            }
        }
    }
}
