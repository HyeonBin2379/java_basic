package jungol.문자열.문자열2.과제;

import java.util.Scanner;

public class 문자열2_형성평가2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] flowers = {"flower", "rose", "lily", "daffodil", "azalea"};
        char ch = sc.nextLine().charAt(0);

        int count = 0;
        for (String flower : flowers) {
            char second = flower.charAt(1);
            char third = flower.charAt(2);
            if (second == ch || third == ch) {
                System.out.println(flower);
                count++;
            }
        }
        System.out.println(count);
    }
}
