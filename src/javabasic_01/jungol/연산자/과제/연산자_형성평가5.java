package javabasic_01.jungol.연산자.과제;

import java.util.Scanner;

public class 연산자_형성평가5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minsuHeight = sc.nextInt();
        int minsuWeight = sc.nextInt();
        int kiyoungHeight = sc.nextInt();
        int kiyoungWeight = sc.nextInt();

        int result = (minsuHeight > kiyoungHeight && minsuWeight > kiyoungWeight) ? 1 : 0;
        System.out.println(result);
    }
}
