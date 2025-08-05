package javabasic_02.day10.morningtest.bank;

import java.util.Scanner;

public class BankApplication {

    private static final Scanner sc = new Scanner(System.in);
    private static final String MENU = """
            ---------------------------------------------
            1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료
            ---------------------------------------------
            선택>\s""";

    private static final String TITLE_FORMAT = """
            -----------
            %s
            -----------
            """;
    private static final Account[] accounts = new Account[100];

    private static boolean isRunning = true;
    private static int count;

    public static void main(String[] args) {
        while (isRunning) {
            selectMenu();
        }
    }

    public static void selectMenu() {
        try {
            System.out.print(MENU);
            int menuNum = Integer.parseInt(sc.nextLine());

            switch (menuNum) {
                case 1:
                    addNewAccount();
                    break;
                case 2:
                    printAccounts();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    exitMenu();
                    break;
                default:
                    System.out.println("1~5 사이의 숫자만 입력 가능합니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addNewAccount() {
        System.out.printf(TITLE_FORMAT, "계좌생성");

        System.out.print("계좌번호: ");
        String accountNum = sc.nextLine();
        System.out.print("계좌주: ");
        String name = sc.nextLine();

        try {
            System.out.print("초기입금액: ");
            int balance = Integer.parseInt(sc.nextLine());

            if (balance < 0) {
                throw new NumberFormatException("잔고는 음수가 될 수 없습니다.");
            }
            Account newAccount = new Account(accountNum, name, balance);
            accounts[count++] = newAccount;
            System.out.println("결과: 계좌가 생성되었습니다.");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            addNewAccount();
        }
    }

    public static void printAccounts() {
        System.out.printf(TITLE_FORMAT, "계좌목록");
        for (int i = 0; i < count; i++) {
            System.out.println(accounts[i]);
        }
    }

    public static void deposit() {
        try {
            System.out.printf(TITLE_FORMAT, "예금");
            System.out.print("계좌번호: ");
            String target = sc.nextLine();
            System.out.print("예금액: ");
            int money = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < count; i++) {
                String account = accounts[i].getAccountNumber();
                if (account.equals(target)) {
                    accounts[i].deposit(money);
                    return;
                }
            }
            System.out.println("결과: 입금할 계좌가 존재하지 않습니다.");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            deposit();
        }
    }

    public static void withdraw() {
        try {
            System.out.printf(TITLE_FORMAT, "출금");
            System.out.print("계좌번호: ");
            String target = sc.nextLine();
            System.out.print("출금액: ");
            int money = Integer.parseInt(sc.nextLine());
            if (money < 0) {
                throw new NumberFormatException("출금액은 음수가 될 수 없습니다.");
            }

            for (int i = 0; i < count; i++) {
                String account = accounts[i].getAccountNumber();
                if (account.equals(target)) {
                    accounts[i].withdraw(money);
                    System.out.println("결과: 출금이 성공되었습니다.");
                    return;
                }
            }
            System.out.println("결과: 출금할 계좌가 존재하지 않습니다.");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            withdraw();
        }
    }

    public static void exitMenu() {
        System.out.println("프로그램 종료");
        isRunning = false;
    }
}
