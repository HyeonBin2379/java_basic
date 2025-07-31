package jungol.반복제어문.반복제어문2.과제;

import java.util.Scanner;

public class 반복제어문2_연습문제5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int evenCount = 0;

        for (int i = 1; i <= 10; i++) {
            int num = sc.nextInt();

            if (num % 2 == 0) {
                evenCount++;
            }
        }
        System.out.printf("입력받은 짝수는 %d개입니다.", evenCount);
    }
}
