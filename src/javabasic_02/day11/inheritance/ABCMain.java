package javabasic_02.day11.inheritance;

public class ABCMain {

    public static void main(String[] args) {
        CC c = new CC();

        System.out.println(c.getDD());
        System.out.println(c.getCC());
        System.out.println(c.getBB());
        System.out.println(c.getAA());

        int result = c.getAA() + c.getBB() + c.getCC() + c.getDD();
        System.out.println(result);
    }
}
