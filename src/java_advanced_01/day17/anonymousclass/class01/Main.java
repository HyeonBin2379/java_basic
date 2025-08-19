package java_advanced_01.day17.anonymousclass.class01;

class Animal {
    public void eat() {
        System.out.println("맛있게 먹습니다.");
    }
}
class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("강아지가 냠냠 먹습니다.");
    }
}

public class Main {

    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat();
    }
}
