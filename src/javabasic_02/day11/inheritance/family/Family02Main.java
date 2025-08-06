package javabasic_02.day11.inheritance.family;

public class Family02Main {

    public static void main(String[] args) {
        SubSon objSon = new SubSon();
        objSon.printSon();
        objSon.printFather();

        SubDaughter objDaughter = new SubDaughter();
        objDaughter.printDaughter();
        objDaughter.printFather();
    }
}
