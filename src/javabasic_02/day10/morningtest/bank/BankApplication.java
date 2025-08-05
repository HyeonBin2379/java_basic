package javabasic_02.day10.morningtest.bank;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BankApplication {

    private static final Scanner SC = new Scanner(System.in);

    // 메뉴 출력 형식
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
            chooseMenu();
        }
    }

    private static void chooseMenu() {
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
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력 가능합니다.");
        }
    }

    // 1. 계좌 생성
    private static void createAccount() {
        System.out.printf(TITLE_FORMAT, "계좌생성");
        try {
            System.out.print("계좌번호: ");
            String accountNum = SC.nextLine();
            if (accountNum.isEmpty()) {
                throw new IllegalArgumentException("계좌번호를 입력해 주세요.");
            }
            if (hasAccount(accountNum)) {
                System.out.println("이미 존재하는 계좌입니다. 계좌를 생성할 수 없습니다.");
                return;
            }

            System.out.print("계좌주: ");
            String owner = SC.nextLine();
            if (owner.isEmpty()) {
                throw new IllegalArgumentException("계좌주를 입력해 주세요.");
            }

            System.out.print("초기입금액: ");    // 금액은 0 이상의 양의 정수
            int balance = Integer.parseUnsignedInt(SC.nextLine());

            // 생성된 계좌를 계좌목록에 저장한 다음, count를 1 증가시켜 저장된 계좌의 수 갱신
            Account newAccount = new Account(accountNum, owner, balance);
            accounts[count++] = newAccount;

            System.out.println("결과: 계좌가 생성되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createAccount();    // 입력 중 예외 발생 시 처음부터 다시 진행
        }
    }
    private static boolean hasAccount(String accountNo) {
        return IntStream.range(0, count)
                .mapToObj(idx -> accounts[idx].getAccountNo())
                .anyMatch(accNum -> accNum.equals(accountNo));
    }

    // 2. 계좌목록 보기 기능
    private static void accountList() {
        System.out.printf(TITLE_FORMAT, "계좌목록");
        Arrays.stream(accounts, 0, count).forEach(System.out::println);
    }

    // 3. 예금 기능
    private static void deposit() {
        try {
            System.out.printf(TITLE_FORMAT, "예금");
            // 입금할 계좌번호, 입금액 입력
            System.out.print("계좌번호: ");
            String accountNum = SC.nextLine();
            if (accountNum.isEmpty()) {
                throw new IllegalArgumentException("계좌번호를 입력해 주세요.");
            }

            // 금액은 항상 0 이상의 양의 정수를 입력해야 함 - 이 범위 바깥의 정수 입력 시 NumberFormatException 발생
            System.out.print("예금액: ");
            int money = Integer.parseUnsignedInt(SC.nextLine());

            for (int i = 0; i < count; i++) {
                String account = accounts[i].getAccountNo();

                if (account.equals(accountNum)) {    // 찾는 계좌가 존재
                    // 예금 이후 금액 계산 후 갱신
                    int afterDeposit = accounts[i].getBalance() + money;
                    accounts[i].setBalance(afterDeposit);
                    return;
                }
            }
            System.out.println("결과: 입금할 계좌가 존재하지 않습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            deposit();  // 예금액 잘못 입력 시 처음부터 다시 진행
        }
    }

    // 4. 출금
    private static void withdraw() {
        try {
            System.out.printf(TITLE_FORMAT, "출금");
            // 출금할 계좌번호, 출금액 입력
            System.out.print("계좌번호: ");
            String accountNum = SC.nextLine();
            if (accountNum.isEmpty()) {
                throw new IllegalArgumentException("계좌번호를 입력해 주세요.");
            }

            // 금액은 항상 0 이상의 양의 정수를 입력해야 함 - 이 범위 바깥의 정수 입력 시 NumberFormatException 발생
            System.out.print("출금액: ");
            int money = Integer.parseUnsignedInt(SC.nextLine());

            for (int i = 0; i < count; i++) {
                String account = accounts[i].getAccountNo();

                if (account.equals(accountNum)) {    // 찾는 계좌가 존재
                    // 출금 이후 금액 계산 후 갱신
                    int afterWithdraw = accounts[i].getBalance() - money;
                    accounts[i].setBalance(afterWithdraw);
                    System.out.println("결과: 출금이 성공되었습니다.");
                    return;
                }
            }
            System.out.println("결과: 출금할 계좌가 존재하지 않습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 5. 프로그램 종료 기능
    private static void exitApp() {
        System.out.println("프로그램 종료");
        isRunning = false;
        SC.close();
    }
}
