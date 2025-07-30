package javabasic_01.day05;

public class WhileEx02 {

    public static void main(String[] args) {
        // 1부터 10까지 출력하는 프로그램을 while문으로 작성
        int loop = 1;
        int total = 0;

        while (true) {
            total += loop;

            if (loop == 100) {
                break;
            }

            loop++;
        }

        System.out.println(total);
    }
}
