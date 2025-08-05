package javabasic_02.day10.morningtest.answer;

public class Member {

    private String name;
    private String id;
    private String password;
    private int age;

    public Member() {

    }

    public Member(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) {
        Member user1 = new Member();
        System.out.println(user1.toString());
        System.out.println(user1.name);
        System.out.println(user1.age);
        System.out.println(user1.id);
        System.out.println(user1.password);

        Member user2 = new Member("홍길동", "Hong");
        System.out.println(user1.toString());
        System.out.println(user1.name);
        System.out.println(user1.age);
        System.out.println(user1.id);
        System.out.println(user1.password);
    }
}