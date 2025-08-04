package jungol.문자열.문자열2.과제;

import java.util.Scanner;

public class 문자열2_형성평가9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        String str1 = String.format("%.3f", sc.nextDouble());
        String str2 = sc.next();

        StringBuffer sb = new StringBuffer();
        sb.append(num1).append(str1).append(str2);

        int half = sb.length()/2;
        if (sb.length() % 2 == 1) {
            System.out.println(sb.substring(0, half+1));
            System.out.println(sb.substring(half+1));
        } else {
            System.out.println(sb.substring(0, half));
            System.out.println(sb.substring(half));
        }
    }
}
