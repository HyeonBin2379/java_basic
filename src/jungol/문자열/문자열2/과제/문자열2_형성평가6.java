package jungol.문자열.문자열2.과제;

import java.util.Scanner;

public class 문자열2_형성평가6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int num = sc.nextInt();

        str1 = str1+str2;
        System.out.println(str1);

        String newStr = str1.substring(0, num);
        if (str2.length() < num) {
            str2 = str1.substring(0, num);
        } else {
            String oldStr = str2.substring(0, num);
            str2 = str2.replace(oldStr, newStr);
        }
        System.out.println(str2);
    }
}
