package jungol.문자열.문자열2.자가진단;

import java.util.Scanner;

public class 문자열2_자가진단2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        for (int i = 1; i <= words.length; i++) {
            if (i % 2 == 1) {
                System.out.println(words[i-1]);
            }
        }
    }
}
