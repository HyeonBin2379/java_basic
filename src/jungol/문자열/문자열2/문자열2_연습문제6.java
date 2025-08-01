package jungol.문자열.문자열2;

import java.util.Scanner;

public class 문자열2_연습문제6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        String newStr1 = str2.substring(0, 3) + str1.substring(3);
        String newStr2 = str2 + str1.substring(0, 3);

        System.out.println(newStr1);
        System.out.println(newStr2);
    }
}
