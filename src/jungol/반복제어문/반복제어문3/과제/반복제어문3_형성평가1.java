package jungol.반복제어문.반복제어문3.과제;

import java.util.Scanner;

public class 반복제어문3_형성평가1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        for (int i = 1; i <= 20; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            sum += num;
            count++;
        }

        int avg = (count != 0) ? sum/count : 0;
        System.out.println(sum + " " + avg);
    }
}
