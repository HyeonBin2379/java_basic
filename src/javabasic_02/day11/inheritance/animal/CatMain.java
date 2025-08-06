package javabasic_02.day11.inheritance.animal;

public class CatMain {

    public static void main(String[] args) {
        Cat obj = new Cat();
        obj.meow();
        obj.eat();

        Kitten objKitten = new Kitten();
        objKitten.meow2();
        objKitten.meow();
        objKitten.eat();
    }
}
