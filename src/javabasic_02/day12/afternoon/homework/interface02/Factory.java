package javabasic_02.day12.afternoon.homework.interface02;

public abstract class Factory {

    protected String name;
    protected int openHour;
    protected int closedHour;

    public Factory(String name, int openHour, int closedHour) {
        this.name = name;
        this.openHour = openHour;
        this.closedHour = closedHour;
    }

    public String getFactoryName() {
        return name;
    }

    public int getWorkingTime() {
        return this.closedHour-this.openHour;
    }

    public abstract int makeProducts(char skill);
}
