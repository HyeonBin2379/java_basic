package javabasic_02.test.loop_array;

import java.util.Scanner;

public class JavaBasic8 {

    private static final Scanner sc = new Scanner(System.in);
    private static final String MENU = """
            -------------------------------
            1.예금 | 2.출금 | 3.잔고 | 4.종료
            -------------------------------
            선택>\s""";

    private static boolean isRunning = true;
    private static int balance;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        while (isRunning) {
            int menuNumber = selectMenu();

            switch (menuNumber) {
                case 1 -> deposit();
                case 2 -> withdraw();
                case 3 -> printBalance();
                case 4 -> exitMenu();
            }
        }
    }

    public static int selectMenu() {
        try {
            System.out.print(MENU);
            int menuNumber = Integer.parseInt(sc.nextLine());
            if (menuNumber < 1 || menuNumber > 4) {
                throw new NumberFormatException("1~4 사이의 숫자만 입력해주세요.");
            }
            return menuNumber;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return selectMenu();
        }
    }

    public static void deposit() {
        try {
            System.out.print("예금액>");
            int deposit = Integer.parseInt(sc.nextLine());
            if (deposit <= 0) {
                throw new DepositException();
            }
            balance += deposit;
            System.out.println();
        } catch (DepositException e) {
            System.out.println(e.getMessage());
            deposit();
        }
    }

    public static void withdraw() {
        try {
            System.out.print("출금액>");
            int withdraw = Integer.parseInt(sc.nextLine());
            if (withdraw <= 0 || balance < withdraw) {
                throw new WithdrawException();
            }
            balance -= withdraw;
            System.out.println();
        } catch (WithdrawException e) {
            System.out.println(e.getMessage());
            withdraw();
        }
    }

    public static void printBalance() {
        System.out.printf("잔고>%d\n\n", balance);
    }

    public static void exitMenu() {
        System.out.println("\n프로그램 종료");
        isRunning = false;
    }

    static class DepositException extends NumberFormatException {
        private String message = "유효하지 않은 예금액입니다.";

        public DepositException() {
            super();
        }
        public DepositException(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }
    static class WithdrawException extends NumberFormatException {
        private String message = "유효하지 않은 출금액입니다.";

        public WithdrawException() {
            super();
        }
        public WithdrawException(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }
}
