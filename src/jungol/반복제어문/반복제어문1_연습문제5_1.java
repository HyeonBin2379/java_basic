package jungol.반복제어문;

import java.util.Scanner;

public class 반복제어문1_연습문제5_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        while (true) {
            int num = sc.nextInt();

            if (num == 0) {
                break;
            }

            if (num % 2 == 1) {
                sum += num;
                count++;
            }
        }

        System.out.printf("홀수의 합 = %d\n", sum);
        System.out.printf("홀수의 평균 = %d\n", sum/count);
    }
}
