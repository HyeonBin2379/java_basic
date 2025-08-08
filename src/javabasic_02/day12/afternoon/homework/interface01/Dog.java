package javabasic_02.day12.afternoon.homework.interface01;

public class Dog extends Animal {

    public Dog(int speed) {
        super(speed);
    }

    @Override
    public void run(int hours) {
        this.distance += this.speed*hours*0.5;
    }
}
