package javabasic_02.day12.afternoon.quiz.interface_ex6;

public class SundableExample {

    public static void printSound(Soundable soundable) {
        System.out.println(soundable.sound());
    }

    public static void main(String[] args) {
        printSound(new Cat());
        printSound(new Dog());
    }
}
