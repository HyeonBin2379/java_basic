package jungol.문자열.문자열2.과제;

import java.util.Arrays;
import java.util.Scanner;

public class 문자열2_형성평가4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = sc.nextLine();
        }
        Arrays.sort(words);

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }
}
