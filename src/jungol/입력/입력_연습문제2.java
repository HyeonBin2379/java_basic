package jungol.입력;

import java.util.Scanner;

public class 입력_연습문제2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 10;
        int b = 20;

        int temp = a;
        a = b;
        b = temp;

        System.out.println(a + " " + b);
    }
}
