package jungol.반복제어문.반복제어문3.과제;

import java.util.Scanner;

public class 반복제어문3_형성평가2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; n*i <= 100; i++) {
            int value = n*i;
            System.out.print(value + " ");

            if (value % 10 == 0) {
                break;
            }
        }
    }
}
