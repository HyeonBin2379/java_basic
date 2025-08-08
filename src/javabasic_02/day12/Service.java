package javabasic_02.day12;

public interface Service {
    // 디폴트 메서드
    default void defaultMethod1() {
        System.out.println("default1()");
        defaultCommon();
    }

    default void defaultMethod2() {
        System.out.println("default2()");
        defaultCommon();
    }

    // private 메서드
    private void defaultCommon() {
        System.out.println("defaultMethod의 중복 코드 A");
        System.out.println("defaultMethod의 중복 코드 B");
    }

    // static 메서드
    static void staticMethod1() {
        System.out.println("staticMethod1() 코드");
        staticCommon();
    }

    static void staticMethod2() {
        System.out.println("staticMethod2() 코드");
        staticCommon();
    }

    // private static 메서드
    private static void staticCommon() {
        System.out.println("staticMethod 중복 코드 A");
        System.out.println("staticMethod 중복 코드 B");
    }
}
