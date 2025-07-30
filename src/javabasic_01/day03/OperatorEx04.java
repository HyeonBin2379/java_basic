package javabasic_01.day03;

public class OperatorEx04 {

    public static void main(String[] args) {
        // 비트연산자: 비트 단위의 논리 연산 수행   대상은 0, 1
        // 피연산자가 2진수 0과 1로 저장되는 정수타입(byte,short,int,long)일 때만 사용 가능
        // 실수타입(float, double)은 비트연산의 대상이 될 수 없음.
        System.out.println(45 & 25);
        System.out.println(45 | 25);
        System.out.println(45 ^ 25);

        int num1 = 1;
        int result1 = num1 << 3;
        int result2 = num1 * (int)Math.pow(2, 3);
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);

        // 대입연산자, 복합대입연산자 +=, -=, *=, /=, %=
        int r = 0;

        r += 10;    // r = r + 10;
        System.out.printf("r의 값: %d\n", r);
        r -= 5;     // r = r + 5;
        System.out.println(r);

        r *= 2;     // r = r * 2;
        System.out.println(r);
        r /= 5;     // r = r / 5;
        System.out.println(r);
        r %= 2;     // r = r % 2;
        System.out.println(r);
    }
}
