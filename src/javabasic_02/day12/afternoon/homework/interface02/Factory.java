package javabasic_02.day12.afternoon.homework.interface02;

public abstract class Factory {

    private String name;
    private int openHour;
    private int closedHour;

    Factory() {
    }

    Factory(String name, int openHour, int closedHour) {
        this.name = name;
        this.openHour = openHour;
        this.closedHour = closedHour;
    }

    String getFactoryName() {
        return this.name;
    }

    int getWorkingTime() {
        return this.closedHour-this.openHour;
    }

    abstract int makeProducts(char skill);
}
