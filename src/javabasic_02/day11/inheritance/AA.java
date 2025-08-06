package javabasic_02.day11.inheritance;

public class AA {

    // private인 부모 클래스의 멤버 요소에는 자식 클래스로 접근 불가
    private int aa = 10;
    private int bb = 20;

    void printAA() {
        System.out.println(aa);
    }

    public int getAA() {
        return aa;
    }

    public int getBB() {
        return bb;
    }
}
