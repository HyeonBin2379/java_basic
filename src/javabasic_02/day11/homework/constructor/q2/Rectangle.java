package javabasic_02.day11.homework.constructor.q2;

public class Rectangle {
    
    private int width;
    private int length;
    private String color;

    public int perimeter() {
        return 2*(width + length);
    }

    public int area() {
        return width*length;
    }
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
