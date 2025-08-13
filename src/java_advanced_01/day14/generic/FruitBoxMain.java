package java_advanced_01.day14.generic;

public class FruitBoxMain {

    public static void main(String[] args) {
        // 제네릭 타입 매개변수에 정수 타입을 할당
        FruitBox<Integer> intBox1 = new FruitBox<>();

        // 제네릭 타입 매개변수에 실수 타입을 할당
        FruitBox<Double> intBox2 = new FruitBox<>();

        // 제네릭 타입 매개변수에 문자열 타입을 할당
        FruitBox<String> intBox3 = new FruitBox<>();

        // 제네릭 타입 매개변수에 Apple 타입을 할당
        FruitBox<Apple> intBox4 = new FruitBox<>();
        for (int i = 0; i < 5; i++) {
            intBox4.add(new Apple());
        }
    }
}
