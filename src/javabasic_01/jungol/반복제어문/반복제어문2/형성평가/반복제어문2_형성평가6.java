package javabasic_01.jungol.반복제어문.반복제어문2.형성평가;

import java.util.Scanner;

public class 반복제어문2_형성평가6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();    // 2개의 정수 입력 - for문 수행 범위
        int num2 = sc.nextInt();

        int sum = 0;    // 3의 배수이거나 5의 배수인 수의 총합
        int count = 0;  // 3의 배수이거나 5의 배수인 수의 개수

        // 큰 숫자가 먼저 입력되는 경우까지 고려
        // ex) 30 10
        for (int i = Math.min(num1, num2); i <= Math.max(num1, num2); i++) {
            // i가 3의 배수이거나 5의 배수
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
                count++;
            }
        }

        // 평균 계산
        double avg = (double)sum/count;

        // 총합과 평균 출력
        System.out.printf("sum : %d\n", sum);
        System.out.printf("avg : %.1f\n", avg);
    }
}
