package javabasic_02.day11.homework.polymorphism.class03.prob;

public class Truck extends Wheeler{

    public Truck(String carName, int velocity, int wheelNumber) {
        this.carName = carName;
        this.velocity = velocity;
        this.wheelNumber = wheelNumber;
    }

    @Override
    public void speedUp(int speed) {
        velocity += 5*speed;
        if (velocity > 100) {
            velocity = 100;
            System.out.printf("%s의 최고속도위반으로 속도를 %d으로 낮춥니다.\n", carName, velocity);
        } else {
            System.out.printf("%s의 현재 속도는 %d 입니다.\n", carName, velocity);
        }
    }

    @Override
    public void speedDown(int speed) {
        velocity -= 5*speed;
        if (velocity < 50) {
            velocity = 50;
            System.out.printf("%s의 최저속도위반으로 속도를 %d으로 올립니다.\n", carName, velocity);
        } else {
            System.out.printf("%s의 현재 속도는 %d 입니다.", carName, velocity);
        }
    }
}
