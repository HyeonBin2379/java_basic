package javabasic_02.day11.homework.inheritance.quiz2;

public class Tv {

    private String color;
    private boolean power;
    private int channel;

    public Tv() {
        this.color = "black";
        this.power = false;
        this.channel = 0;
    }

    public void power() {
        this.power = !this.power;
    }
    public void channelUp() {
        this.channel += 1;
    }
    public void channelDown() {
        this.channel -= 1;
    }
    public void print() {
        System.out.printf("color: %s\tpower:%s\t\tchannel:%d\n", color, power, channel);
    }
}
