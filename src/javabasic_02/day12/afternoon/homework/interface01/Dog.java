package javabasic_02.day12.afternoon.homework.interface01;

public class Dog extends Animal {

    Dog(int speed) {
        this.speed = speed;
    }

    @Override
    void run(int hours) {
        this.distance += (double) (this.speed * hours) / 2;
    }
}
