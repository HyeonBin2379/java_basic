package java_advanced_01.day16.comparableEx;

import java.util.TreeSet;

public class Fruit implements Comparable<Fruit> {

    private String name;
    private int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Fruit o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Fruit apple = new Fruit("사과", 10000);
        Fruit mandarin = new Fruit("귤", 12000);
        Fruit peach = new Fruit("복숭아", 8000);
        Fruit grape = new Fruit("포도", 18000);

        // Comparable을 사용한 자동 정렬
        TreeSet<Fruit> fruitShop1 = new TreeSet<>();
        fruitShop1.add(apple);
        fruitShop1.add(mandarin);
        fruitShop1.add(peach);
        fruitShop1.add(grape);

        for (Fruit fruit : fruitShop1) {
            System.out.println(fruit.name + " : " + fruit.price);
        }
    }
}
