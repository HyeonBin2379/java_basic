package javabasic_01.day01;

public class ex01 {

    public static void main(String[] args) {
        // 3개의 정수 10, 11, 12를 더하여 결과를 출력하세요.
        // 정수형 변수 선언(같은 공간 내 동일 이름으로 여러 번 선언 불가)
        int num1, num2, num3, sum;

        // 각 변수에 값을 할당
        num1 = 12;
        num2 = 13;
        num3 = 14;

        // 연산
        sum = num1 + num2 + num3;

        // 기본 출력 방법
        // 한번 지정한 문자열은 고정
        System.out.println("10+11+12 = " + sum);

        // 변수의 값 변경 시 출력되는 숫자 변경
        System.out.println(num1 + "+" + num2 + "+" + num3 + "=" + sum);
        System.out.printf("%d + %d + %d = %d", num1, num2, num3, sum);

    }
}
