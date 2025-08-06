package javabasic_02.day11.inheritance.test.class03.prob;

public class Account {

    private String accNo;
    private int balance;

    // 입금
    public void save(int money) {
        System.out.println(this.accNo + " 계좌에 " + money + "만원이 입금되었습니다.");
        balance += money;
    }

    // 출금
    public void deposit(int money) {
        System.out.println(this.accNo + " 계좌에 " + money + "만원이 출금되었습니다.");
        if (balance >= money) {
            balance -= money;
        } else {
            System.out.println("잔고가 부족하여 출금할 수 없습니다.");
        }
    }

    // 계좌번호 개설
    public void setAccNo(String accNo) {
        this.accNo = accNo;
        System.out.println(this.accNo + " 계좌가 개설되었습니다.");
    }

    // 계좌번호 확인
    public String getAccNo() {
        return accNo;
    }

    // 잔고 반환
    public int getBalance() {
        return balance;
    }
}
