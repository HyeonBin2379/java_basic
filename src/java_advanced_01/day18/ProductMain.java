package java_advanced_01.day18;

import java.util.ArrayList;
import java.util.List;

public class ProductMain {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "제품1", "회사1", 10000));
        products.add(new Product(2, "제품2", "회사2", 5000));
        products.add(new Product(3, "제품3", "회사3", 6000));
        products.add(new Product(4, "제품4", "회사4", 12000));
        products.add(new Product(5, "제품5", "회사5", 9000));

        products.stream().forEach(System.out::println);
    }
}
