package javabasic_02.test.loop_array;

import java.util.Scanner;

public class JavaBasic8 {

    private static final Scanner sc = new Scanner(System.in);
    private static final String MENU = """
            -------------------------------
            1.예금 | 2.출금 | 3.잔고 | 4.종료
            -------------------------------""";

    private static int remainedMoney;

    public static void main(String[] args) throws Exception {
        Menu:
        while (true) {
            int menuNumber = selectMenu();
            switch (menuNumber) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
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

    public static int selectMenu() {
        System.out.println(MENU);
        System.out.print("선택> ");
        return sc.nextInt();
    }

    public static void deposit() {
        System.out.print("예금액>");
        int deposit = sc.nextInt();
        remainedMoney += deposit;
    }

    public static void withdraw() throws Exception{
        System.out.print("출금액>");
        int withdraw = sc.nextInt();
        if (remainedMoney < withdraw) {
            throw new Exception("잔고 부족");
        } else {
            remainedMoney -= withdraw;
        }
    }
}
