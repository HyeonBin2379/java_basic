package java_advanced_01.day17.lambdaEx;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class Main2 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);

        // 다양한 람다 표현식 용례
        UnaryOperator<Integer> square = x -> x*x;
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a+b;
        Runnable run = () -> System.out.println("hello!!");
    }
}
