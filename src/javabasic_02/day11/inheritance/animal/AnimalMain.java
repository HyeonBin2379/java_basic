package javabasic_02.day11.inheritance.animal;

public class AnimalMain {

    public static void main(String[] args) {
        Cat objCat = new Cat();
        objCat.meow();
        objCat.eat();

        Dog objDog = new Dog();
        objDog.bark();
        objDog.eat();
    }
}
