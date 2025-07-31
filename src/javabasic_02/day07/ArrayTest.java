package javabasic_02.day07;

public class ArrayTest {

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        int[] b = new int[] {10, 20, 30, 40, 50};

        int firstIndexValue = a[0];
        int thirdIndexValue = a[2];
        int result = firstIndexValue + thirdIndexValue;
        System.out.println(result);
    }
}
