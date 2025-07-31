package javabasic_02.test.loop_array;

import java.util.Scanner;

public class JavaBasic8 {

    private static final String MENU = """
            -------------------------------
            1.예금 | 2.출금 | 3.잔고 | 4.종료
            -------------------------------""";
    private static int remainedMoney;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu:
        while (true) {
            System.out.println(MENU);
            System.out.print("선택> ");
            int menuNumber = sc.nextInt();
            switch (menuNumber) {
                case 1:
                    System.out.print("예금액>");
                    int deposit = sc.nextInt();
                    remainedMoney += deposit;
                    break;
                case 2:
                    System.out.print("출금액>");
                    int withdraw = sc.nextInt();
                    remainedMoney -= withdraw;
                    break;
                case 3:
                    System.out.printf("잔고>%d\n", remainedMoney);
                    break;
                case 4:
                    System.out.println("\n프로그램 종료");
                    break Menu;
                default:
                    System.out.println("1~4 사이의 숫자만 입력해주세요.");
            }
            System.out.println();
        }
    }
}
