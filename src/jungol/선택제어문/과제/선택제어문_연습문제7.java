package jungol.선택제어문.과제;

import java.util.Scanner;

public class 선택제어문_연습문제7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] menu = {"삽입", "수정", "삭제"};
        for (int i = 1; i <= 3; i++) {
            System.out.printf("%d. %s\n", i, menu[i-1]);
        }

        System.out.print("숫자를 선택하세요. ");
        int menuNum = sc.nextInt();
        System.out.printf("%s을 선택하셨습니다.", menu[menuNum-1]);
    }
}
