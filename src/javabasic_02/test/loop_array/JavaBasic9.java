package javabasic_02.test.loop_array;

import java.util.Scanner;

public class JavaBasic9 {

    private static final String MENU = """
            --------------------------------------------------
            1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5. 종료
            --------------------------------------------------""";
    private static int[] scores;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu:
        while (true) {
            System.out.println(MENU);
            System.out.print("선택> ");
            int menuNumber = sc.nextInt();
            switch (menuNumber) {
                case 1:
                    System.out.print("학생수> ");
                    int len = sc.nextInt();
                    scores = new int[len];
                    break;
                case 2:
                    for (int i = 0; i < scores.length; i++) {
                        System.out.printf("scores[%d]: ", i);
                        scores[i] = sc.nextInt();
                    }
                    break;
                case 3:
                    for (int i = 0; i < scores.length; i++) {
                        System.out.printf("scores[%d]: %d\n", i, scores[i]);
                    }
                    break;
                case 4:
                    int max = getMaxScore();
                    System.out.printf("최고 점수: %d\n", max);
                    double avg = getAverageScore();
                    System.out.printf("평균 점수: %.1f\n", avg);
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    break Menu;
                default:
                    System.out.println("1~5 사이의 정수를 입력해주세요.");
            }
        }
    }

    public static int getMaxScore() {
        int max = 0;
        for (int i = 0; i < scores.length; i++) {
            max = Math.max(scores[i], max);
        }
        return max;
    }

    public static double getAverageScore() {
        int total = 0;
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }
        return (double)total/scores.length;
    }
}
