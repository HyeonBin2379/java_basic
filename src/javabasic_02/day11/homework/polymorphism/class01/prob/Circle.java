package javabasic_02.day11.homework.polymorphism.class01.prob;

public class Circle extends Shape {

    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public void calculationArea() {
        this.area = Math.PI*radius*radius;
    }
}
