package javabasic_02.day12.afternoon.homework.interface02;

public class CarFactory extends Factory implements IWorkingTogether {

    public CarFactory(String name, int openHour, int closedHour) {
        super(name, openHour, closedHour);
    }

    @Override
    public int makeProducts(char skill) {
        int products;
        switch (skill) {
            case 'A' -> products = 3 * getWorkingTime();
            case 'B' -> products = 2 * getWorkingTime();
            case 'C' -> products = getWorkingTime();
            default -> products = 0;
        }
        return products;
    }

    @Override
    public int workTogether(IWorkingTogether partner) {
        return ((Factory) partner).makeProducts('B');
    }
}
