package javabasic_01.jungol.연산자.과제;

import java.util.Scanner;

public class 연산자_형성평가1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kor = sc.nextInt();
        int eng = sc.nextInt();
        int math = sc.nextInt();
        int com = sc.nextInt();

        int sum = kor + eng + math + com;
        int avg = sum/4;

        System.out.println("sum " + sum);
        System.out.println("avg " + avg);
    }
}
