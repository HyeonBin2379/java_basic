package javabasic_02.day11.homework.polymorphism.class01.prob;

public abstract class Shape {

    protected double area;
    private String name;

    public Shape() {
    }

    public Shape(String name) {
        this.name = name;
    }

    public abstract void calculationArea();

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(name + "의 면적은 " + area);
    }
}
