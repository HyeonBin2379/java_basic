package javabasic_01.jungol.반복제어문.반복제어문2.형성평가;

import java.util.Scanner;

public class 반복제어문2_형성평가5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int evenCount = 0;      // 짝수의 개수
        int oddCount = 0;       // 홀수의 개수

        for (int i = 1; i <= 10; i++) {
            int num = sc.nextInt();   // 정수 입력

            if (num % 2 == 0) {
                evenCount++;    // 짝수의 개수 세기
            } else {
                oddCount++;     // 홀수의 개수 세기
            }
        }

        // 10개의 수 중 짝수와 홀수의 개수 출력
        System.out.println("even : " + evenCount);
        System.out.println("odd : " + oddCount);
    }
}
