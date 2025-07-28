package jungol.반복제어문.반복제어문2.형성평가;

import java.util.Scanner;

public class 반복제어문2_형성평가4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();

            sum += num;
        }

        double avg = (double)sum/n;
        System.out.printf("%.2f\n", avg);
    }
}
