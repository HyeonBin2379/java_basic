package javabasic_02.day11.homework.inheritance.quiz3;

public class CheckingAccount extends Account {

    private String cardNo;

    public CheckingAccount(String accId, String ownerName, long balance, String cardNo) {
        super(accId, balance, ownerName);
        this.cardNo = cardNo;
    }

    @Override
    public void calcRate() {

    }

    public void pay(String cardNo, long amount) {
        if (this.cardNo.equals(cardNo) && amount < this.getBalance()) {
            this.withdraw(amount);
        } else {
            System.out.println("지불이 불가능합니다.");
        }
    }
}
