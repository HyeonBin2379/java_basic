package java_advanced_01.day18;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayStreamEx {

    public static void main(String[] args) {
        String[] strings = new String[] {"1", "2", "3", "4", "5"};
        Stream<String> stream = Arrays.stream(strings);
        stream.forEach(item -> System.out.print(item + " "));
        System.out.println();

        Integer[] integers = new Integer[] {1, 2, 3, 4, 5};
        Arrays.stream(integers).forEach(num -> System.out.print(num + " "));
    }
}
