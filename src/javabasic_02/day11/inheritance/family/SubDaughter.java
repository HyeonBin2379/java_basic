package javabasic_02.day11.inheritance.family;

public class SubDaughter extends SubFather {

    public void printDaughter() {
        System.out.println("나는 딸입니다.");
        System.out.println("나는 아버지로부터 상속받습니다.");
        System.out.println("나의 아버지는 " + this.getJob());
    }
}
