package javabasic_01.jungol.연산자.과제;

import java.util.Scanner;

public class 연산자_형성평가3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int length = sc.nextInt();

        width += 5;
        length *= 2;

        int area = width*length;

        System.out.println("width = " + width);
        System.out.println("length = " + length);
        System.out.println("area = " + area);
    }
}
