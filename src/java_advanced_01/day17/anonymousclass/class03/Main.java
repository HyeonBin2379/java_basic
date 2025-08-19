package java_advanced_01.day17.anonymousclass.class03;

class Animal {
    public String eat() {
        return "맛있게 먹습니다.";
    }
}

public class Main {

    public static void main(String[] args) {
        Animal dog = new Animal(){
            @Override
            public String eat() {
                String run = run();
                return "강아지 멍멍 " + run;
            }
            public String run() {
                return "강아지가 달린다.";
            }
        };
        String eat = dog.eat();
        System.out.println(eat);
    }
}
