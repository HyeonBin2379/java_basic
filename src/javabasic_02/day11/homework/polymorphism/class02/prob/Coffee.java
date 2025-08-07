package javabasic_02.day11.homework.polymorphism.class02.prob;

public class Coffee extends Beverage {

    static int amount;

    public Coffee(String name) {
        super(name);
        calcPrice();
        amount++;
    }

    @Override
    public void calcPrice() {
        switch (this.getName()) {
            case "Americano" -> this.setPrice(1500);
            case "CafeLatte" -> this.setPrice(2500);
            case "Cappuccino" -> this.setPrice(3000);
        }
    }
}
