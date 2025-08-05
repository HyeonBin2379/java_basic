package javabasic_02.day10.morningtest.bank;

public class Account {

    private static final int MIN_BALANCE = 0;
    private static final int MAX_BALANCE = 1000000;

    private final String accountNumber;
    private final String name;
    private int balance;

    public Account(String accountNumber, String name, int balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance < MIN_BALANCE || balance > MAX_BALANCE) {
            throw new NumberFormatException("금액에 음수 입력 불가");
        }
        this.balance = balance;
    }

    public void deposit(int money) {
        this.balance += money;
    }

    public void withdraw(int money) {
        if (money > this.balance) {
            throw new NumberFormatException("잔고 부족");
        }
        this.balance -= money;
    }

    @Override
    public String toString() {
        return String.format("%-11s%s\t%s", accountNumber, name, balance);
    }
}
