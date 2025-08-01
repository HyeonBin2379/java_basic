package jungol.문자열.문자열2.과제;

import java.util.Scanner;

public class 문자열2_형성평가7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens1 = sc.next().split("[^0-9]");
        String[] tokens2 = sc.next().split("[^0-9]");

        int result = Integer.parseInt(tokens1[0])*Integer.parseInt(tokens2[0]);
        System.out.println(result);
    }
}
