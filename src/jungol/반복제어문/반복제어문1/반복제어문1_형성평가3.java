package jungol.반복제어문.반복제어문1;

import java.util.Scanner;

public class 반복제어문1_형성평가3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        while (true) {
            int num = sc.nextInt();

            if (num < 0 || num > 100) {
                break;
            }
            sum += num;
            count++;
        }

        double avg = (double)sum/count;
        System.out.printf("sum : %d\n", sum);
        System.out.printf("avg : %.1f\n", avg);
    }
}
