package javabasic_01.jungol.반복제어문.반복제어문3.과제;

import java.util.Scanner;

public class 반복제어문3_연습문제1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 1부터 입력한 수까지의 누적합을 계산
        int lastNum = 1;        // 마지막으로 저장된 수
        int total = 0;
        while (total <= n) {    // 누적합이 입력받은 수 n보다 커질 때 반복 종료
            total += lastNum;

            if (total > n) {
                break;
            }

            ++lastNum;
        }
        System.out.println(lastNum + " " + total);
    }
}
