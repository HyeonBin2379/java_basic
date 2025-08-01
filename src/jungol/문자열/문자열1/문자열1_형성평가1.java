package jungol.문자열.문자열1;

import java.util.Scanner;

public class 문자열1_형성평가1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch1 = sc.next().charAt(0);
        char ch2 = sc.next().charAt(0);

        System.out.println((ch1+ch2) + " " + Math.abs(ch1-ch2));
    }
}
