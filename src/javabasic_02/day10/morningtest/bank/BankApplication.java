package javabasic_02.day10.morningtest.bank;

import java.util.Scanner;

public class BankApplication {

    private static final Scanner SC = new Scanner(System.in);

    // 각 메뉴 출력 형식
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

    private static final Account[] accounts = new Account[100]; // 계좌 목록
    private static int count;   // 개설된 계좌의 개수

    private static boolean isRunning = true;

    public static void main(String[] args) {
        while (isRunning) {
            selectMenu();
        }
    }

    public static void selectMenu() {
        try {
            // 메뉴 번호 선택
            System.out.print(MENU);
            int choice = Integer.parseInt(SC.nextLine());

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> accountList();
                case 3 -> deposit();
                case 4 -> withdraw();
                case 5 -> exitApp();
                default -> System.out.println("1~5 사이의 숫자만 입력 가능합니다.");
            }
        } catch (NumberFormatException ne) {
            System.out.println(ne.getMessage());
        }
    }

    // 1. 계좌 생성
    private static void createAccount() {
        System.out.printf(TITLE_FORMAT, "계좌생성");
        try {
            System.out.print("계좌번호: ");
            String accountNum = SC.nextLine();

            System.out.print("계좌주: ");
            String owner = SC.nextLine();

            System.out.print("초기입금액: ");    // 계산해야 하므로 정수 형변환
            int balance = Integer.parseUnsignedInt(SC.nextLine());

            // 계좌 생성 후 계좌목록에 저장
            Account newAccount = new Account(accountNum, owner, balance);
            accounts[count++] = newAccount;
            System.out.println("결과: 계좌가 생성되었습니다.");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            createAccount();    // 예외 발생 시 처음부터 다시 진행
        }
    }

    // 2. 계좌목록 보기 기능
    private static void accountList() {
        System.out.printf(TITLE_FORMAT, "계좌목록");
        for (int i = 0; i < count; i++) {
            System.out.println(accounts[i]);
        }
    }

    // 3. 예금 기능
    private static void deposit() {
        try {
            System.out.printf(TITLE_FORMAT, "예금");
            System.out.print("계좌번호: ");
            String accountNo = SC.nextLine();
            System.out.print("예금액: ");

            // 금액은 항상 0 이상의 양의 정수
            int money = Integer.parseUnsignedInt(SC.nextLine());
            for (int i = 0; i < count; i++) {
                String account = accounts[i].getAccountNo();

                // 찾는 계좌가 존재하면 예금
                if (account.equals(accountNo)) {
                    int deposit = accounts[i].getBalance() + money;
                    accounts[i].setBalance(deposit);
                    return;
                }
            }
            System.out.println("결과: 입금할 계좌가 존재하지 않습니다.");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            deposit();  // 예외 발생 시 처음부터 다시 진행
        }
    }

    // 4. 출금
    private static void withdraw() {
        try {
            System.out.printf(TITLE_FORMAT, "출금");
            System.out.print("계좌번호: ");
            String accountNo = SC.nextLine();
            System.out.print("출금액: ");
            int money = Integer.parseUnsignedInt(SC.nextLine());
            if (money < 0) {
                throw new NumberFormatException("출금액은 음수가 될 수 없습니다.");
            }

            for (int i = 0; i < count; i++) {
                String account = accounts[i].getAccountNo();

                // 찾는 계좌가 존재하면 출금
                if (account.equals(accountNo)) {
                    int withdraw = accounts[i].getBalance()-money;
                    accounts[i].setBalance(withdraw);
                    System.out.println("결과: 출금이 성공되었습니다.");
                    return;
                }
            }
            System.out.println("결과: 출금할 계좌가 존재하지 않습니다.");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            withdraw(); // 예외 발생 시 처음부터 다시 진행
        }
    }

    // 5. 프로그램 종료 기능
    private static void exitApp() {
        System.out.println("프로그램 종료");
        isRunning = false;
        SC.close();
    }
}
