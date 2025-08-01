package jungol.문자열.문자열2;

import java.util.Scanner;

public class 문자열2_연습문제10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = Integer.parseInt(sc.next());
        int num2 = Integer.parseInt(sc.nextLine().trim());
        System.out.printf("%d + %d = %d\n", num1, num2, num1+num2);

        double num3 = Double.parseDouble(sc.next());
        double num4 = Double.parseDouble(sc.nextLine());
        System.out.printf("%.2f + %.2f = %.2f\n", num3, num4, num3+num4);
    }
}
