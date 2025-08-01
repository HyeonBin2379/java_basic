package jungol.문자열.문자열1.형성평가;

import java.util.Scanner;

public class 문자열1_형성평가2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine().replaceAll("[@.]", "");
        System.out.println(email);
    }
}
