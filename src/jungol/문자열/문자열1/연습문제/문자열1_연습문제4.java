package jungol.문자열.문자열1.연습문제;

import java.util.Scanner;

public class 문자열1_연습문제4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();

        System.out.printf("입력받은 문자열의 길이는 %d입니다.\n", input.length);
        for (int i = input.length-1; i >= 0; i--) {
            System.out.print(input[i]);
        }
    }
}
