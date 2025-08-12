package javabasic_02.day12.afternoon.homework.interface01;

public abstract class Animal {

    int speed;
    double distance;

    Animal() {}
    Animal(int speed) {
        this.speed = speed;
    }

    abstract void run(int hours);

    double getDistance() {
        return distance;
    }
}
