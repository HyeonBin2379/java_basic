package javabasic_02.day11.homework.inheritance;

public class Drink {

    private String name;
    private int price;
    private int count;

    public Drink(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public static void printTitle() {
        System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\n", "상품명", "단가", "수량", "금액");
    }

    public void printData() {
        System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\n", name, price, count, price*count);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int getTotalPrice() {
        return price*count;
    }
}
