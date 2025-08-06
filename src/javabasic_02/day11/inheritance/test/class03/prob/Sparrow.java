package javabasic_02.day11.inheritance.test.class03.prob;

public class Sparrow implements Bird {

    private String name;
    private int length;

    public void fly() {
        System.out.printf("참새(%s)가 날아다닙니다.\n", name);
    }

    public void sing() {
        System.out.printf("참새(%s)가 소리내어 웁니다.\n", name);
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "참새의 이름은 " + name + " 입니다.";
    }
}
