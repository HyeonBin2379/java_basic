package javabasic_02.test.loop_array;

import java.util.Scanner;

public class JavaBasic8 {

    private static final Scanner sc = new Scanner(System.in);
    private static final String MENU = """
            -------------------------------
            1.예금 | 2.출금 | 3.잔고 | 4.종료
            -------------------------------""";

    private static int remainedMoney;   // 남은 금액

    public static void main(String[] args) throws Exception {
        while (true) {
            int menuNumber = selectMenu();  // 메뉴 번호 입력
            switch (menuNumber) {
                case 1 -> deposit();        // 1. 예금
                case 2 -> withdraw();       // 2. 출금
                case 3 -> System.out.printf("잔고>%d\n", remainedMoney);  // 3. 잔고 출력
                case 4 -> {
                    System.out.println("\n프로그램 종료");    // 프로그램 종료
                    return;
                }
                default -> System.out.println("1~4 사이의 숫자만 입력해주세요.");
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
