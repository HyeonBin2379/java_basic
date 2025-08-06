package javabasic_02.day11.inheritance.family;

public class SubFather extends GrandFather {
    private String job = "프로그래머";
    private String houseAddress = "인천";

    public void printFather() {
        System.out.println("나의 집은 " + houseAddress);
        System.out.println("나는 아버지입니다! 나는 할아버지로부터 상속받습니다.");
    }

    public String getJob() {
        return job;
    }

    public String getHouseAddress() {
        return houseAddress;
    }
}
