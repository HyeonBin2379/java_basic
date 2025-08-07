package javabasic_02.day11.sec04.exam01;

public class Computer extends Calculator {

    Computer() {
        super();
    }

	//메소드 오버라이딩
    // @Override: 정확히 오버라이딩 되었는지를 컴파일 시점에 체크하는 어노테이션
    @Override
    public double areaCircle(double r) {
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }
}