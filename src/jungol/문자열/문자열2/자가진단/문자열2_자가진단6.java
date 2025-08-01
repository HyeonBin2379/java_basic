package jungol.문자열.문자열2.자가진단;

import java.util.Scanner;

public class 문자열2_자가진단6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        String newStr = str1.substring(0, 2);
        String oldStr = str2.substring(0, 2);
        System.out.println(str2.replace(oldStr, newStr)+newStr);
    }
}
