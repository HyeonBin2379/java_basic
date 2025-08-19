package java_advanced_01.day17.anonymousclass.class05;

public interface Operate {

    // 추상 메서드
    int operate(int a, int b);

    // 디폴트 메서드
    default void print() {
        System.out.println("print");
    }
}
