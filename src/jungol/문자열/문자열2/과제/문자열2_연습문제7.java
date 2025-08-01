package jungol.문자열.문자열2.과제;

import java.util.Scanner;

public class 문자열2_연습문제7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = {"champion", "tel", "pencil", "jungol", "olympiad", "class", "information", "lesson", "book", "lion"};
        System.out.print("문자를 입력하세요. ");
        char ch = sc.nextLine().charAt(0);
        int count = 0;
        for (String word : words) {
            if (word.indexOf(ch) != -1) {
                System.out.println(word);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("찾는 단어가 없습니다.");
        }
        System.out.println();

        System.out.print("문자열을 입력하세요. ");
        String str = sc.nextLine();
        count = 0;
        for (String word : words) {
            if (word.contains(str)) {
                System.out.println(word);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("찾는 단어가 없습니다.");
        }
    }
}
