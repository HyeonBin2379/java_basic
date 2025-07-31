package jungol.반복제어문.반복제어문1;

import java.util.Scanner;

public class 반복제어문1_자가진단4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        int sum = 0, count = 1;

        while (true) {
            num = sc.nextInt();
            sum += num;

            if (num >= 100) {
                break;
            }
            ++count;
        }
        System.out.println(sum);
        System.out.printf("%.1f\n", (double)sum/count);
    }
}