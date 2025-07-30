package javabasic_01.day05;

public class ContinueEx01 {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("i = " + i);

            if (i % 2 != 0) {
                continue;       // 홀수일 때만 스킵
            }

            System.out.println("결과출력: " + i);   // 짝수만 출력
        }
    }
}
