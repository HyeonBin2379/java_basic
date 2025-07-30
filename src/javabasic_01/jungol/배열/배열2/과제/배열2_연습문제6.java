package javabasic_01.jungol.배열.배열2.과제;

import java.util.Scanner;

public class 배열2_연습문제6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] student = new int[4][4];

        for (int i = 0; i < 3; i++) {
            System.out.printf("%d번째 학생의 점수 ", i+1);
            for (int j = 0; j < 3; j++) {
                student[i][j] = sc.nextInt();       // i+1번째 학생의 과목별 점수
                student[i][3] += student[i][j];     // 학생별 총점 계산
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                student[3][i] += student[j][i];     // 과목별 총점 계산
            }
            student[3][3] += student[3][i];         // 전체 점수 총합 계산
        }

        System.out.println("     국어 영어 수학 총점");
        for (int i = 1; i <= 4; i++) {
            if (i < 4) {
                System.out.printf(" %d번 ", i);
            } else {
                System.out.printf("합계 ");
            }
            for (int j = 0; j < 4; j++) {
                System.out.printf("%3d ", student[i - 1][j]);
            }
            System.out.println();
        }
    }
}
