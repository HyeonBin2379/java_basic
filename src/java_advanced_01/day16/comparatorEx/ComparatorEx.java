package java_advanced_01.day16.comparatorEx;

import java.util.TreeSet;

public class ComparatorEx {

    public static void main(String[] args) {
        // Comparator를 사용한 자동 정렬 -> FruitComparator를 사용하여 과일 정렬 기준을 설정
        TreeSet<Fruit> fruits = new TreeSet<>(new FruitComparator());
        fruits.add(new Fruit("Apple", 10));
        fruits.add(new Fruit("Banana", 5));

        for (Fruit fruit : fruits) {
            System.out.println(fruit.name + " : " + fruit.price);
        }
    }
}
