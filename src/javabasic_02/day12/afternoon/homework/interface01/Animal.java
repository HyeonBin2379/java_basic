package javabasic_02.day12.afternoon.homework.interface01;

public abstract class Animal {

    protected int speed;
    protected double distance;

    public Animal(int speed) {
        this.speed = speed;
    }

    public abstract void run(int hours);

    public double getDistance() {
        return distance;
    }
}
