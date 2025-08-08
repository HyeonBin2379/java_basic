package javabasic_02.day12.afternoon.sec02;

public class User {

    public static void main(String[] args) {
        InterfaceImpl impl = new InterfaceImpl();

        // InterfaceA에 정의된 메서드만 호출
        InterfaceA ia = impl;
        ia.methodA();

        // InterfaceB에 정의된 메서드만 호출
        InterfaceB ib = impl;
        ib.methodB();

        // InterfaceA, InterfaceB, InterfaceC에 정의된 메서드 모두 호출
        // 인터페이스 상속을 통해, 일부 기능만을 사용하도록 권한을 제한 가능(ex: 구독 서비스)
        InterfaceC ic = impl;
        ia.methodA();
        ib.methodB();
        ic.methodC();
    }
}
