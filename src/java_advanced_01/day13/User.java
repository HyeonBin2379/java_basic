package java_advanced_01.day13;

public class User {

    public static void main(String[] args) {
        // 구현 객체 생성
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();

        // 생성한 구현객체를 1개의 인터페이스 타입으로 묶는 것이 가능
        // 인터페이스를 통해 구현 객체의 메서드를 사용 가능
        A a;
        a = b;
        a = c;
        a = d;
        a = e;
    }
}
