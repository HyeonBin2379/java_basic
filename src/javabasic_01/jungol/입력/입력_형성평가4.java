package javabasic_01.jungol.입력;

import java.util.Scanner;

public class 입력_형성평가4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int result = num1+num2+num3;
        System.out.printf("sum = %d\n", result);
    }
}
