package jungol.반복제어문.반복제어문3.과제;

import java.util.Scanner;

public class 반복제어문3_형성평가10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                int value = (2*(n*i+j)-1) % 10;

                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
