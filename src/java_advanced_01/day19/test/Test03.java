package java_advanced_01.day19.test;

public class Test03 {

    int i;
    Integer iI;

    public void sayHello() {
        System.out.println("say hello");
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
//        iI = new Integer(10)
        System.out.println(test03.i);
        System.out.println(test03.iI);
        test03.sayHello();
    }
}
