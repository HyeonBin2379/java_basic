package jungol.문자열.문자열2.과제;

import java.util.Scanner;

public class 문자열2_형성평가3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = new String[50];
        int count = 0;
        while (true) {
            String word = sc.nextLine();
            if (word.equals("0")) {
                break;
            }
            words[count++] = word;
        }
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                System.out.println(words[i]);
            }
        }
    }
}
