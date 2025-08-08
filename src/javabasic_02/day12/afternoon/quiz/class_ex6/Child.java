package javabasic_02.day12.afternoon.quiz.class_ex6;

public class Child extends Parent {

    public int studentNo;

    // Parent 클래스에 기본 생성자를 추가하거나, 아래와 같이 super()를 사용
    public Child(String name, int studentNo) {
        super(name);
//        this.name = name;
        this.studentNo = studentNo;
    }
}
