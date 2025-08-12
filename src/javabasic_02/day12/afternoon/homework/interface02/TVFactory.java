package javabasic_02.day12.afternoon.homework.interface02;

public class TVFactory extends Factory implements IWorkingTogether {

    TVFactory() {}
    TVFactory(String name, int openHour, int closedHour) {
        super(name, openHour, closedHour);
    }

    @Override
    int makeProducts(char skill) {
        int products;
        switch (skill) {
            case 'A' -> products = 8 * getWorkingTime();
            case 'B' -> products = 5 * getWorkingTime();
            case 'C' -> products = 3 * getWorkingTime();
            default -> products = getWorkingTime();
        }
        return products;
    }

    @Override
    public int workTogether(IWorkingTogether partner) {
        // 동일 타입의 공장끼리 협력
        return ((TVFactory) partner).makeProducts('C');
    }
}
