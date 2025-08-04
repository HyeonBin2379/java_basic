package jungol.문자열.문자열2.자가진단;

import java.util.Scanner;

public class 문자열2_자가진단3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = new String[10];
        for (int i = 0; i < 10; i++) {
            words[i] = sc.nextLine();
        }

        char lastChar = sc.nextLine().charAt(0);
        for (String word : words) {
            int index = word.lastIndexOf(lastChar);
            if (index == word.length()-1) {
                System.out.println(word);
            }
        }
    }
}
