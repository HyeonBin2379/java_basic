package javabasic_02.test.loop_array;

import java.util.Scanner;

public class JavaBasic9 {

    private static final Scanner sc = new Scanner(System.in);
    private static final String MENU = """
            -------------------------------------------------
            1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
            -------------------------------------------------""";
    private static int[] scores;    // 점수 정보

    public static void main(String[] args) {
        while (true) {
            int menuNumber = selectMenu();  // 메뉴 번호

            switch (menuNumber) {
                case 1 -> makeArray();          // 배열 생성
                case 2 -> setScores();          // 학생별 점수 입력
                case 3 -> printScores();        // 학생별 점수 출력
                case 4 -> printMaxAndAverage(); // 최고점과 전체 평균 출력
                case 5 -> {
                    System.out.println("프로그램 종료");
                    return;
                }
                default -> System.out.println("1~5 사이의 정수를 입력해주세요.");
            }
        }
    }

    public static int selectMenu() {
        System.out.println(MENU);
        System.out.print("선택> ");
        return sc.nextInt();
    }

    public static void makeArray() {
        System.out.print("학생수> ");
        int len = sc.nextInt();
        scores = new int[len];
    }

    public static void setScores() {
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("scores[%d]: ", i);
            scores[i] = sc.nextInt();
        }
    }

    public static void printScores() {
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("scores[%d]: %d\n", i, scores[i]);
        }
    }

    public static void printMaxAndAverage() {
        int max = getMaxScore();
        System.out.printf("최고 점수: %d\n", max);
        double avg = getAverageScore();
        System.out.printf("평균 점수: %.1f\n", avg);
    }

    private static int getMaxScore() {
        int max = 0;
        for (int i = 0; i < scores.length; i++) {
            max = Math.max(scores[i], max);
        }
        return max;
    }

    private static double getAverageScore() {
        int total = 0;
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }
        return (double)total/scores.length;
    }
}
