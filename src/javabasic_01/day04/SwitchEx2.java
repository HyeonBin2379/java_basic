package javabasic_01.day04;

import java.util.Scanner;

public class SwitchEx2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char grade = sc.nextLine().charAt(0);

        // 사용자에게 A~C 중 1개의 문자를 받아
        // 'A'면 "매우 우수", 'B'면 "우수", 'C'면 "노력 요함"을 출력
        switch (grade) {
            case 'A':
                System.out.println("매우 우수");
                break;
            case 'B':
                System.out.println("우수");
                break;
            case 'C':
                System.out.println("노력하세요");
                break;
            default:
                System.out.println("성적이 잘못 입력되었습니다.");
        }
    }
}
