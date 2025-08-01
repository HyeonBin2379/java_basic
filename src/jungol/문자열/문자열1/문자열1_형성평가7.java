package jungol.문자열.문자열1;

import java.util.Scanner;

public class 문자열1_형성평가7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");

        for (int i = 1; i <= words.length; i++) {
            System.out.printf("%d. %s\n", i, words[i-1]);
        }
    }
}
