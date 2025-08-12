package javabasic_02.day12.afternoon.homework.interface02;

public class CarFactory extends Factory implements IWorkingTogether {

    CarFactory(String name, int openHour, int closedHour) {
        super(name, openHour, closedHour);
    }

    @Override
    int makeProducts(char skill) {
        int products;
        switch (skill) {
            case 'A' -> products = 3 * getWorkingTime();
            case 'B' -> products = 2 * getWorkingTime();
            case 'C' -> products = getWorkingTime();
            default -> products = 0;
        }
        return products;
    }

    // 파트너 공장과 협력 시 추가 생산량
    @Override
    public int workTogether(IWorkingTogether partner) {
        return ((CarFactory) partner).makeProducts('B');
    }
}
