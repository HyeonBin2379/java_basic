package javabasic_02.day07;

public class DoubleArrayEx01 {

    public static void main(String[] args) {
        // 학생 3명의 국어, 영어, 수학 점수를 관리하는 2차원 배열 만들기
        int[][] scores = new int[3][3];

        // 1번 학생의 국어:90, 영어:50, 수학:80 점수를 저장하고 출력
        scores[0][0] = 90;
        scores[0][1] = 50;
        scores[0][2] = 80;
        // scores[0] = {90, 50, 80};

        // 2번 학생의 국어:80 영어:100 수학:90을 저장하고 출력
        scores[1][0] = 80;
        scores[1][1] = 100;
        scores[1][2] = 90;
        // scores[1] = {80, 100, 90};

        // 3번 학생의 국어:100 영어:90 수학:90을 저장하고 출력
        scores[2][0] = 100;
        scores[2][1] = 90;
        scores[2][2] = 90;
        // scores[2] = {100, 90, 90};

        // 학생별 국어, 영어, 수학 점수 출력
        for (int i = 0; i < 3; i++) {
            System.out.printf((i+1) + "번째 학생의 점수 출력:\n");
            System.out.printf("국어: %d, 영어: %d, 수학 %d\n", scores[i][0], scores[i][1], scores[i][2]);
        }

        // 학생별 과목 점수 총합과 평균 계산
        for (int i = 0; i < 3; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                // 학생별 점수 총합 계산
                total += scores[i][j];
            }

            // 학생별 과목 평균 점수 계산(과목의 개수는 배열의 길이 정보를 사용)
            double avg = (double)total/scores[i].length;
            System.out.printf("학생 %d의 과목별 점수의 총점: %d, 평균: %.1f\n", i+1, total, avg);
        }
    }
}
