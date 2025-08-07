package javabasic_02.day11.homework.polymorphism.class01.prob;

public class Rectangular extends Shape {

    private double width;
    private String hight;

    public Rectangular(String name, double width, double hight) {
        super(name);
        this.width = width;
        this.hight = Double.toString(hight);
    }

    @Override
    public void calculationArea() {
        this.area = this.width*Double.parseDouble(this.hight);
    }
}
