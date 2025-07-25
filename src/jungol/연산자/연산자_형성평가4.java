package jungol.연산자;

import java.util.Scanner;

public class 연산자_형성평가4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(++num1 + " " + num2--);
        System.out.println(num1 + " " + num2);
    }
}
