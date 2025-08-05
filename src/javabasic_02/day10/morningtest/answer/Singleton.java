package javabasic_02.day10.morningtest.answer;

public class Singleton {

    private static Singleton instance;

    // 외부에서 Singleton 인스턴스를 생성하지 못하도록 private 처리
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s1);
    }
}
