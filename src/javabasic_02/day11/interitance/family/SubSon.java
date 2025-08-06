package javabasic_02.day11.interitance.family;

public class SubSon extends SubFather {

    private String name = "길동";

    public void printSon() {
        System.out.println("나는 아들입니다.");
        System.out.println("나는 아버지로부터 상속받습니다.");
        System.out.println("나의 아버지는 " + this.getJob());
    }
}
