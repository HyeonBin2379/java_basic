package javabasic_02.day11.constructor.homework.q1;

public class Rectangle {

    private int width;
    private int height;
    private int area;

    private String color;

    public Rectangle() {
        this(0, 0, "흰색");
    }

    public Rectangle(int width, int height) {
        this(width, height, "흰색");
    }

    public Rectangle(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void calculateArea() {
        this.area = this.width * this.height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
