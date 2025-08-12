package javabasic_02.day12.afternoon.homework.interface02;

public class TVFactory extends Factory implements IWorkingTogether {

    public TVFactory(String name, int openHour, int closedHour) {
        super(name, openHour, closedHour);
    }

    @Override
    public int makeProducts(char skill) {
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
        return ((TVFactory) partner).makeProducts('C');
    }
}
