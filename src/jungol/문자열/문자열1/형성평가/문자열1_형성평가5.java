package jungol.문자열.문자열1.형성평가;

import java.util.Scanner;

public class 문자열1_형성평가5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(Math.max(str1.length(), str2.length()));
    }
}
