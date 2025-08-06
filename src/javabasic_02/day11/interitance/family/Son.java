package javabasic_02.day11.interitance.family;

public class Son extends Father {

    private String name = "길동";

    public void printDetails() {
        System.out.println("나의 이름은 " + this.getFamilyName() + name);
        System.out.println("나의 아버지는 프로그래머");
        System.out.println("나의 집은 " + this.getHouseAddress());
    }
}
