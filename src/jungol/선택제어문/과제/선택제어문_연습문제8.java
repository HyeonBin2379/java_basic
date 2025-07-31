package jungol.선택제어문.과제;

import java.util.Scanner;

public class 선택제어문_연습문제8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("점수를 입력하세요. ");
        int score = sc.nextInt();

        if (score >= 90 && score <= 100) {
            System.out.println("A");
        } else if (score >= 80 && score < 90) {
            System.out.println("B");
        } else if (score >= 70 && score < 80) {
            System.out.println("C");
        } else if (score >= 60 && score < 70) {
            System.out.println("D");
        } else if (score >= 0 && score < 60){
            System.out.println("F");
        } else {
            System.out.println("0에서 100 사이의 점수를 입력해주세요.");
        }
    }
}
