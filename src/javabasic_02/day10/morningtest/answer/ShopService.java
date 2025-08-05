package javabasic_02.day10.morningtest.answer;

public class ShopService {

    private static ShopService shopService;

    private ShopService() {
    }

    public static ShopService getInstance() {
        if (shopService == null) {
            shopService = new ShopService();
        }
        return shopService;
    }
}