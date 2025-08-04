package javabasic_02.test.loop_array;

import java.util.Scanner;

public class JavaBasic9 {

    private static final Scanner sc = new Scanner(System.in);
    private static final String MENU = """
            -------------------------------------------------
            1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
            -------------------------------------------------
            선택>\s""";

    private static int[] scores;
    private static boolean isRunning = true;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        while (isRunning) {
            try {
                int menuNumber = selectMenu();

                switch (menuNumber) {
                    case 1 -> makeArray();
                    case 2 -> setScores();
                    case 3 -> printScores();
                    case 4 -> analyze();
                    case 5 -> exitMenu();
                }
            } catch (NullPointerException e) {
                System.out.println("점수리스트가 존재하지 않아 작업을 수행할 수 없습니다.");
            }
        }
    }
    public static int selectMenu() {
        try {
            System.out.print(MENU);
            int menuNumber = Integer.parseInt(sc.nextLine());
            if (menuNumber < 1 || menuNumber > 5) {
                throw new NumberFormatException("1~5 사이의 숫자를 입력해주세요.");
            }
            return menuNumber;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return selectMenu();
        }
    }

    public static void makeArray() {
        try {
            System.out.print("학생수> ");
            int len = Integer.parseInt(sc.nextLine());
            if (len == 0) {
                throw new NumberFormatException();
            }
            scores = new int[len];
        } catch (NumberFormatException | NegativeArraySizeException e) {
            System.out.println("유효하지 않은 학생수입니다.");
            makeArray();
        }
    }

    public static void setScores() {
        for (int i = 0; i < scores.length; i++) {
            try {
                System.out.printf("scores[%d]: ", i);
                int score = Integer.parseInt(sc.nextLine());
                if (score < 0 || score > 100) {
                    throw new NumberFormatException("0~100 사이의 숫자만 점수로 입력 가능합니다.");
                }
                scores[i] = score;
            } catch (NumberFormatException e) {
                System.out.printf("%d번 학생의 점수가 유효하지 않습니다. 다시 입력해주세요.\n", i);
                i--;
            }
        }
    }

    public static void printScores() {
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("scores[%d]: %d\n", i, scores[i]);
        }
    }

    public static void analyze() {
        int max = getMaxScore();
        double avg = getAverageScore();

        System.out.printf("최고 점수: %d\n평균 점수: %.1f\n", max, avg);
    }

    public static int getMaxScore() {
        int max = 0;
        for (int score : scores) {
            max = Math.max(score, max);
        }
        return max;
    }

    public static double getAverageScore() {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return (double)total/scores.length;
    }

    public static void exitMenu() {
        System.out.println("프로그램 종료");
        isRunning = false;
    }
}
