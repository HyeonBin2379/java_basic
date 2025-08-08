package javabasic_02.day12.afternoon.homework.interface01;

public class Chicken extends Animal implements Cheatable{

    public Chicken(int speed) {
        super(speed);
    }

    @Override
    public void run(int hours) {
        this.distance += this.speed*hours;
    }

    @Override
    public void fly() {
        this.speed *= 2;
    }
}
