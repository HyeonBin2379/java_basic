package javabasic_02.day11.sec06.package1;

public class B {
	//메소드 선언
    public void method() {
        // 클래스 B에서 A라는 객체를 사용
        // protected가 사용된 멤버 요소는 같은 패키지 소속의 다른 클래스에서 접근 가능
        A a = new A();
        a.field = "value";
        a.method();
    }

    public static void main(String[] args) {
        B b = new B();
        b.method();
    }
}