package javabasic_02.day11.sec06.package2;


import javabasic_02.day11.sec06.package1.A;

public class C {
	//메소드 선언
    public void method() {
        // protected가 붙은 멤버 요소는 상속 관계가 아닌 다른 패키지 소속 클래스에서 접근 불가
//        A a = new A();
//        a.field = "value";
//        a.method();
    }
}