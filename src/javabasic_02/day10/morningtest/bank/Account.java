package javabasic_02.day10.morningtest.bank;

public class Account {

    private static final int MIN_BALANCE = 0;
    private static final int MAX_BALANCE = (int)1e6;

    private final String accountNo;   // 계좌번호
    private final String owner;           // 계좌 소유주
    private int balance;            // 통장 잔고

    // 은행에서 계좌 개설 신청 시 개인정보를 은행에 등록하는 첫 과정 -> 생성자를 통해 계좌 정보를 저장할 객체를 생성
    public Account(String accountNo, String owner, int balance) {
        this.accountNo = accountNo;
        this.owner = owner;
        setBalance(balance);
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance < MIN_BALANCE || balance > MAX_BALANCE) {
            throw new NumberFormatException("계좌 잔고 한도를 초과했거나, 잔고가 부족합니다.");
        }
        this.balance = balance;
    }

    @Override
    public String toString() {
        // 계좌 정보 출력 형식 변경
        return String.format("%-10s\t%-5s\t%s", accountNo, owner, balance);
    }
}
