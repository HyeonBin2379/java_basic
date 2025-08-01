package jungol.문자열.문자열2.과제;

import java.util.Scanner;

public class 문자열2_형성평가5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = new String[5];
        for (int i = 0; i < 5; i++) {
            words[i] = sc.nextLine();
        }
        char ch = sc.nextLine().charAt(0);
        String str = sc.nextLine();

        int count = 0;
        for (String word : words) {
            if (word.indexOf(ch) != -1 || word.contains(str)) {
                System.out.println(word);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("none");
        }
    }
}
