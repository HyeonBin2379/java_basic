package jungol.반복제어문.반복제어문1;

import java.util.Scanner;

public class 반복제어문1_연습문제6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 입력하기\n2. 출력하기\n3. 삭제하기\n4. 끝내기");
            System.out.print("작업할 번호를 선택하세요. ");
            int menuNum = sc.nextInt();

            if (menuNum == 1) {
                System.out.println("\n입력하기를 선택하였습니다.\n");
            } else if (menuNum == 2) {
                System.out.println("\n출력하기를 선택하였습니다.\n");
            } else if (menuNum == 3) {
                System.out.println("\n삭제하기를 선택하였습니다.\n");
            } else if (menuNum == 4) {
                System.out.println("\n끝내기를 선택하였습니다.\n");
                break;
            } else {
                System.out.println("\n잘못 입력하였습니다.\n");
            }
        }
    }
}
