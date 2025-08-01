package jungol.문자열.문자열2;

import java.util.Scanner;

public class 문자열2_연습문제4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 <= len2) {
            System.out.println(str1);
            System.out.println(str2);
        } else {
            System.out.println(str2);
            System.out.println(str1);
        }
    }
}
