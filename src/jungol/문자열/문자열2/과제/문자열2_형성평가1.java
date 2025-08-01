package jungol.문자열.문자열2.과제;

import java.util.Scanner;

public class 문자열2_형성평가1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        for (int i = words.length-1; i >= 0; i--) {
            System.out.println(words[i]);
        }
    }
}
