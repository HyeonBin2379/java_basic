package jungol.선택제어문.과제;

import java.util.Scanner;

public class 선택제어문_연습문제6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("세 수를 입력하세요. ");
        int max = 0;

        for (int i = 0; i < 3; i++) {
            int num = sc.nextInt();
            if (num > max) {
                max = num;
            }
        }

        System.out.printf("입력받은 수 중 가장 큰 수는 %d입니다.", max);
    }
}
