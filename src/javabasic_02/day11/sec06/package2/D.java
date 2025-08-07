package javabasic_02.day11.sec06.package2;

import javabasic_02.day11.sec06.package1.A;

public class D extends A {

    //생성자 선언
    public D() {
        super();    // 부모 클래스인 A의 기본 생성자를 호출
    }

    // protected가 붙은 멤버 요소는 다른 패키지 소속 클래스에서 접근 시 자식 클래스일 때만 접근 가능
	//메소드 선언
    public void method1() {
        this.field = "value";   // A의 필드
        this.method();          // A의 메서드
    }

	//메소드 선언
    public void method2() {
//        A a = new A();
//        a.field = "value";
//        a.method();
    }
}