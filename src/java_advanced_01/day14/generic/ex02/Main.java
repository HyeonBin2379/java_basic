package java_advanced_01.day14.generic.ex02;

import java.util.ArrayList;
import java.util.List;

class Fruit {}
class Apple extends Fruit {}
class Pear extends Fruit {}
class Banana extends Fruit {}

class FruitBox<T, U> {
    List<T> apples = new ArrayList<>();
    List<U> bananas = new ArrayList<>();

    public void add(T apple, U banana) {
        apples.add(apple);
        bananas.add(banana);
    }
}

public class Main {

    public static void main(String[] args) {
        // 복수 제네릭 타입: 2개 이상의 타입 파라미터 지정 가능
        FruitBox<Apple, Banana> box = new FruitBox<>();

        box.add(new Apple(), new Banana());
        box.add(new Apple(), new Banana());
        box.add(new Apple(), new Banana());
    }
}
