package jungol.반복제어문.반복제어문2.형성평가;

import java.util.Scanner;

public class 반복제어문2_형성평가6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int sum = 0;
        int count = 0;
        for (int i = Math.min(num1, num2); i <= Math.max(num1, num2); i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
                count++;
            }
        }

        double avg = (double)sum/count;

        System.out.printf("sum : %d\n", sum);
        System.out.printf("avg : %.1f\n", avg);
    }
}
