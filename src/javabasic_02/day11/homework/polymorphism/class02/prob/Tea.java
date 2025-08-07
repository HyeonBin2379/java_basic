package javabasic_02.day11.homework.polymorphism.class02.prob;

public class Tea extends Beverage {

    static int amount;

    public Tea(String name) {
        super(name);
        calcPrice();
        amount++;
    }

    @Override
    public void calcPrice() {
        switch (this.getName()) {
            case "lemonTea" -> this.setPrice(1500);
            case "ginsengTea" -> this.setPrice(2000);
            case "redginsengTea" -> this.setPrice(2500);
        }
    }
}
