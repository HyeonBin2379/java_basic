package day02;

import java.util.Scanner;

public class FourArithmetic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫번째 정수 입력: ");
        int a = sc.nextInt();

        System.out.print("두번째 정수 입력: ");
        int b = sc.nextInt();

        System.out.printf("%d+%d=%d\n", a, b, add(a, b));
        System.out.printf("%d-%d=%d\n", a, b, subtract(a, b));
        System.out.printf("%d*%d=%d\n", a, b, multiple(a, b));
        System.out.printf("%d/%d=%.1f\n", a, b, divide(a, b));

        int kor = 77;
        int eng = 87;
        int total = kor+eng;

        System.out.printf("총점: %d\n평균: %.1f\n", total, total/2.0);
    }

    public static int add(int num1, int num2) {
        return num1+num2;
    }

    public static int subtract(int num1, int num2) {
        return num1-num2;
    }

    public static int multiple(int num1, int num2) {
        return num1*num2;
    }

    public static double divide(int num1, int num2) {
        return (double)num1/num2;
    }
}
